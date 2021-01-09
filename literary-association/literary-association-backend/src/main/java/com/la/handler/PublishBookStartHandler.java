package com.la.handler;

import java.util.List;

import com.la.model.Genre;
import com.la.repository.UserRepository;
import com.la.service.GenreService;
import com.la.service.UserService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishBookStartHandler implements ExecutionListener {

    @Autowired
    private GenreService genreService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.err.println("Process started with ID : " + execution.getId());

        List<Genre> genres = genreService.findAll();
        execution.setVariable("genres", genres);
        execution.setVariable("writer", "none");
        execution.setVariable("editor", "none");
    }
}

