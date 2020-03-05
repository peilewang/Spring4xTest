package com.peilw.child.redistemplate.list_redistemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class Demo {
    @Autowired
    private RedisTemplate redisTemplate;

    public void ListDemo() {
        //返回存储在键中的列表的长度。如果键不存在，则将其解释为空列表，并返回0。当key存储的值不是列表时返回错误。
        System.out.println(redisTemplate.opsForValue().size("list"));
        //Long leftPush(K key, V value);
        //将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从左边插入）
        redisTemplate.opsForList().leftPush("list", "java");
        redisTemplate.opsForList().leftPush("list", "python");
        redisTemplate.opsForList().leftPush("list", "c++");
        //Long leftPushAll(K key, V... values); 批量把一个数组插入到列表中
        String[] strs = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().leftPushAll("list", strs);
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
        //Long rightPush(K key, V value);
        //将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从右边插入）
        redisTemplate.opsForList().rightPush("listRight", "java");
        redisTemplate.opsForList().rightPush("listRight", "python");
        redisTemplate.opsForList().rightPush("listRight", "c++");
        redisTemplate.opsForList().rightPushAll("list", strs);
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
        //void set(K key, long index, V value);
        //在列表中index的位置设置value值
        System.out.println(redisTemplate.opsForList().range("listRight", 0, -1));
        redisTemplate.opsForList().set("listRight", 1, "setValue");
        System.out.println(redisTemplate.opsForList().range("listRight", 0, -1));
        //Long remove(K key, long count, Object value);
        //从存储在键中的列表中删除等于值的元素的第一个计数事件。
        //计数参数以下列方式影响操作：
        //count> 0：删除等于从头到尾移动的值的元素。
        //count <0：删除等于从尾到头移动的值的元素。
        //count = 0：删除等于value的所有元素。
        redisTemplate.opsForList().remove("listRight", 1, "setValue");
        //V index(K key, long index);
        //根据下表获取列表中的值，下标是从0开始的
        redisTemplate.opsForList().index("listRight", 2);
        //V leftPop(K key);
        //弹出最左边的元素，弹出之后该值在列表中将不复存在
        System.out.println(redisTemplate.opsForList().leftPop("list"));
        //V rightPop(K key);
        //弹出最右边的元素，弹出之后该值在列表中将不复存在
        System.out.println(redisTemplate.opsForList().rightPop("list"));
    }

}
