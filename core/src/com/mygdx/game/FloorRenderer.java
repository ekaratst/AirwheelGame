package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class FloorRenderer {
	public SpriteBatch batch;
	private Floor floor;
	private Texture floorImg;
	private World world;
	private AirwheelGame airwheelGame;
	
	public FloorRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	//this.world = new World(airwheelGame);
    	floorImg = new Texture("floorimg.png");
	}
	
	public void render() {
		Vector2 rolFloor = world.getFloor().getRotation();
		batch.begin();
		batch.draw(floorImg, rolFloor.x, 0);
		System.out.println(rolFloor.x);
		batch.end();
		 
	 }
}
