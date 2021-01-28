package com.la.handler;

import com.la.model.Genre;
import com.la.service.GenreService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationStartHandler implements ExecutionListener {

    @Autowired
    private GenreService genreService;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        List<Genre> genres = genreService.findAll();
        delegateExecution.setVariable("genres", genres);
        delegateExecution.setVariable("citiesAndCountries", getCitiesAndCountries());
    }

    public List<CityAndCountry> getCitiesAndCountries() {
        List<CityAndCountry> cityAndCountries = new ArrayList<>();
        cityAndCountries.add(new CityAndCountry(1L, "Belgrade, Serbia"));
        cityAndCountries.add(new CityAndCountry(2L, "Valencia, Spain"));
        cityAndCountries.add(new CityAndCountry(3L, "Rome, Italy"));
        return cityAndCountries;
    }
}
