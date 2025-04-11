package com.example.AtvPontSpringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {

    @GetMapping()
    public String welcome(){
        return "Bem vindo!!";
    }

    @GetMapping("/dev")
    public String dev(){
        return "Lucas Ferreira Gabriel";
    }
}
