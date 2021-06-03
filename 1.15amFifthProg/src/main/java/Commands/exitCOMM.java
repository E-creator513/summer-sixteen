/**package Commands;

import com.utility.Console;
import exceptions.WrongAmountOfElements;

public class exitCOMM extends AbstractCommand{
    public exitCOMM() {
        super("EXIT ", "EXIT THE FILE WITHOUT SAVING ");
    }
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