package com.la.service.publish;

import com.la.model.Genre;
import com.la.model.publish.PublishBookRequest;
import com.la.model.users.Reader;
import com.la.model.users.SysUser;
import com.la.repository.GenreRepository;
import com.la.repository.ReaderRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SetBetaReadersService implements JavaDelegate {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    GenreRepository genreRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PublishBookRequest publishBookRequest = (PublishBookRequest) delegateExecution.getVariable("publishBookRequest");

        Genre genre = genreRepository.findByValue(publishBookRequest.getGenre());

        List<Reader> readerList = readerRepository.findByBetaIsTrueAndBetaReaderGenresContains(genre);

        delegateExecution.setVariable("betaBefore", readerList);
    }
}
