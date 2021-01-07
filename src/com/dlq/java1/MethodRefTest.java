package com.dlq.java1;


import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1、使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的		void accept(T t)
	//PrintStream中的	void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("北京");

		System.out.println("******************************************");

		PrintStream ps = System.out;
		Consumer<String> con2 = ps :: println;
		con2.accept("上海");
	}
	
	//Supplier中的	T get()
	//Employee中的	String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001,"Tom",23,6000);
		Supplier<String> sup1 = () -> emp.getName();
		System.out.println(sup1.get());

		System.out.println("******************************************");

		Supplier<String> sup2 = emp :: getName;
		System.out.println(sup2.get());
		
	}

	// 情况二：类 :: 静态方法
	//Comparator中的	int compare(T t1,T t2)
	//Integer中的		int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
		System.out.println(com1.compare(12, 21));

		System.out.println("******************************************");

		Comparator<Integer> com2 = Integer :: compare;
		System.out.println(com2.compare(12,6));

	}
	
	//Function中的	R apply(T t)
	//Math中的		Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> func = new Function<Double, Long>() {
			@Override
			public Long apply(Double d) {
				return Math.round(d);
			}
		};

		System.out.println("******************************************");

		Function<Double,Long> func1 = d -> Math.round(d);
		System.out.println(func1.apply(12.3));

		System.out.println("******************************************");

		Function<Double,Long> func2 = Math::round;
		System.out.println(func1.apply(12.3));

	}

	// 情况三：类 :: 实例方法 (有难度)
	// Comparator中的	int comapre(T t1,T t2)
	// String中的		int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		};
		System.out.println(com.compare("abc", "abd"));
		System.out.println("******************************************");

		Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
		System.out.println(com1.compare("abc", "abd"));

		System.out.println("******************************************");

		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("abd", "abd"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> pre = new BiPredicate<String, String>() {
			@Override
			public boolean test(String t1, String t2) {
				return t1.equals(t2);
			}
		};
		System.out.println(pre.test("add", "add"));
		System.out.println("******************************************");

		BiPredicate<String,String> pre1 = (t1,t2) -> t1.equals(t2);
		System.out.println(pre1.test("add", "add"));

		System.out.println("******************************************");

		BiPredicate<String,String> pre2 = String :: equals;
		System.out.println(pre2.test("asd", "add"));
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee emp = new Employee(1001,"Lucy",11,4000);
		Function<Employee,String> fun = new Function<Employee, String>() {
			@Override
			public String apply(Employee emp) {
				return emp.getName();
			}
		};
		System.out.println(fun.apply(emp));

		System.out.println("******************************************");

		Function<Employee,String> fun1 = e -> e.getName();
		System.out.println(fun1.apply(emp));

		System.out.println("******************************************");

		Function<Employee,String> fun2 = Employee::getName;
		System.out.println(fun2.apply(emp));
	}

}
