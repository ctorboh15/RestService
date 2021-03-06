package com.webservice.app.model.dao;

import com.webservice.app.model.bean.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRestDAO {

    // Dummy database. Initialize with some dummy values.
    private static List<Customer> customers;

    {
        customers = new ArrayList();
        customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-23a2-3435"));
        customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
    }

    /**
     * Returns list of customers from dummy database.
     *
     * @return list of customers
     */
    public List list() {
        return customers;
    }

    /**
     * Return customer object for given id from dummy database. If customer is
     * not found for id, returns null.
     *
     * @param id customer id
     * @return customer object for given id
     */
    public Customer get(int id) {

        for (Customer c : customers) {
            if (c.getId() == (id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Create new customer in dummy database. Updates the id and insert new
     * customer in list.
     *
     * @param customer Customer object
     * @return customer object with updated id
     */
    public Customer create(Customer customer) {
        customer.setId(43);
        customers.add(customer);
        return customer;
    }

    /**
     * Delete the customer object from dummy database. If customer not found for
     * given id, returns null.
     *
     * @param id the customer id
     * @return id of deleted customer object
     */
    public int delete(int id) {

        for (Customer c : customers) {
            if (c.getId()== (id)) {
                customers.remove(c);
                return id;
            }
        }

        return -1;
    }

    /**
     * Update the customer object for given id in dummy database. If customer
     * not exists, returns null
     *
     * @param id
     * @param customer
     * @return customer object with id
     */
    public Customer update(int id, Customer customer) {

        for (Customer c : customers) {
            if (c.getId()==(id)) {
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }

        return null;
    }
}