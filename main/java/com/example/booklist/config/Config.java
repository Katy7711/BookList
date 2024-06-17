package com.example.booklist.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config {

  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/bookLibrary");
    dataSource.setUsername("bookLibrary");
    dataSource.setPassword("bookLibrary");
    return dataSource;
  }
  @Bean
  public JdbcTemplate jdbcTemplate () {
    return new JdbcTemplate(dataSource());
  }
}
