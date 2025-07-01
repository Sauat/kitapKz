package org.example.kitap_kz.service;

import org.example.kitap_kz.entity.BookLoan;

import java.util.List;

public interface BookLoanService {
    BookLoan getBookLoanById(Long id);

    List<BookLoan> getAllBookLoans();

    BookLoan saveBookLoan(BookLoan bookLoan);

    String returnBook(Long readerid, Long bookId);

    void deleteBookLoanById(Long id);


}
