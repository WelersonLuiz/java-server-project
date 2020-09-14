package com.personal.tcp.util;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2Manager {

    private static Server h2Server;

    public void start() {
        try {
            h2Server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "9092");
            h2Server.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (h2Server != null){
            h2Server.stop();
        }
    }

}