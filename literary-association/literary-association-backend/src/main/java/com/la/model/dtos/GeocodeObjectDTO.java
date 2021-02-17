package com.la.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeObjectDTO {

    @JsonProperty("place_id")
    String placeId;
    @JsonProperty("address_components")
    List<AddressComponentDTO> addressComponents;
    @JsonProperty("formatted_address")
    String formattedAddress;

    GeocodeGeometryDTO geometry;

    public GeocodeObjectDTO() {
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<AddressComponentDTO> getAddressComponents() {
        return addressComponents;
    }

    public void setAdressComponents(List<AddressComponentDTO> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public GeocodeGeometryDTO getGeometry() {
        return geometry;
    }

    public void setGeometry(GeocodeGeometryDTO geometry) {
        this.geometry = geometry;
    }
}
