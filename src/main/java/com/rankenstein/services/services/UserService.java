package com.rankenstein.services.services;

import com.rankenstein.services.models.User;
import com.rankenstein.services.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Realm realm;

    public User getActiveUser() {
        return Optional.ofNullable(SecurityUtils.getSubject())
                .map(Subject::getSession)
                .map(session -> (String)session.getAttribute("username"))
                .map(userRepository::findByUsername)
                .orElse(null);
    }
}
