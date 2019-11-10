package com.vanlinhnguyenued.appcamera2;

import android.graphics.Bitmap;

public class Country {
    private String name;
    private Bitmap image;

    public Country(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
