package com.github.java8.lambda.entity;

/**
 * apple
 * @author assassin
 * @date 2017年12月12日
 */
public class Apple {

	private final String color;
	private final int weight;
	
	public Apple(){
		this(null, 0);
	}
	
	public Apple(String color, int weight){
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
}
