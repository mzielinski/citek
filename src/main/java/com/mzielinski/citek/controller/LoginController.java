package com.mzielinski.citek.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created with IntelliJ IDEA.
 * User: mzielinski
 * Date: 12/7/13
 * Time: 3:40 PM
 */
@Controller
public class LoginController {

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal ) {
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Spring Security Custom Form example");
        return "welcome";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "login";
    }

}
