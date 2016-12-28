package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taiton on 12/27/2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/reservation/layout")
    public String getReservationPage() {
        return "reservation/layout";
    }

    @RequestMapping("/registration/layout")
    public String getRegistrationPage() {
        return "registration/layout";
    }

    @RequestMapping
    public String getIndexPage() {
        return "index";
    }
}
