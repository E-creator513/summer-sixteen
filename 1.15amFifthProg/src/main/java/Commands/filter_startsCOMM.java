/**package Commands;

import com.collection.House;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.CollectionIsEmptyException;
import exceptions.WrongAmountOfElements;

public class filter_startsCOMM extends AbstractCommand{
    private collection_database.CollectionManager collectionManager;
    private House Name;

    public filter_startsCOMM(collection_database.CollectionManager collectionManager) {
        super("filter_starts_with_name", "DISPLAY THE ELEMENTS WHOSE NAME FIELD STARTS WITH THE CHARACTERS ENETRED");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command exit status.

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            String name = String.valueOf(argument.toUpperCase());
            String filteredInfo = collectionManager.weaponFilteredInfo(Name);
            if (!filteredInfo.isEmpty()) {
                Console.println(filteredInfo);
                return true;
            } else Console.println("В коллекции нет солдат с выбранным типом оружия!");
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (IllegalArgumentException exception) {
            Console.printerror("Оружия нет в списке!");
            Console.println("Список оружия дальнего боя - " + Name.nameList());
        }
        return false;
    }
}*/
