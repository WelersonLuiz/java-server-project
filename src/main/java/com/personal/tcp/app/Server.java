package com.personal.tcp.app;

import com.personal.tcp.handler.ClientHandler;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    private final ArrayList<ClientHandler> clients = new ArrayList<>();
    private final ExecutorService pool = Executors.newCachedThreadPool();

    public void run() {

        try {
            int serverPort = 4242;
            ServerSocket serverSocket = new ServerSocket(serverPort);

            while (true) {
                System.out.println("Aguardando nova conexão na Porta " + serverSocket.getLocalPort() + ".");
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getRemoteSocketAddress());

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);

                pool.execute(client);
            }

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}