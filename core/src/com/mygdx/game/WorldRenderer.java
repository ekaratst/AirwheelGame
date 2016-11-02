package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private AirwheelGame airwheelGame;
	public SpriteBatch batch;
	private World world;
	private Texture wheelImg;
	public Texture backgroundImg;
	private Wheel wheel;

	public WorldRenderer(AirwheelGame airwheelGame, World world) {
		this.airwheelGame = airwheelGame;
		batch = this.airwheelGame.batch;
	    this.world = world;
	    backgroundImg = new Texture("background.png");
	    wheelImg = new Texture("wheel.png");
	    wheel = world.getWheel();
	}
	public void render(float delta) {
		SpriteBatch batch = airwheelGame.batch;
        Vector2 pos = world.getWheel().getPosition();
        Vector2 rol = world.getWheel().getRotation();
		batch.begin();
		batch.draw(backgroundImg, 0, 0);
		//batch.draw(wheelImg, pos.x, pos.y);		
		batch.draw(wheelImg, pos.x, pos.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rol.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);
		batch.end();
    }

}
