import java.io.*;

public class Main {
    /**
     * Main class for starting a program
     *
     * @param args - args for program successfully working
     * @throws IOException - may be throw in the method
     */
    public  static void main(String[] args) throws IOException {
        System.out.println("Collection manager  is starting!");
        CollectionManager manager = new CollectionManager();
        manager.add();
        manager.save();
    }
}