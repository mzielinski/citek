package com.mzielinski.citek.controller;

import com.mzielinski.citek.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author mzielinski, Rule Financial
 */
@Controller
@RequestMapping("/customer")
public class SignUpController {

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, BindingResult result) {
        return result.hasErrors() ? "SignUpForm" : "Done";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String displayCustomerForm(ModelMap model) {
        model.addAttribute("customer", new Customer());
        return "SignUpForm";
    }

}
