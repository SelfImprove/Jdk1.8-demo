package com.github.java8.stream.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.github.java8.stream.entity.Trader;
import com.github.java8.stream.entity.Transaction;

/**
 * 交易测试
 * @author assassin
 * @date 2017年12月13日
 */
public class TraderUtilTest {

	private static final List<Transaction> transList = new ArrayList<Transaction>();
	
	static {
		Trader t1 = new Trader("jack", "BeiJing");
		Trader t2 = new Trader("rose", "BeiJing");
		Trader t3 = new Trader("tony", "ShangHai");
		Trader t4 = new Trader("jackson", "ShenZhen");
		Trader t5 = new Trader("lily", "ShangHai");
		Trader t6 = new Trader("tom", "NanJing");
	
		transList.add(new Transaction(t1, 2010, 1000));
		transList.add(new Transaction(t2, 2015, 1000));
		transList.add(new Transaction(t3, 2010, 1000));
		transList.add(new Transaction(t4, 2011, 3000));
		transList.add(new Transaction(t5, 2012, 1000));
		transList.add(new Transaction(t6, 2010, 4000));
		transList.add(new Transaction(t4, 2017, 5000));
		transList.add(new Transaction(t3, 2015, 6000));
		transList.add(new Transaction(t5, 2011, 7000));
		transList.add(new Transaction(t2, 2010, 9000));
	}
	
	@Test
	public void testSelectTrans(){
		List<Transaction> results = TraderUtil.selectTrans(2010, transList);
		results.stream().forEach(t -> System.out.println(t));
	}
	
	@Test
	public void testSelectCities(){
		Set<String> expected = new HashSet<String>();
		expected.add("BeiJing");
		expected.add("ShangHai");
		expected.add("ShenZhen");
		expected.add("NanJing");
		
		Set<String> results = TraderUtil.selectCities(transList);
		Assert.assertEquals(expected, results);
	}
	
	@Test
	public void testSelectByCity(){
		List<Trader> results = TraderUtil.selectByCity("BeiJing", transList);
		results.stream().forEach(t -> System.out.println(t));
	}
	
	@Test
	public void testSelectTraderNames(){
		String traderNames = TraderUtil.selectTraderNames(transList);
		System.out.println(traderNames);
	}
	
	@Test
	public void testIsWorkingInCity(){
		boolean result = TraderUtil.isWorkingInCity("ShangHai", transList);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAccumValueByCity(){
		int result = TraderUtil.getAccumValueByCity("ShangHai", transList);
		int expect = 0;
		for (Transaction trans : transList){
			if (trans.getTrader().getCity().equals("ShangHai")){
				expect += trans.getValue();
			}
		}
		Assert.assertEquals(expect, result);
	}
	
	@Test
	public void testGetMaxValue(){
		int maxValue = TraderUtil.getMaxValue(transList);
		Assert.assertEquals(9000, maxValue);
	}
	
	@Test
	public void testGetMinValue(){
		int minValue = TraderUtil.getMinValue(transList);
		Assert.assertEquals(1000, minValue);
	}
}
