package com.dlq.java1;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的        T   get()
    //Employee的空参构造器：   Employee()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println("我是原始方式编写："+sup.get());

        System.out.println("*************************************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println("我是Lambda表达式编写："+sup1.get());

        System.out.println("*************************************************");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println("我是构造器引用编写："+sup2.get());
    }

	//Function中的R apply(T t)
    @Test
    public void test2(){

	}

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){

	}

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){

	}
}
