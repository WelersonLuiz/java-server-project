package com.personal.tcp;

import com.personal.tcp.util.HexConverter;

import java.io.*;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 4242;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String userInput = "";

        while (!userInput.equals("quit")) {
            System.out.println("[CLIENT] - Send your message: ");
            userInput = keyboard.readLine();
            System.out.println("[CLIENT] - Wating for response... ");

            out.println(userInput);
            System.out.println("[CLIENT] - Server response: " + in.readLine());
        }

        socket.close();
        System.exit(0);
    }

}
