package com.example.model;

public class ApartmentParameters {
    private int minRooms;
    private int maxRooms;
    private double minArea;
    private double maxArea;
    private double minRentPrice;
    private double maxRentPrice;

    public ApartmentParameters(int minRooms, int maxRooms, double minArea, double maxArea, double minRentPrice, double maxRentPrice) {
        this.minRooms = minRooms;
        this.maxRooms = maxRooms;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minRentPrice = minRentPrice;
        this.maxRentPrice = maxRentPrice;
    }

    public int getMinRooms() {
        return minRooms;
    }

    public void setMinRooms(int minRooms) {
        this.minRooms = minRooms;
    }

    public int getMaxRooms() {
        return maxRooms;
    }

    public void setMaxRooms(int maxRooms) {
        this.maxRooms = maxRooms;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    public double getMinRentPrice() {
        return minRentPrice;
    }

    public void setMinRentPrice(double minRentPrice) {
        this.minRentPrice = minRentPrice;
    }

    public double getMaxRentPrice() {
        return maxRentPrice;
    }

    public void setMaxRentPrice(double maxRentPrice) {
        this.maxRentPrice = maxRentPrice;
    }
}
