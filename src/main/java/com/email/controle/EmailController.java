package com.email.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Manasses
 */
@Controller
public class EmailController {
    
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }
}
