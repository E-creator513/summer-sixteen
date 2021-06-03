package com.Server.commands;

import com.Server.CollectionManager;
import com.Server.Exceptions.CollectionIsEmptyException;
import com.Server.Exceptions.WrongAmountOfElementsException;
import com.Server.data.Flat;

public class FilterStartsWitNameCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public FilterStartsWitNameCommand(CollectionManager collectionManager){
        super("filter_by_name_type", "<name>",
                "вывести элементы, значение поля Name которых равно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     *
     * @return Command exit status.
     */

    public synchronized boolean execute(String stringArgument, Object objectArgument) {
        StringBuilder result = new StringBuilder();
        try {
            if (stringArgument.isEmpty() || objectArgument != null) throw new WrongAmountOfElementsException();
            if (collectionManager.collectionSize() == 0) throw new CollectionIsEmptyException();
            String name = String.valueOf(stringArgument.toUpperCase());
            String filteredInfo = collectionManager.nameFilteredInfo(name);
            if (!filteredInfo.isEmpty()) result.append(filteredInfo);
            else result.append("В коллекции нет солдат с выбранным типом оружия!");
            return true;
        } catch (WrongAmountOfElementsException exception) {
            result.append("Использование: '" + getName() + " " + getUsage() + "'");
        } catch (CollectionIsEmptyException exception) {
            result.append("Коллекция пуста!");
        } catch (IllegalArgumentException exception) {
            result.append("Оружия нет в списке!");
            result.append("Список оружия дальнего боя - " + collectionManager.receiveName());
        }
        return false;
    }
}
