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
	public float posMM = 0;
	private BitmapFont font;
	private Texture startImg;
	private Texture airwheelImg;
	private Texture keyrightImg;
	private Texture keyleftImg;
	private Texture spacebarImg;
	boolean start = false;
	private Timer timer;

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
	    keyrightImg = new Texture("keyright.png");
	    keyleftImg = new Texture("keyleft.png");
	    spacebarImg = new Texture("spacebar.png");
	    timer = new Timer();
	}
	
	public void render(float delta) {		
			batch.begin();
			batch.draw(backgroundImg, 0, 0);
			if (!start) {
				batch.draw(startImg, 0, 0);
				batch.draw(airwheelImg, 250, 340);
				batch.draw(keyrightImg, 320, 110);
				batch.draw(keyleftImg, 200, 110);
				batch.draw(spacebarImg, 230, 50);
			}
			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				start = true;
			}
			batch.end();
			if (start) {
			floorRenderer.render();
			wheelRenderer.render();
			batch.begin();
			timer.updateTime();
			font.draw(batch, "Time: " + timer.getSecond(), 550, 450);
			font.draw(batch, "score: " + world.getScore(), 30, 450);
			font.draw(batch, "hightscore: " + world.getHightScore(), 30, 430);
			batch.end();
		}
    }
	
	public float getPosManFromWheelRenderer(){
		return wheelRenderer.getPosMan();
	}
}
