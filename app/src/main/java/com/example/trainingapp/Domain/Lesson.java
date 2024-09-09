package com.example.trainingapp.Domain;

public class Lesson {
    private String title;
    private String duration;
    private String link;
    private String picPath;

    public Lesson(String title, String duration, String link, String picPath) {
        this.title = title;
        this.duration = duration;
        this.link = link;
        this.picPath = picPath;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
