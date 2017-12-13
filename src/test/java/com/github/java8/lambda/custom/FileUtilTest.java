package com.github.java8.lambda.custom;

import java.io.BufferedReader;
import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 自定义函数式接口测试
 * @author assassin
 * @date 2017年12月12日
 */
public class FileUtilTest {
	
	/**
	 * 目标读取文件
	 */
	private File destFile;
	
	@Before
	public void init(){
		destFile = new File(this.getClass().getResource("/config.properties").getFile());
	}
	
	/**
	 * 读取文件第一行
	 */
	@Test
	public void testReadLine1(){
		String line_1 = FileUtil.read(destFile, (BufferedReader reader) -> reader.readLine());
		Assert.assertNotNull(line_1);
		System.out.println(line_1);
	}
	
	/**
	 * 读取文件前两行
	 */
	@Test
	public void testReadLine2(){
		String line_2 = FileUtil.read(destFile, (BufferedReader reader) -> reader.readLine() + "\n" + reader.readLine());
		Assert.assertNotNull(line_2);
		System.out.println(line_2);
	}
}
