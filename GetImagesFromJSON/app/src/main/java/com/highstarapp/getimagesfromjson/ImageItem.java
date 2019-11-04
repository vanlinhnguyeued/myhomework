package com.highstarapp.getimagesfromjson;

public class ImageItem {
    String url;
    String description;

    public ImageItem(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
