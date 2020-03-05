package com.peilw.child.dao;

import com.peilw.child.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "book cache")
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addBook(Book book) {
        return jdbcTemplate.update("INSERT INTO book(name , author) VALUES (? , ?)",
                book.getName(), book.getAuthor());
    }
    @CachePut(key = "#book.id")
    public int updateBook(Book book) {
        return jdbcTemplate.update("UPDATE book SET name=?,author=? WHERE id=?",
                book.getName(), book.getAuthor(), book.getId());
    }
    @CacheEvict(key ="#id")
    public int deleteBookByid(Integer id) {
        return jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
    @Cacheable
    public Book getBookByid(Integer id) {
        return jdbcTemplate.queryForObject("select * from book where id =?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
    }
}