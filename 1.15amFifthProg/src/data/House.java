package data;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Emmanuel Zvavamwe
 * @version 1.0
 * Class for describing the house
 */

@XmlType (name = "house")
@XmlRootElement
public class House {
    /** field NAME */
    @XmlElement
    private  String name; //Поле не может быть null
    /** field YEAR*/
    @XmlElement
    private long year; //Значение поля должно быть больше 0
    /** field numberoflifts*/
    @XmlElement
    private long numberOfLifts; //Значение поля должно быть больше 0


    /**
     * Constructor
     * @param name - name of house
     * @param year  - how old is the house
     * @param numberOfLifts - number of ligts
     */
    public House(String name,long year,long numberOfLifts ){
        this.name =name;
        this.year =year ;
        this.numberOfLifts=numberOfLifts;
    }

    public  String getName() {

        return name;
    }

    public long getYear() {

        return year;
    }

    public long getNumberOfLifts() {

        return numberOfLifts;
    }
    /**
     * Default constructor
     */
    public House() {}

    @Override
    public String toString() {
        return "House{" +
                "name=" + name +
                "year=" + year +
                ", numberOfLifts=" + numberOfLifts +
                '}';
    }
}


