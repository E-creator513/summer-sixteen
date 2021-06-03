/**package Commands;

import com.utility.collection_database;
import com.utility.Console;
import exceptions.WrongAmountOfElements;

import java.time.LocalDateTime;

public class infoCOMM extends AbstractCommand {
    collection_database.CollectionManager collectionManager ;
    public infoCOMM(collection_database.CollectionManager name) {
        super("DATA","ENTER information about the collection");
    }

    /**
     * Executes the command.
     * @return Command exit status.

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            LocalDateTime lastInitTime = collectionManager.getLastInitTime();
            String lastInitTimeString = (lastInitTime == null) ? "INITIALISATION HAS NOT YET OCCURRED" :
                    lastInitTime.toLocalDate().toString() + " " + lastInitTime.toLocalTime().toString();

            LocalDateTime lastSaveTime = collectionManager.getLastSaveTime();
            String lastSaveTimeString = (lastSaveTime == null) ? "INITIALISATION HASNT YET OCCURRED" :
                    lastSaveTime.toLocalDate().toString() + " " + lastSaveTime.toLocalTime().toString();

            Console.println("LAYOUT(PRINTING )OF INFORMATION:");
            Console.println(" TYPE(ТИП): " + collectionManager.collectionType());
            Console.println(" QUANTITY OF INFORMATION: " + collectionManager.collectionSize());
            Console.println(" LAST TIME SAVING DATA: " + lastSaveTimeString);
            Console.println(" LAST INNITIALISATION DATA: " + lastInitTimeString);
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("USE: '" + getName() + "'");
        }
        return false;
    }
}
*/
