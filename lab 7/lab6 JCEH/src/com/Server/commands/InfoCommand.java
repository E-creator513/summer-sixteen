package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.ServerCode.KingManager.ServerConn;
import com.Server.data.Flat;

import java.util.Set;

public class InfoCommand extends AbstractCommand {

    ServerConn serverConnection;

    public InfoCommand(ServerConn connection) {
        setDescription("Prints information about the collection.");
        this.serverConnection = connection;
    }

    @Override
    public synchronized String execute() {
        Set<Flat> collection = CollectionManager.getInstance().getFlats();
        int amountOfElements = 0;
        for (Flat p: collection) if (p.getId() == serverConnection.getId()) amountOfElements++;
        return CollectionManager.getInstance().toString() + "\nYour ID in system is: " +
                serverConnection.getId() + "\nAmount of yours elements: " + amountOfElements;
    }
}