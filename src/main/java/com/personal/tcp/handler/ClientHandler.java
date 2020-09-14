package com.personal.tcp.handler;

import com.personal.tcp.factory.MessageServiceFactory;
import com.personal.tcp.service.CoreService;
import com.personal.tcp.enumeration.MessageTypeEnum;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    static Logger log = Logger.getLogger(ClientHandler.class.getName());
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

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String input = br.readLine();
            log.info(input);

            // Validate message

            MessageTypeEnum type = MessageTypeEnum.getTypeMessage(input);
            CoreService service = factory.criarProcessador(type);

            // Process message
            service.process(input);

            out.println("Mensagem recebida com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] hexStringToByteArray(String s) {
        byte[] data = new byte[s.length()/2];
        for (int i = 0; i < data.length; i ++) {
            data[i] = (byte) ((Character.digit(s.charAt(i*2), 16) << 4)
                    + Character.digit(s.charAt(i*2 + 1), 16));
        }
        return data;
    }

    public byte[] inputToByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        byte[] read = new byte[1];
        int len;

        while((len = in.read(read)) > -1) {
            byteArray.write(read, 0, len);
        }

        byte[] bytes = byteArray.toByteArray();

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }

        System.out.println("Input receved: " + sb.toString());
        return bytes;
    }
}
