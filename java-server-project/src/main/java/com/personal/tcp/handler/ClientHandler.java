package com.personal.tcp.handler;

import com.personal.tcp.entities.message.Message;
import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.factory.MessageServiceFactory;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.UserInfoServiceImpl;
import com.personal.tcp.util.CrcValidator;
import com.personal.tcp.util.HexConverter;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.secure.spi.IntegrationException;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private BufferedReader in;
    private PrintWriter out;
    private MessageServiceFactory factory;

    private static final Logger LOG = LogManager.getLogger(UserInfoServiceImpl.class);

    public ClientHandler() {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
    }

    public ClientHandler connect(Socket client) throws IOException {
        ClientHandler handler = new ClientHandler();

        handler.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        handler.out = new PrintWriter(client.getOutputStream(), true);
        handler.factory = new MessageServiceFactory();

        return handler;
    }

    @Override
    public void run() {
        try {
            String message = in.readLine();
            String response = handleMessage(message);

            out.println(response);
            out.close();
            in.close();
        } catch (IntegrationException e){
            System.err.println("[SERVER] - " + e.getMessage());
            out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("[SERVER] - IOException while reading/writing message");
        }
    }

    public String handleMessage(String message){
        System.out.println("[SERVER] - Message received: " + message);
        validateMessage(message);

        byte[] input = HexConverter.getByteArrayFromHex(message);

        MessageTypeEnum type = MessageTypeEnum.fromByte(input[2]);
        CoreService service = factory.createService(type);

        byte[] byteResponse = service.process(input);
        String response = HexConverter.getHexFromByteArray(byteResponse);

        System.out.println("[SERVER] - Response: " + response);

        LOG.info("[SERVER] - Message processed: " + message);
        LOG.info("[SERVER] - Response: " + response);
        return response;
    }

    public void validateMessage(String message){
        try {
            byte[] input = HexConverter.getByteArrayFromHex(message);
            new Message(input);
            if (!CrcValidator.crcIsValid(input))
                throw new IntegrationException("CRC invalid");
        } catch (Exception e){
            throw new IntegrationException("Message format invalid.");
        }
    }

}
