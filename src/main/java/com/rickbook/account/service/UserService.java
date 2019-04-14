package com.rickbook.account.service;

import com.rickbook.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
