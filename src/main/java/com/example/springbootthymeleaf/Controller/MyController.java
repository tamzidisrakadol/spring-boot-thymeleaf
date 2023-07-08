package com.example.springbootthymeleaf.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




//RequestMapping is only for html file + we can also set method inside it

@Controller
public class MyController {

    @GetMapping(value = "/about")
    public String about(Model model){
        model.addAttribute("name", "Tamzid Israk");
        return "about";
    }

    @GetMapping("/aboutIterate")
    public String aboutIteration(Model model){
        List<String> names = List.of("ankit", "israk", "tamzid", "laxmi", "karan");
        model.addAttribute("names",names);
        return "iterate";
    }


    @GetMapping("/aboutCondition")
    public String aboutCondition(Model model){
        model.addAttribute("isActive", false);
        model.addAttribute("gender", "f");

        List<Integer> myList =List.of(15, 415, 454, 541);
        model.addAttribute("myList", myList);
        return "condition";
    }
     
    
}


