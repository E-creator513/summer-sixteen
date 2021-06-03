package utility;
//import javax.swing.text.View;
import data.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.View;


/**
 * @author Zvavamwe Emmanuel
 * @version 1.0
 * Class realising the commands defined
 */

public class collectionManager {
    private Deque <Flat> flats ;


    private File xmlCollection ;

    private ZonedDateTime initialingourdate;

    private boolean initialtime;

    private Deque<String> commandsinfo ;
    {
        initialtime = false;
        flats = new ArrayDeque<>();

        // Making a manual
        commandsinfo = new ArrayDeque<>();
        commandsinfo.push("help - display help for available commands");
        commandsinfo.push("info print all elements in string representation to standard output");
        commandsinfo.push("add add new element to the collection");
        commandsinfo.push("update_by_id id - update the element`s value, whose ID is equal to the given." +
                " You should to enter ID after entering a command.");
        commandsinfo.push("remove_by_id id - remove an element from the collection by its ID." +
                " You should to enter ID after entering a command.");
        commandsinfo.push("clear - clear the collection");
        commandsinfo.push("save - save the collection to file");
        commandsinfo.push("execute_script filename - read and execute a script from specified file." +
                " You should to enter path to file after entering a command.");
        commandsinfo.push("exit - end the program (without saving to file)");
        commandsinfo.push("add_if_min - add new element to the collection, if it`s value less, " +
                "than smallest element of this collection. You should to enter characteristics of" +
                " comparing element after entering a command.");
        commandsinfo.push("remove_greater - remove from the collection all elements greater than the specified" +
                " one. You should to enter a height which will be comparing with element`s heights.");
        commandsinfo.push("remove_lower - remove from the collection all elements less than the specified one." +
                " You should to enter a height which will be comparing with element`s heights.");
        commandsinfo.push("sum_of_height - print the sum of the values of the height field for all elements" +
                " of the collection");
        commandsinfo.push("group_counting_by_nationality - group collection items by field value " +
                "nationality, display the number of items in each group");
        commandsinfo.push("count_greater_than_nationality nationality - print the number of elements, value" +
                "whose nationality fields are greater than the given. You should to enter a nationality which will" +
                " be comparing with element`s heights.");
    }


