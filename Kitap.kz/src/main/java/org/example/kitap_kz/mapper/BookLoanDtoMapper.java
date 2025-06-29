package org.example.kitap_kz.mapper;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.BookLoanDto;
import org.example.kitap_kz.entity.BookLoan;
import org.example.kitap_kz.service.BookService;
import org.example.kitap_kz.service.ReaderService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookLoanDtoMapper {

    private final ReaderService readerService;

   private final BookService bookService;
   private final ReaderService bookReaderService;
    // ентити ды дто га айналдыру
    public BookLoanDto toBookLoanDto(BookLoan bookLoan) {
        BookLoanDto bookLoanDto = new BookLoanDto();
        bookLoanDto.setId(bookLoan.getId());
        bookLoanDto.setBookId(bookLoan.getBook().getId());
        bookLoanDto.setReaderId(bookLoan.getReader().getId());
        bookLoanDto.setLocalDate(bookLoan.getLocalDate());
        bookLoanDto.setReturnDate(bookLoan.getReturnDate());
        return bookLoanDto;
    }

    // дто ны ентитге аударатын метод
    public BookLoan fromBookLoanDto(BookLoanDto bookLoanDto) {
        BookLoan bookLoan = new BookLoan();
        bookLoan.setId(bookLoanDto.getId());
        bookLoan.setBook(bookService.findById(bookLoanDto.getBookId()));
        bookLoan.setReader(readerService.findById(bookLoanDto.getReaderId()));
        bookLoan.setLocalDate(bookLoanDto.getLocalDate());
        bookLoan.setReturnDate(bookLoanDto.getReturnDate());
        return bookLoan;
    }
}
