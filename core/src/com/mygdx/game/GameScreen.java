package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
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
	private WheelRenderer wheelRenderer;
	private Floor floor;
	private World world;
	private WorldRenderer worldRenderer;
	private boolean bool = true;
	private float checkPosMan = 0;
	private Texture playagainImg;
	private boolean checkSound = true;
	private Sound soundBackgroud = Gdx.audio.newSound(Gdx.files.internal("sounds/background.mp3"));
	private Sound soundCrash = Gdx.audio.newSound(Gdx.files.internal("sounds/crash.wav"));
	private Sound soundBoost = Gdx.audio.newSound(Gdx.files.internal("sounds/boost.mp3"));
	Banana banana;

	public GameScreen(AirwheelGame airwheelGame) {
		soundBackgroud.loop();
		this.airwheelGame = airwheelGame;
		world = new World(airwheelGame);
        wheel = world.getWheel();
        floor = world.getFloor();
        batch = airwheelGame.batch;
        worldRenderer = new WorldRenderer(airwheelGame, world);
        playagainImg = new Texture("playagain.png");
    }

	@Override
	public void render(float delta) {
		if (bool) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			worldRenderer.render(delta);
			checkPosMan = worldRenderer.getPosManFromWheelRenderer();
			update(delta);
		} 
		if (checkPosMan <= -60 || checkPosMan >= 60) {
			bool=false;
			if (checkSound) {
				soundCrash.play(1.0f);
				checkSound = false;
			}
			batch.begin();
			batch.draw(playagainImg, 185, 220);
			batch.end();
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				bool = true;
				worldRenderer.wheelRenderer.posMan = -2;
				world.resetScore();
			}
		}
	}
	
	 private void update(float delta) {
	        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
	        	wheel.roll(Wheel.DIRECTION_LEFT);//หมุนซ้าย
	        	floor.move(Floor.DIRECTION_LEFT);
	        }
	        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
	        	wheel.roll(Wheel.DIRECTION_RIGHT);//หมุนขวา
	        	floor.move(Floor.DIRECTION_RIGHT);
	        }
	        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
	        	floor.boost();
	        	soundBoost.play(1.0f);
	        }
	        updateBananaPosition();
	        floor.updatefloor();
		 	wheel.updatefloor();
		 	world.collectBanana();
	 }
	 
	 public void updateBananaPosition() {
		 for (Banana banana : this.world.bananas) {
			 banana.position.x = banana.position.z + world.getFloor().getPositionFloor().x;
		 }
	 }
}
