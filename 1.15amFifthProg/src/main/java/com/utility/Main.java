package main.java.com.utility;

import utility.Commander;
import utility.collectionManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("collection manager");
        Commander commander=new Commander(new collectionManager());
commander.interactiveMod();    }
}
