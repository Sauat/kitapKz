package org.example.kitap_kz.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.entity.Author;
import org.example.kitap_kz.repo.AuthorRepo;
import org.example.kitap_kz.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;


    @Override
    public Author findAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAuthorByAll() {
        return authorRepo.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author oldAuthor = findAuthorById(id);
        oldAuthor.setId(author.getId());
        oldAuthor.setFirstName(author.getFirstName());
        oldAuthor.setLastName(author.getLastName());
        return authorRepo.save(oldAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author oldAuthor = findAuthorById(id);
        authorRepo.delete(oldAuthor);
    }

}
