package com.webservice.app.model.dao;

import com.webservice.app.model.bean.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl extends AbstractBaseBeanDAO<Customer> implements CustomerDAO
{
    private static final String TABLE_NAME = "Customer";

    public CustomerDAOImpl()
    {

    }

    @Override
    public List<Customer> list()
    {
        return super.listAll();
    }

    @Override
    public Customer findByID(int id)
    {
        return super.findByID(id);
    }

    @Override
    public void save(Customer customer)
    {
        saveOrUpdate(customer);
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
