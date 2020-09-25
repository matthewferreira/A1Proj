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
	private int maximumSpeed = 40;

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
	public int getMaximumSpeed() { return maximumSpeed; }
	public void setMaximumSpeed(int ms) { maximumSpeed = ms; }
	public int getLastNut() { return lastNutReached; }
	public void setLastNut(int ls) { lastNutReached = ls; }
	
	public void reduceEnergyLevel() { energyLevel -= energyConsumptionRate; }
	
	@Override
	public void move() {
		
		if(energyLevel > 0 && damageLevel < 5) {
			int head = super.getHeading() + steeringDirection;
			int deltaX = (int) (Math.cos(Math.toRadians(90 - head))*super.getSpeed());
			int deltaY = (int) (Math.sin(Math.toRadians(90 - head))*super.getSpeed());
			
			int newX = (int) (super.getLocation().getX() + deltaX);
			int newY = (int) (super.getLocation().getY() + deltaY);
			
			if(newX > 1000) {newX = 1000;}
			else if(newX < 0) {newX = 0;}
			if(newY > 1000) {newY = 1000;}
			else if(newY < 0) {newY = 0;}
			
			super.setLocation(newX, newY);
		}
		else if(energyLevel <= 0 || damageLevel >=5) {
			super.setSpeed(0);
		}
		
		
	}
	
	public void turnLeft() {
		steeringDirection -= 5;
		if(steeringDirection < -40) {steeringDirection = -40;}
		super.setHeading(super.getHeading()+steeringDirection);
	}
	
	public void turnRight() {
		steeringDirection += 5;
		if(steeringDirection > 40) {steeringDirection = 40;}
		super.setHeading(super.getHeading() + steeringDirection);
	}
	public void collide(GameObject g) {
		if(g instanceof Bird) {
			damageLevel += 1;
			//maximumSpeed = maximumSpeed*(damageLevel / 5);
		}
		if(g instanceof Squirrel) {
			damageLevel += 1;
		}
		if(g instanceof Nut) {
			Nut nut = (Nut)g;
			if(++lastNutReached == nut.getSeqNum()) {
				lastNutReached = nut.getSeqNum();
			}
		}
		
	}
	
	@Override
	public void setSpeed(int spd) {if(spd < maximumSpeed) { super.setSpeed(spd);} }
	
	
}
