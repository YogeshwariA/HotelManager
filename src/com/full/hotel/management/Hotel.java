package com.full.hotel.management;

public class Hotel extends HotelManager {
	private String hotelName;
	private double costPerDay;
	private double discountPercentage;
	private int discountDays;
	private int star;
	
	
	public Hotel(String hotelName,double costPerDay, double discountPercentage, int star, int discountDays) {
		this.costPerDay = costPerDay;
		this.discountDays = discountDays;
		this.discountPercentage = discountPercentage;
		this.star = star;

	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public int getDiscountDays() {
		return discountDays;
	}
	public void setDiscountDays(int discountDays) {
		this.discountDays = discountDays;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
}
