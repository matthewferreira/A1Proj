package com.mycompany.myapp;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
	private static int gameClock = 0;
	private Random random = new Random();
	private ArrayList<GameObject> gameObjectList;
	private int livesRemaining = 3;
	
	private Squirrel player;
	public void init() {
		gameObjectList = new ArrayList<GameObject>();
		Nut nut1 = new Nut(50, 200);
		Nut nut2 = new Nut(200, 275);
		Nut nut3 = new Nut(500, 500);
		Nut nut4 = new Nut(750, 750);
		Bird bird1 = new Bird();
		Bird bird2 = new Bird();
		Tomato tomato1 = new Tomato();
		Tomato tomato2 = new Tomato();
		player = new Squirrel(50, 200);
		
		gameObjectList.add(nut1);
		gameObjectList.add(nut2);
		gameObjectList.add(nut3);
		gameObjectList.add(nut4);
		gameObjectList.add(player);
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
		
	}
	
	public void tick() {
		
		moveAll(gameObjectList);
		reduceEnergy(player);
		System.out.println("Player loc=" + player.getLocation().getX() + "," + player.getLocation().getY() + " steerDirection=" + player.getSteeringDirection() + " speed=" + player.getSpeed() + " head=" + player.getHeading() + " energyLevel=" + player.getEnergyLevel() + " lastNut=" + player.getLastNut());
		gameClock++;
		System.out.println("gameClock increase to " + gameClock);
	}
	
	public void reduceEnergy(Squirrel s) {
		s.reduceEnergyLevel();
	}
	
	public void moveAll(ArrayList<GameObject> go) {
		for(int i = 0; i < go.size(); i++) {
			if(go.get(i) instanceof Movable) {
				Movable mObj = (Movable)go.get(i);
				mObj.move();
			}
		}
	}
	
	public Squirrel getPlayer() {
		return player;
	}
	public void exit() {
		System.exit(0);
	}
	
}
