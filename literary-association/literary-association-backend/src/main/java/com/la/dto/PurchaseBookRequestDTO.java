package com.la.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PurchaseBookRequestDTO {
    private Double price;
    private List<BookDTO> bookList;
}
