package com.github.java8.stream.demo;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import com.github.java8.stream.entity.Trader;
import com.github.java8.stream.entity.Transaction;

/**
 * Stream使用
 * @author assassin
 * @date 2017年12月13日
 */
public class TraderUtil {

	/**
	 * 找出指定年份的所有交易并按照交易额排序 
	 */
	public static final List<Transaction> selectTrans(int year, List<Transaction> transList){
		return transList.stream()
				        .filter(t -> t.getYear() == year)
				        .sorted(comparing(Transaction::getValue))
				        .collect(toList());
	}
	
	/**
	 * 找出交易员所在的所有城市
	 */
	public static final Set<String> selectCities(List<Transaction> transList){
		return transList.stream()
				        .map(t -> t.getTrader().getCity())
				        .distinct()       // 下面输出的时候Set集合已经做了去重处理,因此这里省略
				        .collect(toSet());
	}
	
	/**
	 * 找出所有来自指定城市的交易员,并按照名字排序
	 */
	public static final List<Trader> selectByCity(String city, List<Transaction> transList){
		return transList.stream()
				        .map(trans -> trans.getTrader())
				        .filter(trader -> trader.getCity().equals(city))
				        .distinct()
				        .sorted(comparing(Trader::getName))
				        .collect(toList());
	}
	
	/**
	 * 找出所有交易员的姓名,按字母排序并拼接成字符串
	 */
	public static final String selectTraderNames(List<Transaction> transList){
		return transList.stream()
				        .map(trans -> trans.getTrader().getName())
				        .distinct()
				        .sorted()
				        .collect(joining(","));
	}
	
	/**
	 * 有没有在指定城市工作的交易员
	 */
	public static final boolean isWorkingInCity(String city, List<Transaction> transList){
		return transList.stream()
				        .anyMatch(t -> t.getTrader().getCity().equals(city));
	}
	
	/**
	 * 获取指定城市的交易总额
	 */
	public static final int getAccumValueByCity(String city, List<Transaction> transList){
		return transList.stream()
				        .filter(t -> t.getTrader().getCity().equals(city))
				        .map(t -> t.getValue())
				        .reduce(0, Integer::sum);
	}
	
	/**
	 * 找出所有交易中最高的交易额
	 */
	public static final int getMaxValue(List<Transaction> transList){
		return transList.stream()
				        .map(Transaction::getValue)
				        .reduce(Integer::max)
				        .orElse(-1);
	}
	
	/**
	 * 找出所有交易中最小的交易额
	 */
	public static final int getMinValue(List<Transaction> transList){
		return transList.stream()
		        		.map(Transaction::getValue)
		        		.reduce(Integer::min)
		        		.orElse(-1);
	}
}
