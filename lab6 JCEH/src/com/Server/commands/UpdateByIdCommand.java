package com.Server.commands;


import com.Server.CollectionManager;
import com.Server.data.Flat;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.HashSet;

/**
 * CLass for realizing command "update_by_id"
 * @author MANU
 * @version 1.1
 */
public class UpdateByIdCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public UpdateByIdCommand(CollectionManager manager) {
        super(manager);
        setDescription("Updates an element finding it by it`s ID.");
    }

    /**
     * Method for executing this command
     * @param arg - XML-like serialized string which contains object of class Person which will be added
     * @return executing status in string representation
     */
    public String execute (String arg) {
        try {
            Flat newFlat = new XmlMapper().readValue(arg, Flat.class);
            HashSet<Flat> flats = getManager().getFlats();
            String id = String.valueOf(newFlat.getId());
            for (Flat flat : flats) {
                long intId = flat.getId();
                String strId = String.valueOf(intId);
                if (strId.equals(id)) {
                    flats.remove(flat);
                    getManager().getFlats().add(newFlat);
                    getManager().save();
                    return "Element was added successfully.";
                }
            }
            return "Element was not added, because it`s id is not defined in the collection";
        } catch (IOException ioException) {
            getManager().save();
            return "File updating error.";
        }
    }
}