package com.houssem.superhero.pojo;

import java.io.Serializable;

/**
 * Created by HOUSSEM on 27/02/2016.
 */
public class Hero implements Serializable{

    public final static int SHORT_INTRO_SIZE = 80;

    private String image;
    private String title;
    private String intro;
    private String year;
    private String text;
    private String color;

    private boolean fullIntroDisplayed;

    public Hero(String image, String title, String intro, String year, String text, String color){
        this.image = image;
        this.title = title;
        this.intro = intro;
        this.year = year;
        this.text = text;
        this.color = color;
    }

    public String getShortIntro(){
        return intro.substring(0, SHORT_INTRO_SIZE) + "...";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFullIntroDisplayed() {
        return fullIntroDisplayed;
    }

    public void setFullIntroDisplayed(boolean fullIntroDisplayed) {
        this.fullIntroDisplayed = fullIntroDisplayed;
    }

}
