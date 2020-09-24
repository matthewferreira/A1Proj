package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;

public class Nut extends Fixed{
	private static int objNumber = 1;
	private int sequenceNumber = objNumber;
	

	public Nut() {
		super(10, ColorUtil.BLACK);
		objNumber++;
	}
	
	public Nut(float x, float y) {
		super(10, ColorUtil.BLACK, x, y);
		objNumber++;
	}
	
	
	public int getSeqNum() {
		return sequenceNumber;
	}
	
	@Override
	public void setColor(int r, int g, int b){}
	
	
}
