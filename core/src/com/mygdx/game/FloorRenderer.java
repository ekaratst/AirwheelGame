package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class FloorRenderer {
	public SpriteBatch batch;
	private Floor floor;
	private Texture upperFloorImg;
	private Texture normalFloorImg;
	private Texture lowerFloorImg;
	private World world;
	private AirwheelGame airwheelGame;
	
	public FloorRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	upperFloorImg = new Texture("upperFloor.png");
    	normalFloorImg = new Texture("normalFloor.png");
    	lowerFloorImg = new Texture("lowerFloor.png");
	}
	
	public void render() {
		Vector2 posFloor = world.getFloor().getPositionFloor();
		batch.begin();
		for (int numberOfFloor = 0; numberOfFloor < 1000; numberOfFloor++) {
			batch.draw(normalFloorImg, 92*numberOfFloor + posFloor.x, 0);
			/*
			numberOfFloor++;
			batch.draw(normalFloorImg, 92*numberOfFloor + posFloor.x, 0);
			numberOfFloor++;
			batch.draw(lowerFloorImg, 92*numberOfFloor + posFloor.x, 0);
			numberOfFloor++;
			batch.draw(normalFloorImg, 92*numberOfFloor + posFloor.x, -40);
			numberOfFloor++;
			batch.draw(upperFloorImg, 92*numberOfFloor + posFloor.x, 0);
			*/
		}
		batch.end();
	 }
}
