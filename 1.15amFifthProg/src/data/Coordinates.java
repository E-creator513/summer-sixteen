package data;

import javax.xml.bind.annotation.XmlElement;

public class Coordinates {
    /** field x */
    @XmlElement
    private Integer x; //Поле не может быть null
    /** field x */
    @XmlElement
    private Long y; //Поле не может быть null

    /**
     * Constructor for making Coordinates field
     * @param receiveX - x-coordinate
     * @param receiveY- y-coordinate
     */
    public Coordinates(Integer receiveX, Long receiveY) {
        this.x=x;
        this.y=y;
    }
    /** Default constructor */
    public Coordinates() {}

    public Integer getX() {
        return x;
    }



    public Long getY() {
        return y;
    }



    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}