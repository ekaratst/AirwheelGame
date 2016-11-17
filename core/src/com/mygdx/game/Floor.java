package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Floor {
	private Vector2 positionFloor;
	public static final int DIRECTION_LEFT = 1;
	public static final int DIRECTION_RIGHT = 2;
	public static final int DIRECTION_UP = 3;
	public static final int DIRECTION_DOWN = 4;
	 
	public Floor(int x, int y) {
		positionFloor = new Vector2(x,y);
	}    
	 
	public Vector2 getPositionFloor() {
		return positionFloor;    
	}
	
	public void move(int dir) { 
        switch(dir) {
        case DIRECTION_RIGHT:
        	positionFloor.x -= 2;
            break;
        case DIRECTION_LEFT:
        	positionFloor.x += 3;
            break;
        case DIRECTION_UP:
        	positionFloor.y += 1;
            break;
        case DIRECTION_DOWN:
        	positionFloor.y -= 1;
            break;
        }
	}
	
	public void updatefloor() {
		positionFloor.x -= 1;
	}
	
	public void boost() {
		positionFloor.x -= 3;
	}
}
