package com.example.booklist.dao;

import com.example.booklist.BookMapper;
import com.example.booklist.entity.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BookDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // можно использовать готовый new BeanPropertyRowMapper<>(Book.class) вместо new BookMapper
  public List<Book> getBooks() {
    return jdbcTemplate.query("SELECT * FROM Book", new BookMapper());
  }

  public Book getBookById(long id) {
    return jdbcTemplate.query("SELECT * FROM Book where id=?", new Object[]{id}, new BookMapper())
        .stream().findAny().orElseThrow();
  }

  public Book save(Book book) {
    jdbcTemplate.update("INSERT INTO Book VALUES (1, ?, ?, ?)", book.getAuthor(), book.getTittle(),
        book.getPublicationYear());
    return book;
  }

  public Book update(long id, Book book) {
     jdbcTemplate.update("UPDATE Book SET author=?, tittle=?, publicationYear=? WHERE id=?",
        book.getAuthor(), book.getTittle(), book.getPublicationYear(), id);
     return book;
  }

  public void delete(long id) {
     jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
  }
}
