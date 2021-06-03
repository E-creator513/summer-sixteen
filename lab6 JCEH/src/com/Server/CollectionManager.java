package com.Server;

import javax.xml.bind.*;
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


import com.Server.data.*;
/**
 * @author Mr Zvavamwe Emmanuel
 * @version 1.0
 * Class which realised user`s commands
 */
public class CollectionManager {

    /**
     * HashSet collection for keeping a collection as java-object
     */
    private final HashSet<Flat> flats;

    private NavigableSet<Flat> flats1;
    /**
     * Field used for saving collection into xml file
     */
    private File xmlCollection;
    /**
     * Field for saving date of initialization thw collection
     */
    private ZonedDateTime initializationDate;
    /**
     * Field for checking the program was started
     */
    private boolean wasStart;
    /**
     * HashMap collection for making a manual
     */
    private final HashMap<String, String> commandsInfo;
    private Object InfoCommand;

    {
        wasStart = false;
        flats = new HashSet<>();

        // Making a manual
        commandsInfo = new HashMap<>();
        commandsInfo.put("help", " - display help for available commands");
        commandsInfo.put("info", " - print all elements in string representation to standard output");
        commandsInfo.put("add", " - add new element to the collection");
        commandsInfo.put("update_by_id id", " - update the element`s value, whose ID is equal to the given." +
                " You should to enter ID after entering a command.");
        commandsInfo.put("remove_by_id id", " - remove an element from the collection by its ID." +
                " You should to enter ID after entering a command.");
        commandsInfo.put("clear", " - clear the collection");
        commandsInfo.put("save", " - save the collection to file");
        commandsInfo.put("execute_script filename", " - read and execute a script from specified file." +
                " You should to enter path to file after entering a command.");
        commandsInfo.put("exit", " - end the program (without saving to file)");
        commandsInfo.put("add_if_min", " - add new element to the collection, if it`s value less, " +
                "than smallest element of this collection. You should to enter characteristics of" +
                " comparing element after entering a command.");
        commandsInfo.put("remove_header ", " - remove from the collection all elements greater than the specified" +
                " one. You should to enter a height which will be comparing with element`s heights.");
        commandsInfo.put("add_if_max {element} :", " add a new item to the collection if its value is greater than the value of the largest item in this collection");
        commandsInfo.put("count_counting _than_Furnish furnish :", " print the number of elements whose value of the numberOfRooms field is less than the given one");
        commandsInfo.put("group_counting_by_number_of_rooms numberOfRooms ", " - group collection items by field value " +
                "number of rooms , display the number of items in each group");
        commandsInfo.put("filter_starts_with_name name :", " display elements whose name field value begins with the given substring.");
    }

