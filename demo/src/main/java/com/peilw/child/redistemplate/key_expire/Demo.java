package com.peilw.child.redistemplate.key_expire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Demo {
    @Autowired
    private RedisTemplate redisTemplate;

    public void expire1() throws Exception {
        //构造Key与Redis操作组件ValueOperations
        final String key1 = "redis:test:6";
        //第一种方法：在往缓存中set数据时，提供一个TTL，表示ttl时间一到，缓存中的key
        //将自动失效，即被清理，在这里TTL是10秒
        redisTemplate.opsForValue().set(key1, "expire操作", 10L, TimeUnit.SECONDS);
        //等待5秒-判断key是否还存在
        Thread.sleep(5000);
        Boolean existKey1 = redisTemplate.hasKey(key1);
        Object value =  redisTemplate.opsForValue().get(key1);
        log.info("等待5秒-判断key是否还存在：{} 对应的值：{}", existKey1, value);
        //再等待5秒-再判断key是否还存在
        Thread.sleep(5000);
        existKey1 = redisTemplate.hasKey(key1);
        value =  redisTemplate.opsForValue().get(key1);
        log.info("再等待5秒-再判断key是否还存在：{} 对应的值：{}", existKey1, value);
    }
    public void expire2() throws Exception{
        //构造key与redis操作组件
        final String key2="redis:test:7";
        //第二种方法：在往缓存中set数据后，采用redisTemplate的expire方法使该key失效
        redisTemplate.opsForValue().set(key2, "expire操作-2");
        redisTemplate.expire(key2,10L, TimeUnit.SECONDS);
        //等待5秒-判断key是否还存在
        Thread.sleep(5000);
        Boolean existKey=redisTemplate.hasKey(key2);
        Object value=redisTemplate.opsForValue().get(key2);
        log.info("等待5秒-判断key是否还存在：{} 对应的值：{}", existKey, value);
        //再等待5秒-再判断key是否还存在
        Thread.sleep(5000);
        existKey=redisTemplate.hasKey(key2);
        value=redisTemplate.opsForValue().get(key2);
        log.info("再等待5秒-再判断key是否还存在：{} 对应的值：{}", existKey, value);
    }
}
