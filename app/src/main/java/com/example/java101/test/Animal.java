package com.example.java101.test;

import android.util.Log;

public class Animal {

    private String type;
    private String color;

    public Animal(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public void canWalk(){
        Log.v("ZXC","Yes");
    }

    private void canFly(){
        Log.v("ZXC","No");
    }
}
