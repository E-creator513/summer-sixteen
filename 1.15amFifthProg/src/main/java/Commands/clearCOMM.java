/**package Commands;

import com.utility.collection_database;
import com.utility.Console;
import exceptions.WrongAmountOfElements;

public class clearCOMM extends AbstractCommand{
    private collection_database.CollectionManager collectionManager;
    public clearCOMM(collection_database.CollectionManager collectionManager) {
        super("CLEAR ", "CLEAN THE SLATE ");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            collectionManager.clearCollection();
            Console.println("COLLECTION IS CLEARED !");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("USAGE : '" + getName() + "'");
        }
        return false;
    }
}*/