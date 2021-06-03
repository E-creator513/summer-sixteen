package utility;

import exceptions.IncorrectInputInScriptException;

import java.io.BufferedReader;
import java.util.Scanner;

//import src.com.utility.manu.App;
//import src.manu.App;

public class FlatCoordinateManager {
    public static Scanner getUserScanner;
    private static Object userScanner;
    private static long area;
    private static int Min_ROOMS=0;
    private static long MAX_year=0;
    private static Object App;
    // = ;
    private long year = 1;
    //  private long area = 975;
    private Integer MAX_Y;
    private final long MIN_MARINES = 1;
    private final long MAX_MARINES = 1000;


    private static BufferedReader bufferedReader;
    private static boolean fileMode;

    public FlatCoordinateManager(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        fileMode = false;
    }

    public static void setUserScanner(Scanner userScanner) {
    }


    public Scanner getGetUserScanner(){
        return (Scanner) userScanner;
    }

    public BufferedReader getUserScanner() {
        return (BufferedReader) userScanner;
    }

    /**
     * Sets a scanner to scan user input.
     *
     * @param bufferedReader Scanner to set.
     */
  //  public void setBufferedReader(BufferedReader bufferedReader) {
     //   this.bufferedReader = bufferedReader;
    }

    /**
     * @return Scanner, which uses for user input.
     */
  //  public BufferedReader getBufferedReader() {
     //   return bufferedReader;
  //  }

    /**
     * Sets marine asker mode to 'File Mode'.
     */
   // public static void setFileMode() {
    //    fileMode = true;
    //}

    /**
     * Sets marine asker mode to 'User Mode'.

    public static void setUserMode() {
        fileMode = false;
    }

    /**
     * Asks a user the marine's name.
     *
     * @return Marine's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.



    public static String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
              //  Console.print(App.PS2);
                name = bufferedReader.readLine();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustNotBeEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustNotBeEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return name;
    }

    /**
     * Asks a user the marine's X coordinate.
     *
     * @return Marine's X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public Integer askX() throws IncorrectInputInScriptException {
        String strX;
        Integer x;
        while (true) {
            try {
                Console.println("Введите координату X:");
                //Console.print(App.PS2);
                strX = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strX);
                x = Integer.parseInt(strX);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return x;
    }

    public String readAllLines(BufferedReader Max_Y) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = Max_Y.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }

    /**
     * Asks a user the marine's Y coordinate.
     *
     * @return Marine's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public Long askY() throws IncorrectInputInScriptException {
        String strY;
        Long y;
        while (true) {
            try {
                Console.println("Введите координату Y < " + (MAX_Y + 1) + ":");
               // Console.print(App.PS2);
                strY = bufferedReader.readLine();
                if (fileMode) Console.println(strY);
                y = Long.parseLong(strY);
                if (y > MAX_Y) throw new NotInDeclaredRangeLimits();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredRangeLimits exception) {
                Console.printerror("Координата Y не может превышать " + MAX_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return y;
    }

    /**
     * Asks a user the marine's coordinates.
     *
     * @return Marine's coordinates.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public static Coordinates askCoordinates() throws IncorrectInputInScriptException {
        Integer x;
        Long y;
      //  x = askX();
    ////    y = askY();
       // return new Coordinates(x, y);
    }

    /**
     * Asks a user the marine's health.
     *
     * @return Marine's health.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public static double askArea() throws IncorrectInputInScriptException {
        String strHealth;
        double health;
        while (true) {
            try {
                Console.println("Enter Area:");
                Console.print(App.PS2);
                strHealth = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strHealth);
                health = Double.parseDouble(strHealth);
                if (area > 975 || area < 0) throw new NotInDeclaredRangeLimits();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Area is not recognised");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredRangeLimits exception) {
                Console.printerror("area has to be greater than zero!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("area has to be a magnitude number!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("unknown error!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return area;
    }

    /**
     * Asks a user the marine's category.
     *
     * @return Marine's category.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public static Furnisher askFurnish() throws IncorrectInputInScriptException {
        String strFurnish;
        Furnisher category;
        while (true) {
            try {
                Console.println("Список категорий - " + Furnisher.nameList());
                Console.println("Введите категорию:");
                Console.print(App.PS2);
                strFurnish = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strFurnish);
                category = Furnisher.valueOf(strFurnish.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Категория не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Категории нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return category;
    }

    /**
     * Asks a user the marine's weapon type.
     *
     * @return Marine's weapon type.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public static View askView() throws IncorrectInputInScriptException {
        String strWeaponType;
        View view;
        while (true) {
            try {
                Console.println("Список оружия дальнего боя - " + View.nameList());
                Console.println("Введите оружие дальнего боя:");
                Console.print(App.PS2);
                strWeaponType = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strWeaponType);
                view = View.valueOf(strWeaponType.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Оружие не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Оружия нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return view;
    }

    /**
     * Asks a user the marine's melee weapon.
     *
     * @return Marine's melee weapon.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public static int askNoOFRooms() throws IncorrectInputInScriptException {
        String strNoOFRooms;
        int NoOFRooms = 0;
        while (true) {
            try {
                Console.println("Enter the name of rooms");
                //console.println("Введите оружие ближнего боя:");
                Console.print(App.PS2);
                strNoOFRooms = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strNoOFRooms);
                NoOFRooms =Integer.parseInt(strNoOFRooms);
                if(NoOFRooms< Min_ROOMS) throw new NotInDeclaredRangeLimits();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Оружие не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Оружия нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (NotInDeclaredRangeLimits notInDeclaredRangeLimits) {
                Console.printerror("RANGE HAS TO BE GREATER THAN ZERO");
            }
        }
        return NoOFRooms;
    }

    /**
     * Asks a user the marine chapter's name.
     *
     * @return Chapter's name.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public String askChapterName() throws IncorrectInputInScriptException {
        String chapterName;
        while (true) {
            try {
                Console.println("Введите имя ордена:");
              //  Console.print(App.PS2);
                chapterName = bufferedReader.readLine().trim();
                if (fileMode) Console.println(chapterName);
                if (chapterName.equals("")) throw new MustNotBeEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя ордена не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustNotBeEmptyException exception) {
                Console.printerror("Имя ордена не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return chapterName;
    }

    /**
     * Asks a user the marine chapter's number of soldiers.
     *
     * @return Number of soldiers.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public long askChapterMarinesCount() throws IncorrectInputInScriptException {
        String strMarinesCount;
        long marinesCount;
        while (true) {
            try {
                Console.println("Введите количество солдат в ордене < " + (MAX_MARINES + 1) + ":");
                Console.print(App.PS2);
                strMarinesCount = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strMarinesCount);
                marinesCount = Long.parseLong(strMarinesCount);
                if (marinesCount < MIN_MARINES || marinesCount > MAX_MARINES) throw new NotInDeclaredRangeLimits();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Количество солдат в ордене не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredRangeLimits exception) {
                Console.printerror("Количество солдат в ордене должно быть положительным и не превышать " + MAX_MARINES + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Количество солдат в ордене должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return marinesCount;
    }

    /**
     * Asks a user the marine's chapter.
     *
     * @return Marine's chapter.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public String askHousename() throws IncorrectInputInScriptException {
        String Housename;
        while (true) {
            try {
                Console.println("Add the name of the house");
                Console.print(App.PS2);
                Housename = bufferedReader.readLine().trim();
                if (fileMode) Console.println(Housename);
                if (Housename.equals("")) throw new MustNotBeEmptyException();
                break;
            } catch (NoSuchElementException e) {
                Console.printerror("name is not recognised ");

                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (MustNotBeEmptyException e) {
                Console.printerror("house name shouldnt be empty");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException E) {
                Console.printerror("unknown error");
                System.exit(0);
            }
        }
        return Housename;
    }
    public long askHouseYear() throws IncorrectInputInScriptException {
        String strYear;
        long year;
        while (true) {
            try {
                Console.println("Введите количество солдат в ордене < " + (0 + 1) + ":");
                Console.print(App.PS2);
                strYear = bufferedReader.readLine().trim();
                if (fileMode) Console.println(strYear);
                year = Long.parseLong(strYear);
                if (year < 0) throw new NotInDeclaredRangeLimits();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Количество солдат в ордене не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredRangeLimits exception) {
                Console.printerror("Количество солдат в ордене должно быть положительным и не превышать " + MAX_year + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Количество солдат в ордене должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return year;
    }


    public static House askHouse() throws IncorrectInputInScriptException {
        String name;
        long year;
        name = askHousename();
        year = askHouseYear();
        return new House(name, year);
    }

    /**
     * Asks a user a question.
     *
     * @return Answer (true/false).
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
   // public boolean askQuestion() throws IncorrectInputInScriptException {
   //     return askQuestion();
   // }

    /**
     * Asks a user a question.
     *
     * @param question A question.
     * @return Answer (true/false).
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.

    public static boolean askQuestion(String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                Console.println(finalQuestion);
                Console.print(App.PS2);
                answer = bufferedReader.readLine().trim();
                if (fileMode) Console.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInDeclaredRangeLimits();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Ответ не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredRangeLimits exception) {
                Console.printerror("Ответ должен быть представлен знаками '+' или '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return (answer.equals("+")) ? true : false;
    }

    @Override
    public String toString() {
        return "MarineAsker (вспомогательный класс для запросов пользователю)";
    }

    public Integer LivingSpace() {
        return LivingSpace();
    }

    public int NoofRooms() {
        return NoofRooms() ;
    }
}

*/





