package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.data.Flat;

import java.util.Set;

public class RemoveByIdCommand extends AbstractCommand {

    public RemoveByIdCommand(CollectionManager serverConnection) {
        setDescription("Removes element of the collection by it's id");
    }

    @Override
    public synchronized String execute(String arg) {
        CollectionManager manager = CollectionManager.getInstance();
        Set<Flat> collection = manager.getFlats();
        int id = Integer.parseInt(arg);
        if (collection.size() != 0) {
            for (Flat flat : collection) {
                if (flat.getId() == id) {
                    collection.remove(flat);
                    manager.save();
                    return "Element was removed successfully.";
                }
            }
            return "Element with this ID is not exist.";
        } else return "Collection is empty.";
    }
}