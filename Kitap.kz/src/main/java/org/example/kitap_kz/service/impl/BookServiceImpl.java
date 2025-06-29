package org.example.kitap_kz.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.BookDTO;
import org.example.kitap_kz.entity.Book;
import org.example.kitap_kz.repo.AuthorRepo;
import org.example.kitap_kz.repo.BookRepository;
import org.example.kitap_kz.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepo authorRepository;

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book bookEntity = new Book();
        bookEntity.setBookTitle(bookDTO.getBookTitle());
        bookEntity.setIsbn(bookDTO.getIsbn());
        bookEntity.setAvailable(bookDTO.isAvailable());
        bookEntity.setAuthor(authorRepository.findById(bookDTO.getAuthorId()).get());
        return bookRepository.save(bookEntity);
    }

    @Override
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {

        Optional<Book> book1 = bookRepository.findById(id);
        if (book1.isPresent()) {
            book1.get().setBookTitle(book.getBookTitle());
            bookRepository.save(book1.get());
            return book1.get();
        }
        return null;
    }

    @Override
    public Book deleteBookByTitle(@RequestParam("title") String title) {
        Book book = bookRepository.findByBookTitle(title);
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);

    }
}
