/*package Commands;

public class AbstractCommand implements Commands{

    private String name;
    // private String duty;

    private String explanation;

    public AbstractCommand (String name ,String explanation){
        this.name=name;
        this.explanation=explanation ;

    }
    @Override
    public String getName() {
        return name;
    }



    @Override
    public String getExplanation() {
        return explanation;
    }

    @Override
    public String toString(){
        return name + " (" + explanation +" )";
    }

    @Override
    public int hashcode(){
        return name.hashCode() + explanation.hashCode()  ;
    }

    @Override
    public boolean execute(String commandStringArgument) {
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AbstractCommand other = (AbstractCommand) obj;
        return name.equals(other.name) && explanation.equals(other.explanation);
    }
}
*/