package com.mygdx.game;

import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class FloorRenderer {
	public SpriteBatch batch;
	private Floor floor;
	private Texture normalFloorImg;
	private Texture bananaImg;
	private World world;
	private AirwheelGame airwheelGame;
	List <Banana> bananas;

	public FloorRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	bananas = world.bananas;
    	normalFloorImg = new Texture("normalFloor.png");
    	bananaImg = new Texture("banana.png");
	}
	
	public void render() {
		Vector2 posFloor = world.getFloor().getPositionFloor();
		batch.begin();
		for (int numberOfFloor = 0; numberOfFloor < 1000; numberOfFloor++) {
			batch.draw(normalFloorImg, 92*numberOfFloor + posFloor.x, 0);
			bananaRenderer(posFloor);
		}
		batch.end();
	 }
	
	public void bananaRenderer (Vector2 posFloor) {
		for (Banana banana : this.bananas) {
			batch.draw(bananaImg, banana.position.x, 195);
		}
	}
}
