package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Wheel {
	private Vector2 position;
	private Vector2 rotation;
	//private Vector2 poscheck;
	public static final int DIRECTION_LEFT = 1;
	public static final int DIRECTION_RIGHT = 2;
	public static final int DIRECTION_UP = 3;
	public static final int DIRECTION_DOWN = 4;
	 
	public Wheel(int x, int y) {
		position = new Vector2(x,y);
		rotation = new Vector2(x,y);
		//poscheck = new Vector2(x,y);
	}    
	 
	public Vector2 getPosition() {
		return position;    
	}
	/*
	public Vector2 getPoscheck() {
		return poscheck;    
	}
	*/
	public Vector2 getRotation() {
		return rotation;    
	}
	
	public void roll(int dir) { 
        switch (dir) {
        case DIRECTION_RIGHT:
            position.x += 2;
        	rotation.x -= 2;
            break;
        case DIRECTION_LEFT:
            position.x -= 2;
        	rotation.x += 2;
            break;
        }
    }
	
	public void move(int dir) { 
        switch (dir) {
        case DIRECTION_UP:
        	position.y += 1;
            break;
        case DIRECTION_DOWN:
        	position.y -= 1;
            break;
        }
    }
	
	public void updatefloor() {
		rotation.x -= 2;
	}
	/*
	public void moveCheck(int dir) { 
        switch (dir) {
        case DIRECTION_UP:
        	poscheck.y += 1;
            break;
        case DIRECTION_DOWN:
        	poscheck.y -= 1;
            break;
        case DIRECTION_RIGHT:
        	poscheck.x += 1;
            break;
        case DIRECTION_LEFT:
        	poscheck.x -= 1;
            break;
        }
    }
    */
}
