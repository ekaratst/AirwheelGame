package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private AirwheelGame airwheelGame;
	public SpriteBatch batch;
	private World world;
	private Texture wheelImg;
	private Texture floorImg;
	public Texture backgroundImg;
	private Wheel wheel;
	//private Floor floor;

	public WorldRenderer(AirwheelGame airwheelGame, World world) {
		this.airwheelGame = airwheelGame;
		batch = this.airwheelGame.batch;
	    this.world = world;
	    backgroundImg = new Texture("background.png");
	    wheelImg = new Texture("wheel.png");
	    floorImg = new Texture("floorimg.png");
	    wheel = world.getWheel();
	}
	public void render(float delta) {
		SpriteBatch batch = airwheelGame.batch;
        Vector2 pos = world.getWheel().getPosition();
        Vector2 rolWheel = world.getWheel().getRotation();
        Vector2 rolFloor = world.getFloor().getRotation();
		batch.begin();
		batch.draw(backgroundImg, 0, 0);
		batch.draw(floorImg, rolFloor.x, 0);
		//System.out.println(rolFloor.x);
		//batch.draw(wheelImg, pos.x, pos.y);	
		//System.out.println(pos.x);
		batch.draw(wheelImg, pos.x, pos.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rolWheel.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);
		//System.out.println(rolWheel.x);
		batch.end();
    }

}
