package com.la.service;

import com.la.model.User;

public interface UserService {
    User findByUsername(String username);
}
