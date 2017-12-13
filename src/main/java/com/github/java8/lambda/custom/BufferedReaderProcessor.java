package com.github.java8.lambda.custom;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 文件读取函数式接口.函数式接口中只能包含一个抽象函数
 * @author assassin
 * @date 2017年12月12日
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
	
	/**
	 * 读取函数
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	String readLine(BufferedReader reader) throws IOException;
	
}
