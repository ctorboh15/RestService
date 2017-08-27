package com.webservice.app.managers;

import com.webservice.app.model.bean.Customer;
import com.webservice.app.model.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCustomerManager implements CustomerManager
{
    @Autowired
    private CustomerDAO customerDAO;


    @Override
    public List<Customer> listAllActive()
    {
        return customerDAO.list();
    }

    @Override
    public Customer findbyID(int id)
    {
        customerDAO.findByID(id);
        return null;
    }


}
