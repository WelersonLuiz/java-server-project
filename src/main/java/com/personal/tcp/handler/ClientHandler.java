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

    private final InputStream in;
    private final OutputStream out;
    private final PrintWriter pw;
    private final MessageServiceFactory factory;
    private static final Logger LOG = LogManager.getLogger(UserInfoServiceImpl.class);

    public ClientHandler(Socket client) throws IOException {
        this.in = client.getInputStream();
        this.out = client.getOutputStream();
        this.pw = new PrintWriter(client.getOutputStream(), true);
        this.factory = new MessageServiceFactory();

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
    }

    @Override
    public void run() {

        try {
            byte[] input = HexConverter.getByteArrayFromInput(in);
            LOG.info("[SERVER] - Message received: " + HexConverter.getHexFromByteArray(input));
            System.out.println("[SERVER] - Message received: " + HexConverter.getHexFromByteArray(input));

            MessageTypeEnum type = MessageTypeEnum.fromByte(input[2]);
            CoreService service = factory.createService(type);

            byte[] response = service.process(input);

            System.out.println("[SERVER] - Response: " + HexConverter.getHexFromByteArray(response));
            out.write(response);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }

        System.out.println("[SERVER] - Connection closed");
    }

}
