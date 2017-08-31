package com.webservice.app.controller;

import com.webservice.app.forms.CustomerForm;
import com.webservice.app.managers.CustomerManager;
import com.webservice.app.model.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CustomerController
{
    @Autowired
    private CustomerManager customerManager;


    @GetMapping("/customer/create")
    public ModelAndView createCustomer()
    {
        return new ModelAndView("customer/customerHome", "customer", new CustomerForm());
    }

    @PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute("customer")CustomerForm customer,
                                       BindingResult result, ModelMap model)
    {
        try
        {
            customerManager.saveCustomerFromForm(model,customer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        model.addAttribute("customer",customer);
        return "customer/reviewCustomer";
    }

    @GetMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, ModelMap model)
    {
        Customer customer = customerManager.findbyID(id); //customerDAO.get(id);
        if (customer != null)
        {
            model.addAttribute("customer",customer);
        }

        return "customer/editCustomerAjax";
    }

    @GetMapping("/customer/{id}")
    public String reviewCustomer(@PathVariable("id") int id, ModelMap modelMap)
    {
        Customer customer = customerManager.findbyID(id);
        modelMap.addAttribute("customer",customer);
        return "customer/reviewCustomer";

    }

}
