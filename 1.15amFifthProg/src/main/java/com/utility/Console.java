/**package com.utility;

//import src.com.utility.manu.App;
import exceptions.ScriptRecursion;
//import src.manu.App;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Console {
    private CommandManager commandManager;
    private BufferedReader userScanner;
    private FlatCoordinateManager flatCoordinateManager;
    private List<String> scriptStack = new ArrayList<>();

    public Console(CommandManager commandManager, BufferedReader userScan, FlatCoordinateManager flatCoordinateManager) {
        this.commandManager = commandManager;
        this.userScanner = userScanner;
        this.flatCoordinateManager = flatCoordinateManager;
    }

    public static void printIn(Object toOut) {
    }

    /**
     * Mode for catching commands from user input.

    public void Mode() {
        String[] userCommand = {"", ""};
        int commandStatus;
        try {
            do {
               // Console.print(App.PS1);
                userCommand = (userScanner.readLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                commandManager.addToHistory(userCommand[0]);
                commandStatus = launchCommand(userCommand);
            } while (commandStatus != 2);
        } catch (NoSuchElementException exception) {
            Console.printerror("USER INPUT IS NOT DETECTED!");
        } catch (IllegalStateException exception) {
            Console.printerror("UNEXPECTED ERROR!");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Mode for catching commands from a script.
     * @param argument Its argument.
     * @return Exit code.

    public int scriptMode(String argument) {
        String[] userCommand = {"", ""};
        int commandStatus;
        scriptStack.add(argument);
        try (Scanner scriptScanner = new Scanner(new FileReader(argument)
        )) {
            if (scriptScanner.hasNext()) throw new NoSuchElementException() ;
            {
                Scanner tmpScanner = FlatCoordinateManager.getUserScanner;

                FlatCoordinateManager.setUserScanner(scriptScanner);
                FlatCoordinateManager.setUserScanner(scriptScanner);
                FlatCoordinateManager.setFileMode();
                String line;
                BufferedReader reader = null;
                do {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                    scriptScanner.nextLine();
                  //  Console.println(App.PS1 + String.join(" ", userCommand));
                    if (userCommand[0].equals("execute_script")) {
                        for (String script : scriptStack) {
                            if (userCommand[1].equals(script)) throw new ScriptRecursion();
                        }
                    }
                    commandStatus = launchCommand(userCommand);
                } while ((line = String.valueOf(reader.read())) != null);
                FlatCoordinateManager.setUserScanner(tmpScanner);
                FlatCoordinateManager.setUserMode();
                if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                    Console.println("CHECK THE SCRIPT FOR THE CORRECTNESS OF ENTERED DATA!");
                return commandStatus;

            }
        } catch (FileNotFoundException exception) {
            Console.printerror("FILE WITH THE SCRIPTURE IS NOT FOUND!");
        } catch (NoSuchElementException exception) {
            Console.printerror("SCRIPT FILE IS EMPTY!");
        } catch (ScriptRecursion exception) {
            Console.printerror("SCRIPT CANT BE CALLED RECURSIVELY!");
        } catch (IllegalStateException exception) {
            Console.printerror("UNEXPECTED ERROR!");
            System.exit(0);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            scriptStack.remove(scriptStack.size()-1);
        }
        return 1;
    }

    /**
     * Launchs the command.
     * @param userCommand Command to launch.
     * @return Exit code.

    private int launchCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
                if (!commandManager.help(userCommand[1])) return 1;
                break;
            case "info":
                if (!commandManager.info(userCommand[1])) return 1;
                break;
            case "show":
                if (!commandManager.show(userCommand[1])) return 1;
                break;
            case "add":
                if (!commandManager.add(userCommand[1])) return 1;
                break;
            case "update":
                if (!commandManager.update(userCommand[1])) return 1;
                break;
            case "remove_by_id":
                if (!commandManager.removeById(userCommand[1])) return 1;
                break;
            case "clear":
                if (!commandManager.clear(userCommand[1])) return 1;
                break;
            case "save":
                if (!commandManager.save(userCommand[1])) return 1;
                break;
            case "execute_script":
                if (!commandManager.executeScript(userCommand[1])) return 1;
                else return scriptMode(userCommand[1]);
            case "add_if_min":
                if (!commandManager.addIfMin(userCommand[1])) return 1;
                break;
            case "add_if_max":
                if (!commandManager.addIfMax(userCommand[1])) return 1;
            case "remove_head":
                if (!commandManager.remove_head(userCommand[1])) return 1;
                break;
            case "history":
                if (!commandManager.history(userCommand[1])) return 1;
                break;
            case "group_counting_by_furnish":
                if (!commandManager.group_counting_by_Fur(userCommand[1])) return 1;
                break;
            case "count_less_than_number_of_rooms numberOfRooms":
                if (!commandManager.count_less_than_number_of_rooms (userCommand[1])) return 1;
                break;
            case "filter_starts_with_name":
                if (!commandManager.filter_starts_with_name(userCommand[1])) return 1;
                break;
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(userCommand[0])) return 1;
        }
        return 0;
    }

    /**
     * Prints toOut.toString() to Console
     * @param toOut Object to print

    public static void print(Object toOut) {
        System.out.print(toOut);
    }

    /**
     * Prints toOut.toString() + \n to Console
     * @param toOut Object to print

    public static void println(Object toOut) {
        System.out.println(toOut);
    }

    /**
     * Prints error: toOut.toString() to Console
     * @param toOut Error to print

    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }

    /**
     * Prints formatted 2-element table to Console
     * @param element1 Left element of the row.
     * @param element2 Right element of the row.

    public static void printtable(Object element1, Object element2) {
        System.out.printf("%-37s%-1s%n", element1, element2);
    }

    @Override
    public String toString() {
        return "Console (класс для обработки ввода команд)";
    }


    // public static void println(Object TOOUTPUT) {
    //    println();
    // }//



    public static void printerror(String s) {
    }
}
*/