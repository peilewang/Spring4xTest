package com.peilw.child.redistemplate.string_redistemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class Demo {
    @Autowired
    RedisTemplate redisTemplate;

    public void StringDemo() {
        redisTemplate.opsForValue().set("num", "123");
        redisTemplate.opsForValue().get("num");
        redisTemplate.opsForValue().set("num", "123", 10, TimeUnit.SECONDS);
        redisTemplate.opsForValue().get("num");
    }

    public void StringDemo2() {
        //1、set(K key, V value)
        //新增一个字符串类型的值,key是键，value是值。
        redisTemplate.opsForValue().set("stringValue", "bbb");
        //2、get(Object key)
        //获取key键对应的值。
        String stringValue = redisTemplate.opsForValue().get("stringValue") + "";
        System.out.println("通过get(Object key)方法获取set(K key, V value)方法新增的字符串值:" + stringValue);
        //3、append(K key, String value)
        //在原有的值基础上新增字符串到末尾。
        redisTemplate.opsForValue().append("stringValue", "aaa");
        String stringValueAppend = redisTemplate.opsForValue().get("stringValue") + "";
        System.out.println("通过append(K key, String value)方法修改后的字符串:" + stringValueAppend);
        //get(K key, long start, long end)
        //截取key键对应值得字符串，从开始下标位置开始到结束下标的位置(包含结束下标)的字符串。
        String cutString = redisTemplate.opsForValue().get("stringValue", 0, 3);
        System.out.println("通过get(K key, long start, long end)方法获取截取的字符串:" + cutString);
        //5、getAndSet(K key, V value)
        //获取原来key键对应的值并重新赋新值。
        String oldAndNewStringValue = redisTemplate.opsForValue().getAndSet("stringValue", "ccc") + "";
        System.out.print("通过getAndSet(K key, V value)方法获取原来的" + oldAndNewStringValue + ",");
        String newStringValue = redisTemplate.opsForValue().get("stringValue") + "";
        System.out.println("修改过后的值:" + newStringValue);
        // 12、set(K key, V value, long timeout, TimeUnit unit)
        //设置变量值的过期时间。
        redisTemplate.opsForValue().set("timeOutValue", "timeOut", 5, TimeUnit.SECONDS);
        String timeOutValue = redisTemplate.opsForValue().get("timeOutValue") + "";
        System.out.println("通过set(K key, V value, long timeout, TimeUnit unit)方法设置过期时间，过期之前获取的数据:" + timeOutValue);
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timeOutValue = redisTemplate.opsForValue().get("timeOutValue") + "";
        System.out.print(",等待10s过后，获取的值:" + timeOutValue);
    }
}
