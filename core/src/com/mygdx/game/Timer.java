package com.mygdx.game;

public class Timer {
	private int time = 0;
	public int second = 15;
	GameScreen gameScreen;
	
	public Timer(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
	public void updateTime() {
		time += 1;
		secondMinus();
		if (gameScreen.getIfResetTime() == 1) {
			second = 15;
		}
	}
	
	public void secondMinus() {
		if (time % 100 == 0 && second != -1) {
			second -= 1;
		}
	}
	
	public int getSecond() {
		return second;
	}
	
	public int resetSecond() {
		second = 15;
		return second;
	}
}
