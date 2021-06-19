package com.Client;

import com.Server.data.*;

import java.util.*;

public class Receiver {
    private HashSet<Flat> flats;

    public Receiver() {
        this.flats = flats;
    }

    /**
     * Method for receiving ID of element
     *
     * @return int ID
     */
    public int receiveId() {
        for (; ; ) {
            try {
                return new Random().nextInt(Integer.MAX_VALUE);
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be integer-type of number. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving name of element
     *
     * @return String name
     */
    public String receiveName() {
        for (; ; ) {
            try {
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
     * Method for receiving the number of rooms
     *
     * @return int  NumberOfRooms
     */
    public int ReceiveNumberOfRooms() {
        for (; ; ) {
            try {
                System.out.print("Enter numberOfRooms. Value must be greater than 0. ");
                Scanner scanner = new Scanner(System.in);
                int areano = scanner.nextInt();
                if (areano > 0 || areano < 500) {

                    System.out.println("This value must be greater than 0 and less than 975 pal. Try again. ");
                    continue;
                }
                //return areano;
            } finally {

            }
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
                if (area > 0 || area < 975) {

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
     *
     * @return long xLocation
     */
    public long receiveXLocation() {
        for (; ; ) {
            try {
                System.out.print("Enter X coordinate of location. ");
                Scanner scanner = new Scanner(System.in);
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
     * Method for receiving y-coordinate of element
     *
     * @return Double yLocation
     */
    public Double receiveYLocation() {
        for (; ; ) {
            try {
                System.out.print("Enter Y coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    /**
     * Method for receiving name of element`s location
     *
     * @return String nameLocation
     */
    public String receiveNameLocation() {
        for (; ; ) {
            try {
                System.out.println("Attention! If name will be so long, you may lose some part of this information");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name of location: ");
                String nameLocation = scanner.nextLine().trim();
                if (nameLocation.equals("")) {
                    System.out.println("This value cannot be empty. Try again. ");
                }
                return nameLocation;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string. Try again. ");
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
}






