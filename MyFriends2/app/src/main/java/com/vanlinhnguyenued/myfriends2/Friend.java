package com.vanlinhnguyenued.myfriends2;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.List;

public class Friend implements Serializable {
    private String name, status;
    private int avatar;
    private Drawable avatar_drawable; //neu k co id thi truyen` drawable

    List<Friend> followList;

    public Drawable getAvatar_drawable() {
        return avatar_drawable;
    }

    public void setAvatar_drawable(Drawable avatar_drawable) {
        this.avatar_drawable = avatar_drawable;
    }

    //bí quá làm thêm 1 constructor nữa
    public Friend(String name, String status, int avatar) {
        this.name = name;
        this.status = status;
        this.avatar = avatar;
        avatar_drawable=null;
    }
    public Friend(String name, String status, Drawable dr) {
        this.name = name;
        this.status = status;
        this.avatar = avatar;

        avatar_drawable=dr;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
