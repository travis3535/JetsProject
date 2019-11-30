package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApp {

	// fields
	AirField jetsAf = new AirField();
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
		kb = new Scanner(System.in);

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
				Jet jet = new FighterJet(lineSplit[0], speedSplit, rangeSplit, priceSplit);
				System.out.println("Jet  " + jet.toString());
				System.out.println("*************************");

				jetsAf.addJet(jet);

			}

		} catch (IOException e) {
			System.err.println(e);
		}

		int input;
		do {
			displayUserMenu();
			input = kb.nextInt();

			switch (input) {
				case 1:
					listAllJets();
					break;
				case 2:
					flyAllJets();
					break;
				case 3:
//					View fastest Jet
					break;
				case 4:
//					View longest ranged Jet
					break;
				case 5:
//					Load all Cargo Jets
					break;
				case 6:
//					DOGFIGHT!
					break;
				case 7:
//					Add a Jet to Fleet
					break;
				case 8:
//					Remove a Jet from Fleet
					break;
				case 9:
//					QUIT
					break;
				default:
					break;
			}
		} while (input <= 9);

		kb.close();

	}

	public void listAllJets() {
		for (Jet temp : jetsAf.getJets()) {
			if (temp != null) {
				System.out.println(temp);
			}
		}

	}

	public void flyAllJets() {
		for (Jet temp : jetsAf.getJets()) {
			if (temp != null) {
				temp.fly();
			}
		}
	}

	public void listFastest() {
		
	}

	private void displayUserMenu() {
		System.out.println();
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
