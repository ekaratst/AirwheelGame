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
	private World world;
	private AirwheelGame airwheelGame;
	private Wheel wheel;
	int n=1;
	
	public WheelRenderer(SpriteBatch batch,Floor floor, World world) {
		this.floor = floor;
    	this.batch = batch;
    	this.world = world;
    	wheelImg = new Texture("wheel.png");
    	wheel = world.getWheel();
	}
	
	public void render() {
		Vector2 posWheel = world.getWheel().getPosition();
        Vector2 rolWheel = world.getWheel().getRotation();
		batch.begin();
		batch.draw(wheelImg, 70, posWheel.y, wheelImg.getWidth()/2, wheelImg.getHeight()/2, wheelImg.getWidth(), wheelImg.getHeight(), 1, 1, rolWheel.x, 1, 1, wheelImg.getWidth(), wheelImg.getHeight(), false, false);
		System.out.println("posWheel.x: "+posWheel.x);
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
		System.out.println("n: "+n);
		System.out.println("(n++)posWheel.x: "+posWheel.x +">="+(92*(5*n+2)-2));
		System.out.println("---------");
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
		System.out.println("(n--)posWheel.x: "+posWheel.x +">="+(92*(5*n-3)));
		batch.end();
	}
}
