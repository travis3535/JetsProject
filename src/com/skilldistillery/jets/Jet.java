package com.skilldistillery.jets;

public abstract class Jet {
	// Fields
	private String model;
	private double speed;
	private int range;
	private long price;

	// Constructors
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// Methods
	public void fly() {
		this.toString();
		double flyTime = range / speed;
		System.out.println(this.model + "'s - Flytime in Hours at Max Cruising Speed " + flyTime);

	}

	public double getSpeedInMach() {
		double mach = this.speed / 767.269;

		return mach;

	}

	@Override
	public String toString() {
		return "Model : " + model + ", Speed in MPH :" + speed + ", Range in Miles :" + range + ", Price $:" + price
				+ ", Speed in Mach : " + getSpeedInMach();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
