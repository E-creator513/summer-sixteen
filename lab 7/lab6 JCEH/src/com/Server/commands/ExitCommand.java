package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;

//import server.serverCode.CollectionManager;



/**
 * Class for realizing command "exit"
 * @author
 * @version 1.1
 */
public class ExitCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     *
     * @param serverCollection
     */
    public ExitCommand(CollectionManager serverCollection) {
        setDescription("Switches off a program.");
    }

    /**
     * Method for realizing this command
     * @return command executing status into s string representation
     */
    @Override
    public synchronized String execute() {
        CollectionManager.getInstance().save();
        return "Finishing a program.";
    }
}