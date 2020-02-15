package com.example.onlinefoodportal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Favourite {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("foodid")
    @Expose
    private Food food;

    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
