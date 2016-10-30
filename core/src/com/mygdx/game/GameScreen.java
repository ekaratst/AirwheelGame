package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {

	private Texture wheelImg;
	private AirwheelGame airwheelGame;
	public Texture backgroundImg;
	public SpriteBatch batch;
	private Wheel wheel;
	private World world;

	public GameScreen(AirwheelGame airwheelGame) {
		this.airwheelGame = airwheelGame;
		//world = new World(airwheelGame);
        wheelImg = new Texture("wheel.png");
        backgroundImg = new Texture("background.png");
        world = new World(airwheelGame);
        wheel = world.getWheel();
       // wheel = new Wheel(95,90);
        batch = new SpriteBatch();
    }

	@Override
	public void render (float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		Vector2 pos = wheel.getPosition();
		batch.draw(backgroundImg, 0, 0);
		batch.draw(wheelImg, pos.x, pos.y);
		batch.end();
	}
	
	 private void update(float delta) {
	        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
	        	wheel.roll(Wheel.DIRECTION_LEFT);//หมุนซ้าย
	        }
	        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	        	wheel.roll(Wheel.DIRECTION_RIGHT);//หมุนขวา
	        }
	    }
}
