package com.personal.tcp;

import com.personal.tcp.handler.ClientHandler;
import com.personal.tcp.util.H2Manager;
import org.hibernate.secure.spi.IntegrationException;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final ExecutorService pool = Executors.newCachedThreadPool();
    private static final int port = 4242;

    public static void main(String[] args) {
        H2Manager h2Manager = new H2Manager();
        h2Manager.start();
        Server server = new Server();
        server.run();
    }

    public void run() {
        try {
            ServerSocket server = createServerSocket();
            while (true) {
                ClientHandler client = createClient(server);
                pool.execute(client);
            }
        } catch(IntegrationException e) {
            System.err.println("[SERVER] - Error: " + e.getMessage());
        }
    }

    private ServerSocket createServerSocket() throws IntegrationException {
        try {
            ServerSocket socket = new ServerSocket(Server.port);
            System.out.println("[SERVER] - Connections on port: " + socket.getLocalPort());
            return socket;
        } catch (IOException e) {
            throw new IntegrationException("Fail to create server socket.");
        }
    }

    private ClientHandler createClient(ServerSocket server){
        try {
            Socket socket = server.accept();
            System.out.println("\n[SERVER] - Client connected: " + socket.getRemoteSocketAddress());
            return new ClientHandler(socket);
        } catch (IOException e) {
            throw new IntegrationException("Fail to connect the new client");
        }
    }

}