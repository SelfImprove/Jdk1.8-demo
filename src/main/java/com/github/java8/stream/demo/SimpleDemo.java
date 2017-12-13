package com.github.java8.stream.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * stream操作入门示例
 * @author assassin
 * @date 2017年12月12日
 */
public class SimpleDemo {

	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>();
		// 生成0-9999999个数字
		long numberCount = 10000000;
		for (long i = 0; i < numberCount; i++){
			list.add(i);
		}
		
		// 单线程查询
		long start = System.currentTimeMillis();
		long count = count(list);
		System.out.println("count:" + count + ", time: " + (System.currentTimeMillis() - start));
	
		start = System.currentTimeMillis();
		count = countParallel(list);
		System.out.println("countParallel:" + count + ", time: " + (System.currentTimeMillis() - start));
	}

	/**
	 * 查询集合中的所有以0结尾的数字个数
	 */
	public static long count(List<Long> list){
		return list.stream().filter(a -> a % 2 == 0).count();
	}
	
	/**
	 * 并行查询集合中的所有以0结尾的数字个数
	 */
	public static long countParallel(List<Long> list){
		return list.parallelStream().filter(a -> a % 2 == 0).count();
	}
}
