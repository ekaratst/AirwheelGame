package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Wheel {

	private Vector2 position;
	public static final int DIRECTION_LEFT = 1;
	public static final int DIRECTION_RIGHT = 2;
	int x = 95;
	int y = 90;
	 
	public Wheel(int x, int y) {
		position = new Vector2(x,y);
	}    
	 
	public Vector2 getPosition() {
		return position;    
	}
	
	public void roll(int dir) { 
        switch(dir) {
        case DIRECTION_RIGHT:
            position.x += 10;
            break;
        case DIRECTION_LEFT:
            position.x -= 10;
            break;
        }
    }
}
