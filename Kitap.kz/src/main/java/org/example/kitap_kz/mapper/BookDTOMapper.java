package org.example.kitap_kz.mapper;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.BookDTO;
import org.example.kitap_kz.entity.Book;
import org.example.kitap_kz.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookDTOMapper {
    private final AuthorService authorService;

    public BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setBookTitle(book.getBookTitle());
        bookDTO.setAuthorId(book.getAuthor().getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setAvailable(book.isAvailable());
        return bookDTO;
    }

    public Book toBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setBookTitle(bookDTO.getBookTitle());
        book.setAuthor(authorService.findAuthorById(bookDTO.getAuthorId()));
        book.setIsbn(bookDTO.getIsbn());
        book.setAvailable(bookDTO.isAvailable());
        return book;
    }
}
