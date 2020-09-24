package com.mycompany.myapp;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Squirrel extends Movable implements ISteerable{
	
	private Random random = new Random();
	private int steeringDirection = 0;
	private int energyLevel = 100;
	private int energyConsumptionRate = 5;
	private int damageLevel = 0;
	private int lastNutReached = 1;

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
	
	public int getSteeringDirection() { return steeringDirection; }
	public void setSteeringDirection(int sd) { steeringDirection = sd; }
	public int getEnergyLevel() { return energyLevel; }
	public void setEnergyLevel(int el) { energyLevel = el; }
	public int getDamageLevel() { return damageLevel; }
	public void setDamageLevel(int dl) { damageLevel = dl; }
	
	/*
	public void turnLeft() {
		steeringDirection += 5;
		super.setHeading(super.getHeading()-steeringDirection);
	}
	public void turnRight() {
		if(steeringDirection <= 40) { super.setHeading(super.getHeading() + steeringDirection); }
	}
	*/
	
}
