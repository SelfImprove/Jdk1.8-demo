package com.github.java8.stream.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) throws IOException {
		
		// 由值构建流
		Stream<String> stream1 = Stream.of("hello", "world", "!");
		
		// 由数组构建流
		int[] numbers = {1, 2, 3, 5};
		IntStream intStream = Arrays.stream(numbers);
		
		// 由文件构建流
		Stream<String> fileStream = Files.lines(Paths.get("test.dat"));
		
		//----------- 由函数构建流-----------------------------
		
		// 由Stream.iterate构建无限流
		Stream<Integer> iterateStream = Stream.iterate(0, a -> a + 2).limit(10);
		
		// 由Stream.generate构建无限流
		Stream<Double> generateStream = Stream.generate(Math::random).limit(10);
	}

}
