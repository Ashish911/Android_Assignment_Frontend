package com.example.onlinefoodportal.model;

public class Restaurant {

    private String Name;
    private String Logo;
    private String Tags;
    private String Location;
    private String Delivery;

    public Restaurant(String name, String logo, String tags, String location, String delivery) {
        Name = name;
        Logo = logo;
        Tags = tags;
        Location = location;
        Delivery = delivery;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
