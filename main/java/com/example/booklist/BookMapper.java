package com.example.booklist;

import com.example.booklist.entity.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {

  @Override
  public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    Book book = new Book();
    book.setId(resultSet.getLong("id"));
    book.setAuthor(resultSet.getString("author"));
    book.setTittle(resultSet.getString("tittle"));
    book.setPublicationYear(resultSet.getString("publication_year"));
    return book;
  }
}
