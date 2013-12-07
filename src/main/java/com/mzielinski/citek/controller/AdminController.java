package com.mzielinski.citek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: mzielinski
 * Date: 12/7/13
 * Time: 4:32 PM
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String welcomeAdmin(ModelMap model) {
        model.addAttribute("message", "Spring Security - ROLE_ADMIN");
        return "admin";
    }

}
