package com.github.java8.lambda.custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件读取工具类
 * @author assassin
 * @date 2017年12月12日
 */
public final class FileUtil {
	
	/**
	 * 读取文件
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static String read(File file, BufferedReaderProcessor processor){
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			line = processor.readLine(reader);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return line;
	}
	
	public static String read(File file){
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return line;
	}
}
