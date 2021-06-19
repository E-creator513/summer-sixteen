package com.Server.commands;

import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.data.Flat;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.IOException;
import java.util.Set;

public class UpdateByIdCommand extends AbstractCommand {

    public UpdateByIdCommand(CollectionManager serverCollection) {
        setDescription("Updates the element of collection, if it`s id equal id of entered element");
    }

    @Override
    public synchronized String execute(String arg) {
        XmlMapper mapper = new XmlMapper();
        try {
            CollectionManager manager = CollectionManager.getInstance();
            Flat flat = mapper.readValue(arg, Flat.class);
            int id = (int) flat.getId();
            Set<Flat> collection = manager.getFlats();
            for (Flat p : collection) {
                if (p.getId() == id) {
                    collection.remove(p);
                    collection.add(flat);
                    manager.save();
                    return "Element was added successfully";
                }
            }
            return "Element was not added.";

        } catch (IOException ioException) {
            return "Invalid argument. Try again.";
        }
    }
}