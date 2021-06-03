/**package Commands;

import com.collection.*;
import com.utility.FlatCoordinateManager;
import com.utility.collection_database;
import com.utility.Console;
import exceptions.CollectionIsEmptyException;
import exceptions.FlatNotFoundException;
import exceptions.IncorrectInputInScriptException;
import exceptions.WrongAmountOfElements;

import java.util.Date;

public class updateIDCOMM extends AbstractCommand {
    private collection_database.CollectionManager collectionManager;
    private FlatCoordinateManager flatCoordinateManager;
    public updateIDCOMM(collection_database.CollectionManager collectionManager ,FlatCoordinateManager flatCoordinateManager) {
        super("update <ID> {element}", "UPDATE THE COLLECTION ITEM BY UPDATING YOUR ID "
        );
        this.collectionManager=collectionManager;
        this.flatCoordinateManager=flatCoordinateManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElements();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();

            Long id = Long.parseLong(argument);
            Flat oldFLATno = collectionManager.getById(id);
            if (oldFLATno == null) throw new FlatNotFoundException();

            String name = oldFLATno.getName();
            Coordinates coordinates = oldFLATno.getCoordinates();
            Date creationDate = oldFLATno.getCreationDate();
            long area = oldFLATno.getArea();
            int numberOfRooms = oldFLATno.getNumberOfRooms();
            Integer livingSpace = oldFLATno.getLivingSpace();
            Furnisher furnish = oldFLATno.getFurnish();
            View view = oldFLATno.getview();
            House house=oldFLATno.getHouse();

            collectionManager.removeFromCollection(oldFLATno);

            if (FlatCoordinateManager.askQuestion("DO YOU WANT TO CHANGE THE NAME OF THE FLAT?")) name = FlatCoordinateManager.askName();
            if (FlatCoordinateManager.askQuestion("DO YOU WANT TO CHANGE THE COORDINATES?")) coordinates = FlatCoordinateManager.askCoordinates();
            if (FlatCoordinateManager.askQuestion("DO YOU WANT TO CHANGE THE AREA OF TOWN ?"))  area= (long) FlatCoordinateManager.askArea();
            if (FlatCoordinateManager.askQuestion("DO YOU WANT THE CHANGE THE NUMBER OF ROOMS?")) numberOfRooms = FlatCoordinateManager.askNoOFRooms();
            //  if (FlatCoordinateManager.askQuestion ("DO YOU WANT TO CHANGE THE LIVING SPACE ?")) livingSpace = FlatCoordinateManager.askLivingSpace();
            if (FlatCoordinateManager.askQuestion("DO YOU WANT TO CHANGE THE FURNISH?")) furnish = FlatCoordinateManager.askFurnish();
            if (FlatCoordinateManager.askQuestion("WHAT KIND OF VIEW DO YOU WANT ?")) view = FlatCoordinateManager.askView();
            if (FlatCoordinateManager.askQuestion("DO YOU REALLY WANT TO CHANGE THE HOUSE ?")) house=FlatCoordinateManager.askHouse();
            collectionManager.addToCollection(new Flat(
                    id,
                    name,
                    coordinates,
                    creationDate,
                    area,
                    numberOfRooms,
                    livingSpace,
                    furnish,
                    view,
                    house
            ));
            Console.println("THE CHANGE WAS SUCCESSFULL!");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        } catch (CollectionIsEmptyException exception) {
            Console.printerror("Коллекция пуста!");
        } catch (NumberFormatException exception) {
            Console.printerror("ID должен быть представлен числом!");
        } catch (FlatNotFoundException exception) {
            Console.printerror("Солдата с таким ID в коллекции нет!");
        } catch (IncorrectInputInScriptException exception) {}
        return false;
    }
}

*/
