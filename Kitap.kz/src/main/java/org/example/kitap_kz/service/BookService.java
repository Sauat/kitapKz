package org.example.kitap_kz.service;

import org.example.kitap_kz.dto.BookDTO;
import org.example.kitap_kz.entity.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookService {
    Book addBook( BookDTO book);

    Book updateBook(@RequestBody Book book, @PathVariable Long id);

    Book deleteBookByTitle(@RequestParam("title") String title);

    Book findById(Long id);
}
