package com.webservice.app.model.dao;

import com.webservice.app.model.bean.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl extends AbstractBaseBeanDAO<Customer> implements CustomerDAO
{
    private static final String TABLE_NAME = "Customer";

    public CustomerDAOImpl()
    {

    }

    @Override
    public List<Customer> list() {
        return super.listAll();
    }

    @Override
    public Customer get(Long id) {
        return null;
    }

    @Override
    public boolean create(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    public boolean delete(Long id) {
        return false;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }
}
