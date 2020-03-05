package com.peilw.child.controller;

import com.peilw.child.entity.Book;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> Books = new ArrayList<>();
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice("30");
        Books.add(book);
        Book book1 = new Book();
        book1.setAuthor("曹雪芹");
        book1.setName("红楼梦");
        book1.setPrice("40");
        Books.add(book1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", Books);
        modelAndView.setViewName("books");
        return modelAndView;
    }

    @GetMapping("/hello")
    @ResponseBody
    public void hello(Model model) {
        Map<String, Object> map = model.asMap();
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = map.get(key);
            System.out.println(key + ">>>" + value);
        }
    }

    @PostMapping("/")
    @CrossOrigin(value = "http://localhost/8080", maxAge = 18000, allowedHeaders = "*")
    public String addBook(String name) {
        return "receive:" + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost/8080", maxAge = 18000, allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
