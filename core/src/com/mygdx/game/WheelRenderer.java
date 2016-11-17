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
	float a = 1;
	float velocityOfMan = -16;
	public int velocityOfWheel = 1;
	public float posMan = -10;
	
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
		batch.end();
	}
	
	public void drawManAndMotor() {
		Vector2 posWheel = world.getWheel().getPosition();
		Vector2 rolWheel = world.getWheel().getRotation();
		batch.draw(manImg, 73, posWheel.y+15, manImg.getWidth()/2, 10, manImg.getWidth(), manImg.getHeight(), 1, 1, velocityOfMan, 1, 1, manImg.getWidth(), manImg.getHeight(), false, false);
		normalStateOfMan();
		isPressed();
		updateVelocityOfMan();
		batch.draw(motorImg, 64, posWheel.y+2);
	}
	
	public void drawWheel() {
		Vector2 posWheel = world.getWheel().getPosition();
		Vector2 rolWheel = world.getWheel().getRotation();
		batch.draw(wheelImg, 70, posWheel.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rolWheel.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);	
	}
	
	public void updateVelocityOfMan() {
		if (posMan < 0) {
			velocityOfMan = -1 * (float) ((Math.sqrt(2*98*Math.abs(posMan))));;
		} else {
			velocityOfMan = (float) ((Math.sqrt(2*98*Math.abs(posMan))));
		}
	}
	
	public void normalStateOfMan() {
		if (posMan <= 0) {
			posMan -= 1 ;
		}
		else {
			posMan += 1 ;
		}
	}

	public float getPosMan() {
		return posMan;
	}
	
	public void isPressed() {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				posMan += 9;
			} else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				posMan -= 9;
			}
		} else {
			if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				posMan += 2;
			} else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				posMan -= 2;
			}
		}
	}
}
