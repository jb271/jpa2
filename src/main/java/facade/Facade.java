package facade;

import entity.Customer;
import entity.ItemType;
import entity.Order;
import entity.OrderLine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Facade {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    private final EntityManager em = emf.createEntityManager();

    public Facade() {
    }

    public Customer createCustomer(String name, String email) {
        Customer customer = new Customer(name, email);
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        return customer;
    }

    public Customer getCustomer(long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        Query q = em.createQuery("SELECT c FROM Customer c");
        return q.getResultList();
    }
    
    public Order createOrder(Customer customer) {
        Order order = new Order(customer);
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        return order;
    }
    
    public Order getOrder(long id) {
        return em.find(Order.class, id);
    }

    public ItemType createItemType(String name, String description, double price) {
        ItemType itemType = new ItemType(name, description, price);
        em.getTransaction().begin();
        em.persist(itemType);
        em.getTransaction().commit();
        return itemType;
    }
    
    public OrderLine createOrderLine(Order order, ItemType itemType, int quantity) {
        OrderLine orderLine = new OrderLine(order, itemType, quantity);
        em.getTransaction().begin();
        em.persist(orderLine);
        em.getTransaction().commit();
        return orderLine;
    }
    
    public double getOrderTotal(Order order) {
        double sum = 0;
        System.out.println("COUNT" + order.getOrderLines().size());
        for (OrderLine orderLine : order.getOrderLines()) {
            System.out.println("LINE"+ orderLine);
            sum += orderLine.getQuantity() * orderLine.getItemType().getPrice();
        }
        return sum;
    }
    
}
