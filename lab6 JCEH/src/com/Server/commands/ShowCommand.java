package com.Server.commands;

import com.Server.CollectionManager;
import com.Server.data.Flat;

import java.util.HashSet;

/**
 * Class for realizing command "show"
 * @author MANU
 * @version 1.1
 */
public class ShowCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public ShowCommand(CollectionManager manager) {
        super(manager);
        setDescription("Prints all elements in string representation to standard output.");
    }

    /**
     * Method for executing this command
     * @return executing status of this command
     */
    @Override
    public synchronized String execute() {
        HashSet<Flat> flats = getManager().getFlats();
        StringBuilder result = new StringBuilder();
        for (Flat flat : flats) {
            result.append(flat.toString() + "\n");
        }
        if (flats.size() != 0) {
            return result.toString();
        } else return "Collection is empty.";
    }
}