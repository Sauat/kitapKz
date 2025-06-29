package org.example.kitap_kz.dto;

import lombok.Data;

@Data

public class BookDTO {

    private Long id;

    private String bookTitle;

    private Long authorId;

    private String isbn;

    private boolean available;
}
