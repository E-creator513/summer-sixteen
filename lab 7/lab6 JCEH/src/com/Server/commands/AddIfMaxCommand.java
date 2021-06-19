package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.IOException;
import java.util.Set;

public class AddIfMaxCommand extends AbstractCommand {

    private Object Flats;

    public AddIfMaxCommand(CollectionManager serverCollection) {
        setDescription("Adds an element to collection if it`s height less then min height in this collection");
    }

    @Override
    public synchronized String execute(String arg) {
        try {
            CollectionManager manager = CollectionManager.getInstance();
            Set<Flat> flats = manager.getFlats();
            long minimalHeight = Long.MAX_VALUE;
            for (Flat flat : flats ) {
                if (flat.getNumberOfRooms() > minimalHeight) {
                    minimalHeight = flat.getNumberOfRooms();
                }
            }
            Flat flat = new XmlMapper().readValue(arg, Flat.class);
            if (flat.getNumberOfRooms() > minimalHeight) {
                manager.getFlats().add(flat);
                manager.save();
                return "Element was added successfully.";

            } else {
                manager.save();
                return "Element wan not added to collection because its height  " +
                        "greater than lower element`s height in the collection.";
            }
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println("Something bad with serializing a command.");
        } catch (IOException ioException) {
            System.out.println("Something bad with deserializing object to xml string");
        }
        return "Element is not added";
    }
}
