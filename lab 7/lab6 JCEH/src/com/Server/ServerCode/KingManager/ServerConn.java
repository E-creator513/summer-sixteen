package com.Server.ServerCode.KingManager;


import com.Server.commands.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
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

public class ServerConn  implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */



        private static HashMap<String, AbstractCommand> availableCommands;
        private final DatagramSocket socket;
        private boolean running;
        private final byte[] buf = new byte[65535];
        private byte[] buf2 = new byte[65535];
        //private final HashMap<String, AbstractCommand> availableCommands = new HashMap<>();
        private int id;

        public ServerConn(DatagramSocket socket) {
            this.socket = socket;
            availableCommands.put("login", new LoginCommand(this));
            availableCommands.put("register", new RegisterCommand());
            availableCommands.put("delete_account", new DeleteAccountCommand(this));
            availableCommands.put("help", new HelpCommand());
        }




    public void run() {
            try {
                running = true;
                while (running) {
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    System.out.println("received");
                    AbstractCommand errorCommand = new AbstractCommand() {
                        @Override
                        public String execute() {
                            return "Unknown command. Write help for receiving list of available commands.";
                        }
                    };
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
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

        public  void setId(int id) {

            this.id = id;
        }

        public  long getId() {

            return id;
        }

        public  DatagramSocket getSocket() {

            return this.socket;
        }

        public  HashMap<String, AbstractCommand> getAvailableCommands() {
            return availableCommands;
        }

        @Override
        public String toString() {
            return "ServerConnection{" +
                    "socket=" + socket +
                    ", running=" + running +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ServerConn that = (ServerConn) o;
            return running == that.running &&
                    id == that.id &&
                    Objects.equals(socket, that.socket) &&
                    Arrays.equals(buf, that.buf) &&
                    Arrays.equals(buf2, that.buf2) &&
                    Objects.equals(availableCommands, that.availableCommands);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(socket, running, availableCommands, id);
            result = 42 * result + Arrays.hashCode(buf);
            result = 42 * result + Arrays.hashCode(buf2);
            return result;
        }
    }


