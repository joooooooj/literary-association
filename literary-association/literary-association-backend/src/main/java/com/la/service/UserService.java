package com.la.service;

import com.la.model.users.User;

public interface UserService {
    User findByUsername(String username);
}
