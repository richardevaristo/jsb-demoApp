package com.richardevaristo.demoApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String HelloWorld(){
        return "HELLO WORLD";
    }

}
