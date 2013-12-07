package com.mzielinski.citek.controller;

import com.mzielinski.citek.orm.entity.Customer;
import com.mzielinski.citek.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Date;


/**
 * Customer form controller.
 * 
 * @author David Winterfeldt
 */
@Controller
public class CustomerController {

    final Logger logger = LoggerFactory.getLogger(getClass());
    
    private static final String DELETE_PATH_KEY = "/customer/delete";
    private static final String SEARCH_VIEW_PATH_KEY = "/customer/search";
    
    private static final String SEARCH_VIEW_KEY = "redirect:search.html";
    private static final String SEARCH_MODEL_KEY = "customers";

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    /**
     * For every request for this controller, this will 
     * create a customer instance for the form.
     */
    @ModelAttribute
    public Customer newRequest(@RequestParam(required=false) Integer id) {
        return (id != null ? service.findById(id) : new Customer());
    }

    /**
     * <p>Customer form request.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/form'.</p>
     */
    @RequestMapping(value="/customer/form", method=RequestMethod.GET)
    public void form() {}
    
    /**
     * <p>Saves a customer.</p>
     * 
     * <p>Expected HTTP POST and request '/customer/form'.</p>
     */
    @RequestMapping(value="/customer/form", method=RequestMethod.POST)
    public Customer form(Customer customer, Model model) {
        if (customer.getCreated() == null) {
            customer.setCreated(new Date());
        }
        Customer result = service.save(customer);
        model.addAttribute("statusMessageKey", "customer.form.msg.success");
        return result;
    }

    /**
     * <p>Deletes a customer.</p>
     * 
     * <p>Expected HTTP POST and request '/customer/delete'.</p>
     */
    @RequestMapping(value=DELETE_PATH_KEY, method=RequestMethod.POST)
    public String delete(@RequestParam("id") Integer id) {
        logger.info("'{}'  id={}", DELETE_PATH_KEY, id);
        service.delete(id);
        return SEARCH_VIEW_KEY;
    }

    /**
     * <p>Searches for all customers and returns them in a 
     * <code>Collection</code>.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/search'.</p>
     */
    @RequestMapping(value=SEARCH_VIEW_PATH_KEY, method=RequestMethod.GET)
    public @ModelAttribute(SEARCH_MODEL_KEY) Collection<Customer> search() {
        return service.find();
    }

}
