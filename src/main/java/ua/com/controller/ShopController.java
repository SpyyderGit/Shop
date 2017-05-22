package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 22.05.2017.
 */


@Controller
public class ShopController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
}
