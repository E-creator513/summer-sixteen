package com.Server.data;


import com.Server.data.Flat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EMMANUEL ZVAVAMWE
 * @version 1.0
 * Class for describing a collection in a marshaling-ready view
 */
@XmlRootElement(name = "flats")
@XmlAccessorType (XmlAccessType.NONE)
public class Flats
{
    /** Field flats - list for keeping collection */
    @XmlElement(name = "flat")
    private List<Flat> flats = null;

    /**
     * Method for get flats list
     * @return List<Flat> persons
     */
    public List<Flat> getFlats() {

        return flats;
    }

    /** Method for passing a value to the flats  list */
    public void setFlats(ArrayList<Flat> flats) {

        this.flats = flats;
    }
}
