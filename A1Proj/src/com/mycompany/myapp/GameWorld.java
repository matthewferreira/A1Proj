package com.mycompany.myapp;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
	private static int gameClock = 0;
	private Random random = new Random();
	private ArrayList<GameObject> gameObjectList;
	private int livesRemaining = 3;
	private Squirrel player;
	private Nut nut1;
	private Nut nut2;
	private Nut nut3;
	private Nut nut4;
	private Bird bird1;
	private Bird bird2;
	private Tomato tomato1;
	private Tomato tomato2;
	
	public void init() {
		gameObjectList = new ArrayList<GameObject>();
		nut1 = new Nut(50, 200);
		nut2 = new Nut(200, 275);
		nut3 = new Nut(500, 500);
		nut4 = new Nut(750, 750);
		bird1 = new Bird();
		bird2 = new Bird();
		tomato1 = new Tomato();
		tomato2 = new Tomato();
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
	}
	
	public void tick() {
		moveAll(gameObjectList);
		getPlayer().reduceEnergyLevel();
		System.out.println("Player loc=" + player.getLocation().getX() + "," + player.getLocation().getY() + " steerDirection=" + player.getSteeringDirection() + " speed=" + player.getSpeed() + " head=" + player.getHeading() + " energyLevel=" + player.getEnergyLevel() + " lastNut=" + player.getLastNut());
		gameClock++;
		System.out.println("gameClock increase to " + gameClock);
	}
	
	public void moveAll(ArrayList<GameObject> go) {
		for(int i = 0; i < go.size(); i++) {
			if(go.get(i) instanceof Movable) {
				Movable mObj = (Movable)go.get(i);
				mObj.move();
			}
		}
	}
	
	public ArrayList<GameObject> getObjectList() {return gameObjectList;}
	
	public ArrayList<GameObject> getObjsOfType(String type, ArrayList<GameObject> go){
		ArrayList<GameObject> allObjOfType = new ArrayList<GameObject>();
		switch(type) {
		case "bird":
			for(int i = 0; i < go.size(); i++) {
				if(go.get(i) instanceof Bird) {
					allObjOfType.add((Bird)go.get(i));
				}
			}
			break;
		case "squirrel":
			for(int i = 0; i < go.size(); i++) {
				if(go.get(i) instanceof Squirrel) {
					allObjOfType.add((Squirrel)go.get(i));
				}
			}
			break;
		case "tomato":
			for(int i = 0; i < go.size(); i++) {
				if(go.get(i) instanceof Tomato) {
					allObjOfType.add((Tomato)go.get(i));
				}
			}
			break;
		case "nut":
			for(int i = 0; i < go.size(); i++) {
				if(go.get(i) instanceof Nut) {
					allObjOfType.add((Nut)go.get(i));
				}
			}
			break;
			
		default:
			System.out.println("Invalid Input. Valid inputs are 'squirrel', 'bird', 'nut', 'tomato'");
			
		}
		return allObjOfType;
	}
	
	public void display() {
		System.out.println("livesRemaining=" + getLivesRemaining());
		System.out.println("gameClock=" + getGameClock());
		System.out.println("lastNutReached=" + getPlayer().getLastNut());
		System.out.println("energyLevel=" + getPlayer().getEnergyLevel());
		System.out.println("damageLevel=" + getPlayer().getDamageLevel());
	}
	public void printMap() {
		System.out.println("Displaying Map");
		for(int i = 0; i < gameObjectList.size(); i++) {
			if(gameObjectList.get(i) instanceof Nut) {
				Nut nutObj = (Nut)gameObjectList.get(i);
				System.out.println("Nut: loc=" + nutObj.getLocation().getX() + ", " +  nutObj.getLocation().getY() + " color=" + nutObj.printColor() + " size=" + nutObj.getSize() + " seqNum=" + nutObj.getSeqNum());
			}
			else if(gameObjectList.get(i) instanceof Bird) {
				Bird birdObj = (Bird)gameObjectList.get(i);
				System.out.println("Bird: loc=" + birdObj.getLocation().getX() + ", " + birdObj.getLocation().getY() + " color=" + birdObj.printColor() + " heading=" + birdObj.getHeading() + " speed=" + birdObj.getSpeed() + " size=" + birdObj.getSize());
				
			}
			else if(gameObjectList.get(i) instanceof Squirrel) {
					Squirrel sqObj = (Squirrel)gameObjectList.get(i);
					System.out.println("Squirrel: loc=" + sqObj.getLocation().getX() + ", " + sqObj.getLocation().getY() + " color=" + sqObj.printColor() + " heading=" + sqObj.getHeading() + " speed=" + sqObj.getSpeed() + " size=" + sqObj.getSize() + " maxSpeed=" + sqObj.getMaximumSpeed() + " steeringDirection=" + sqObj.getSteeringDirection() + " energyLevel=" + sqObj.getEnergyLevel() + " damageLevel=" + sqObj.getDamageLevel());
			}
			else if(gameObjectList.get(i) instanceof Tomato) {
				Tomato tomObj = (Tomato)gameObjectList.get(i);
				System.out.println("Tomato: loc=" + tomObj.getLocation().getX() + ", " + tomObj.getLocation().getY() + " color=" + tomObj.printColor() + " size=" + tomObj.getSize() + " nutrition=" + tomObj.getNutrition());
				
			}
		}
		
	}
	public void addTomato() {
		Tomato newTomato = new Tomato();
		getObjectList().add(newTomato);
	}
	public Tomato collideTomato() {
		
		int size = getObjsOfType("tomato", getObjectList()).size();
		int randomInt = random.nextInt(size);
		Tomato randomTomato = (Tomato) getObjsOfType("tomato", getObjectList()).get(randomInt);
		randomTomato.collide();
		addTomato();
		return randomTomato;
	}
	public int getLivesRemaining() {return livesRemaining;}
	
	public void loseLife() {
		livesRemaining--;
		System.out.println("You lost a life! " + getLivesRemaining() + " lives remaining.");
		if(livesRemaining > 0) {
			init();
		}
		else {
			System.out.println("Game Over, you failed!");
			exit();
		}
	}
	public static void youWin() {
		System.out.println("Game over, you win! Total Time: " + gameClock);
		exit();
	}
	public int getGameClock() {return gameClock;}
	public Squirrel getPlayer() {return player;}
	public static void exit() {System.exit(0);}
	
	
}
