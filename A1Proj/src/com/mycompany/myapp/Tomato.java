package com.mycompany.myapp;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Tomato extends Fixed{
	private static Random random = new Random();
	private int nutrition;
	
	public Tomato() {
		super(10 + random.nextInt(40), ColorUtil.MAGENTA);
		nutrition = super.getSize();
	}
}
