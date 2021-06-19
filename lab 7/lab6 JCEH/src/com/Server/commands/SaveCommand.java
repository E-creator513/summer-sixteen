package com.Server.commands;

import com.Server.ServerCode.KingManager.CollectionManager;


public class SaveCommand extends AbstractCommand {

    public SaveCommand(CollectionManager serverCollection) {
        setDescription("Does nothing. Saving is an automatic process :)");
    }

    @Override
    public synchronized String execute() {
        return "Don`t worry, saving is an automatic process starting after some changes in collection :)";
    }
}
