package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class World {
	 private Wheel wheel;
	 private Floor floor;
	 private AirwheelGame airwheelGame;
	 private WheelRenderer wheelRenderer;
	 List <Banana> bananas = new ArrayList<Banana> ();
	 int count = 0;
	 private int score;
	 private int hightscore = 0;
	 
	 World(AirwheelGame airwheelGame) {
	        this.airwheelGame = airwheelGame;
	        wheel = new Wheel(70,187);
	        floor = new Floor(0,0);
	        for (int i = 0 ; i < 100 ; i++) {
	        	Banana banana = new Banana(count);
	        	bananas.add(banana);
	        	count = banana.getCount();
	        }
	        score = 0;
	 }
	 
	 public void collectBanana() {
		 if ((!bananas.isEmpty()) && (bananas.get(0).position.x < 70)) {
			 bananas.remove(0);
			 increaseScore();
			 Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/collect.wav"));
			 sound.play(1.0f);
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
	 
	 public int getScore() {
		 return score;
	 }
	 
	 public void increaseScore() {
		 score += 1;
	 }
	 
	 public int getHightScore() {
		 if (score > hightscore) {
			 hightscore = score;
		 } 
		 return hightscore;
	 }
	 
	 public int resetScore() {
		 return score=0;
	 }
}
