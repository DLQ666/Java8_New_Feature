package com.dlq.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1、举例：（o1,o2）-> Integer.conpare(o1,o2);
 * 2、格式：
 *
 */
public class LambdaTest02 {

    //语法格式一：无参，无返回值
    @Test
    public void test1() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("无参，无返回值");
            }
        };
        run1.run();

        System.out.println("***********************************************************");

        Runnable run2 = () -> {
            System.out.println("lambda无参，无返回值");
        };
        run2.run();
    }

    @Test
    public void test2() {
        //语法格式二：Lambda需要一个参数，但是没有返回值。
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("需要一个参数，但是没有返回值");

        System.out.println("***********************************************************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("Lambda需要一个参数，但是没有返回值");
    }

    @Test
    public void test3() {
        //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("数据类型可以省略，因为可由编译器推断得出，称为“类型推断”");

        System.out.println("***********************************************************");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("数据类型可以省略，因为可由编译器推断得出，称为“类型推断”");
    }
    @Test
    public void test4(){
        ArrayList<String> list = new ArrayList</*String*/>();//类型推断
        int[] arr = /*new int[]*/{1,2,3};//类型推断
    }

    @Test
    public void test5(){
        //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("Lambda若只需要一个参数时，参数的小括号可以省略");

        System.out.println("***********************************************************");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("Lambda若只需要一个参数时，参数的小括号可以省略");
    }

    @Test
    public void test6(){
        //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 21));

        System.out.println("***********************************************************");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 6));
    }

    @Test
    public void test7(){
        //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> com1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 6));

        System.out.println("***********************************************************");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12, 21));
    }

    @Test
    public void test8(){
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("Lambda若只需要一个参数时，参数的小括号可以省略");

        System.out.println("***********************************************************");

        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("当Lambda体只有一条语句时，return与大括号若有，都可以省略");
    }
}
