package org.example.kitap_kz.repo;

import org.example.kitap_kz.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
