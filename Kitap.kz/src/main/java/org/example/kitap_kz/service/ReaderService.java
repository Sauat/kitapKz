package org.example.kitap_kz.service;

import org.example.kitap_kz.dto.ReaderDTO;
import org.example.kitap_kz.entity.Reader;

public interface ReaderService {
    Reader addReader(ReaderDTO readerDTO);


    Reader findById(Long id);
}
