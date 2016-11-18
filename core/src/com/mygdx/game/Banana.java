package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Banana {
	int count = 0;
	Vector3 position;
	Random random = new Random();
	
	public Banana(int count) {
		position = new Vector3();
		count += random.nextInt(1000);
		position.x = (float) count;
		position.y = (float) 165;
		position.z = position.x;
		this.count = count;
	}	
	
	public Vector3 getPosition() {
		return position;
	}
	
	public int getCount() {
		return this.count;
	}
}
