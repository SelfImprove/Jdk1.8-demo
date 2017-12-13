package com.github.java8.stream.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.java8.lambda.entity.Apple;

/**
 * 常用流操作
 * @author assassin
 * @date 2017年12月12日
 */
public class StreamOp {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9);
		// [0, 2, 4]
		System.out.println(select(list));
		
		List<Apple> appleList = Arrays.asList(new Apple("red", 10), new Apple("red", 11), new Apple("green", 11));
		System.out.println(map(appleList));
		
		List<String> wordList = Arrays.asList("Hello", "World");
		System.out.println(flatMap(wordList));
		
		System.out.println(anyMatch(list));
		
		System.out.println(allMatch(list));
		
		System.out.println(noneMatch(list));
		
		System.out.println(findAny(list));
		
		System.out.println(findFirst(list));
		
		System.out.println(sum(list));
		
		System.out.println(max(new ArrayList<Integer>()));
	}

	/**
	 * 筛选集合中前3个不同偶数 
	 */
	public static final List<Integer> select(List<Integer> list){
		return list.stream()
				   .filter(a -> a % 2 == 0)         //筛选偶数
				   .distinct()                      //去重
				   .limit(3)                        //截断流
				   .collect(Collectors.toList());   //以list集合方式输出结果
	}
	
	/**
	 * 筛选Apple集合中的所有颜色
	 */
	public static final List<String> map(List<Apple> appleList){
		return appleList.stream()
				        .map(Apple::getColor)
				        .collect(Collectors.toList());
	}
	
	/**
	 * 计算集合中所有单词包含的字母
	 */
	public static final List<String> flatMap(List<String> wordList){
		return wordList.stream()
				       .map(word -> word.split(""))   // 拆分,注意该map返回的是Stream<String[]>
				       .flatMap(Arrays::stream)       // 合并流
				       .distinct()
				       .collect(Collectors.toList());
	}
	
	/**
	 * 检查集合中是否至少有一个偶数
	 */
	public static final boolean anyMatch(List<Integer> list){
		return list.stream()
				   .anyMatch(a -> a % 2 == 0);
	}
	
	/**
	 * 检查集合中的元素是否都小于10
	 */
	public static final boolean allMatch(List<Integer> list){
		return list.stream()
				   .anyMatch(a -> a < 10);
	}
	
	/**
	 * 检查集合中的元素是否没有负数
	 */
	public static final boolean noneMatch(List<Integer> list){
		return list.stream()
				   .noneMatch(a -> a < 0);
	}
	
	/**
	 * 找出集合中任意一个大于5的数字,不存在则返回-1
	 */
	public static final int findAny(List<Integer> list){
		
		int result = -1;
		
		// 找出集合中任意一个大于5的数字
		Optional<Integer> optional = list.stream()
										 .filter(a -> a > 5)
										 .findAny();
		// 检查是否存在元素
		if (optional.isPresent()){
			// 存在,获取元素值
			result = optional.get();
		}
		
		return result;
	}
	
	/**
	 * 找出集合中第一个大于5的数字,不存在则返回-1
	 */
	public static final int findFirst(List<Integer> list){
		
		int result = -1;
		
		// 找出集合中第一个大于5的数字
		Optional<Integer> optional = list.stream()
										 .filter(a -> a > 5)
										 .findFirst();
		// 检查是否存在元素
		if (optional.isPresent()){
			// 存在,获取元素值
			result = optional.get();
		}
		
		return result;
	}
	
	/**
	 * 计算集合中所有偶数元素的和
	 */
	public static final int sum(List<Integer> list){
		// 1. 写法1
		/*int result = list.stream()
				         .filter(a -> a % 2 == 0)
				         .reduce(0, (a, b) -> a + b);*/
		// 2. 写法2
		int result = list.stream()
				     .filter(a -> a % 2 == 0)
				     .reduce(0, Integer::sum);   // 0是初始值
		return result;
	}
	
	/**
	 * 计算集合中所有元素的最大值
	 */
	public static final int max(List<Integer> list){
		int result = list.stream()
				         .reduce(Integer::max)
				         .orElse(-1);     // 如果不存在则返回默认值: -1
		return result;
	}
	
}
