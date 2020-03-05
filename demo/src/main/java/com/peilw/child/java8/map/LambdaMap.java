package com.peilw.child.java8.map;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaMap {
    private Map<String, Object> map = Maps.newHashMap();

    @Before
    public void initData() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key5", 'h');
    }


    /**
     * 遍历Map的方式一
     * 通过Map.keySet遍历key和value
     */
    @Test
    public void testErgodicWayOne() {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (String key : map.keySet()) {
            System.out.println("map.get(" + key + ") = " + map.get(key));
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));
    }

    /**
     * 遍历Map第二种
     * 通过Map.entrySet使用Iterator遍历key和value
     */
    @Test
    public void testErgodicWayTwo() {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().iterator().forEachRemaining(item -> System.out.println("key:value=" + item.getKey() + ":" + item.getValue()));
    }

    /**
     * 遍历Map第三种
     * 通过Map.entrySet遍历key和value，在大容量时推荐使用
     */
    @Test
    public void testErgodicWayThree() {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));
    }

    /**
     * 遍历Map第四种
     * 通过Map.values()遍历所有的value，但不能遍历key
     */
    @Test
    public void testErgodicWayFour() {
        System.out.println("---------------------Before JAVA8 ------------------------------");
        for (Object value : map.values()) {
            System.out.println("map.value = " + value);
        }
        System.out.println("---------------------JAVA8 ------------------------------");
        map.values().forEach(System.out::println); // 等价于map.values().forEach(value -> System.out.println(value));
    }

    /**
     * 遍历Map第五种
     * 通过k,v遍历，Java8独有的
     */
    @Test
    public void testErgodicWayFive() {
        System.out.println("---------------------Only JAVA8 ------------------------------");
        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
    }

    /**
     * java8 map新方法
     */
    @Test
    public void testMap() {
        String ret;
        Map<String, String> map = Maps.newHashMap();
        ret = map.putIfAbsent("a", "aaa");//ret 为"aaa", map 为 {"a":"aaa"}
        ret = map.putIfAbsent("a", "bbb");//ret 为 "aaa", map 还是 {"a":"aaa"}
        map.put("b", null);
        ret = map.putIfAbsent("b", "bbb");//ret 为 "bbb", map 为 {"a":"aaa","b":"bbb"}
        //Map.Entry comparingByKey 和  comparingByValue 方法
        //另外介绍一下 Map.Entry 新加的两个排序方法，它们分别有无参与带 Comparator 参数可嵌套使用的两个版本
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(String::compareTo)).collect(Collectors.toList());
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(String::compareTo)).collect(Collectors.toList());

    }
}
