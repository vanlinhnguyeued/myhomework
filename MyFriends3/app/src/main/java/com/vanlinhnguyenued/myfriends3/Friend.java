package com.vanlinhnguyenued.myfriends3;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, numberphone, email;
    private int avatar, rating;

    public Friend(String name, String numberphone, String email, int avatar, int rating) {
        this.name = name;
        this.numberphone = numberphone;
        this.email = email;
        this.avatar = avatar;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}