package com.la.mapper;

import com.la.dto.PurchaseBookRequestDTO;
import com.la.model.PurchaseBookRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class PurchaseBookRequestDTOMapper implements MapperInterface<PurchaseBookRequest, PurchaseBookRequestDTO> {

    private ModelMapper modelMapper;

    @Autowired
    public PurchaseBookRequestDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PurchaseBookRequest toEntity(PurchaseBookRequestDTO dto) throws ParseException {
        return modelMapper.map(dto, PurchaseBookRequest.class);
    }

    @Override
    public PurchaseBookRequestDTO toDTO(PurchaseBookRequest entity) {
        return modelMapper.map(entity, PurchaseBookRequestDTO.class);
    }
}
