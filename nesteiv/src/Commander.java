import data.Flat;

import java.util.*;

/**
 * @author Ivan Nesterov
 * @version 1.0
 * Method for handling user`s command
 */
public class Commander {

    /** Collection manager for realising user`s commands */
    private final CollectionManager collectionManager;
    /** Field for receiving user`s command */
    private String userCommand;
    /** Field for separating user input into a command and an argument to it */
    private String[] finalUserCommand;

    {
        userCommand = "";
    }

    /**
     * Constructor for making a commander
     * @param manager - CollectionManager class object which will realise user`s commands
     */
    public Commander(CollectionManager manager) {
        this.collectionManager = manager;
    }


    /**
     * Method for starting interactive mood
     */
    public void interactiveMod() {
        try {
            try (Scanner commandReader = new Scanner(System.in)) {
                while (!userCommand.equals("exit")) {
                    System.out.print("Enter a command: ");
                    userCommand = commandReader.nextLine();
                    finalUserCommand = userCommand.trim().toLowerCase().split(" ", 2);
                    try {
                        switch (finalUserCommand[0]) {
                            case "":
                                break;
                            case "help":
                                collectionManager.help();
                                break;
                            case "info":
                                collectionManager.info();
                                break;
                            case "show":
                                collectionManager.show();
                                break;
                            case "add":
                                collectionManager.add();
                                break;
                            case "update_by_id":
                                collectionManager.update_by_id(finalUserCommand[1]);
                                break;
                            case "remove_by_id":
                                collectionManager.remove_by_id(finalUserCommand[1]);
                                break;
                            case "clear":
                                collectionManager.clear();
                                break;
                            case "save":
                                collectionManager.save();
                                break;
                            case "execute_script":
                                collectionManager.execute_script(finalUserCommand[1]);
                                break;
                            case "exit":
                                collectionManager.exit();
                                break;
                            case "add_if_min":
                                System.out.println("Enter characteristics of element, which will be compared with elements in collection.");
                                collectionManager.add_if_min(new Flat(collectionManager.receiveId(), collectionManager.receiveName(), collectionManager.receiveCoordinates(), collectionManager.returnDate(),collectionManager.receiveArea(),collectionManager.ReceiveNumberOfRooms(),
                                        collectionManager.receiveLivingSpace(),collectionManager.receiveFurnish(),collectionManager.receiveView(), collectionManager.receiveHOUSE()));
                                break;
                            case "remove_header ":
                                System.out.println("Enter characteristics of element, which will be compared with elements in collection.");
                                collectionManager.remove_header(collectionManager.ReceiveNumberOfRooms());
                                break;
                            case "ADD IF MAX":
                                System.out.println("Enter characteristics of element, which will be compared with elements in collection.");
                                collectionManager.add_if_max(new Flat(collectionManager.receiveId(), collectionManager.receiveName(), collectionManager.receiveCoordinates(), collectionManager.returnDate(),collectionManager.receiveArea(),collectionManager.ReceiveNumberOfRooms(),
                                        collectionManager.receiveLivingSpace(),collectionManager.receiveFurnish(),collectionManager.receiveView(), collectionManager.receiveHOUSE()));
                                break;

                            case "group_counting_by_furnish":
                                collectionManager.group_counting_by_furnish();
                                break;
                            case "count_LESS_than_number of rooms":
                                System.out.println("Enter number of rooms, which will be compared with element`s number of rooms .");
                                collectionManager.count_less_than_numberof_rooms(collectionManager.ReceiveNumberOfRooms());
                                break;
                            case "filter by name in the collection":
                                System.out.println("enter the name of the element in the collection");
                                collectionManager.filter_starts_with_name(collectionManager.receiveNameHouse());
                            default:
                                System.out.println("Unknown command. Write help for help.");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Argument of command is absent. Write help for help.");
                    }
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program will be finished now.");
            System.exit(1);
        }
    }

    /** Method for comparing elements */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commander)) return false;
        Commander commander = (Commander) o;
        return Objects.equals(commander, commander.collectionManager);
    }

    /** Method for receiving hashcode of element */
    @Override
    public int hashCode() {
        int result = Objects.hash(collectionManager, userCommand);
        result = 42 * result + Arrays.hashCode(finalUserCommand);
        return result;
    }
}