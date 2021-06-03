package com.Server;


import com.Server.commands.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class for realizing connection on server side and activating interactive mod with client.
 * Class worked using UDP protocol and allows to run the required command classes
 * depending on the command received from the client
 *
 * @author MANU
 * @verson 1.1
 */

public class ServerConn  implements Runnable{



        /** Field socket which allows to transport datagrams */
        private DatagramSocket socket;
        /** Flag for checking if interactive mod is active */
        private boolean running;
        /** Array of bytes for organizing a packet for receiving data from client */
        private byte[] buf = new byte[65535];
        /** Array of bytes for organizing a packet for sending answer to client */
        private byte[] buf2 = new byte[65535];
        /** Field allows to use methods of CollectionManager class */
        private final CollectionManager serverCollection;
        /** Map for printing available commands for user */
        private final HashMap<String, AbstractCommand> availableCommands;

        /**
         * Constructor for this class
         * @param serverCollection - object of class CollectionManager
         */
        ServerConn(CollectionManager serverCollection) {
            try {
                socket = new DatagramSocket(4242);
            } catch (SocketException socketException) {
                System.err.println("Host is busy. Try later.");
                System.exit(1);
            }
            this.serverCollection = serverCollection;
            availableCommands = new HashMap<>();
            availableCommands.put("add", new AddCommand(serverCollection));
            availableCommands.put("add_if_min", new AddIfMinCommand(serverCollection));
            availableCommands.put("clear", new ClearCommand(serverCollection));
            availableCommands.put("count_greater_than_nationality", new CountLessThanNumOfRoomsCommand(serverCollection));
            availableCommands.put("execute_script", new ExecuteScriptCommand(serverCollection));
            availableCommands.put("exit", new ExitCommand(serverCollection));
            availableCommands.put("group_counting_by_nationality", new GroupCountingByFurnishCommand(serverCollection));
            availableCommands.put("help", new HelpCommand(serverCollection));
            availableCommands.put("info", new InfoCommand(serverCollection));
            availableCommands.put("remove_by_id", new RemoveByIdCommand(serverCollection));
            availableCommands.put("remove_greater", new RemoveHeaderCommand(serverCollection));
            availableCommands.put("remove_lower", new AddIfMaxCommand(serverCollection));
            availableCommands.put("save", new SaveCommand(serverCollection));
            availableCommands.put("show", new ShowCommand(serverCollection));
            availableCommands.put("sum_of_height", new FilterStartsWitNameCommand(serverCollection));
            availableCommands.put("update_by_id", new UpdateByIdCommand(serverCollection));
        }

        /** Active link this client */
        public void run() {
            try {
                running = true;
                while (running) {
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    System.out.println("received");
                    AbstractCommand errorCommand = new AbstractCommand(null) {
                        @Override
                        public String execute() {
                            return "Unknown command. Write help for receiving list of available commands.";
                        }
                    };
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    //packet = new DatagramPacket(buf, buf.length, address, port);
                    String command = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Message [" + command + "] is received from client.");
                    String[] parsedCommand = command.trim().split(" ", 2);
                    String answer;
                    if (parsedCommand.length == 1) {
                        answer = availableCommands.getOrDefault(parsedCommand[0], errorCommand).execute();
                    } else if (parsedCommand.length == 2) {
                        answer = availableCommands.getOrDefault(parsedCommand[0], errorCommand).execute(parsedCommand[1]);
                    } else answer = "Unknown command. Write [help] for receiving list of available commands";
                    buf2 = answer.getBytes();
                    DatagramPacket sendingPacket = new DatagramPacket(buf2, buf2.length, address, port);
                    String check = new String(sendingPacket.getData(), 0, sendingPacket.getLength());
                    socket.send(sendingPacket);
                    System.out.println("Answer has been recent successfully. Content of answer: ");
                    System.out.println(check);
                }
                socket.close();
            } catch (IOException exception) {
                System.err.println(socket + " is disconnected to server.");
            } catch (NoSuchElementException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("Program will be finished now.");
                System.exit(0);
            }
        }

        @Override
        public String toString() {
            return "ServerConnection{" +
                    "serverCollection=" + serverCollection +
                    ", availableCommands=" + availableCommands +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ServerConn)) return false;
            ServerConn that = (ServerConn) o;
            return Objects.equals(serverCollection, that.serverCollection) &&
                    Objects.equals(availableCommands, that.availableCommands);
        }

        @Override
        public int hashCode() {
            return Objects.hash(serverCollection, availableCommands);
        }
    }

