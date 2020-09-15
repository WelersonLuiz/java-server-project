package com.personal.tcp;

import com.personal.tcp.util.HexConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 4242;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while (true){
            System.out.print("> ");
            String command = keyboard.readLine();

            if (command.equals("exit")) break;
            socket.getOutputStream()
                    .write(HexConverter.getByteArrayFromString(command));

            String response = in.readLine();
            System.out.println("Response: " + response);
        }

        socket.close();
        System.exit(0);
    }

}
