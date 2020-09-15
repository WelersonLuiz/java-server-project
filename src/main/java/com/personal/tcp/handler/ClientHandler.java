package com.personal.tcp.handler;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.factory.MessageServiceFactory;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.UserInfoServiceImpl;
import com.personal.tcp.util.HexConverter;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket client;
    private final BufferedReader in;
    private final PrintWriter out;
    private final MessageServiceFactory factory;

    private static final Logger LOG = LogManager.getLogger(UserInfoServiceImpl.class);

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.factory = new MessageServiceFactory();

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
    }

    @Override
    public void run() {

        try {
            String message = in.readLine();


            byte[] input = HexConverter.getByteArrayFromString(message);
            System.out.println("[SERVER] - Message received: " + HexConverter.getHexFromByteArray(input));

            MessageTypeEnum type = MessageTypeEnum.fromByte(input[2]);
            CoreService service = factory.createService(type);

            byte[] response = service.process(input);
            LOG.info("[SERVER] - Message processed: " + HexConverter.getHexFromByteArray(input));

            System.out.println("[SERVER] - Response: " + HexConverter.getHexFromByteArray(response) + "\n");
            out.println(HexConverter.getHexFromByteArray(response));

        } catch (Exception e) {
            System.err.println("[SERVER] - Invalid Message");
            out.println("Invalid Message");
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
