/**package Commands;

import com.utility.collection_database;
import com.utility.Console;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElements;

public class groupCOMM extends AbstractCommand {
    private collection_database.CollectionManager collectionManager;
    public groupCOMM(collection_database.CollectionManager collectionManager) {
        super("group_counting_by_furnish","GROUP elements of the collection by the value of the furnish field");
        this.collectionManager=collectionManager;
    }
    /**
     * Executes the command.
     * @return Command exit status.

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            double Groupcount = collectionManager.getSumOfHealth();
            if (Groupcount == 0) throw new CollectionIsEmptyException();
            Console.println("Сумма здоровья всех солдат: " + Groupcount);
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        }
        return false;
    }
}*/
