package com.la.service.registration;

import com.la.dto.FormSubmissionDTO;
import com.la.model.Genre;
import com.la.model.users.Reader;
import com.la.model.users.SysUser;
import com.la.repository.ReaderRepository;
import com.la.repository.UserRepository;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CreateReaderService implements JavaDelegate {

    @Autowired
    private UserRepository<SysUser> userRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        SysUser user = userRepository.findByUsername(delegateExecution.getVariable("registeredUser").toString());
        System.out.println("KORISNIK JE " + user.getUsername());

        Reader reader = new Reader();
        reader.setUsername(user.getUsername());
        reader.setPassword(user.getPassword());
        reader.setFirstName(user.getFirstName());
        reader.setLastName(user.getLastName());
        reader.setEmail(user.getEmail());
        reader.setCity(user.getCity());
        reader.setState(user.getState());

        // MOZDA ROLE I ACTIVE

        List<FormSubmissionDTO> preferences = (List<FormSubmissionDTO>) delegateExecution.getVariable("readerPreferences");
        preferences.forEach(formField -> {
            if (formField.getFieldId().equals("genres")) {
                System.out.println("OVDE SU ZANROVI KOD PISCA" + formField.getFieldValue());
                reader.setGenres(Collections.singleton(new Genre(formField.getFieldValue())));
            }
        });

        readerRepository.save(reader);
        userRepository.deleteById(user.getId());
    }
}
