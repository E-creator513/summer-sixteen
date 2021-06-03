/**package Commands;

import com.utility.collection_database;
import com.utility.Console;
import exceptions.WrongAmountOfElements;

public class saveCOMM extends AbstractCommand{
    collection_database.CollectionManager collectionManager;
    public saveCOMM(collection_database.CollectionManager collectionManager) {
        super("SAVE","Save the collections in the file ");
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            collectionManager.saveCollection();
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}*/
