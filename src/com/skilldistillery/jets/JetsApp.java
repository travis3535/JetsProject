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
				int rangeSplit = Integer.parseInt(lineSplit[2]);
				long priceSplit = Long.parseLong(lineSplit[3]);
				String typeOfJet = lineSplit[4];
				if (typeOfJet.equalsIgnoreCase("fighter")) {
					Jet jet = new FighterJet(lineSplit[0], speedSplit, rangeSplit, priceSplit);
					jetsAf.addJet(jet);
				}
				if (typeOfJet.equalsIgnoreCase("cargo")) {
					Jet jet = new CargoPlane(lineSplit[0], speedSplit, rangeSplit, priceSplit);
					jetsAf.addJet(jet);
				}
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
					listFastest();
					break;
				case 4:
					listLongest();
					break;
				case 5:
					loadAllCargo();
					break;
				case 6:
					System.out.println("Dogfighting is currently unavailable at your level of training.");
					System.out.println("Please check back later");
					break;
				case 7:
					userJetAdd();
					break;
				case 8:
					userJetRemove();
					break;
				case 9:
					System.out.println("Thanks for visiting Area 51");
					break;
			}
		} while (input <= 8);

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
		double speed = Double.MIN_VALUE;
		Jet fastest = null;
		for (Jet temp : jetsAf.getJets()) {
			if (temp.getSpeed() > speed) {
				speed = temp.getSpeed();
				fastest = temp;
			}
		}
		System.out.println(fastest.toString());
	}

	public void listLongest() {
		int longest = Integer.MIN_VALUE;
		Jet furthest = null;
		for (Jet temp : jetsAf.getJets()) {
			if (temp.getRange() > longest) {
				longest = temp.getRange();
				furthest = temp;
			}
		}
		System.out.println(furthest.toString());

	}

	public void loadAllCargo() {
		for (Jet temp : jetsAf.getJets()) {
			if (temp instanceof CargoCarrier) {
				((CargoCarrier) temp).loadCargo();
			}
		}

	}

	void userJetAdd() {
		System.out.println("Please enter model:");
		String userModel = kb.next();
		System.out.println("Speed in MPH to nearest tenth : ");
		double userSpeed = kb.nextDouble();
		System.out.println("Range : ");
		int userRange = kb.nextInt();
		System.out.println("Price $: ");
		long userPrice = kb.nextLong();
		System.out.println("Type of jet, fighter or cargo : ");
		String userType = kb.next();

		if (userType.equalsIgnoreCase("fighter")) {
			Jet jet = new FighterJet(userModel, userSpeed, userRange, userPrice);
			System.out.println("Jet  " + jet.toString());
			jetsAf.addJet(jet);
		}
		if (userType.equalsIgnoreCase("cargo")) {
			Jet jet = new CargoPlane(userModel, userSpeed, userRange, userPrice);
			System.out.println("Cargo  " + jet.toString());
			jetsAf.addJet(jet);
		}

	}

	public void userJetRemove() {
		System.out.println("Enter number of jet to remove");
		int userRemove;
		Jet removedJet = null;
		int count = 1;
		for (Jet temp : jetsAf.getJets()) {
			System.out.println(count + " " + temp.getModel());
			count++;
		}
		userRemove = kb.nextInt();

		removedJet = jetsAf.getJets().remove(userRemove - 1);
		System.out.println("Removing " + removedJet);
	}

	private void displayUserMenu() {
		System.out.println();
		System.out.println("Please select an option below");
		System.out.println();
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
