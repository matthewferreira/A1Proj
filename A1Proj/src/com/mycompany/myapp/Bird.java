package com.mycompany.myapp;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Bird extends Movable{
	
	private static Random random = new Random();
	
	public Bird() {
		super(10 + random.nextInt(40), ColorUtil.BLUE);
		super.setHeading(random.nextInt(359));
		super.setSpeed(random.nextInt(10));
	}
	
	public void move() {
		int heading = super.getHeading() - 5 + random.nextInt(10);
		int speed = super.getSpeed();
		int deltaX = (int) (Math.cos(Math.toRadians(90 - heading))*speed);
		int deltaY = (int) (Math.sin(Math.toRadians(90 - heading))*speed);
		
		int newX = (int) (super.getLocation().getX() + deltaX);
		int newY = (int) (super.getLocation().getY() + deltaY);
		
		super.setLocation(newX, newY);
	}

	
}
