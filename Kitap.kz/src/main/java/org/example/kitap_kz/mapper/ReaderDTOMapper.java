package org.example.kitap_kz.mapper;

import lombok.RequiredArgsConstructor;
import org.example.kitap_kz.dto.ReaderDTO;
import org.example.kitap_kz.entity.Reader;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReaderDTOMapper {
    public ReaderDTO toReaderDTO(Reader reader) {
        ReaderDTO readerDTO = new ReaderDTO();
        readerDTO.setId(reader.getId());
        readerDTO.setFullName(reader.getFullName());
        readerDTO.setEmail(reader.getEmail());
        return readerDTO;
    }

    public Reader toReader(ReaderDTO readerDTO) {
        Reader reader = new Reader();
        reader.setId(readerDTO.getId());
        reader.setFullName(readerDTO.getFullName());
        reader.setEmail(readerDTO.getEmail());
        return reader;
    }
}
