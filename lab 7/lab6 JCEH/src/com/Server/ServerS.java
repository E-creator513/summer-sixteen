package com.Server;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.ServerCode.KingManager.KingDatabaseMan;
import com.Server.ServerCode.KingManager.ServerConn;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Class for starting a server
 * @author MANU
 * @version 1.1
 */

//public class ServerS {


        /** Server entry point
        public static void main(String[] args) {
            try {
                KingDatabaseMan.getInstance();
                CollectionManager.getInstance();
               // CollectionManager serverCollection = new CollectionManager(args[0]);
                System.out.println("Launching the server platform.\nWaiting for the client as of now...");
                ServerConn serverConnection = new ServerConn(new DatagramSocket(4242));
                System.out.println("server was activated successfully");
                serverConnection.run();
            } catch (ArrayIndexOutOfBoundsException | SocketException arrayIndexOutOfBoundsException) {
                System.err.println("You forgot enter path to file. Use [java -jar Server.jar /path/to/file] for correct using.");
                System.exit(1);
            }catch (IOException ioException){
                System.err.println("IO exception");
                System.exit(1);
            }
        }
    }
         **/

import java.io.IOException;
import java.net.DatagramSocket;

public class ServerSide {

    //private static final CollectionManager serverCollection;

    public static void main(String[] args) {
        try {
            KingDatabaseMan.getInstance();
            CollectionManager.getInstance();
            System.out.println("Starting a server moodle.\nWaiting a client...");
            ServerConn serverConnection = new ServerConn(new DatagramSocket(4242));
            System.out.println("Server was activated successfully.");
            serverConnection.run();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.err.println("You forgot enter path to file. Use [java -jar Server.jar /path/to/file] for correct using.");
            System.exit(1);
        } catch (IOException ioException) {
            System.err.println("IO exception");
            System.exit(1);
        }
    }
}