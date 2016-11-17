package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Banana {
	int count = 0;
	Vector2 position;
	Random random = new Random();
	
	public Banana (int count) {
		position = new Vector2();
		count += random.nextInt(1000);
		position.x = (float) count;
		position.y = (float) 165;
		
		System.out.println(position.x);
		this.count = count;
	}	
	
	public Vector2 getPosition() {
		return position;
	}
	
	public int getCount() {
		return this.count;
	}
}
