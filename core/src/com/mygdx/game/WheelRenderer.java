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
	//public Texture checkImg;
	float posMan = -5;
	
	public WheelRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	wheelImg = new Texture("wheel.png");
    	motorImg = new Texture("motor.png");
    	manImg = new Texture("man.png");
    	//checkImg = new Texture("check.png");
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
		//System.out.println("posWheel.x: "+ posWheel.x+ "< "+ 92*(5*numberCheckPartOfFloorPosition-3));
		//if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition-3) && posWheel.x <= 92*(5*numberCheckPartOfFloorPosition-2)) {
				posWheel.y -=2;
			} else if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition-1) && posWheel.x <= 92*(5*numberCheckPartOfFloorPosition)) {
				posWheel.y +=2;
			}
			if (posWheel.x >= 92*(5*numberCheckPartOfFloorPosition+2)-2) {
				numberCheckPartOfFloorPosition++;
			}
			System.out.println("numberCheckPartOfFloorPosition: "+numberCheckPartOfFloorPosition);
			System.out.println("posWheel.x: "+ posWheel.x+ "< "+ (92*(5*numberCheckPartOfFloorPosition-3)));
		//}
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
		Vector2 rolWheel = world.getWheel().getRotation();
		//batch.draw(manImg, 73, posWheel.y+15);
		batch.draw(manImg, 73, posWheel.y+15, manImg.getWidth()/2, 10, manImg.getWidth(), manImg.getHeight(), 1, 1, velocityOfMan, 1, 1, manImg.getWidth(), manImg.getHeight(), false, false);		
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			posMan++;
		else {
			posMan--;
		}
		updateVelocityOfMan();
		System.out.println("rolWheel.y: "+ rolWheel.y);
		batch.draw(motorImg, 64, posWheel.y+2);
	}
	
	public void drawWheel() {
		Vector2 posWheel = world.getWheel().getPosition();
		//Vector2 posCheck = world.getWheel().getPoscheck();
		Vector2 rolWheel = world.getWheel().getRotation();
		batch.draw(wheelImg, 70, posWheel.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rolWheel.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);
		//batch.draw(checkImg, posCheck.x, posCheck.y);
		//System.out.println("posCheck.x: "+ posCheck.x+"|| posCheck.y: "+posCheck.y);
	}
	
	public void updateVelocityOfMan() {
		System.out.println("posMan: "+ posMan);
		if (posMan < 0) {
			velocityOfMan = -1 * (float) ((Math.sqrt(2*98*Math.abs(posMan))));;
		} else {
			velocityOfMan = (float) ((Math.sqrt(2*98*Math.abs(posMan))));
		}
		System.out.println("velocityOfMan: "+ velocityOfMan);
	}
}
