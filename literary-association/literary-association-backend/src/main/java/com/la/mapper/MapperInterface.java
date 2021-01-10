package com.la.mapper;

import java.text.ParseException;

public interface MapperInterface<T, U> {
    T toEntity(U dto) throws ParseException;

    U toDTO(T entity);
}
