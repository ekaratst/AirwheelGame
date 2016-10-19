package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {

	private Texture wheelImg;
	private AirwheelGame airwheelGame;
	public Texture backgroundImg;
	public SpriteBatch batch;

	public GameScreen(AirwheelGame airwheelGame) {
		this.airwheelGame = airwheelGame;
        wheelImg = new Texture("wheel.png");
        backgroundImg = new Texture("background.png");
        batch = new SpriteBatch();
    }

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(backgroundImg, 0, 0);
		batch.draw(wheelImg, 0, 90);
		batch.end();
	}
}
