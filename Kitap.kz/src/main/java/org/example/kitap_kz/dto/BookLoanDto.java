package org.example.kitap_kz.dto;

import lombok.Data;
import org.example.kitap_kz.entity.Book;
import org.example.kitap_kz.entity.Reader;

import java.time.LocalDate;
@Data
public class BookLoanDto {
    private Long id;

    private Long bookId;
    private Long readerId;


    private LocalDate localDate;
    private LocalDate returnDate;
}
