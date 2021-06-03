package Commands;

/**import com.utility.Console;
import exceptions.WrongAmountOfElements;

/**
 * Command 'history'. It's here just for logical structure.

public class HistoryCommand extends AbstractCommand {

    public HistoryCommand() {
        super("history", "вывести историю использованных команд");
    }

    /**
     * Executes the command.
     *
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
