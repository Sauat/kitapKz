package org.example.kitap_kz.controller;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.BookLoanDto;
import org.example.kitap_kz.entity.BookLoan;
import org.example.kitap_kz.mapper.BookLoanDtoMapper;
import org.example.kitap_kz.service.BookLoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookLoans")
@RequiredArgsConstructor
public class BookLoanController {
    private final BookLoanService bookLoanService;
    private final BookLoanDtoMapper bookLoanDtoMapper;

    @PostMapping
    private BookLoan createBookLoan(@RequestBody BookLoanDto bookLoanDto) {
        BookLoan bookLoan = bookLoanDtoMapper.fromBookLoanDto(bookLoanDto);
        BookLoan bookLoan1 = bookLoanService.saveBookLoan(bookLoan);
        return bookLoan1;
    }
}
