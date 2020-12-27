package com.la.handler;

import java.util.List;

import com.la.model.Genre;
import com.la.repository.UserRepository;
import com.la.service.GenreService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishBookStartHandler implements ExecutionListener {

    @Autowired
    private GenreService genreService;

    @Autowired
    UserRepository userRepository;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.err.println("Poceo proces sa ID-jem : " + execution.getId());

        List<Genre> genres = genreService.findAll();
        execution.setVariable("genres", genres);

        System.err.println("Setovana varijabla 'genres' : " + execution.getVariable("genres"));
    }
}

