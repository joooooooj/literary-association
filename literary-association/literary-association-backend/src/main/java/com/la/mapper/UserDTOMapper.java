package com.la.mapper;

import com.la.dto.UserDTO;
import com.la.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class UserDTOMapper implements MapperInterface<User, UserDTO> {

    private ModelMapper modelMapper;

    @Autowired
    public UserDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public User toEntity(UserDTO dto) throws ParseException {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public UserDTO toDTO(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }
}
