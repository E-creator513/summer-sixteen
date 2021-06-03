package data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;




/**
 * @author EMMANUEL TAFADZWA
 * @QUANTUM
 */

@XmlRootElement(name="com.utility.Flatsdude")
@XmlAccessorType(XmlAccessType.NONE)
public class Flatsdude {
    /** Field persons - list for keeping collection */
    @XmlElement(name = "flat")
    private List<Flat> flats = null;

    /**
     * Method for get persons list
     * @return List<Person> persons
     */
    public List<Flat> getFlatsdude() {
        return flats;
    }

    /** Method for passing a value to the persons list */
    public void setFlatsdude(ArrayList<Flat> flats) {
        this.flats = flats;
    }
}


