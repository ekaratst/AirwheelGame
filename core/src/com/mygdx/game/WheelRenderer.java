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
	int numberCheckPartOfFloorPosition = 1;
	
	public WheelRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	wheelImg = new Texture("wheel.png");
    	motorImg = new Texture("motor.png");
    	manImg = new Texture("man.png");
	}
	
	public void render() {
		batch.begin();
		drawWheel();
		drawManAndMotor();
		whenIsPressedRight();
		whenIsPressedLeft();
		batch.end();
	}
	public void whenIsPressedRight() {
		Vector2 posWheel = world.getWheel().getPosition();
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition-3) && posWheel.x <= 92*(5*numberCheckPartOfFloorPosition-2)) {
				posWheel.y--;
			} else if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition-1) && posWheel.x <= 92*(5*numberCheckPartOfFloorPosition)) {
				posWheel.y++;
			}
			if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition+2)-2) {
				numberCheckPartOfFloorPosition++;
			}
		}
	}
	public void whenIsPressedLeft() {
		Vector2 posWheel = world.getWheel().getPosition();
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition-3) && posWheel.x <= 92*(5*numberCheckPartOfFloorPosition-2)) {
				posWheel.y++;
			} else if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition-1) && posWheel.x <= 92*(5*numberCheckPartOfFloorPosition)) {
				posWheel.y--;
			}
			if (posWheel.x <= 92*(5*numberCheckPartOfFloorPosition-3)) {
				numberCheckPartOfFloorPosition--;
			}
		}
	}
	
	public void drawManAndMotor() {
		Vector2 posWheel = world.getWheel().getPosition();
		batch.draw(manImg, 73, posWheel.y+15);
		//batch.draw(manImg, 73, posWheel.y+15, manImg.getWidth()/2, 10, manImg.getWidth(), manImg.getHeight(), 1, 1, rolWheel.x, 1, 1, manImg.getWidth(), manImg.getHeight(), false, false);
		batch.draw(motorImg, 64, posWheel.y+2);
	}
	
	public void drawWheel() {
		Vector2 posWheel = world.getWheel().getPosition();
		Vector2 rolWheel = world.getWheel().getRotation();
		batch.draw(wheelImg, 70, posWheel.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rolWheel.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);
	}
	
}
