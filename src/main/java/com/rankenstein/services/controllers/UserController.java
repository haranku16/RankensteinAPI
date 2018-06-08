package com.rankenstein.services.controllers;

import com.rankenstein.services.models.User;
import com.rankenstein.services.repositories.UserRepository;
import com.rankenstein.services.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(path = "/set-name", method = RequestMethod.POST)
    public void setName(@RequestParam(name="name") String name) {
        User user = userService.getActiveUser();
        user.setName(name);
        user.updateExpirationDate();
        userRepository.save(user);
    }

    @RequestMapping(path = "/set-nickname", method = RequestMethod.POST)
    public void setNickname(@RequestParam(name="nickname") String nickname) {
        User user = userService.getActiveUser();
        user.setNickname(nickname);
        user.updateExpirationDate();
        userRepository.save(user);
    }
}
