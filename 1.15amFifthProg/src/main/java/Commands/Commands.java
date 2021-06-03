package Commands;

public interface Commands {
    String getName () ;
    //String getUsage ();
    String getExplanation ();

    int hashcode();

    boolean execute (String commandStringArgument);
}
