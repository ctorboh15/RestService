package com.webservice.app.managers;

import com.webservice.app.model.dao.CustomerDAO;
import com.webservice.app.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CustomerManager extends BaseBeanManager<Customer>
{

}
