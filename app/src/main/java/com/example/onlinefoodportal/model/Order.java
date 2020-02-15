package com.example.onlinefoodportal.model;

public class Order {

    private String foodname;
    private int Price;
    private String location;
    private String PhoneNo;

    public Order(String foodname, int price, String location, String phoneNo) {
        this.foodname = foodname;
        Price = price;
        this.location = location;
        PhoneNo = phoneNo;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }
}
