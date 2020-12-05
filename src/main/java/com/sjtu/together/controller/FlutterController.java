package com.sjtu.together.controller;


import org.apache.xerces.util.SynchronizedSymbolTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class FlutterController {


    @CrossOrigin
    @GetMapping(value = "/api/getUserActivities")
    public String getUserActivities(@RequestParam String username) {
        System.out.println(username);
        return username + " says [Hello world]";
    }

}
