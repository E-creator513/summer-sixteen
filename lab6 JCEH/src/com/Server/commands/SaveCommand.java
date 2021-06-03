package com.Server.commands;

import com.Server.CollectionManager;

/**
 * Class for realizing command "help"
 * @author MANU
 * @version 1.1
 */
public class SaveCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public SaveCommand(CollectionManager manager) {
        super(manager);
        setDescription("Does nothing. Saving is an automatic process :)");
    }

    /**
     * Method for realizing this command
     * @return message about uselessness of this method
     */
    @Override
    public synchronized String execute() {
        getManager().save();
        return "Don`t worry, saving is an automatic process starting after some changes in collection :)";
    }
}
