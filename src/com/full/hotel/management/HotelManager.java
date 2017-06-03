package com.full.hotel.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelManager {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, List<Hotel>> hotelsMap = new HashMap<>();

		try (Scanner scanner = new Scanner(System.in)) {
			

			/*hotels.add(new Hotel("Park", 90, 20, 5, 2));
			hotels.add(new Hotel("Hyaat", 82, 12, 5, 3));
			hotels.add(new Hotel("Raddisson", 30, 18, 3, 3));
			hotels.add(new Hotel("RainTree", 58, 15, 3, 2));
			hotels.add(new Hotel("Accord", 41.55, 11.8, 1, 3));
			hotels.add(new Hotel("Fortune", 43, 14.8, 1, 4));*/

			List<Hotel> fiveStarHotel = new ArrayList<>();
			fiveStarHotel.add(new Hotel("Park", 90, 20, 5, 2));
			fiveStarHotel.add(new Hotel("Hyaat", 82, 12, 5, 3));
			hotelsMap.put(5, fiveStarHotel);
			
			List<Hotel> treeStarHotel = new ArrayList<>();
			treeStarHotel.add(new Hotel("Raddisson", 30, 18, 3, 3));
			treeStarHotel.add(new Hotel("RainTree", 58, 15, 3, 2));
			hotelsMap.put(3, treeStarHotel);

			List<Hotel> oneStarHotel = new ArrayList<>();
			oneStarHotel.add(new Hotel("Accord", 41.55, 11.8, 1, 3));
			oneStarHotel.add(new Hotel("Fortune", 43, 14.8, 1, 4));
			hotelsMap.put(1,oneStarHotel);

			
			System.out.println("Enter amount: ");
			int amount = scanner.nextInt();
			System.out.println("How many days u want to stay here?: ");
			int days = scanner.nextInt();
			System.out.println("What is your rating 1 or 3 or 5?.");
			int rating = scanner.nextInt();
			
			List<Hotel> hotels=hotelsMap.get(rating);
			
			System.out.println(bookHotel(amount, days, rating, hotels));
		}
	}

	private static String bookHotel(double money, int days, int starRating, List<Hotel> hotels) {

		double cheapestCost = 0;
		String hotelName = "";

		for (Hotel hotel : hotels) {
				double costOfHotel = getCostOfHotel(days, hotel);
				if (cheapestCost == 0) {
					cheapestCost = costOfHotel;
					hotelName = hotel.getHotelName();

				} else if (costOfHotel < cheapestCost) {
					hotelName = hotel.getHotelName();
					cheapestCost = costOfHotel;
				}
		}
		return isHotelBooked(money, days, starRating, cheapestCost, hotelName);

	}

	private static String isHotelBooked(double money, int days, int starRating, double minCost, String hotelName) {
		if (money > minCost) {
			return "Hotel Booked for " + days + " days in " + starRating + " star Hotel " + hotelName
					+ " for the cost of " + minCost + " for hotel";
		} else {
			return "Sorry! you dont have sufficient amount to book any hotel";
		}
	}

	private static double getCostOfHotel(int noOfDays, Hotel hotel) {
		double totalCost = hotel.getCostPerDay() * noOfDays;

		if (noOfDays > hotel.getDiscountDays()) {
			totalCost = totalCost - ((totalCost / 100) * hotel.getDiscountPercentage());
		}

		return totalCost;
	}

}
