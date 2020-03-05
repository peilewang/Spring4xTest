package com.peilw.child.mapper;

import com.peilw.child.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Integer id);
    Book getBookById();
    List<Book> getAllBooks();
}
