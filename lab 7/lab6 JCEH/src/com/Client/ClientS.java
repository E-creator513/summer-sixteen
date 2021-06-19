package com.Client;

public class ClientS {

    public static void main(String[] args) {
        System.out.println("Launching the client platform.\nConnecting to server...");
        ClientConn connection = new ClientConn();
        connection.work();
    }
}
