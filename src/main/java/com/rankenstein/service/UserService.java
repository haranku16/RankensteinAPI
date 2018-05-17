package com.rankenstein.service;

import com.rankenstein.service.annotations.Service;
import com.rankenstein.service.exceptions.ServiceException;
import com.rankenstein.service.models.User;

import java.util.List;

@Service(path="/api/user")
public interface UserService {
    User getUser(String username) throws ServiceException;
    User getMyUser() throws ServiceException;
    void login(String username, String password) throws ServiceException;
    void register(User user) throws ServiceException;
    List<User> searchForUsers(String searchQuery) throws ServiceException;
    List<User> getMyFriends() throws ServiceException;
}
