package com.peilw.child.redistemplate.hash_redistemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo {
    @Autowired
    private RedisTemplate redisTemplate;

    public void hashDemo() {
        //Long delete(H key, Object... hashKeys);
        //删除给定的哈希hashKeys
        System.out.println(redisTemplate.opsForHash().delete("redisHash", "name"));
        System.out.println(redisTemplate.opsForHash().entries("redisHash"));
        //Boolean hasKey(H key, Object hashKey);
        //确定哈希hashKey是否存在
        System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "666"));
        System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "777"));
        //HV get(H key, Object hashKey);
        //从键中的哈希获取给定hashKey的值
        System.out.println(redisTemplate.opsForHash().get("redisHash", "age"));
        //Set<HK> keys(H key);
        //获取key所对应的散列表的key
        System.out.println(redisTemplate.opsForHash().keys("redisHash"));
        //Long size(H key);
        //获取key所对应的散列表的大小个数
        System.out.println(redisTemplate.opsForHash().size("redisHash"));
        //void putAll(H key, Map<? extends HK, ? extends HV> m);
        //使用m中提供的多个散列字段设置到key对应的散列表中
        Map<String, Object> testMap = new HashMap();
        testMap.put("name", "666");
        testMap.put("age", 27);
        testMap.put("class", "1");
        redisTemplate.opsForHash().putAll("redisHash1", testMap);
        System.out.println(redisTemplate.opsForHash().entries("redisHash1"));
        //void put(H key, HK hashKey, HV value);
        //设置散列hashKey的值
        redisTemplate.opsForHash().put("redisHash", "name", "666");
        redisTemplate.opsForHash().put("redisHash", "age", 26);
        redisTemplate.opsForHash().put("redisHash", "class", "6");
        System.out.println(redisTemplate.opsForHash().entries("redisHash"));
        //List<HV> values(H key);
        //获取整个哈希存储的值根据密钥
        System.out.println(redisTemplate.opsForHash().values("redisHash"));
        //Map<HK, HV> entries(H key);
        //获取整个哈希存储根据密钥
        System.out.println(redisTemplate.opsForHash().entries("redisHash"));
    }

    public void hashDemo2() {
        //1、put(H key, HK hashKey, HV value)
        //   新增hashMap值。
        redisTemplate.opsForHash().put("hashValue", "map1", "map1-1");
        redisTemplate.opsForHash().put("hashValue", "map2", "map2-2");
        //values(H key)
        //  获取指定变量中的hashMap值。
        List<Object> hashList = redisTemplate.opsForHash().values("hashValue");
        System.out.println("通过values(H key)方法获取变量中的hashMap值:" + hashList);
        //entries(H key)
        //  获取变量中的键值对。
        Map<Object, Object> map = redisTemplate.opsForHash().entries("hashValue");
        System.out.println("通过entries(H key)方法获取变量中的键值对:" + map);
        //get(H key, Object hashKey)
        //  获取变量中的指定map键是否有值,如果存在该map键则获取值，没有则返回null。
        Object mapValue = redisTemplate.opsForHash().get("hashValue", "map1");
        System.out.println("通过get(H key, Object hashKey)方法获取map键的值:" + mapValue);
        //hasKey(H key, Object hashKey)
        //判断变量中是否有指定的map键。
        boolean hashKeyBoolean = redisTemplate.opsForHash().hasKey("hashValue", "map3");
        System.out.println("通过hasKey(H key, Object hashKey)方法判断变量中是否存在map键:" + hashKeyBoolean);
        //keys(H key)
        //获取变量中的键
        Set<Object> keySet = redisTemplate.opsForHash().keys("hashValue");
        System.out.println("通过keys(H key)方法获取变量中的键:" + keySet);
        //size(H key)
        //获取变量的长度
        long hashLength = redisTemplate.opsForHash().size("hashValue");
        System.out.println("通过size(H key)方法获取变量的长度:" + hashLength);

    }
}