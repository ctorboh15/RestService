package com.webservice.app.managers;

import com.webservice.app.forms.CustomerForm;
import com.webservice.app.model.dao.CustomerDAO;
import com.webservice.app.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.text.ParseException;
import java.util.List;

/**
 * Customer Manager Interface
 */
public interface CustomerManager extends BaseBeanManager<Customer>
{
    public void saveCustomerFromBean(ModelMap modelMap, Customer customer);
    public void saveCustomerFromForm(ModelMap modelMap, CustomerForm customerForm) throws ParseException;

}
