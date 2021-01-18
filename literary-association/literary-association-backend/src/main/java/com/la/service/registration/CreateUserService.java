package com.la.service.registration;

import com.la.dto.FormSubmissionDTO;
import com.la.model.users.SysUser;
import com.la.repository.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    @Autowired
    private UserRepository<SysUser> userRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<FormSubmissionDTO> registration = (List<FormSubmissionDTO>) delegateExecution.getVariable("registration");
        User newUser = identityService.newUser("");
        SysUser newSystemUser = new SysUser();
        newSystemUser.setActive(Boolean.FALSE);
        registration.forEach(formField -> {
            if (formField.getFieldId().equals("username")) {
                newUser.setId(formField.getFieldValue());
                newSystemUser.setUsername(formField.getFieldValue());
            }
            if (formField.getFieldId().equals("password")) {
                newUser.setPassword(formField.getFieldValue());
                newSystemUser.setPassword(formField.getFieldValue());
            }
            if (formField.getFieldId().equals("name")) {
                newUser.setFirstName(formField.getFieldValue());
                newSystemUser.setFirstName(formField.getFieldValue());
            }
            if (formField.getFieldId().equals("surname")) {
                newUser.setLastName(formField.getFieldValue());
                newSystemUser.setLastName(formField.getFieldValue());
            }
            if (formField.getFieldId().equals("email")) {
                newUser.setEmail(formField.getFieldValue());
                newSystemUser.setEmail(formField.getFieldValue());
            }
            if (formField.getFieldId().equals("cityandcountry")) {
                newSystemUser.setCity(formField.getFieldValue().split(",")[0]);
                newSystemUser.setState(formField.getFieldValue().split(",")[1]);
            }
        });
        identityService.saveUser(newUser);
        userRepository.save(newSystemUser);

        delegateExecution.setVariable("registeredUser", newUser.getId());
    }
}
