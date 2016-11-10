package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WheelRenderer {
	public SpriteBatch batch;
	private Floor floor;
	private Texture wheelImg;
	private Texture motorImg;
	private Texture manImg;
	private World world;
	private Wheel wheel;
	int n = 1;
	
	public WheelRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	wheelImg = new Texture("wheel.png");
    	motorImg = new Texture("motor.png");
    	manImg = new Texture("man.png");
    	wheel = world.getWheel();
	}
	
	public void render() {
		Vector2 posWheel = world.getWheel().getPosition();
        Vector2 rolWheel = world.getWheel().getRotation();
		batch.begin();
		batch.draw(wheelImg, 70, posWheel.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rolWheel.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);
		batch.draw(manImg, 73, posWheel.y+15, manImg.getWidth()/2, 10, manImg.getWidth(), manImg.getHeight(), 1, 1, rolWheel.x, 1, 1, manImg.getWidth(), manImg.getHeight(), false, false);
		batch.draw(motorImg, 64, posWheel.y+2);
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if(posWheel.x >= 92*(5*n-3) && posWheel.x <= 92*(5*n-2)) {
				posWheel.y--;
			}
			else if(posWheel.x >= 92*(5*n-1) && posWheel.x <= 92*(5*n)) {
				posWheel.y++;
			}
			if(posWheel.x >= 92*(5*n+2)-2) {
				n++;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			if(posWheel.x >= 92*(5*n-3) && posWheel.x <= 92*(5*n-2)) {
				posWheel.y++;
			}
			else if(posWheel.x >= 92*(5*n-1) && posWheel.x <= 92*(5*n)) {
				posWheel.y--;
			}
			if(posWheel.x <= 92*(5*n-3)) {
				n--;
			}
		}
		batch.end();
	}
}
