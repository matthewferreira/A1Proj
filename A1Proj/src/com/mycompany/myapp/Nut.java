package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;

public class Nut extends Fixed{
	private static int objCount = 1;
	private int sequenceNumber = objCount;
	

	public Nut() {
		super(10, ColorUtil.BLACK);
		objCount++;
	}
	
	public Nut(float x, float y) {
		super(10, ColorUtil.BLACK, x, y);
		objCount++;
	}
	
	
	public int getSeqNum() {
		return sequenceNumber;
	}
	
	@Override
	public void setColor(int r, int g, int b){}
	
	public static int getObjCount() {
		return objCount;
	}
	
}
