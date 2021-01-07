package com.dlq.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * Java内置的4大核心函数式接口
 *
 * 消费型接口：Consumer<T>    void accept(T t)
 * 供给型接口：Supplier<T>    T get()
 * 函数型接口：Function<T,R>  R apply(T t)
 * 断定型接口：Predicate<T>   boolean test(T t)
 *
 */
public class LambdaTest03 {

    @Test
    public void test1(){
        //消费型接口：Consumer<T>    void accept(T t)
        heppyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("我是原始的消费型实例对象，获得的money为："+aDouble);
            }
        });

        System.out.println("******************************************************************");

        heppyTime(400, money -> {
            System.out.println("我是Lambda表达式的消费型实例对象，获得的money为：" + money);
        });
    }
    public void heppyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println("我是原始写法："+filterString);

        System.out.println("**********************************************************");

        List<String> filterString1 =filterString(list,s ->  s.contains("京"));
        System.out.println("我是Lambda表达式写法："+filterString1);

    }
    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
