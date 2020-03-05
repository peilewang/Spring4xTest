package com.peilw.child.controller;

import com.peilw.child.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherBookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test1")
    public void test1() {
        ValueOperations<String, String> opsl = stringRedisTemplate.opsForValue();
        opsl.set("name","三国演义");
        String name = opsl.get("name");
        System.out.println(name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book bl = new Book();
        bl.setId(1);
        bl.setName("红楼梦");
        bl.setAuthor("曹雪芹");
        ops2.set("bl" , bl);
        Book book = (Book)ops2.get("bl");
        System.out.println(book);
    }
}
