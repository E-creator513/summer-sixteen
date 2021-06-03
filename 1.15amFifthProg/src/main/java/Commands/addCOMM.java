/**package Commands;

import com.collection.Flat;
import com.utility.FlatCoordinateManager;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElements;

import java.time.LocalDateTime;




public class addCOMM extends AbstractCommand {
    private final collection_database.CollectionManager collectionManager;
    private final FlatCoordinateManager flatCoordinateManager;

    public addCOMM(collection_database.CollectionManager collectionManager, FlatCoordinateManager flatCoordinateManager) {
        super("add{ELEMEMNT}", "Add new alement in the collection");
        this.collectionManager = collectionManager;
        this.flatCoordinateManager = flatCoordinateManager;
    }

    /**
     * executes the command
     *
     * @return Command exit status

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new WrongAmountOfElements();
            collectionManager.addToCollection(new Flat(collectionManager.generateNextId(),
                    flatCoordinateManager.askCoordinates(),
                    FlatCoordinateManager.askName(),
                    // flatCoordinateManager.askHealth(),
                    LocalDateTime.now(),
                    flatCoordinateManager.askArea(),
                    flatCoordinateManager.NoofRooms(),
                    flatCoordinateManager.LivingSpace(),
                    flatCoordinateManager.askFurnish(),
                    flatCoordinateManager.askView(),
                    flatCoordinateManager.askHouse()
            ));
            Console.println("elements successfully added ");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("purpose(use): '" + getName() + "'");

        } catch (IncorrectInputInScriptException exception) {
        }
        return false;
    }
}
*/