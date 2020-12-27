package com.la.service.impl;

import com.la.model.users.SysUser;
import com.la.repository.UserRepository;
import com.la.service.UserService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    IdentityService identityService;

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = findByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException(String.format("User with username '%s' was not found", username));
        } else {
            return sysUser;
        }
    }

    public User createCamundaUser(String username) {
        User camundaUser = identityService.createUserQuery().userIdIn(username).singleResult();
        // Ako ne postoji
        if (camundaUser == null){
            SysUser sysUser = userRepository.findByUsername(username);
            if (sysUser != null) {
                camundaUser = identityService.newUser(sysUser.getUsername());
                camundaUser.setEmail(sysUser.getEmail());
                camundaUser.setFirstName(sysUser.getFirstName());
                camundaUser.setLastName(sysUser.getLastName());
                camundaUser.setPassword(sysUser.getPassword());
                identityService.saveUser(camundaUser);
            }
        }
        return camundaUser;
    }

}
