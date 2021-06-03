/*package src.manu;

import Commands.*;
import com.utility.CommandManager;
import com.utility.Console;
import com.utility.collection_database;
import com.utility.fileManager1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {

    public static final String PS1 = "$ ";
    public static final String PS2 = "> ";




    public static void main(String[] args) throws IOException {
        try (BufferedReader userScanner = new BufferedReader(new InputStreamReader(System.in)) {
            final String envVariable = "LABA";

            com.utility.FlatCoordinateManager flatCoordinateManager = new com.utility.FlatCoordinateManager(userScanner);
            fileManager1 fileManager = new fileManager1(envVariable);
            collection_database.CollectionManager collectionManager = new collection_database.CollectionManager(fileManager);

            CommandManager commandManager = new CommandManager(
                    new helpCOMM(),
                    new infoCOMM(collectionManager),
                    new showCOMM(collectionManager),
                    new addCOMM(collectionManager, flatCoordinateManager),
                    new updateIDCOMM(collectionManager, flatCoordinateManager),
                    new removeIDCOMM(collectionManager),
                    new clearCOMM(collectionManager),
                    new saveCOMM(collectionManager),
                    new exitCOMM(),
                    new executeCOMM(),
                    new addifMINCOMM(collectionManager, flatCoordinateManager),
                    new remove_Head_COMM(collectionManager, flatCoordinateManager),
                    new HistoryCommand(),
                    new addIFMax(collectionManager, flatCoordinateManager),
                    new groupCOMM(collectionManager),
                    new filter_startsCOMM(collectionManager)

            );
            com.utility.Console Console = new Console(commandManager, userScanner, flatCoordinateManager);

            //com.utility.Console.Mode();
        }


//com.utility.Console.Mode();

*/