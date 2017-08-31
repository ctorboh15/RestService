package com.webservice.app.managers;


import com.webservice.app.Utils.AppDateUtils;
import com.webservice.app.Utils.BeanConstants;
import com.webservice.app.forms.BaseBeanForm;
import com.webservice.app.forms.CustomerForm;
import com.webservice.app.model.bean.Customer;
import com.webservice.app.model.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Customer Manager Implementation
 */
@Component
public class DefaultCustomerManager extends AbstractBeanManager<Customer> implements CustomerManager
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
        return customerDAO.findByID(id);
    }

    @Override
    public void saveCustomerFromForm(ModelMap modelMap, CustomerForm customerForm) throws ParseException {
        try
        {
            Customer customer = null;
            if (!doValidation(modelMap, customerForm))
            {
                if(customerForm.getID() > 0)
                {
                    customer = customerDAO.findByID(customerForm.getID());
                    copyFormToBean(customer,customerForm);

                }
                else
                {
                    customer = copyFormToBean(customerForm);
                }

                doBeanSave(customer);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }


    @Override
    protected List<String> validate(BaseBeanForm form)
    {
        return null;
    }



    @Override
    protected Customer copyFormToBean(BaseBeanForm form) throws ParseException
    {
        Customer customer = new Customer();
        CustomerForm customerForm = (CustomerForm) form;

        try
        {
            customer.setFirstName(customerForm.getFirstName());
            customer.setLastName(customerForm.getLastName());
            customer.setEmail(customerForm.getEmail());
            customer.setMobile(customerForm.getMobile());
            Date dob = AppDateUtils.strToDate(customerForm.getDateOfBirth());
            customer.setDateOfBirth(dob);
            customer.setActiveIND(BeanConstants.YES);

        }
        catch (Exception e)
        {
            // Do nothing form should have been validated by this point
        }

        return  customer;
    }

    @Override
    protected Customer copyFormToBean(Customer customer, BaseBeanForm form)
    {

        CustomerForm customerForm = (CustomerForm) form;
        customer.setFirstName(customerForm.getFirstName());
        customer.setLastName(customerForm.getLastName());
        customer.setEmail(customerForm.getEmail());
        customer.setMobile(customerForm.getMobile());

        try {

            Date dob = AppDateUtils.strToDate(customerForm.getDateOfBirth());
            customer.setDateOfBirth(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  customer;
    }


    @Override
    public void saveCustomerFromBean(ModelMap modelMap, Customer customer)
    {

    }




    @Override
    protected void doBeanSave(Customer customer)
    {
        customerDAO.save(customer);
    }

    @Override
    protected void doBeanUpdate(Customer customer)
    {

    }
}
