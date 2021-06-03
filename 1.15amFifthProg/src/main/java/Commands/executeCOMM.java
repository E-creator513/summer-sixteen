/**package Commands;

import com.utility.Console;
import exceptions.WrongAmountOfElements;

public class executeCOMM extends AbstractCommand{
    public executeCOMM() {
        super("execute_script <file_name>", "EXECUTE THE SCRIPT AS PER COMMANDED");
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongAmountOfElements();
            Console.println("Выполняю скрипт '" + argument + "'...");
            return true;
        } catch (WrongAmountOfElements exception) {
            Console.println("Использование: '" + getName() + "'");
        }
        return false;
    }
}
*/