package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.data.Flat;
import com.Server.data.Furnish;

import java.util.Set;
//import serverCode.CollectionManager;

public class CountLessThanNumOfRoomsCommand extends AbstractCommand {

    public CountLessThanNumOfRoomsCommand(CollectionManager serverCollection) {
        setDescription("Counts amounts of elements which nationality greater than current.");
    }

    public synchronized String execute(String arg) {

        Furnish furnish = Furnish.valueOf(arg);
        int exampleHashcode = furnish.hashCode();
        Set<Flat> flats = CollectionManager.getInstance().getFlats();
        int counter = 0;
        for (Flat flat : flats) {
            if ((flat.getFurnish()).hashCode() > exampleHashcode) {
                counter += 1;
            }
        }
        return "Operation was finished successfully. " + counter + " elements.";
    }
}

