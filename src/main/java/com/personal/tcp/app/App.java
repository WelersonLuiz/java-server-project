package com.personal.tcp.app;

import com.personal.tcp.Server;
import com.personal.tcp.util.H2Manager;

public class App {

    public static void main(String[] args) {
        H2Manager h2Manager = new H2Manager();
        h2Manager.start();
        Server server = new Server();
        server.run();
    }

}
