/**package Commands;


import com.utility.collection_database;
import com.utility.Console;
import exceptions.WrongAmountOfElements;

public class showCOMM extends AbstractCommand{
    collection_database.CollectionManager collectionManager ;
    public showCOMM(String name, String explanation) {
        super("SHOW", "JUST ADD ALL ELEMENTS RELATED TO THE COLLECTION");
    }

    public showCOMM(collection_database.CollectionManager collectionManager) {
        super("show1","Add elements related to the collection ");
    }


    /**
     * Executes the command.
     * @return Command exit status.

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            Console.println(collectionManager);
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}
*/