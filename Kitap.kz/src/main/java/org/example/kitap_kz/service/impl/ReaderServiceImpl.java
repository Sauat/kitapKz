package org.example.kitap_kz.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.ReaderDTO;
import org.example.kitap_kz.entity.Reader;
import org.example.kitap_kz.repo.ReaderRepository;
import org.example.kitap_kz.service.ReaderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;

    @Override
    public Reader addReader(ReaderDTO readerDTO) {
        Reader readerEntity = new Reader();
        readerEntity.setId(readerDTO.getId());
        readerEntity.setFullName(readerDTO.getFullName());
        readerEntity.setEmail(readerDTO.getEmail());
        return readerRepository.save(readerEntity);
    }

    @Override
    public Reader findById(Long id) {
        return readerRepository.findById(id).orElse(null);

    }



}
