package com.github.java8.lambda.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.github.java8.lambda.entity.Apple;

/**
 * 使用lambda表达式对apple进行排序
 * @author assassin
 * @date 2017年12月12日
 */
public class AppleSorted {

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();
		appleList.add(new Apple("red", 10));
		appleList.add(new Apple("red", 20));
		appleList.add(new Apple("green", 15));
		appleList.add(new Apple("green", 10));
		
		System.out.println("before sort:");
		// 打印集合
		printList(appleList);
		
		// 排序方式1
		// sort_1(appleList);
		
		// 排序方式3
		// sort_3(appleList);
		
		// sort_4(appleList);
		
		sort_5(appleList);
		
		System.out.println("after sort:");
		// 打印集合
		printList(appleList);
	}
	
	/**
	 * 写法1,使用Comparator接口函数
	 */
	public static final void sort_1(List<Apple> appleList){
		appleList.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());
	}
	
	/**
	 * 写法2,省略参数类型
	 */
	public static final void sort_2(List<Apple> appleList){
		appleList.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
	}
	
	/**
	 * 写法3,使用Comparator.comparing()静态方法,返回一个Comparator实例
	 */
	public static final void sort_3(List<Apple> appleList){
		Comparator<Apple> comparator = Comparator.comparing((Apple a) -> a.getWeight());
		appleList.sort(comparator);
	}
	
	/**
	 * 写法4,使用Comparator.comparing()静态方法,结合方法引用
	 */
	public static final void sort_4(List<Apple> appleList){
		appleList.sort(Comparator.comparing(Apple::getWeight));
	}
	
	/**
	 * Comparator复合使用,使用Comparator.comparing()静态方法,结合方法引用
	 */
	public static final void sort_5(List<Apple> appleList){
		// 先根据重量weight倒叙排列,再根据颜色排序
		appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
	}
	
	public static final <T> void printList(List<T> list){
		list.stream().forEach(t -> System.out.println(t));
	}
}
