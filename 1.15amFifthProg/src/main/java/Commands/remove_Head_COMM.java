/**package Commands ;

import com.collection.Flat;
import com.utility.FlatCoordinateManager;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.CollectionIsEmptyException;
import exceptions.FlatNotFoundException;
import exceptions.WrongAmountOfElements;

public class remove_Head_COMM extends AbstractCommand{
    collection_database.CollectionManager collectionManager;
    FlatCoordinateManager flatCoordinateManager;
    private Flat FlatToFind;

    public remove_Head_COMM(collection_database.CollectionManager collectionmanager,FlatCoordinateManager flatCoordinateManager ) {
        super("remove_head", "DUMP THE FIRST ELEMENT OF THE COLLECTION AND REMOVE IT ");
        this.collectionManager=collectionmanager;
        this.flatCoordinateManager=flatCoordinateManager;
    }
    /**
     * Executes the command.
     * @return Command exit status.

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Long id=Long.parseLong(argument);



            Flat FlatFromCollection = collectionManager.getByValue(FlatToFind);
            if (FlatFromCollection == null) throw new FlatNotFoundException();
            collectionManager.removeGreater(FlatFromCollection);
            Console.println("Солдаты успешно удалены!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (FlatNotFoundException exception) {
            Console.printerror("Солдата с такими характеристиками в коллекции нет!");
        }// catch (IncorrectInputInScriptException exception) {}
        return false;
    }

}*/