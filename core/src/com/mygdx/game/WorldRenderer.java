package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private AirwheelGame airwheelGame;
	public SpriteBatch batch;
	private World world;
	public Texture backgroundImg;
	private FloorRenderer floorRenderer;
	private WheelRenderer wheelRenderer;
	private Floor floor;
	public float posMM=0;
	private BitmapFont font;

	public WorldRenderer(AirwheelGame airwheelGame, World world) {
		this.airwheelGame = airwheelGame;
		batch = this.airwheelGame.batch;
	    this.world = world;
	    this.floorRenderer = new FloorRenderer(batch, floor, world);
	    this.wheelRenderer = new WheelRenderer(batch, floor, world);
	    backgroundImg = new Texture("background.png");
	    font = new BitmapFont();
	}
	
	public void render(float delta) {
		
		
		batch.begin();
		batch.draw(backgroundImg, 0, 0);
		batch.end();
		floorRenderer.render();
		wheelRenderer.render();
		batch.begin();

		font.draw(batch, "" + world.getScore(), 50, 450);
		batch.end();
		
    }
	
	public float getPosManFromWheelRenderer(){
		return wheelRenderer.getPosMan();
	}

}
