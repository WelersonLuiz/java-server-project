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

            MessageTypeEnum type = MessageTypeEnum.fromByte(byteArray[2]);
            System.out.println("ClientHandler.run() - MessageType - " + type);

            CoreService service = factory.createService(type);
            String response = service.process(HexConverter.getHexMessage(byteArray));

            out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ClientHandler.run() - Processing of message finished!");
    }

}
