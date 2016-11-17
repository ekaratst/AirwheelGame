package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class World {
	 private Wheel wheel;
	 private Floor floor;
	 private AirwheelGame airwheelGame;
	 private WheelRenderer wheelRenderer;
	 List <Banana> bananas = new ArrayList<Banana> ();
	 int count = 0;
	 
	 World(AirwheelGame airwheelGame) {
	        this.airwheelGame = airwheelGame;
	        wheel = new Wheel(70,187);
	        floor = new Floor(0,0);
	        for (int i = 0 ; i < 100 ; i++) {
	        	Banana banana = new Banana(count);
	        	bananas.add(banana);
	        	count = banana.getCount();
	        }
	 }
	 
	 Wheel getWheel() {
		 return wheel;
	 }
	 
	 Floor getFloor() {
		 return floor;
	 }
	 
	 WheelRenderer getWheelRenderer() {
		 return wheelRenderer;
	 }
}
