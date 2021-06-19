package com.Server.commands;

import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.ServerCode.KingManager.ServerConn;


public class ClearCommand extends AbstractCommand {

    private final ServerConn serverConnection;

    public ClearCommand(ServerConn connection) {
        this.serverConnection = connection;
        setDescription("Removes all elements of the collection.");
    }

    @Override
    public synchronized String execute() {
        CollectionManager manager = CollectionManager.getInstance();
        manager.getFlats().removeIf(p -> (p != null && p.getId() == serverConnection.getId()));
        manager.save();
        return "All your elements are removed.";
    }
}
