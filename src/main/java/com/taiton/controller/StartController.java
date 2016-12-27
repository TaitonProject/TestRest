package com.taiton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taiton on 12/27/2016.
 */
@Controller
public class StartController {
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

}
