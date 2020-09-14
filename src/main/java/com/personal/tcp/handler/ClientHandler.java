package com.personal.tcp.handler;

import com.personal.tcp.enumeration.MessageTypeEnum;
import com.personal.tcp.factory.MessageServiceFactory;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.util.HexConverter;
import com.personal.tcp.util.Validator;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;
    private InputStream in;
    private PrintWriter out;
    private MessageServiceFactory factory;

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.in = client.getInputStream();
        this.out = new PrintWriter(client.getOutputStream(), true);
        this.factory = new MessageServiceFactory();
    }

    @Override
    public void run() {
        System.out.println("ClientHandler.run() - Starting processing of message ...");

        try {
            byte[] byteArray = HexConverter.getByteArray(in);

            String stringType = String.format("%02X ", byteArray[2]);
            MessageTypeEnum type = MessageTypeEnum.fromString(stringType);
            System.out.println("ClientHandler.run() - MessageType - " + type);


//            String hexMessage = HexConverter.getHexMessage(in);
            CoreService service = factory.createService(type);

//            // Process message
//            String response = service.process("");
//            out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ClientHandler.run() - Processing of message finished!");
    }

}
