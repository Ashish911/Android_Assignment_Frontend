package com.example.onlinefoodportal.model;

public class Food {

    private String FoodName;
    private String FoodImage;
    private Integer Price;

    public Food(String foodName, String foodImage, Integer price) {
        FoodName = foodName;
        FoodImage = foodImage;
        Price = price;
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

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }
}
