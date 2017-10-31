package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by coag on 31-10-2017.
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String sayHi(
            @RequestParam(name = "name", defaultValue = "DAT16i")
            String name){
        System.out.println("name is "+name);
        return "hi";
    }

}
