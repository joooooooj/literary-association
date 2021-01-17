package com.la.service.registration;

import com.la.dto.FormSubmissionDTO;
import com.la.model.Genre;
import com.la.model.users.Reader;
import com.la.repository.ReaderRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UpdateReaderService implements JavaDelegate {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Reader reader = readerRepository.findByUsername(delegateExecution.getVariable("registeredUser").toString());
        System.out.println("KORISNIK JE " + reader.getUsername());

        // PROVERA DA LI GENRE POSTOJI, JER PRAVI NOVI

        List<FormSubmissionDTO> preferences = (List<FormSubmissionDTO>) delegateExecution.getVariable("betaReaderWantedGenres");
        preferences.forEach(formField -> {
            if (formField.getFieldId().equals("genres")) {
                System.out.println("OVDE SU ZANROVI KOD PISCA KADA JE BETA" + formField.getFieldValue());
                reader.setBetaReaderGenres(Collections.singleton(new Genre(formField.getFieldValue())));
            }
        });

        readerRepository.save(reader);
    }
}
