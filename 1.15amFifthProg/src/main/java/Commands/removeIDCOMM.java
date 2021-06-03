/**package Commands;

import com.collection.Flat;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.CollectionIsEmptyException;
import exceptions.FlatNotFoundException;
import exceptions.WrongAmountOfElements;

public class removeIDCOMM extends AbstractCommand{
    private collection_database.CollectionManager collectionManager;
    private Object FLATToRemove;

    public removeIDCOMM(collection_database.CollectionManager collectionManager) {
        super("REMOVE BY ID ", "DELETE ELEMENT FROM COLLECTION USING ID");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            Long id = Long.parseLong(argument);
            Flat FlatToRemove = collectionManager.getById(id);
            if (FLATToRemove == null) throw new FlatNotFoundException();
            collectionManager.removeFromCollection(FlatToRemove);
            Console.println("Солдат успешно удален!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (FlatNotFoundException exception) {
            Console.printerror("Солдата с таким ID в коллекции нет!");
        }
        return false;
    }
}

*/
