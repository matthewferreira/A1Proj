package com.mycompany.myapp;

public abstract class Fixed extends GameObject{
	
	public Fixed(int sz, int clr) {
		super(sz, clr);
	}
	
	public Fixed(int sz, int clr, float x, float y) {
		super(sz, clr, x, y);
	}
	
	@Override
	public void setLocation(float x, float y){}
	
}
