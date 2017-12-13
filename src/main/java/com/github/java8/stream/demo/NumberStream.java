package com.github.java8.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 数值流
 * @author assassin
 * @date 2017年12月13日
 */
public class NumberStream {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// 使用数值流计算
		int sum = list.stream()
					  .mapToInt(a -> a)
					  .sum();
		
		int max = list.stream()
					  .mapToInt(a -> a)
					  .max()
					  .orElse(-1);
		
		int min = list.stream()
				  	  .mapToInt(a -> a)
				  	  .min()
				  	  .orElse(-1);
		
		System.out.println("sum: " + sum);
		System.out.println("max: " + max);
		System.out.println("min: " + min);
		
		// 通过IntStream.rangeClosed生成范围在0-10之间的数值流
		int[] evenNumbers = IntStream.rangeClosed(0, 10).filter(n -> n % 2 == 0).toArray();
		System.out.println("0-10 偶数: " + Arrays.toString(evenNumbers));
	}
}
