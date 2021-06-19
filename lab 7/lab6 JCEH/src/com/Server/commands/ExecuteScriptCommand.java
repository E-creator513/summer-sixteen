package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;

import java.io.*;

/**
 * Class for realizing command "execute_script"
 * @author MANU
 * @version 1.1
 */

public class ExecuteScriptCommand extends AbstractCommand {

    CollectionManager serverConnection;

    public ExecuteScriptCommand(CollectionManager connection) {
        this.serverConnection = connection;
        setDescription("Executes script from a file.");
    }

    public String execute(String nameOfFile) {
        try {
            System.out.println("WARNING. To avoid recursion, your file cannot contain execute script commands.");
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameOfFile)));
            String[] finalUserCommand;
            String command;
            while((command = reader.readLine()) != null) {
                finalUserCommand = command.trim().toLowerCase().split(" ", 2);
                switch (finalUserCommand[0]) {
                    case "help":
                        HelpCommand help = new HelpCommand();
                        help.execute();
                        break;
                    case "info":
                        InfoCommand info = new InfoCommand(serverConnection);
                        info.execute();
                        break;
                    case "show":
                        ShowCommand show = new ShowCommand(serverConnection);
                        show.execute();
                        break;
                    case "add":
                        AddCommand add = new AddCommand(serverConnection);
                        add.execute(finalUserCommand[1]);
                        break;
                    case "update_by_id":
                        UpdateByIdCommand update_by_id = new UpdateByIdCommand(serverConnection);
                        update_by_id.execute(finalUserCommand[1]);
                        break;
                    case "remove_by_id":
                        RemoveByIdCommand remove_by_id = new RemoveByIdCommand(serverConnection);
                        remove_by_id.execute(finalUserCommand[1]);
                        break;
                    case "clear":
                        ClearCommand clear = new ClearCommand(serverConnection);
                        clear.execute();
                        break;
                    case "save":
                        SaveCommand save = new SaveCommand(serverConnection);
                        save.execute();
                        break;
                    case "execute_script":
                        System.out.println("This script cannot to contain this command.");
                        break;
                    case "exit":
                        ExitCommand exit = new ExitCommand(serverConnection);
                        exit.execute();
                        break;
                    case "add_if_min":
                        AddIfMinCommand add_if_min = new AddIfMinCommand(serverConnection);
                        add_if_min.execute(finalUserCommand[1]);
                        break;
                    case "remove_greater":
                        RemoveGreaterCommand remove_greater = new RemoveGreaterCommand(serverConnection);
                        remove_greater.execute(finalUserCommand[1]);
                        break;
                    case "add_if_max":
                        AddIfMaxCommand remove_MAX = new AddIfMaxCommand(serverConnection);
                        remove_MAX.execute(finalUserCommand[1]);
                        break;
                    case "Filter by name ":
                        FilterStartsWitNameCommand sum_of_height = new FilterStartsWitNameCommand(serverConnection);
                        sum_of_height.execute();
                        break;
                    case "group_counting_by_furnish":
                        GroupCountingByFurnishCommand group_counting = new GroupCountingByFurnishCommand(serverConnection);
                        group_counting.execute();
                        break;
                    case "count_less_than_numberofrooms":
                        CountLessThanNumOfRoomsCommand count_greater_than_= new CountLessThanNumOfRoomsCommand(serverConnection);
                        count_greater_than_.execute(finalUserCommand[1]);
                        break;
                    default:
                        reader.readLine();
                        break;
                }
            }
            reader.close();


            return "Commands are ended.";
        } catch (FileNotFoundException fileNotFoundException) {
            return "File not found. Try again.";
        } catch (IOException ioException) {
            return "File reading exception. Try again.";
        }
    }
}