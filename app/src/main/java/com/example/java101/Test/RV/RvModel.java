package com.example.java101.Test.RV;

import android.graphics.drawable.Drawable;

public class RvModel {

    public String name,info;
    public Integer image;

    public RvModel() {
    }

    public RvModel(String name, String info, Integer image) {
        this.name = name;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
