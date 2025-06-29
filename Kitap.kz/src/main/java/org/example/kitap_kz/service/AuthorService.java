package org.example.kitap_kz.service;

import org.example.kitap_kz.entity.Author;

import java.util.List;

public interface AuthorService {
    Author findAuthorById(Long id);

    List<Author> findAuthorByAll();

    Author createAuthor(Author author);

    Author updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);
}
