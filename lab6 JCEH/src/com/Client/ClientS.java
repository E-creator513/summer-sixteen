package com.Client;

public class ClientS {

    public static void main(String[] args) {
        System.out.println("Starting a client moodle.\nConnecting to server...");
        ClientConn connection = new ClientConn();
        connection.work();
    }
}
