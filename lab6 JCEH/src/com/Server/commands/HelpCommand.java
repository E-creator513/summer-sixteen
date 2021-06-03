package com.Server.commands;

import com.Server.CollectionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for realizing command "help"
 * @author MANU
 * @version 1.1
 */
public class HelpCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public HelpCommand(CollectionManager manager) {
        super(manager);
        setDescription("Displays help for available commands.");
    }

    /**
     * Method for executing this command
     * @return command executing status into a string representation
     */
    @Override
    public synchronized String execute() {
        StringBuilder result = new StringBuilder();
        HashMap<String, String> commandsInfo = getManager().getInfoCommands();
        for (Map.Entry<String, String> entry : commandsInfo.entrySet()) {
            result.append(entry.getKey() + entry.getValue() + "\n");
        }
        getManager().save();
        return result.toString();
    }
}