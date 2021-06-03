package com.Server.commands;


import com.Server.CollectionManager ;
import java.io.*;

/**
 * Class for realizing command "execute_script"
 * @author MANU
 * @version 1.1
 */
public class ExecuteScriptCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public ExecuteScriptCommand(CollectionManager manager) {
        super(manager);
        setDescription("Executes script from a file.");
    }

    /**
     * Method for realizing this command
     * @param nameOfFile - string representation of path to file which contain script
     * @return method executing status into a string representation
     */
    public String execute(String nameOfFile) {
        try {
            System.out.println("WARNING. To avoid recursion, your file cannot contain execute script commands.");
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameOfFile)));
            StringBuilder message = new StringBuilder();
            String[] finalUserCommand;
            String command;
            while((command = reader.readLine()) != null) {
                finalUserCommand = command.trim().toLowerCase().split(" ", 2);
                //String regex = "//s+";
                switch (finalUserCommand[0]) {
                    case "help":
                        HelpCommand help = new HelpCommand(getManager());
                        message.append(help.execute()).append("\n");
                        break;
                    case "info":
                        InfoCommand info = new InfoCommand(getManager());
                        message.append(info.execute()).append("\n");
                        break;
                    case "show":
                        ShowCommand show = new ShowCommand(getManager());
                        message.append(show.execute()).append("\n");
                        break;
                    case "add":
                        AddCommand add = new AddCommand(getManager());
                        message.append(add.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "update_by_id":
                        UpdateByIdCommand update_by_id = new UpdateByIdCommand(getManager());
                        message.append(update_by_id.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "remove_by_id":
                        RemoveByIdCommand remove_by_id = new RemoveByIdCommand(getManager());
                        message.append(remove_by_id.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "clear":
                        ClearCommand clear = new ClearCommand(getManager());
                        message.append(clear.execute()).append("\n");
                        break;
                    case "save":
                        SaveCommand save = new SaveCommand(getManager());
                        message.append(save.execute()).append("\n");
                        break;
                    case "execute_script":
                        message.append("This script cannot to contain this command.").append("\n");
                        break;
                    case "exit":
                        ExitCommand exit = new ExitCommand(getManager());
                        message.append(exit.execute()).append("\n");
                        break;
                    case "add_if_min":
                        AddIfMinCommand add_if_min = new AddIfMinCommand(getManager());
                        message.append(add_if_min.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "remove_greater":
                        RemoveHeaderCommand remove_greater = new RemoveHeaderCommand(getManager());
                        message.append(remove_greater.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "remove_lower":
                        AddIfMaxCommand remove_lower = new AddIfMaxCommand(getManager());
                        message.append(remove_lower.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "sum_of_height":
                        FilterStartsWitNameCommand sum_of_height = new FilterStartsWitNameCommand(getManager());
                        message.append(sum_of_height.execute()).append("\n");
                        break;
                    case "group_counting_by_nationality":
                        GroupCountingByFurnishCommand group_counting_by_furnish = new GroupCountingByFurnishCommand(getManager());
                        message.append(group_counting_by_furnish.execute()).append("\n");
                        break;
                    case "count_greater_than_nationality":
                        CountLessThanNumOfRoomsCommand countLessThanNumOfRoomsCommand = new CountLessThanNumOfRoomsCommand(getManager());
                        message.append(countLessThanNumOfRoomsCommand.execute(finalUserCommand[1])).append("\n");
                        break;
                    default:
                        message.append("Unknown command").append("\n");
                        //reader.readLine();
                        break;
                }
            }
            reader.close();
            getManager().save();
            return message.toString();
            //return "Commands are ended.";
        } catch (FileNotFoundException fileNotFoundException) {
            return "File not found. Try again.";
        } catch (IOException ioException) {
            return "File reading exception. Try again.";
        }
    }
}
