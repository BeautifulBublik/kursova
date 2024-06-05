package com.example.model;

public class Apartments {
    private Integer id;
    private String address;
    private int numberOfRooms;
    private double area;
    private double rentPrice;
    private String description;

    public Apartments(Integer id, String address, int numberOfRooms, double area, double rentPrice, String description) {
        this.id = id;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.rentPrice = rentPrice;
        this.description = description;
    }

    public Apartments(String address, int numberOfRooms, double area, double rentPrice, String description) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.rentPrice = rentPrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
