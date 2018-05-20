package com.rankenstein.service;

import com.rankenstein.service.abstractions.Transformer;
import com.rankenstein.service.annotations.Service;
import com.rankenstein.service.models.User;

import java.util.List;

@Service(path="/api/user")
public interface UserServices {
    @Service(path="/login")
    Transformer<User,String> login();
    @Service(path="/register")
    Transformer<User,Void> register();
    @Service(path="/username")
    Transformer<String,User> findByUsername();
    @Service(path="/search")
    Transformer<String,List<User>> search();
}
