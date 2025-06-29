package org.example.kitap_kz.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.entity.BookLoan;
import org.example.kitap_kz.repo.BookLoanRepo;
import org.example.kitap_kz.service.BookLoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepo bookLoanRepo;

    public BookLoan getBookLoanById(Long id) {
        return bookLoanRepo.findById(id).orElse(null);
    }

    public List<BookLoan> getAllBookLoans() {
        return bookLoanRepo.findAll();
    }
    @Override
    public BookLoan saveBookLoan(BookLoan bookLoan) {
        return bookLoanRepo.save(bookLoan);
    }

    public void deleteBookLoanById(Long id) {
        BookLoan bookLoan = getBookLoanById(id);
        bookLoanRepo.delete(bookLoan);
    }
}
