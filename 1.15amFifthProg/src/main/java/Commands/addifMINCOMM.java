/**package Commands;

import com.collection.Flat;
import com.utility.FlatCoordinateManager;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElements;

import java.time.LocalDateTime;

public class addifMINCOMM extends AbstractCommand{
    private collection_database collectionManager;
    private FlatCoordinateManager flatCoordinateManager;

    public addifMINCOMM(collection_database collectionManager , FlatCoordinateManager flatCoordinateManager) {
        super("add_if_min {element}","add a new element if its value is less than the smallest one");
        this.collectionManager=collectionManager;
        this.flatCoordinateManager=flatCoordinateManager;

    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            Flat FlatToAdd = new Flat(
                    collectionManager.generateNextId(),
                    flatCoordinateManager.askName(),
                    flatCoordinateManager.askCoordinates(),
                    LocalDateTime.now(),
                    flatCoordinateManager.askArea(),
                    flatCoordinateManager.askView(),
                    flatCoordinateManager.askFurnish(),
                    flatCoordinateManager.askHouse()
            );
            if (collectionManager.collectionSize() == 0 || FlatToAdd.compareTo(collectionManager.getFirst()) < 0) {
                collectionManager.addToCollection(FlatToAdd);
                Console.println("ELEMENT SUCCESSFULLY ADDED!");
                return true;
            } else Console.printerror("THE VALUE ADDED IS GREATER THAN THE DEFINED ELEMENT!");
        } catch (WrongAmountOfElements exception) {
            Console.println("USAGE: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }

}*/
