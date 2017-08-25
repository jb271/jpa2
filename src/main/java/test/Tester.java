package test;

import facade.Facade;
import javax.persistence.Persistence;

public class Tester {
    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);
        Facade f = new Facade();
    }
}
