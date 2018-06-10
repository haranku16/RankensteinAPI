package com.rankenstein.services.controllers;

import com.rankenstein.services.repositories.UserRepository;
import com.rankenstein.services.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresRoles("USER")
@RequestMapping(path="/api/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
}
