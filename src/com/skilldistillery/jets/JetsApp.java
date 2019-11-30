package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApp {

	// fields
	private AirField airField;
	private Scanner kb;

	// constructors

	public JetsApp() {

	}

	// Methods
	public static void main(String[] args) {
		JetsApp ja = new JetsApp();

		ja.Launch();

	}

	private void Launch() {
		//buffered reader / file reader for Jets.txt file somewhere in here?
		AirField jetsAf = new AirField();
		
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("Jets.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] lineSplit = line.split(",");
				double speedSplit = Double.parseDouble(lineSplit[1]);
				System.out.println("speed : " + speedSplit);
				int rangeSplit = Integer.parseInt(lineSplit[2]);
				System.out.println("range : " + rangeSplit);
				long priceSplit = Long.parseLong(lineSplit[3]);
				System.out.println("price : " + priceSplit);
				System.out.println("*************************");
			}
			
			}
			catch (IOException e) {
				System.err.println(e);
			}
			finally {
				
			}
	}

	private void displayUserMenu() {
		System.out.println("Please select an option below");
		System.out.println("Option 1 : List Jet Fleet");
		System.out.println("Option 2 : Fly all Jets");
		System.out.println("Option 3 : View fastest Jet");
		System.out.println("Option 4 : View longest ranged Jet");
		System.out.println("Option 5 : Load all Cargo Jets");
		System.out.println("Option 6 : DOGFIGHT!");
		System.out.println("Option 7 : Add a Jet to Fleet");
		System.out.println("Option 8 : Remove a Jet from Fleet");
		System.out.println("Option 9 : QUIT");

	}
}
