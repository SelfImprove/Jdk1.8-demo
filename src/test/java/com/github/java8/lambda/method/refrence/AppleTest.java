package com.github.java8.lambda.method.refrence;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.junit.Test;

import com.github.java8.lambda.entity.Apple;

/**
 * 方法引用测试
 * @author assassin
 * @date 2017年12月12日
 */
public class AppleTest {

	@Test
	public void testConstructor(){
		// 无参构造函数引用
		Supplier<Apple> appleSupplier = Apple::new;
		Apple apple = appleSupplier.get();
		System.out.println(apple);
	
		// 有参构造函数引用
		BiFunction<String, Integer, Apple> biFunction = Apple::new;
		apple = biFunction.apply("green", 10);
		System.out.println(apple);
	}
}
