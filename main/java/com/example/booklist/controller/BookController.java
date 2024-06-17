package com.example.booklist.controller;

import com.example.booklist.dao.BookDao;
import com.example.booklist.entity.Book;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

  private final BookDao bookDao;

  @PostMapping("/save/book")
  public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    return ResponseEntity.ok(bookDao.save(book));
  }

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(bookDao.getBooks());
  }

  @GetMapping("book/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    return ResponseEntity.ok(bookDao.getBookById(id));
  }

  @PatchMapping("/update/book")
  public ResponseEntity<Book> updateProduct(Long id,
      @Valid @RequestBody Book book) {
    return ResponseEntity.ok(bookDao.update(id, book));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
    bookDao.delete(id);
    return ResponseEntity.ok().build();
  }
}

