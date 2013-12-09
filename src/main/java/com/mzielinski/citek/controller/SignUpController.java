package com.mzielinski.citek.controller;

import com.mzielinski.citek.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "SignUpForm";
        }
        m.addAttribute("message", "Successfully saved person: " + customer.getName());
        return "Done";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String displayCustomerForm(ModelMap model) {
        model.addAttribute("customer", new Customer());
        return "SignUpForm";
    }

}
