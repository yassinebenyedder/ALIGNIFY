package com.yassinenourchene.alighnify.Model;

public class Exercise {
    private String title;
    private int imageResId;

    public Exercise(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}
