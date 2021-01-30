package com.la.service.registration;

import com.la.dto.FormSubmissionDTO;
import com.la.handler.RegistrationStartHandler;
import com.la.model.Genre;
import com.la.model.users.Reader;
import com.la.model.users.SysUser;
import com.la.repository.GenreRepository;
import com.la.repository.ReaderRepository;
import com.la.repository.UserRepository;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CreateUserService implements JavaDelegate {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private UserRepository<SysUser> userRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private RegistrationStartHandler registrationStartHandler;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<FormSubmissionDTO> registration = (List<FormSubmissionDTO>) delegateExecution.getVariable("registration");
        Boolean isWriter = (Boolean) delegateExecution.getVariable("is_writer");
        Boolean isBeta = (Boolean) delegateExecution.getVariable("is_beta");
//        List<FormSubmissionDTO> preferences = (List<FormSubmissionDTO>) delegateExecution.getVariable("userPreferences");

        User newUser = identityService.newUser("");
        SysUser newSystemUser;
        Reader newReader = new Reader();

        if (isWriter) {
            newSystemUser = new SysUser();
        } else {
            newSystemUser = newReader;
        }
        newSystemUser.setActive(false);
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
                String city = registrationStartHandler.getCitiesAndCountries().get(Integer.parseInt(formField.getFieldValue())).getValue().split(",")[0];
                String country = registrationStartHandler.getCitiesAndCountries().get(Integer.parseInt(formField.getFieldValue())).getValue().split(",")[1];
                newSystemUser.setCity(city);
                newSystemUser.setState(country);
            }
            if (formField.getFieldId().equals("genresInterestedIn")) {
                System.out.println("OVDE SU ZANROVI KOD KORISNIKA" + formField.getFieldValue());
                newSystemUser.setGenres(Collections.singleton(genreRepository.findById(Long.parseLong(formField.getFieldValue())).get()));
            }
        });

        identityService.saveUser(newUser);
        userRepository.save(newSystemUser);

        delegateExecution.setVariable("registeredUser", newUser.getId());
    }
}
