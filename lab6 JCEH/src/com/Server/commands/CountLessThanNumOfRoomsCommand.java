package com.Server.commands;

import com.Server.CollectionManager;

import static java.lang.Integer.valueOf;

/**
 * Class for realizing command "count_greater_than_nationality"
 *
 * @author Ivan Nesterov
 * @version 1.1
 */



public class CountLessThanNumOfRoomsCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public CountLessThanNumOfRoomsCommand(CollectionManager manager) {
        super(manager);
        setDescription("Counts amounts of elements which nationality greater than current.");
    }

    /**
     * Method for executing this command
     *
     * @param arg - string representation of object of class Country, which will be used for counting in execute
     * @return executing status into a string representation
     */
    public synchronized String execute(String arg) {
        int roomsCommand = valueOf(arg);
        StringBuilder result = new StringBuilder();
        try {
            result.append(getManager().count_less_than_numberof_rooms(roomsCommand));
        } catch (Exception exception) {
            System.out.println("Invalid argument.");
        }
        getManager().save();
        return result.toString();
    }

}

