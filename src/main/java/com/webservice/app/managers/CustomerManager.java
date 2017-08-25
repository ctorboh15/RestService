package com.webservice.app.managers;

import com.webservice.app.model.dao.CustomerDAO;
import com.webservice.app.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerManager implements BaseBeanManager<Customer>
{
    @Autowired
    private CustomerDAO customerDAO;


    @Override
    public List<Customer> listAllActive()
    {
        return customerDAO.list();
    }
}
