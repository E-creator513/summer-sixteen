package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.data.Flat;

import java.util.Set;

class RemoveGreaterCommand extends AbstractCommand {

    CollectionManager serverConnection;

    public RemoveGreaterCommand(CollectionManager connection) {
        this.serverConnection = connection;
        setDescription("Removes all elements which height more than current.");
    }

    public synchronized String execute(String arg) {
        CollectionManager manager = CollectionManager.getInstance();
        long height = Long.valueOf(arg);
        Set<Flat> flats = CollectionManager.getInstance().getFlats();
        int counter = 0;
        for (Flat flat : flats) {
            if (flat.getNumberOfRooms() > height) {
                flats.remove(flat);
                counter += 1;
            }
        }
        manager.save();
        return "Operation was finished successfully. " + counter + " elements were deleted.";
    }
}

