package entity;

import entity.Address;
import enums.CustomerType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-23T13:26:12")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, CustomerType> customerType;
    public static volatile SingularAttribute<Customer, Address> address;
    public static volatile ListAttribute<Customer, String> hobbies;
    public static volatile MapAttribute<Customer, String, String> phones;
    public static volatile SingularAttribute<Customer, Long> id;

}