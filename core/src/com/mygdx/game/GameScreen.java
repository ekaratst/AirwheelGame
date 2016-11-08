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
	private Floor floor;
	private World world;
	private WorldRenderer worldRenderer;

	public GameScreen(AirwheelGame airwheelGame) {
		this.airwheelGame = airwheelGame;
		world = new World(airwheelGame);
        wheel = world.getWheel();
        floor = world.getFloor();
        worldRenderer = new WorldRenderer(airwheelGame, world);
    }

	@Override
	public void render(float delta) {
		System.out.println("update");
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render(delta);
	}
	
	 private void update(float delta) {
	        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
	        	wheel.roll(Wheel.DIRECTION_LEFT);//หมุนซ้าย
	        	floor.roll(Floor.DIRECTION_LEFT);
	        }
	        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
	        	wheel.roll(Wheel.DIRECTION_RIGHT);//หมุนขวา
	        	System.out.println("GameScreenWheel");
	        	floor.roll(Floor.DIRECTION_RIGHT);
	        	System.out.println("GameScreenFloor");
	        }
	        if (Gdx.input.isKeyPressed(Keys.UP)) {
	        	wheel.move(Wheel.DIRECTION_UP);
	        }
	        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
	        	wheel.move(Wheel.DIRECTION_DOWN);
	        }
	    }
}
