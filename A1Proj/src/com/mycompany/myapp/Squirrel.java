package com.mycompany.myapp;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Squirrel extends Movable implements ISteerable{
	
	Random random = new Random();
	int steeringDirection = 0;
	int maximumSpeed;
	int energyLevel = 100;
	int energyConsumptionRate = 5;
	int damageLevel = 0;
	int lastNutReached = 1;

	public Squirrel() {
		super(40, ColorUtil.GRAY);
		super.setSpeed(5 + random.nextInt(5));
		super.setHeading(random.nextInt(359));
	}
	
	public Squirrel(float x, float y) {
		super(40, ColorUtil.GRAY, x, y);
		super.setSpeed(5);
		super.setHeading(0);
	}
	
	@Override
	public void setColor(int r, int g, int b) {}
	
	
	/*public void turnLeft() {
		super.setHeading(super.getHeading()-steeringDirection);
	}*/
	
}
