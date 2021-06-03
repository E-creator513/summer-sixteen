package com.Server.data;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZonedDateTime;


@XmlRootElement (name = "flat")
@XmlAccessorType(XmlAccessType.NONE)
public class Flat {
    /** Field ID */
    @XmlElement
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /** Field ID */
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    /** Field ID */
    @XmlElement
    private Coordinates coordinates; //Поле не может быть null
    /** Field ID */
    @XmlElement
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /** Field ID */
    @XmlElement
    private long area; //Максимальное значение поля: 975, Значение поля должно быть больше 0
    /** Field ID */
    @XmlElement
    private int numberOfRooms; //Значение поля должно быть больше 0
    /** Field ID */
    @XmlElement
    private Integer livingSpace; //Значение поля должно быть больше 0
    /** Field ID */
    @XmlElement
    private Furnish furnish; //Поле не может быть null
    /** Field ID */
    @XmlElement
    private View view; //Поле не может быть null
    /** Field ID */
    @XmlElement
    private House house; //Поле может быть null
    /** Field ID */


    public Flat(long id, String name, Coordinates coordinates, String creationDate, long area, int numberOfRooms, Integer livingSpace, Furnish furnish, View view, House house) {
        this.id=id ;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=returnCreationDate();
        this.area=area;
        this.numberOfRooms=numberOfRooms;
        this.livingSpace=livingSpace;
        this.furnish=furnish;
        this.view=view;
        this.house=house;

    }
    /** Default constructor */
    public Flat() {

    }
    /**
     * Method for get ID
     * @return int id
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Method for get name
     * @return  String
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method for get Coordinates
     * @return  coordinates
     */

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Method for get Area
     * @return long area
     */

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
    /**
     * Method for get Number of rooms
     * @return int numberOfRooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    /**
     * Method for get Livivng Space
     * @return Integer
     */
    public Integer getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(Integer livingSpace) {
        this.livingSpace = livingSpace;
    }
    /**
     * Method for get furnish
     * @return Furnish  furnish
     */
    public Furnish getFurnish() {
        return furnish;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }
    /**
     * Method for get View
     * @return View view
     */
    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
    /**
     * Method for get House
     * @return House house
     */
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }


    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", livingSpace=" + livingSpace +
                ", furnish=" + furnish +
                ", view=" + view +
                ", house=" + house +

                '}';
    }
    /**
     * Method for get current date into string representation
     * @return String date
     */
    public String returnCreationDate() {
        return ZonedDateTime.now().toString();
    }




    public int compareTo(Flat p){
        return getName().compareTo(p.getName());
    }
}



