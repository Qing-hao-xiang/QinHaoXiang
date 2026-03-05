package com.example;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Hello Railway!");
        return "index";
    }
}