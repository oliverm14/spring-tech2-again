package com.example.demo;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by coag on 31-10-2017.
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public ModelAndView sayHi(
            @RequestParam(name = "name", defaultValue = "DAT16i")
            String name){
        System.out.println("name is "+name);
        ModelAndView mv = new ModelAndView("hi");

        mv.getModel().put("name", name);
        return mv;
    }

}
