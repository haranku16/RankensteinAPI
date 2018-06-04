package com.rankenstein.services.controllers;

import com.rankenstein.services.response.Response;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequiresRoles("USER")
    @RequestMapping(path = "/api/hello", method=RequestMethod.GET)
    public Response<String> greet(@RequestParam(name = "name", defaultValue = "world", required = false) String name) {
        return new Response<>("Hello, " + name + "!");
    }
}
