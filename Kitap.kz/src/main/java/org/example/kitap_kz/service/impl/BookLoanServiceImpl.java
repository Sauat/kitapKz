package org.example.kitap_kz.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.entity.Book;
import org.example.kitap_kz.entity.BookLoan;
import org.example.kitap_kz.repo.BookLoanRepo;
import org.example.kitap_kz.service.BookLoanService;
import org.example.kitap_kz.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepo bookLoanRepo;
    private final BookService bookService;

    @Override
    public BookLoan getBookLoanById(Long id) {
        return bookLoanRepo.findById(id).orElse(null);
    }

    @Override
    public List<BookLoan> getAllBookLoans() {
        return bookLoanRepo.findAll();
    }

    @Override
    public BookLoan saveBookLoan(BookLoan bookLoan) {
        return bookLoanRepo.save(bookLoan);
    }

    @Override
    public String returnBook(Long readerId, Long bookId) {
        BookLoan bookLoan = bookLoanRepo.findByReaderIdAndBookId(readerId, bookId);
        if (bookLoan != null) {
            bookLoan.setReturnDate(LocalDate.now());
            Book book = bookService.findById(bookLoan.getBook().getId());
            book.setAvailable(true);
            bookService.updateBook(book, book.getId());
            bookLoanRepo.deleteById(bookLoan.getId());
            return "Successfully returned book loan";

        }

        return "Bookloan not found";
    }

    @Override
    public void deleteBookLoanById(Long id) {
        BookLoan bookLoan = getBookLoanById(id);
        bookLoanRepo.delete(bookLoan);
    }
}
