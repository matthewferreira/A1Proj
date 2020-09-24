package com.mycompany.myapp;

import java.util.ArrayList;

public class GameWorld {
	private static int gameClock = 0;

	private Squirrel squirrel1;
	public void init() {
		ArrayList<GameObject> gameObjectList = new ArrayList<GameObject>();
		Nut nut1 = new Nut(50, 200);
		Nut nut2 = new Nut(200, 275);
		Nut nut3 = new Nut(500, 500);
		Nut nut4 = new Nut(750, 750);
		Bird bird1 = new Bird();
		Bird bird2 = new Bird();
		Tomato tomato1 = new Tomato();
		Tomato tomato2 = new Tomato();
		squirrel1 = new Squirrel(50, 200);
		
		gameObjectList.add(nut1);
		gameObjectList.add(nut2);
		gameObjectList.add(nut3);
		gameObjectList.add(nut4);
		gameObjectList.add(squirrel1);
		gameObjectList.add(bird1);
		gameObjectList.add(bird2);
		gameObjectList.add(tomato1);
		gameObjectList.add(tomato2);
		
		for(int i = 0; i < gameObjectList.size(); i++) {
			if(gameObjectList.get(i) instanceof Nut) {
				System.out.println("Nut " + (i + 1) + " size=" + gameObjectList.get(i).getSize() + " loc=" + gameObjectList.get(i).getLocation().getX() + ", " + gameObjectList.get(i).getLocation().getY() + " color=" + gameObjectList.get(i).getColor());
			}
			else if(gameObjectList.get(i) instanceof Bird) {
				System.out.println("Bird size=" + gameObjectList.get(i).getSize() + " loc=" + gameObjectList.get(i).getLocation().getX() + ", " + gameObjectList.get(i).getLocation().getY() + " color=" + gameObjectList.get(i).getColor());
				
			}
			else if(gameObjectList.get(i) instanceof Squirrel) {
				System.out.println("Squirrel size=" + gameObjectList.get(i).getSize() + " loc=" + gameObjectList.get(i).getLocation().getX() + ", " + gameObjectList.get(i).getLocation().getY() + " color=" + gameObjectList.get(i).getColor());
				
			}
			else if(gameObjectList.get(i) instanceof Tomato) {
				System.out.println("Tomato size=" + gameObjectList.get(i).getSize() + " loc=" + gameObjectList.get(i).getLocation().getX() + ", " + gameObjectList.get(i).getLocation().getY() + " color=" + gameObjectList.get(i).getColor());
				
			}
		}
		
		for(int i = 0; i < 1000; i++) {
			bird1.move();
			System.out.println("Bird1 loc=" + bird1.getLocation().getX() + ", " + bird1.getLocation().getY() + " head=" + bird1.getHeading() + " spd=" + bird1.getSpeed());
			
			/*bird2.move();
			System.out.println("Bird2 loc=" + bird2.getLocation().getX() + ", " + bird2.getLocation().getY() + " head=" + bird2.getHeading() + " spd=" + bird2.getSpeed()); */
		}
		
	}
	
	public void tick() {
		gameClock++;
		
		//if(squirrel1.getDamageLevel() > 0 && )
	}
	
	public void exit() {
		System.exit(0);
	}
	
}
