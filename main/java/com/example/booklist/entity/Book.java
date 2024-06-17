package com.example.booklist.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {


  private Long id;
  @NotEmpty
  private String tittle;
  @NotEmpty
  private String author;
  @NotEmpty
  private String publicationYear;


}
