package com.example.drawer;

public class NewsHeadline {
    private String title;
    private String description;
    private int imageResourceId; // Store the image resource ID

    public NewsHeadline(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
