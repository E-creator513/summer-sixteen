package com.Server.commands;

import com.Server.CollectionManager;

/**
 * Class for realizing command "group_counting_by_nationality"
 *
 * @author MANU
 * @version 1.1
 */

public class GroupCountingByFurnishCommand extends AbstractCommand {


        /**
         * Constructor for this class
         *
         * @param manager - field for using opportunities of Collection Manager
         */
        public GroupCountingByFurnishCommand(CollectionManager manager) {
            super(manager);
            setDescription("Groups elements by furnish and returns amount of element in every group.");
        }

        /**
         * Method for realizing this command
         *
         * @return command execution status into a string representation
         */
        public synchronized String execute() {
            StringBuilder result = new StringBuilder();
            result.append(getManager().group_counting_by_furnish() ) ;
            getManager().save();
            return result.toString();
        }
    }