    // Constructor for checking a path to file existence and file readiness to work
    public CollectionManager(String arg) {
     //   Scanner scanner = new Scanner(System.in);
        try {

                if (checkFile(arg)) {
                    try {
                        final QName qName = new QName("flat");
                        InputStream inputStream = new FileInputStream(new File(arg));
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
                                House newHouse1 = unmarshalledFlat.getHouse();
                                if (unmarshalledFlat.getId() != 0 && !unmarshalledFlat.getName().equals(null) &&
                                        !newCoordinates.getX().equals(null) && !newCoordinates.getY().equals(null) &&
                                        !unmarshalledFlat.returnCreationDate().equals(null) && unmarshalledFlat.getArea() > 0 &&
                                        unmarshalledFlat.getNumberOfRooms() > 0
                                        && !unmarshalledFlat.getLivingSpace().equals(null) && !unmarshalledFlat.getFurnish().equals(null)
                                        && !unmarshalledFlat.getView().equals(null) && newHouse.getNumberOfLifts() > 0 &&
                                        newHouse.getYear() > 0 && !newHouse.getNamehouse().equals(null)) {
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
                        xmlCollection = new File(arg);
                        wasStart = true;
                        initializationDate = ZonedDateTime.now();

                    } catch (JAXBException jaxbException) {
                        System.out.println("XML syntax error pliz and i knew i got him .");
                    } catch (FileNotFoundException fileNotFoundException) {
                        System.out.println("File not found");
                    } catch (XMLStreamException xmlStreamException) {
                       xmlCollection=new File(arg);
                        System.out.println("empty collection was loaded successffuly ");
                    }
                } else { System.out.println("Try again.");
                System.exit(1);
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }

    public void add(CollectionManager comm) {
        Flat newFlat = new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(), receiveArea(), ReceiveNumberOfRooms(),
                receiveLivingSpace(), receiveFurnish(), receiveView(), receiveHOUSE());
        flats.add(newFlat);
    }

    /**
     * Class which check file is existed, and can be readable and writeable.
     *
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

    /**
     * Method for printing manual for user
     */
    public void help() {
        for (Map.Entry<String, String> entry : commandsInfo.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }


    /** Method for printing information about the collection */
    public String info() {
        StringBuilder result = new StringBuilder();
        result.append("Type of collection: java.util.HashSet" + "\n");
        result.append("Initialization date: " + initializationDate + "\n");
        result.append("Amount of elements in the collection: " + flats.size() + "\n");
        result.append("Collection manager is active: " + wasStart);
        return result.toString();
    }

    /**
     * Method for printing collection elements into the string representation
     */
    public void show() {
        for (Flat flat : flats) {
            System.out.println(flat.toString() + "\n");
        }
    }

    /**
     * Method for receiving ID of element
     *
     * @return int ID
     */
    public long receiveId() {
        long maxId = 0;
        for (Flat flat : flats) {
            if (flat.getId() > maxId) {
                maxId = flat.getId();
            }
        }
        return maxId + 1;
    }

    /**
     * Method for receiving name of element
     *
     * @return String name
     */
    public String receiveName() {
        for (; ; ) {
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
     *
     * @return long x
     */
    public long receiveX() {
        for (; ; ) {
            try {
                System.out.print("Enter X coordinate. Max value is 690. ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Value cannot be empty. ");
                long x = scanner.nextLong();
                System.out.print("Value cannot be empty. ");
                String xx = Long.toString(x);
                if (x > 690) {
                    System.out.println("Max value is 690. Try again. ");
                    continue;
                }
                if (xx.equals("")) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return x;
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
     *
     * @return Float y
     */
    public Float receiveY() {
        for (; ; ) {
            try {
                System.out.print("Enter Y coordinate. This value cannot be empty. ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextFloat();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for making coordinates by using methods receiveX() and receiveY()
     */
    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }

    /**
     * Method for receiving height of element
     *
     * @return long height
     */
    public long receiveArea() {
        for (; ; ) {
            try {
                System.out.print("Enter Area. Value must be greater than 0. ");
                Scanner scanner = new Scanner(System.in);
                long area = scanner.nextLong();
                if (area <= 0 || area > 975) {

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
     * Method for receiving the number of rooms
     *
     * @return int  NumberOfRooms
     */
    public int ReceiveNumberOfRooms() {

        for (; ; ) {

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


    public Integer receiveLivingSpace() {
        Integer LivingSpace = 0;
        for (Flat flat : flats) {
            if (flat.getLivingSpace() > 0) {
                flat.getLivingSpace();
            }
        }
        return LivingSpace;
    }

    /**
     * Method for receiving  furnish
     *
     * @return furnish
     */
    public Furnish receiveFurnish() {
        for (; ; ) {
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
     * Method for receiving the view of element
     *
     * @return View view
     */
    public View receiveView() {
        for (; ; ) {
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


    public Integer receiveNumberOfLifts() {
        for (; ; ) {
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
     *
     * @return Double yLocation
     */
    public Long receiveyearHouse() {
        for (; ; ) {
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
     *
     * @return String nameLocation
     */
    public String receiveNameHouse() {
        for (; ; ) {
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
     *
     * @return Location location
     */
    public House receiveHOUSE() {

        return new House(receiveNameHouse(), receiveyearHouse(), receiveNumberOfLifts());
    }


    /**
     * Method for adding element by using all receive-fields methods
     *
     * @param
     */
    public void add() {
        Flat newFlat = new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(), receiveArea(), ReceiveNumberOfRooms(),
                receiveLivingSpace(), receiveFurnish(), receiveView(), receiveHOUSE());
        flats.add(newFlat);
    }

    /**
     * Method for saving (marshaling) java collection to XML-file and updating hash of file
     *
     * @param
     */
    public void save() {
        try {
            Flats newFlats = new Flats();
            newFlats.setFlats(new ArrayList<>(flats));
            JAXBContext jaxbContext = JAXBContext.newInstance(Flats.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Marshal the persons list in file
            jaxbMarshaller.marshal(newFlats, xmlCollection);
        } catch (JAXBException jaxbException) {
            System.out.println("XML syntax error. Try again. ");
        }


    }

    /**
     * Method for remove elements from collection if it`s number of rooms entered is greater than precidded
     */
    public void remove_header(int numberOfRooms) {
        int counter = 0;
        for (Flat flat : flats) {
            if (flat.getNumberOfRooms() > numberOfRooms) {
                flats.remove(flat);
                counter += 1;
            }
        }
        System.out.println("Operation was finished successfully. " + counter + " elements were deleted.");
    }

    /**
     * Method for remove elements from collection if it`s height less than entered height
     */

    public void add_if_max(Flat example) {
        long maximumnumberofrooms = Long.MAX_VALUE;
        for (Flat flat : flats) {
            if (flat.getNumberOfRooms() > maximumnumberofrooms) {
                maximumnumberofrooms = flat.getNumberOfRooms();
            }
        }
        if (example.getNumberOfRooms() > maximumnumberofrooms) {
            flats.add(example);
            System.out.println("Element was added successfully.");
        } else {
            System.out.println("Element wan not added to collection because its height  " +
                    "less than the high element`s height in the collection.");
        }
    }

    /**
     * Method for adding element to collection if it`s height less than entered height
     */
    public void add_if_min(Flat example) {
        long minimalnumberofrooms = Long.MAX_VALUE;
        for (Flat flat : flats) {
            if (flat.getNumberOfRooms() < minimalnumberofrooms) {
                minimalnumberofrooms = flat.getNumberOfRooms();
            }
        }
        if (example.getNumberOfRooms() < minimalnumberofrooms) {
            flats.add(example);
            System.out.println("Element was added successfully.");
        } else {
            System.out.println("Element wan not added to collection because its height  " +
                    "greater than lower element`s height in the collection.");
        }
    }

    /**
     * Method for printing sum of element`s heights
     */
    public void filter_starts_with_name(String name) {
        String[] name1;
        for (Flat flat : flats) {
            String[] words = new String[]{"abcd", "abcde", "abcdef", "abfg", "abdc"};
            String filter = "abc";

            for (String word : words) {
                if (word.matches(filter + "(.*)")) {
                    System.out.println("This pass the filter: " + word);
                }
            }

        }

    }

    /**
     * Method for switching off the program
     */
    public void exit() {
        try {
            System.out.println("Program will be finished now. ");
            TimeUnit.SECONDS.sleep(3);
            System.exit(0);
        } catch (InterruptedException interruptedException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }

    /**
     * Method for removing all elements from collection
     */
    public void clear() {
        flats.clear();
        System.out.println("Collection was cleaned successfully.");
    }

    /**
     * Method for counting amount of elements, which the number of elements whose value of the numberOfRooms field is less than the given one
     * @param numberOfRooms
     * @return
     */
    public int count_less_than_numberof_rooms(int numberOfRooms) {
        int counter = 0;
        for (Flat flat : flats) {
            if ((flat.getNumberOfRooms() ) < numberOfRooms) {
                System.out.println("number of rooms less than the given one " + numberOfRooms);
            }
        }
        System.out.println("Operation was finished successfully. " + counter + " elements.");
        return counter;
    }

    /**
     * Method for removing the element by it`s ID
     */
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

    /**
     * Method for updating the element by it`s ID
     */
    public void update_by_id(String id) {
        for (Flat flat : flats) {
            long intId = flat.getId();
            String strId = String.valueOf(intId);
            if (strId.equals(id)) {
                flats.remove(flat);
                Flat updatedFlat = new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(), receiveArea(), ReceiveNumberOfRooms(),
                        receiveLivingSpace(), receiveFurnish(), receiveView(), receiveHOUSE());
                flats.add(updatedFlat);
                System.out.println("Element was updated successfully.");
            }
        }
        System.out.println("Element with this ID is not defined. Try again.");
        System.out.println("Element with this ID is not defined.");
    }

    /**
     * Method for counting amount and grouping elements by it`s nationality field
     */
    public String group_counting_by_furnish() {
        int chinaCounter = 0;
        int germanyCounter = 0;
        int northKoreaCounter = 0;

        int FINE = 0;
        int NONE = 0;
        int BAD = 0;

        for (Flat flat : flats) {
            switch (flat.getFurnish()) {
                case FINE:
                    FINE += 1;
                case NONE:
                    NONE += 1;
                case BAD:
                    BAD += 1;
            }
        }
        StringBuilder result = new StringBuilder();
        System.out.println("Elements of this collection were grouped by FURNISH.");
        System.out.println("First group: FINE. Amount of elements: " + FINE);
        System.out.println("Second group: NONE . Amount of elements: " + NONE);
        System.out.println("Third group: BAD. Amount of elements: " + BAD);
        return result.toString();
    }
    public String nameFilteredInfo(String name) {
        String info = "";
        for (Flat flat : flats1) {
            String weaponToFilter;
            if (flat.getName().equals(name)) {
                info += flat + "\n\n";
            }
        }
        return info.trim();
    }

    /**
     * Method for executing script from external file
     */
    public void execute_script(String nameOfFile) {
        try {
            System.out.println("WARNING. To avoid recursion, your file cannot contain execute script commands.");
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameOfFile)));
            //private String userCommand;
            String[] finalUserCommand;
            String command;
            while ((command = reader.readLine()) != null) {
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
                    case "save":
                        save();
                        break;
                    case "execute_script":
                        System.out.println("This script cannot to contain this command.");
                        break;
                    case "exit":
                        exit();
                    case "add_if_min":
                        add_if_min(new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(), receiveArea(), ReceiveNumberOfRooms(),
                                receiveLivingSpace(), receiveFurnish(), receiveView(), receiveHOUSE()));
                        break;
                    case "remove_header":
                        remove_header(ReceiveNumberOfRooms());
                        break;
                    case "ADD IF MAX":
                        add_if_max(new Flat(receiveId(), receiveName(), receiveCoordinates(), returnDate(), receiveArea(), ReceiveNumberOfRooms(),
                                receiveLivingSpace(), receiveFurnish(), receiveView(), receiveHOUSE()));
                        break;
                    case "FILTER BY NAME ":
                        filter_starts_with_name(receiveName());
                        break;
                    case "group_counting_by_furnish":
                        group_counting_by_furnish();
                        break;
                    case "count_less_than_number of rooms ":
                        count_less_than_numberof_rooms(ReceiveNumberOfRooms());
                        break;
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
    public int collectionSize() {
        return flats1.size();
    }

    /**
     * Method for printing current date in string representation
     */
    public String returnDate() {
        return ZonedDateTime.now().toString();
    }

    public HashSet<Flat> getFlats() {
return flats;    }

    public HashMap<String, String> getInfoCommands() {
        return (HashMap<String, String>) InfoCommand;
    }
}
