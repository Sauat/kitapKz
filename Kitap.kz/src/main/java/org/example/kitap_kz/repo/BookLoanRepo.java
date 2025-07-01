package org.example.kitap_kz.repo;

import org.example.kitap_kz.entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookLoanRepo extends JpaRepository<BookLoan, Long> {
    BookLoan findByReaderIdAndBookId(Long readerId, Long bookId);
}
