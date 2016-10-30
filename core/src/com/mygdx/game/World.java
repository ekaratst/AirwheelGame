package com.mygdx.game;

public class World {
	 private Wheel wheel;
	 private AirwheelGame airwheelGame;
	 World(AirwheelGame airwheelGame) {
	        this.airwheelGame = airwheelGame;
	 
	        wheel = new Wheel(95,90);
	    }
	 
	 Wheel getWheel() {
	        return wheel;
	    }
}
