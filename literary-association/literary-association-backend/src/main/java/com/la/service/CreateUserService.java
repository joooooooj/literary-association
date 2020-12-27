package com.la.service;

import com.la.dto.FormItemDTO;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateUserService implements JavaDelegate {

    @Autowired
    private IdentityService identityService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
            List<FormItemDTO> registration = (List<FormItemDTO>) delegateExecution.getVariable("registration");
            User newUser = identityService.newUser("");
            registration.forEach(formField -> {
                if (formField.getFieldId().equals("username")) {
                    newUser.setId(formField.getFieldValue());
                }
                if (formField.getFieldId().equals("password")) {
                    newUser.setPassword(formField.getFieldValue());
                }
            });
            identityService.saveUser(newUser);
    }
}
