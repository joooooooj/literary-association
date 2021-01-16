package com.la.model.mappers;

import com.la.model.dtos.BookDTO;
import com.la.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class BookDTOMapper implements MapperInterface<Book, BookDTO> {

    private ModelMapper modelMapper;

    @Autowired
    public BookDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Book toEntity(BookDTO dto) throws ParseException {
        return modelMapper.map(dto, Book.class);
    }

    @Override
    public BookDTO toDTO(Book entity) {
        return modelMapper.map(entity, BookDTO.class);
    }
}
