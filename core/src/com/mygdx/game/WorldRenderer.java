package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
	public WheelRenderer wheelRenderer;
	private Floor floor;
	public float posMM=0;
	private BitmapFont font;
	private Texture startImg;
	private Texture airwheelImg;
	boolean start = false;

	public WorldRenderer(AirwheelGame airwheelGame, World world) {
		this.airwheelGame = airwheelGame;
		batch = this.airwheelGame.batch;
	    this.world = world;
	    this.floorRenderer = new FloorRenderer(batch, floor, world);
	    this.wheelRenderer = new WheelRenderer(batch, floor, world);
	    backgroundImg = new Texture("background.png");
	    font = new BitmapFont();
	    startImg = new Texture("startall.png"); 
	    airwheelImg = new Texture("airwheel.png"); 
	}
	
	public void render(float delta) {		
			batch.begin();
			batch.draw(backgroundImg, 0, 0);
			if (!start) {
				batch.draw(startImg, 0, 0);
				batch.draw(airwheelImg, 250, 340);
			}
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				start = true;
			}
			batch.end();
			if (start) {
			floorRenderer.render();
			wheelRenderer.render();
			batch.begin();
			font.draw(batch, "score: " + world.getScore(), 30, 450);
			font.draw(batch, "hightscore: " + world.getHightScore(), 30, 430);
			batch.end();
		}
    }
	
	public float getPosManFromWheelRenderer(){
		return wheelRenderer.getPosMan();
	}

}
