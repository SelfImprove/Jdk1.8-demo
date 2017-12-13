package com.github.java8.lambda.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.github.java8.lambda.entity.Apple;

/**
 * 谓词复合用法
 * @author assassin
 * @date 2017年12月12日
 */
public class PredicateDemo {

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("red", 10));
		appleList.add(new Apple("red", 20));
		appleList.add(new Apple("red", 15));
		appleList.add(new Apple("green", 15));
		appleList.add(new Apple("green", 10));
		appleList.add(new Apple("red", 5));
		
		// 谓词复合找出颜色为红色并且重量大于10的苹果集合
		Predicate<Apple> predicateColor = (Apple a) -> a.getColor().equals("red");
		appleList.stream()
				 .filter(predicateColor.and((Apple a) -> a.getWeight() > 10))
				 .forEach(a -> System.out.println(a));
		
		System.out.println("------------------");
		
		// 找出颜色为红色并且重量大于10或小于10的苹果集合
		Predicate<Apple> predicateWeight = (Apple a) -> a.getWeight() > 10;
		appleList.stream()
				 .filter(predicateColor.and(predicateWeight.or((Apple a) -> a.getWeight() < 10)))
				 .forEach(a -> System.out.println(a));
	}

}
