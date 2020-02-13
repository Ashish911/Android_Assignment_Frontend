package com.example.onlinefoodportal.model;

public class Restaurant {

    private String RestaurantName, _id;
    private String Logo;
    private String Tags;
    private String Location;
    private String Delivery;
    private String Categoryid;

    public Restaurant(String _id){
        this._id = _id;
    }

    public Restaurant(String restaurantName, String logo, String tags, String location, String delivery, String categoryid) {
        RestaurantName = restaurantName;
        Logo = logo;
        Tags = tags;
        Location = location;
        Delivery = delivery;
        Categoryid = categoryid;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String delivery) {
        Delivery = delivery;
    }

    public String getCategoryid() {
        return Categoryid;
    }

    public void setCategoryid(String categoryid) {
        Categoryid = categoryid;
    }
}
