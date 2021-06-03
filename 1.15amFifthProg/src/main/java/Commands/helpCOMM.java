/**package Commands;

import com.utility.Console;
import exceptions.WrongAmountOfElements;

public class helpCOMM extends AbstractCommand {
    //collection_database.CollectionManager collectionManager ;
    public helpCOMM() {

        super("HELP", "DISPLAY HELP FOR AVAILABLE COMMANDS ");
    }

    /**
     * Executes the command.
     * @return Command exit status.

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}*/
