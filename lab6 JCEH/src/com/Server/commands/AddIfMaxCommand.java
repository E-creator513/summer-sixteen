package com.Server.commands;


import com.Server.CollectionManager;
import com.Server.data.Flat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.HashSet;

/**
 * Class for realizing command "add_fi_min"
 *
 * @author MANU
 * @version 1.1
 */
public class AddIfMaxCommand extends AbstractCommand {

    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public AddIfMaxCommand(CollectionManager manager) {
        super(manager);
        setDescription("Adds an element to collection if it`s height less then min height in this collection");
    }

    /**
     * Method for executing a command
     *
     * @param arg - XML-like serialized string which contains object of class Person which will be added
     * @return executing status into string representation
     */
    public synchronized String execute(String arg) {
        try {
            HashSet<Flat> flats = getManager().getFlats();
            long minimalHeight = Long.MAX_VALUE;
            for (Flat flat : flats) {
                if (flat.getArea() > minimalHeight) {
                    minimalHeight = flat.getArea();
                }
            }
            Flat flat = new XmlMapper().readValue(arg, Flat.class);
            if (flat.getArea() > minimalHeight) {
                getManager().getFlats().add(flat);
                getManager().save();
                return "Element was added successfully.";

            } else {
                getManager().save();
                return "Element wan not added to collection because its Area is  " +
                        "less than higher element`s height in the collection.";
            }
        } catch (JsonProcessingException jsonProcessingException) {
            System.out.println("Something bad with serializing a command.");
        } catch (IOException ioException) {
            System.out.println("Something bad with deserializing object to xml string");
        }
        return "Element is not added";
    }
}

