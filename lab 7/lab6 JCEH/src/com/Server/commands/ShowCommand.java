package com.Server.commands;


import com.Server.ServerCode.KingManager.CollectionManager;
import com.Server.ServerCode.KingManager.ServerConn;
import com.Server.data.Flat;

import java.util.Set;

public class ShowCommand extends AbstractCommand {

    private final ServerConn serverConnection;

    public ShowCommand(ServerConn connection) {
        this.serverConnection = connection;
        setDescription("Prints all elements in string representation to standard output.");
    }

    @Override
    public synchronized String execute() {
        CollectionManager manager = CollectionManager.getInstance();
        Set<Flat> collection = manager.getFlats();
        StringBuilder result = new StringBuilder();
        if (collection.size() != 0) {
            for (Flat p: collection) {
                result.append(p.toString());
                if (p.getId() == serverConnection.getId()) result.append(" ВЛАДЕЛЕЦ");
                result.append("\n    ");
            }
            return result.toString();
        }
        else return "Коллекция пуста.";
    }
}