package com.personal.tcp.handler;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.factory.MessageServiceFactory;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.service.impl.UserInfoServiceImpl;
import com.personal.tcp.util.HexConverter;
import com.personal.tcp.util.Validator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket client;
    private final InputStream in;
    private final PrintWriter out;
    private final MessageServiceFactory factory;
    private static final Logger LOG = LogManager.getLogger(UserInfoServiceImpl.class);

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.in = client.getInputStream();
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.factory = new MessageServiceFactory();

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.jboss").setLevel(Level.OFF);
    }

    @Override
    public void run() {
        System.out.println("ClientHandler.run() - Starting processing of message ...");

        try {
            byte[] byteArray = HexConverter.getByteArray(in);

            MessageTypeEnum type = MessageTypeEnum.fromByte(byteArray[2]);
            System.out.println("ClientHandler.run() - MessageType - " + type);

            CoreService service = factory.createService(type);

            String input = HexConverter.getHexMessage(byteArray);
            LOG.info("Mensagem recebida - " + input);

            input = input.replaceAll(" ", "");
            String response = service.process(input);

            out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ClientHandler.run() - Processing of message finished!");
    }

}
