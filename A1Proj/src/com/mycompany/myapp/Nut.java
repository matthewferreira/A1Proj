package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;

public class Nut extends Fixed{
	private static int objCount = 0;
	private int sequenceNumber;
	

	public Nut() {
		super(10, ColorUtil.YELLOW);
		objCount++;
		sequenceNumber = objCount;
	}
	
	public Nut(float x, float y) {
		super(10, ColorUtil.YELLOW, x, y);
		objCount++;
		sequenceNumber = objCount;
		
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
