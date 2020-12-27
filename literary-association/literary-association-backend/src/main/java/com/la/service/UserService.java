package com.la.service;

import com.la.model.users.SysUser;
import org.camunda.bpm.engine.identity.User;

public interface UserService {
    SysUser findByUsername(String username);

    User createCamundaUser(String username);
}
