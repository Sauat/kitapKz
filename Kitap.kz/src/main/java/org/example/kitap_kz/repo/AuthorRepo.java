package org.example.kitap_kz.repo;

import org.example.kitap_kz.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
