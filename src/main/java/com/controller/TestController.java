package com.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TestController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam("id") String id){
        System.out.println(id);
        return "Hello Vet Application";
    }
}
