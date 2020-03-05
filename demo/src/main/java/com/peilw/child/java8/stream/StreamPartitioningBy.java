package com.peilw.child.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class StreamPartitioningBy {
    public static void main(String[] args){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        //分区
        /*分区是分组的特殊情况：由一个谓词（返回一个布尔值的函数）作为分类函数，它称分区函
        数。分区函数返回一个布尔值，这意味着得到的分组Map的键类型是Boolean，于是它最多可以
        分为两组——true是一组，false是一组。例如，如果你是素食者或是请了一位素食的朋友来共
        进晚餐，可能会想要把菜单按照素食和非素食分开：*/
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarianDishes =
                menu.stream().filter(Dish::isVegetarian).collect(toList());
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));
    }
}
