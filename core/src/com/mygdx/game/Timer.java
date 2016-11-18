package com.mygdx.game;

public class Timer {
	private int time = 0;
	public int second = 30;
	
	public void updateTime() {
		time += 1;
		secondMinus();
		//System.out.println(second);
	}
	
	public void secondMinus() {
		if (time % 100 == 0 && second != 0) {
			second -= 1;
		}
	}
	
	public int getSecond() {
		return second;
	}
}
