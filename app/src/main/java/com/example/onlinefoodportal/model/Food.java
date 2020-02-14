package com.example.onlinefoodportal.model;

public class Food {

    private String _id;
    private String FoodName;
    private String FoodImage;
    private int Price;
    private String Restaurantid;

    public Food(String _id) {
        this._id = _id;
    }

    public Food(String foodName, String foodImage, int price, String restaurantid) {
        FoodName = foodName;
        FoodImage = foodImage;
        Price = price;
        Restaurantid = restaurantid;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodImage() {
        return FoodImage;
    }

    public void setFoodImage(String foodImage) {
        FoodImage = foodImage;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getRestaurantid() {
        return Restaurantid;
    }

    public void setRestaurantid(String restaurantid) {
        Restaurantid = restaurantid;
    }
}
