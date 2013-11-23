package com.mzielinski.citek.controller;

import com.mzielinski.citek.model.Subscriber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author mzielinski, Rule Financial
 */
@Controller
@RequestMapping("/subscriber")
public class SubscriberController {

    @RequestMapping(value="/submit", method= RequestMethod.POST)
    public String submitForm(@Valid Subscriber subscriber, BindingResult result, Model m) {
        if(result.hasErrors()) {
            return "SubscriberForm";
        }
        m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
        return "Done";
    }

    @RequestMapping(method=RequestMethod.GET)
    public String displaySubscriberForm(Model m) {
        m.addAttribute("subscriber", new Subscriber());
        return "SubscriberForm";
    }

}
