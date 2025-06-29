package org.example.kitap_kz.controller;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.BookDTO;
import org.example.kitap_kz.entity.Book;
import org.example.kitap_kz.entity.BookLoan;
import org.example.kitap_kz.repo.BookRepository;
import org.example.kitap_kz.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    @PostMapping
    public Book addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(book, id);
    }

    @DeleteMapping
    public Book deleteBookByTitle(@RequestParam("title") String title) {
        return bookService.deleteBookByTitle(title);
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        return bookRepository.findByavailable(true);


    }
}
