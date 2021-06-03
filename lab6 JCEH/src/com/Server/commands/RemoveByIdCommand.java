package com.Server.commands;


import com.Server.CollectionManager;
import com.Server.data.Flat;

import java.util.HashSet;

public class RemoveByIdCommand extends AbstractCommand {

    public RemoveByIdCommand(CollectionManager manager) {
        super(manager);
        setDescription("Removes an element finding it by it`s ID.");
    }


    public String execute (String id) {
        HashSet<Flat> flats = getManager().getFlats();
        for (Flat flat : flats) {
            long intId = flat.getId();
            String strId = String.valueOf(intId);
            if (strId.equals(id)) {
                flats.remove(flat);
                getManager().save();
                return "Element was removed successfully.";
            }
        }
        getManager().save();
        return "Element with this ID is not exist.";
    }
}
