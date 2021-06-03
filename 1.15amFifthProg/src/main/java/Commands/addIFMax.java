/**package Commands;

import com.collection.Flat;
import com.utility.FlatCoordinateManager;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElements;

import java.time.LocalDateTime;

//import static com.utility.FlatCoordinateManager.askLivingSpace;

public class addIFMax extends AbstractCommand {
    private collection_database.CollectionManager collectionManager;
    private FlatCoordinateManager flatCoordinateManager ;
    public addIFMax(collection_database.CollectionManager collectionManager, FlatCoordinateManager flatCoordinateManager) {
        super("add_if_max {element}" ,"ADD AN ELEMENT TO THE COLLECTION IF ITS VALUE EXCEEDS THE LARGEST ITEM");
        this.collectionManager=collectionManager;
        this.flatCoordinateManager=flatCoordinateManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            Flat FlatToAdd = new Flat(collectionManager.generateNextId(), flatCoordinateManager.askName(), flatCoordinateManager.askCoordinates(), LocalDateTime.now(), flatCoordinateManager.askView(), flatCoordinateManager.askNoOFRooms(), flatCoordinateManager.askArea(), flatCoordinateManager.askFurnish(),  flatCoordinateManager.askHouse());
            if (collectionManager.collectionSize() > 0 || FlatToAdd.compareTo(collectionManager.getFirst()) > 0) {
                collectionManager.addToCollection(FlatToAdd);
                Console.println("Солдат успешно добавлен!");
                return true;
            } else Console.printerror("Значение солдата больше, чем значение наименьшего из солдат!");
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}
*/