    // Constructor for checking a path to file existence and file readiness to work
    public collectionManager() {
        Scanner scanner = new Scanner(System.in);
        try {
            for ( ; ; ) {
                System.out.print("pliz show me where i am wrong GOD Enter a full path to XML file with collection: ");
                String pathToFile = scanner.nextLine();
                if (checkFile(pathToFile)) {
                    try {
                        final QName qName = new QName("person");
                        InputStream inputStream = new FileInputStream(new File(pathToFile));
                        // create xml event reader for input stream
                        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
                        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
                        // initialize jaxb
                        JAXBContext context = JAXBContext.newInstance(Flat.class);
                        Unmarshaller unmarshaller = context.createUnmarshaller();
                        XMLEvent e;
                        // Field for counting amount of downloaded elements
                        int counterGood = 0;
                        int counterBad = 0;
                        // Loop for unmarshalling the collection
                        while ((e = xmlEventReader.peek()) != null) {
                            // check the event is a Document start element
                            if (e.isStartElement() && ((StartElement) e).getName().equals(qName)) {
                                // unmarshall the document
                                Flat unmarshalledFlat = unmarshaller.unmarshal(xmlEventReader, Flat.class).getValue();
                                Coordinates newCoordinates = unmarshalledFlat.getCoordinates();
                                House newHouse = unmarshalledFlat.getHouse();
                                if (unmarshalledFlat.getId() != 0 && !unmarshalledFlat.getName().equals(null) &&
                                        !newCoordinates.getX().equals(null) && !newCoordinates.getY().equals(null) &&
                                        !unmarshalledFlat.returnCreationDate().equals(null) && unmarshalledFlat.getArea() > 0
                                        && !unmarshalledFlat.getLivingSpace().equals(null)
                                        && !unmarshalledFlat.getFurnish().equals(null) && !newHouse.getName().equals(null) &&
                                        !unmarshalledFlat.getView().equals(null)) {
                                    flats.add(unmarshalledFlat);
                                    counterGood += 1;
                                } else counterBad += 1;
                            } else {
                                xmlEventReader.next();
                                xmlEventReader.next();
                            }
                        }
                        System.out.println("Collection was loaded successfully. " + counterGood + " elements has been loaded.");
                        System.out.println("Amount of elements which contains invalid values and has not been loaded: " + counterBad);
                        xmlCollection = new File(pathToFile);
                        initialtime = true;
                        initialingourdate = ZonedDateTime.now();
                        break;
                    } catch (JAXBException jaxbException) {
                        System.out.println("XML syntax error.");
                    } catch (FileNotFoundException fileNotFoundException) {
                        System.out.println("File not found");
                    } catch (XMLStreamException xmlStreamException) {
                        System.out.println("XML Stream error");
                    }
                } else System.out.println("Try again.");
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }

    /**
     * Class which check file is existed, and can be readable and writeable.
     * @return readiness status
     */
    public boolean checkFile(String pathToFile) {
        File checkingFile = new File(pathToFile);
        if (!checkingFile.exists()) {
            System.out.println("File not found. Try again.");
            return false;
        }
        if (!checkingFile.canRead()) {
            System.out.println("File cannot be readable. You should to have this permission.");
            return false;
        }
        if (!checkingFile.canWrite()) {
            System.out.println("File cannot be writeable. You should to have this permission.");
            return false;
        }
        return true;
    }
    /** Method for printing manual for user */
    public void help() {
        //HashMap<Object, Object> commandsInfo;
        commandsinfo = new ArrayDeque<>();
        Iterator<String> itr = commandsinfo.descendingIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


    }
    /** Method for printing information about the collection */
    public void info() {
        System.out.println("Type of collection: java.util.Arraydeque");
        System.out.println("Initialization date: " + initialingourdate);
        System.out.println("Amount of elements in the collection: " + flats.size());
        System.out.println("Collection manager is active: " + initialtime );
    }

    /** Method for printing collection elements into the string representation */
    public void show() {
        for (Flat flat : flats) {
            System.out.println(flat.toString() + "\n");
        }
    }

    /**
     * Method for receiving ID of element
     * @return int ID
     */
    public long   receiveId() {
        long maxId=0;
        for (Flat flat : flats) {
            if (flat.getId()>maxId)
                maxId =flat.getId();
        }
        return maxId + 1;
    }
    /**
     * Method for receiving the number of rooms
     * @return int  NumberOfRooms
     */
    public int ReceiveNumberOfRooms() {

        for ( ; ; ) {

            System.out.print("Enter number of rooms. Value must be greater than 0. ");
            Scanner scanner = new Scanner(System.in);
            int NumberofRooms = scanner.nextInt();
            for (Flat flat : flats)
                if (flat.getNumberOfRooms() < 0) {
                    flat.getNumberOfRooms();

                    System.out.println("This value must be greater than 0 pal. Try again. ");
                    continue;
                }
            return NumberofRooms;
        }
    }



    public Integer receiveLivingSpace(){
        Integer LivingSpace=0;
        for(Flat flat : flats){
            if (flat.getLivingSpace()>0){
                flat.getLivingSpace();
            }
        }
        return LivingSpace;
    }

    /**
     * Method for receiving name of element
     * @return String name
     */
    public String receiveName() {
        for ( ; ; ) {
            try {
                System.out.println("Attention! If name will be so long, you may lose some part of this information");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name: ");
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty. Try again");
                    continue;
                }
                return name;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving x-coordinate of element
     * @return long x
     */
    public Integer receiveX() {
        for ( ; ; ) {
            try {
                System.out.print("Enter X coordinate. Max value is 690. ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Value cannot be empty. ");
                long x = scanner.nextInt();
                System.out.print("Value cannot be empty. ");
                String xx = Integer.toString((int) x);
                if (x == Integer.parseInt(null)) {
                    System.out.println("Max value is 690. Try again. ");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return Math.toIntExact(x);
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving y-coordinate of element
     * @return Float y
     */
    public Long receiveY() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Y coordinate. This value cannot be empty. ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextLong();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /** Method for making coordinates by using methods receiveX() and receiveY() */
    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }

    /**
     * Method for receiving height of element
     * @return long height
     */
    public long receiveArea() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Area. Value must be greater than 0. ");
                Scanner scanner = new Scanner(System.in);
                long area = scanner.nextLong();
                if (area <= 0 || area >975 )  {

                    System.out.println("This value must be greater than 0 and less than 975 pal. Try again. ");
                    continue;
                }
                return area;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving x-coordinate of location of element
     * @return long xLocation
     */
    public Integer receiveNumberOfLifts() {
        for ( ; ; ) {
            try {
                System.out.print("Enter number of lifts of the house. ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving y-coordinate of element
     * @return Double yLocation
     */
    public Long receiveyearHouse() {
        for ( ; ; ) {
            try {
                System.out.print("Enter the year the house was built  : ");
                Scanner scanner = new Scanner(System.in);
                Long yearHouse = scanner.nextLong();
                if (yearHouse.equals(0)) {
                    System.out.println("This value cannot be empty. Try again. ");
                }
                return scanner.nextLong();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving name of element`s house
     * @return String nameLocation
     */
    public String receiveNameHouse() {
        for ( ; ; ) {
            try {
                System.out.println("Attention! If name will be so long, you may lose some part of this information");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name of house: ");
                String nameHouse = scanner.nextLine().trim();
                if (nameHouse.equals("")) {
                    System.out.println("This value cannot be empty. Try again. ");
                }
                return nameHouse;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving Location field by using methods receiveXLocation(),
     * receiveYLocation() and receiveNameLocation()
     * @return Location location
     */
    public House receiveHOUSE() {

        return new House(receiveNameHouse(), receiveyearHouse(),receiveNumberOfLifts());
    }

    /**
     * Method for receiving  furnish
     * @return furnish
     */
    public Furnish receiveFurnish() {
        for ( ; ; ) {
            try {
                System.out.println("Choose the type of furniture. Enter the number according to your liking. ");
                System.out.print("Variants: 1 -NONE, 2 - FINE, 3 - BAD. Enter 1, 2 or 3: ");
                Scanner scanner = new Scanner(System.in);
                int furnisherChoose = scanner.nextInt();
                switch (furnisherChoose) {
                    case 1:
                        return Furnish.NONE;
                    case 2:
                        return Furnish.FINE;
                    case 3:
                        return Furnish.BAD;
                    default:
                        break;
                }
                System.out.println("You should to enter 1, 2 or 3. Try again. ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a number (1, 2 or 3). Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving hair color of element
     * @return View view
     */
    public View receiveView() {
        for ( ; ; ) {
            try {
                System.out.println("Choose the type of view. Enter the number corresponding to the desired option.");
                System.out.print("Variants: 1 - STREET, 2 - YARD, 3 - BAD, 4 - NORMAL, 5 - GOOD . Enter 1, 2, 3, 4, or 5: ");
                Scanner scanner = new Scanner(System.in);
                int ViewChoice = scanner.nextInt();
                switch (ViewChoice) {
                    case 1:
                        return View.STREET;
                    case 2:
                        return View.YARD;
                    case 3:
                        return View.BAD;
                    case 4:
                        return View.NORMAL;
                    case 5:
                        return View.GOOD;
                    default:
                        break;
                }
                System.out.println("You should to enter 1, 2, 3, 4 or 5. Try again. ");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a number (1, 2, 3, 4 or 5). Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }



    /** Method for adding element by using all receive-fields methods */
    public void add() {
        Flat newFlat = new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(),
                receiveArea(),ReceiveNumberOfRooms(),receiveLivingSpace(), receiveFurnish(), receiveView(),receiveHOUSE());
        flats.add(newFlat);
    }

    /** Method for saving (marshaling) java collection to XML-file and updating hash of file
    public void save() {
        try {
            Flatsdude newFlats = new Flatsdude();
            newFlats.setFlatsdude(new ArrayList<>(flats));
            JAXBContext jaxbContext = JAXBContext.newInstance(Flat.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //Marshal the persons list in file
            jaxbMarshaller.marshal(newFlats, xmlCollection);
        } catch (JAXBException jaxbException) {
            System.out.println("XML syntax error. Try again. ");
        }


    } */

    /** Method for remove elements from collection if it`s height more than entered height */
    public void remove_greater(long area) {
        int counter = 0;
        for (Flat flat : flats) {
            if (flat.getArea() > area) {
                flats.remove(flat);
                counter += 1;
            }
        }
        System.out.println("Operation was finished successfully. " + counter + " elements were deleted.");
    }

    /** Method for remove elements from collection if it`s  number of rooms is less than entered height */
    public void remove_lower(int NoOfRooms) {
        int counter = 0;
        for (Flat flat : flats) {
            if (flat.getNumberOfRooms() < NoOfRooms) {
                flats.remove(flat);
                counter += 1;
            }
        }
        System.out.println("Operation was finished successfully. " + counter + " elements were deleted.");
    }

    /** Method for adding element to collection if it`s height less than entered height */
    public void add_if_min(Flat example) {
        long minimalHeight = Long.MAX_VALUE;
        for (Flat flat : flats) {
            if (flat.getArea() < minimalHeight) {
                minimalHeight = flat.getArea();
            }
        }
        if (example.getArea() < minimalHeight) {
            flats.add(example);
            System.out.println("Element was added successfully.");
        } else {
            System.out.println("Element wan not added to collection because its height " +
                    "greater than lower element`s height in the collection.");
        }
    }

    /** Method for printing sum of element`s heights */
    public void sum_of_height() {
        double sum = 0;
        for (Flat person : flats) {
            sum += person.getArea();
        }
        System.out.println("Sum of height values in this collection is " + sum);
    }

    /** Method for switching off the program */
    public void exit() {
        try {
            System.out.println("Program will be finished now. ");
            TimeUnit.SECONDS.sleep(2);
            System.exit(0);
        } catch (InterruptedException interruptedException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }

    /** Method for removing all elements from collection */
    public void clear() {
        flats.clear();
        System.out.println("Collection was cleaned successfully.");
    }


    public void Group_counting_by_Furnish(){
        int CouNone=0;
        int CouFine=0;
        int CouBad=0 ;
        for (Flat flat : flats ){
            switch (flat.getFurnish()){
                case NONE:
                    CouNone+=1;
                case FINE:
                    CouFine+=1;
                case BAD:
                    CouBad+=1;
            }
        }
        System.out.println("ELEMENTS OF THIS COLLECTION WERE GROUPED BY FURNISH");
        System.out.println("First group : NONE.Amount of Elements :"+CouNone);
        System.out.println("Second group : NONE.Amount of Elements :"+CouFine);
        System.out.println("Third group : NONE.Amount of Elements :"+CouFine);
    }
    /** Method for removing the element by it`s ID */
    public void remove_by_id(String id) {
        for (Flat flat : flats) {
            long intId = flat.getId();
            String strId = String.valueOf(intId);
            if (strId.equals(id)) {
                flats.remove(flat);
                System.out.println("Element was deleted successfully.");
            }
        }
        System.out.println("Element with this ID is not defined.");
    }

    /** Method for updating the element by it`s ID */
    public void update_by_id(String id) {
        for (Flat flat : flats) {
            long intId = flat.getId();
            String strId = String.valueOf(intId);
            if (strId.equals(id)) {
                flats.remove(flat);
                Flat updatedFlat = new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(),
                        receiveArea(),ReceiveNumberOfRooms(),receiveLivingSpace(), receiveFurnish(), receiveView(),receiveHOUSE());
                flats.add(updatedFlat);
                System.out.println("Element was updated successfully.");
            }
        }
        System.out.println("Element with this ID is not defined. Try again.");
        System.out.println("Element with this ID is not defined.");
    }



    /** Method for executing script from external file */
    public void execute_script(String nameOfFile) {
        try {
            System.out.println("WARNING. To avoid recursion, your file cannot contain execute script commands.");
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameOfFile)));
            //private String userCommand;
            String[] finalUserCommand;
            String command;
            while((command = reader.readLine()) != null) {
                finalUserCommand = command.trim().toLowerCase().split(" ", 2);
                switch (finalUserCommand[0]) {
                    case "help":
                        help();
                        break;
                    case "info":
                        info();
                        break;
                    case "show":
                        show();
                        break;
                    case "add":
                        add();
                        break;
                    case "update_by_id":
                        update_by_id(finalUserCommand[1]);
                        break;
                    case "remove_by_id":
                        remove_by_id(finalUserCommand[1]);
                        break;
                    case "clear":
                        clear();
                        break;
                    /**case "save":
                        save();
                        break;*/
                    case "execute_script":
                        System.out.println("This script cannot to contain this command.");
                        break;
                    case "exit":
                        exit();
                    case "add_if_min":
                        add_if_min( new Flat(receiveId(),receiveName(),receiveCoordinates(),returnDate(),receiveArea(),ReceiveNumberOfRooms(),receiveLivingSpace(),receiveFurnish(),receiveView(),receiveHOUSE())
                        );
                        break;
                    case "remove_greater":
                        remove_greater(receiveArea());
                        break;
                    case "remove_lower":
                        remove_lower((int) receiveArea());
                        break;
                    case "sum_of_height":
                        sum_of_height();
                        break;
                    case "group_counting_by_furniture":
                        Group_counting_by_Furnish();
                        break;
                    //case "count_greater_than_nationality":
                    //    count_greater_than_nationality(receiveNationality());
                    //    break;
                    default:
                        reader.readLine();
                        break;
                }
                System.out.println("Command is ended.");
            }
            System.out.println("Commands are ended.");
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found. Try again.");
        } catch (IOException ioException) {
            System.out.println("File reading exception. Try again.");
        }
    }

    /** Method for printing current date in string representation */
    public String returnDate() {
        return ZonedDateTime.now().toString();
    }
}

/** Method for adding element by using all receive-fields methods */







