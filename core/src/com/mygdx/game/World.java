package com.mygdx.game;

public class World {
	 private Wheel wheel;
	 private Floor floor;
	 private AirwheelGame airwheelGame;
	 World(AirwheelGame airwheelGame) {
	        this.airwheelGame = airwheelGame;
	        wheel = new Wheel(70,74);
	        floor = new Floor(0,0);
	 }
	 
	 Wheel getWheel() {
	        return wheel;
	 }
	 
	 Floor getFloor() {
	        return floor;
	 }
}
