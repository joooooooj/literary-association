package com.la.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown =  true)
public class GeocodeResultDTO {

    List<GeocodeObjectDTO> results;
    String status;

    public GeocodeResultDTO() {
    }

    public List<GeocodeObjectDTO> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public void setResults(List<GeocodeObjectDTO> results) {
        this.results = results;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
