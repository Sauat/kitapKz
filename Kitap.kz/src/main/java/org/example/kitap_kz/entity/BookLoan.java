package org.example.kitap_kz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "BookLoans")
@Data
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   @OneToOne
   @JoinColumn(name="book_id", nullable=false)
   private Book book;

   @ManyToOne
   @JoinColumn(name="reader_id",nullable = false)
   private Reader reader;


    private LocalDate localDate;
    private LocalDate returnDate;


}
