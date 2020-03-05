package com.peilw.child.redistemplate.set_redistemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Demo {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setDemo() {
        //Long add(K key, V... values);
        //无序集合中添加元素，返回添加个数
        //也可以直接在add里面添加多个值 如：template.opsForSet().add("setTest","aaa","bbb")
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("setTest", strs));
        //Long remove(K key, Object... values);
        //移除集合中一个或多个成员
        strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().remove("setTest", strs));
        // V pop(K key);
        //移除并返回集合中的一个随机元素
        System.out.println(redisTemplate.opsForSet().pop("setTest"));
        System.out.println(redisTemplate.opsForSet().members("setTest"));
        //Boolean move(K key, V value, K destKey);
        //将 member 元素从 source 集合移动到 destination 集合
        redisTemplate.opsForSet().move("setTest", "aaa", "setTest2");
        System.out.println(redisTemplate.opsForSet().members("setTest"));
        System.out.println(redisTemplate.opsForSet().members("setTest2"));
        //Long size(K key);
        //无序集合的大小长度
        System.out.println(redisTemplate.opsForSet().size("setTest"));
        //Set<V> members(K key);
        //返回集合中的所有成员
        System.out.println(redisTemplate.opsForSet().members("setTest"));
    }

    public void setDemo2() {
        //  1、add(K key, V... values)
        //  向变量中批量添加值。
        redisTemplate.opsForSet().add("setValue", "A", "B", "C", "B", "D", "E", "F");
        //  2、members(K key)
        //  获取变量中的值。
        Set set = redisTemplate.opsForSet().members("setValue");
        System.out.println("通过members(K key)方法获取变量中的元素值:" + set);
        // 3、size(K key)
        //   获取变量中值的长度。
        long setLength = redisTemplate.opsForSet().size("setValue");
        System.out.println("通过size(K key)方法获取变量中元素值的长度:" + setLength);
        //  4、randomMember(K key)
        //   随机获取变量中的元素。
        Object randomMember = redisTemplate.opsForSet().randomMember("setValue");
        System.out.println("通过randomMember(K key)方法随机获取变量中的元素:" + randomMember);
        //randomMembers(K key, long count)
        //随机获取变量中指定个数的元素。
        List randomMembers = redisTemplate.opsForSet().randomMembers("setValue", 2);
        System.out.println("通过randomMembers(K key, long count)方法随机获取变量中指定个数的元素:" + randomMembers);
        //isMember(K key, Object o)
        //  检查给定的元素是否在变量中。
        boolean isMember = redisTemplate.opsForSet().isMember("setValue", "A");
        System.out.println("通过isMember(K key, Object o)方法检查给定的元素是否在变量中:" + isMember);
        //move(K key, V value, K destKey)
        //   转移变量的元素值到目的变量。
        boolean isMove = redisTemplate.opsForSet().move("setValue", "A", "destSetValue");
        if (isMove) {
            set = redisTemplate.opsForSet().members("setValue");
            System.out.print("通过move(K key, V value, K destKey)方法转移变量的元素值到目的变量后的剩余元素:" + set);
            set = redisTemplate.opsForSet().members("destSetValue");
            System.out.println(",目的变量中的元素值:" + set);
        }
        //   8、pop(K key)
        //   弹出变量中的元素。
        Object popValue = redisTemplate.opsForSet().pop("setValue");
        System.out.print("通过pop(K key)方法弹出变量中的元素:" + popValue);
        set = redisTemplate.opsForSet().members("setValue");
        System.out.println(",剩余元素:" + set);
        //   9、remove(K key, Object... values)
        //   批量移除变量中的元素。
        long removeCount = redisTemplate.opsForSet().remove("setValue", "E", "F", "G");
        System.out.print("通过remove(K key, Object... values)方法移除变量中的元素个数:" + removeCount);
        set = redisTemplate.opsForSet().members("setValue");
        System.out.println(",剩余元素:" + set);
        // 11、difference(K key, Collection<K> otherKeys)
        // 通过集合求差值。
        List list = new ArrayList();
        list.add("destSetValue");
        Set differenceSet = redisTemplate.opsForSet().difference("setValue", list);
        System.out.println("通过difference(K key, Collection<K> otherKeys)方法获取变量中与给定集合中变量不一样的值:" + differenceSet);

    }
}
