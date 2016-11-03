package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Floor {
	private Vector2 rotation;
	public static final int DIRECTION_LEFT = 1;
	public static final int DIRECTION_RIGHT = 2;
	int x = 0;
	int y = 0;
	 
	public Floor(int x, int y) {
		rotation = new Vector2(x,y);
	}    
	 
	public Vector2 getRotation() {
		return rotation;    
	}
	
	public void roll(int dir) { 
        switch(dir) {
        case DIRECTION_RIGHT:
            //position.x += 10;
        	rotation.x -= 2;
            break;
        case DIRECTION_LEFT:
            //position.x -= 10;
        	rotation.x += 2;
            break;
        }
	}

}
