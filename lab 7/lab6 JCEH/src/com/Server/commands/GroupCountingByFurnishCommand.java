package com.Server.commands;

import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.data.Flat;

import java.util.Set;

/**
 * Class for realizing command "group_counting_by_nationality"
 *
 * @author MANU
 * @version 1.1
 */

public class GroupCountingByFurnishCommand extends AbstractCommand {

    public GroupCountingByFurnishCommand(CollectionManager serverCollection) {
        setDescription("Prints sum of values of field name of each element in collection.");
    }

    @Override
    public synchronized String execute() {
        CollectionManager manager = CollectionManager.getInstance();
        Set<Flat> collection = manager.getFlats();
        if (collection.size() != 0) {
            int sum = 0;
            for (Flat p: collection) {
                sum += p.getNumberOfRooms();
            }
            return String.valueOf(sum);
        }
        else return "Collection is empty.";
    }
    }

