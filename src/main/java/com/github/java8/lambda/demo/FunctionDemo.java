package com.github.java8.lambda.demo;

import java.util.function.Function;

/**
 * 函数复合
 * @author assassin
 * @date 2017年12月12日
 */
public class FunctionDemo {

	public static void main(String[] args) {
		// 函数f(x)
		Function<Integer, Integer> f = x -> x + 1;
		
		// 函数g(x)
		Function<Integer, Integer> g = x -> x * 2;
		
		// f(g(x))
		Function<Integer, Integer> composeFunction = f.compose(g);
		
		// g(f(x))
		Function<Integer, Integer> andThenFunction = f.andThen(g);
		
		// g(1) -> f(2)  => 3
		System.out.println(composeFunction.apply(1));
		
		// f(1) -> g(2)  => 4
		System.out.println(andThenFunction.apply(1));
	}

}
