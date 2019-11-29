package com.skilldistillery.jets;

public abstract class Jet {
	//Fields
	private String model;
	private double speed;
	private int range;
	private long price;
	
	//Constructors
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	//Methods
	public void fly() {
		
	}
	
	public double getSpeedInMach() {
		return speed;
		
	}
	
}
