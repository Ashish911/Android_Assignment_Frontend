package com.example.onlinefoodportal.model;

public class Order {

    private String foodname;
    private String Price;
    private String location;
    private String PhoneNo;

    public Order(String foodname, String price, String location, String phoneNo) {
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
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
