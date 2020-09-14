package com.personal.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 4242;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("0A 15 A1 20 7A C3 0C 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D");

        String serverResponse = input.readLine();
        System.out.println("Server Response: " + serverResponse);

        socket.close();
        System.exit(0);
    }


}
