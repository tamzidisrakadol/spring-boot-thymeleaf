package com.example.springbootthymeleaf.Controller;

import java.util.List;

import com.example.springbootthymeleaf.Modal.LoginData;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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

    @GetMapping("/footerService")
    public String aboutFragment(Model model){
        model.addAttribute("title","Title header Tamzid Israk");
        model.addAttribute("subtitle","Subtitle from Israk");
        return "footerService";
    }

    @GetMapping("/contact")
    public String newBase(){
        return "contact";
    }

    @GetMapping("/form")
    public String loginForm(Model model){
        model.addAttribute("loginData",new LoginData());
        return "form";
    }


    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "form";
        }
        System.out.println(loginData);
        return "sucess";
    }
     
    
}


