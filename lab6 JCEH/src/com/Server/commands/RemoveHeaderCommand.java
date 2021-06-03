package com.Server.commands;

import com.Server.CollectionManager;
import com.Server.data.Flat;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.HashSet;

/**
 * Class for realizing command "remove_greater"
 * @author Ivan Nesterov
 * @version 1.1
 */

public class RemoveHeaderCommand extends AbstractCommand {



        /**
         * Constructor for this class
         *
         * @param manager - field for using opportunities of Collection Manager
         */
        public RemoveHeaderCommand(CollectionManager manager) {
            super(manager);
            setDescription("Removes all elements which height more than current.");
        }

        /**
         * Method for executing this command
         * @param arg - string XML-like representation of object of class Person
         * @return executing status of this command
         */
        public synchronized String execute(String arg) {
            try {
                HashSet<Flat> collection = getManager().getFlats();
                Flat currentFlat = new XmlMapper().readValue(arg, Flat.class);
                if (collection.size() != 0) {
                    int beginSize = collection.size();
                    collection.removeIf(p -> (p != null && p.compareTo(currentFlat) > 0));
                    getManager().save();
                    return "Amount of elements which were removed: " + (beginSize - collection.size());
                } else return "Collection is empty. Comparing is impossible.";
            } catch (IOException ioException) {
                return "Comparing error.";
            }
        }
    }

