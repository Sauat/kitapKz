package org.example.kitap_kz.repo;

import org.example.kitap_kz.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
     Book findByBookTitle(String bookTitle);


     List<Book> findByAuthor_FirstName(String authorFirstName);

     List<Book> findByavailable(boolean available);
}

