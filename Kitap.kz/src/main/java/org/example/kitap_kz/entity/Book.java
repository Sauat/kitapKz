package org.example.kitap_kz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_title")
    private String bookTitle;

   @OneToOne
   @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "available")
    private boolean available;



}
