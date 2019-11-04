package com.vanlinhnguyenued.jsonparse;

public class ImageItem {
    private String url;
    private String description;

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
