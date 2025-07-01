package org.example.kitap_kz.controller;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.ReaderDTO;
import org.example.kitap_kz.entity.Reader;
import org.example.kitap_kz.repo.ReaderRepository;
import org.example.kitap_kz.service.ReaderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepository;
    private final ReaderService readerService;

    @PostMapping
    public Reader addReader(@RequestBody ReaderDTO readerDTO) {
        return readerService.addReader(readerDTO);
    }
}
