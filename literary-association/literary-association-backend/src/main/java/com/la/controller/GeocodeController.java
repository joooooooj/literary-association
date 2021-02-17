package com.la.controller;

import com.la.model.dtos.GeocodeLocationDTO;
import com.la.model.dtos.GeocodeResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

@RestController
@RequestMapping("geocode")
public class GeocodeController {

    private static final String PLACE_DETAILS_URL = "https://maps.googleapis.com/"
            + "maps/api/geocode/json?address="
            + "{encodedAddress}&sensor=false&key=AIzaSyCFxVnESrFcFZzyuEq7YaIuGgWFYvZ4SW4";

    @Autowired
    RestTemplate restTemplate;

    public GeocodeLocationDTO getGeocode(String location) throws Exception {
        System.out.println("Getting geocode!");
        String encodedAddress = URLEncoder.encode(location, "UTF-8");
        GeocodeResultDTO response = restTemplate.getForObject(PLACE_DETAILS_URL, GeocodeResultDTO.class, encodedAddress);
        if (response.getResults() != null) {
            GeocodeLocationDTO geocodeLocation = response.getResults().get(0).getGeometry().getGeocodeLocation();
            return geocodeLocation;
        } else {
            return null;
        }
    }
}
