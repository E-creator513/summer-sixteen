package com.Server.commands; /**package com.Server.commands;


import com.Server.data.Flat;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.Server.CollectionManager;
import java.io.IOException;

/**
 * Class for realizing command for adding new element to the collection
 *
 * @author MANU
 * @version 1.1

public class AddCommand extends AbstractCommand {
*/
    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager

    public AddCommand(CollectionManager manager) {
        super(manager);
        setDescription("Adds new element to the collection.");
    }*/

    /**
     * Method for executing this command
     *
     * @param arg - XML-like serialized string which contains object of class Person which will be added
     * @return executing status in string representation

    public synchronized String execute(String arg) {
        try {
            Flat flat = new XmlMapper().readValue(arg, Flat.class);
            getManager().getFlats().add(flat);
            getManager().save();
            return "Element was added successfully.";
        } catch (IOException ioException) {
            return "Invalid argument";
        }
    }
}
**/

import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.ServerCode.KingManager.ServerConn;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.Server.data.Flat;

import java.io.IOException;


public class AddCommand extends AbstractCommand {

    private final ServerConn serverConnection;

    public AddCommand(ServerConn connection) {
        this.serverConnection = connection;
        setDescription("Adds new element to the collection.");
    }

    public synchronized String execute(String arg) {
        try {
           // COllectionManager manager = COllectionManager.getInstance();
            CollectionManager manager = CollectionManager.getInstance();
            Flat flat = new XmlMapper().readValue(arg, Flat.class);
            flat.setId(serverConnection.getId());
            manager.getFlats().add(flat);
            manager.save();
            return "Element was added successfully.";
        } catch (IOException ioException) {
            return "Invalid argument";
        }
    }
}