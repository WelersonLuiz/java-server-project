package com.personal.tcp;

import com.personal.tcp.handler.ClientHandler;
import com.personal.tcp.util.H2Manager;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final ArrayList<ClientHandler> clients = new ArrayList<>();
    private final ExecutorService pool = Executors.newCachedThreadPool();

    public void run() {
        int serverPort = 4242;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("[SERVER] - Connections on port: " + serverSocket.getLocalPort() + "");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("\n[SERVER] - Client connected: " + socket.getRemoteSocketAddress());

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);

                pool.execute(client);
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }



}