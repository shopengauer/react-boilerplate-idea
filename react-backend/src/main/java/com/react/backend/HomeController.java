package com.react.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vasiliy on 22.11.16.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/json",method = RequestMethod.GET)
    @ResponseBody
    String index(){
        return "Json data";
    }
}
