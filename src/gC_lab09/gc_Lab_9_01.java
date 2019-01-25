package gC_lab09;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class gc_Lab_9_01 {

	private static Map<String, Double> menu = new TreeMap<>();

	public static void main(String[] args) {

		String Order;
		String moreStuff = "y";
		double avgOfCart = 0;

		Scanner scnr = new Scanner(System.in);

		populateMenu();

		ArrayList<String> cartNames = new ArrayList<>();

		ArrayList<Double> cartPrices = new ArrayList<>();

		System.out.println("~*~Welcome to Maarschalkerweerd Rynsburger's Dutch Market~*~");
		System.out.println("\n");
		System.err.println("AFTER 24 WONDERFUL YEARS, WE ARE CLOSING FOREVER -- ALL ITEMS PRICED TO SELL");

		do {

			printMenu();
			System.out.println("\n");
			System.out.println("What item would you like to order?");

			Order = scnr.nextLine();
			Order = Order.toUpperCase();

			// validate the item ordered

			while (!menu.containsKey(Order)) {
				System.err.println("Sorry we dont have those. Try again, if you want.");
				System.out.println("What item would you like to order?");
				Order = scnr.nextLine();
				Order = Order.toUpperCase();

			}

			cartNames.add(Order);

			cartPrices.add(menu.get(Order));

			System.out.println("We put the " + Order + " in your cart for the price of $" + menu.get(Order));
			System.out.println("Would you like to order more stuff? (Y/N) ? ");
			moreStuff = scnr.nextLine();
			// validate y/n input
			while (!(moreStuff.equalsIgnoreCase("y") || moreStuff.equalsIgnoreCase("n"))) {
				System.err.println("Invalid input. Please enter Y to keep shopping or N to checkout.");
				moreStuff = scnr.nextLine();
			}

		} while (moreStuff.equalsIgnoreCase("y"));
		{

// average the prices

			for (double d : cartPrices) {
				avgOfCart += d;
			}

			avgOfCart = avgOfCart / cartPrices.size();

// print the receipt
			System.out.println("ORDER SUMMARY");
			System.out.println("=========================");
			for (int i = 0; i < cartNames.size(); i++) {
				System.out.printf("%-28s %s\n", cartNames.get(i), "€" + cartPrices.get(i));
			}
			System.out.println("\n");
			DecimalFormat df = new DecimalFormat("0.00");
			System.out.println("The average price per item is: €" + df.format(avgOfCart));
			System.out.println("\n" + "Bedankt voor het winkelen! We wensen je een goed leven!");

		}
	}

	private static void populateMenu() {
		menu.put("CHEESE", 3.99);
		menu.put("SHRIVLED MUSHROOM", 2.59);
		menu.put("OLD BEER", 11.59);
		menu.put("RARE PEARS", 22.53);
		menu.put("TWEEZERS", 338.01);
		menu.put("VINTAGE TOOTHBRUSH", 85.01);
		menu.put("HEIRLOOM BASIL", 299.43);
		menu.put("VHS TAPE", 3.99);
		menu.put("SOUP", 1.99);
		menu.put("AUTOGRAPHED DICTIONARY", 33.06);
	}

	private static void printMenu() {
		for (String name : menu.keySet()) {
			System.out.printf("%-28s %s\n", name, "€" + menu.get(name));

		}
	}

}