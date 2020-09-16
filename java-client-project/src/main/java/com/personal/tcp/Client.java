package com.personal.tcp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 4242;
    private static final Logger LOG = LogManager.getLogger(Client.class);

    public static void main(String[] args) throws IOException {

        while (true) {
            Socket socket = new Socket(SERVER_IP, PORT);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("[CLIENT] - Send your message: ");
            String userInput = keyboard.readLine();
            LOG.info("[CLIENT] - Message sent: " + userInput);
            if (userInput.equals("quit")) break;

            System.out.println("[CLIENT] - Waiting for response... ");
            out.println(userInput);

            String response = in.readLine();

            LOG.info("[CLIENT] - Server response: " + response);
            System.out.println("[CLIENT] - Server response: " + response);
            socket.close();
        }

        System.exit(0);
    }

}
