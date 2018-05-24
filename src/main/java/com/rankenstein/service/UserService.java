package com.rankenstein.service;

import com.rankenstein.service.annotations.Hides;
import com.rankenstein.service.annotations.Service;
import com.rankenstein.service.models.Page;
import com.rankenstein.service.models.Response;
import com.rankenstein.service.models.User;
import com.rankenstein.service.util.PageSize;

@Service(path="/api/user")
public interface UserService {
    Response<String> login(String username, String password);
    Response<String> register(String username, String password, String firstName, String lastName, String email, String phoneNumber);
    @Hides({"password","unprivileged"})
    Response<User> userInfo(String secret, String username);
    @Hides({"password","unprivileged"})
    Response<Page<User>> search(String query, int pageNumber, PageSize pageSize);
    @Hides({"password", "unprivileged"})
    Response<Page<User>> friends(int pageNumber, PageSize pageSize);
}
