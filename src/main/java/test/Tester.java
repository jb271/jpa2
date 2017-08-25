package test;

import entity.Customer;
import entity.ItemType;
import entity.Order;
import facade.Facade;
import javax.persistence.Persistence;

public class Tester {
    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);
        Facade f = new Facade();
        Customer alice = f.createCustomer("Alice", "alice@example.com");
        Customer bob = f.createCustomer("Bob", "bob@example.com");
        Order order = f.createOrder(bob);
        ItemType itemType = f.createItemType("Test", "Some description...", 50);
        f.createOrderLine(order, itemType, 3);
        
        Order order2 = f.getOrder(order.getId());
        System.out.println(f.getOrderTotal(order2));
        
        System.out.println(f.getOrder(1));
        System.out.println(f.getAllCustomers().get(0).getName());
    }
}
