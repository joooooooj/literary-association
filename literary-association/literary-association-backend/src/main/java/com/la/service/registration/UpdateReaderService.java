package com.la.service.registration;

import com.la.dto.FormSubmissionDTO;
import com.la.model.Genre;
import com.la.model.users.Reader;
import com.la.model.users.SysUser;
import com.la.repository.GenreRepository;
import com.la.repository.ReaderRepository;
import com.la.repository.UserRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UpdateReaderService implements JavaDelegate {

    @Autowired
    private UserRepository<SysUser> userRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Reader reader = (Reader) userRepository.findByUsername(delegateExecution.getVariable("registeredUser").toString());
        System.out.println("KORISNIK JE " + reader.getUsername());

        List<FormSubmissionDTO> preferences = (List<FormSubmissionDTO>) delegateExecution.getVariable("betaReaderWantedGenres");
        preferences.forEach(formField -> {
            if (formField.getFieldId().equals("genres")) {
                System.out.println("OVDE SU ZANROVI KOD PISCA KADA JE BETA" + formField.getFieldValue());

                Set<Genre> genres = new HashSet<>();
                genres.add(genreRepository.findById(Long.parseLong(formField.getFieldValue())).get());
                reader.setBetaReaderGenres(genres);
            }
        });
        reader.setBeta(true);
        userRepository.save(reader);
    }
}
