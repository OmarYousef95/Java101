package com.example.java101.SharedPreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class Data {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;


    public Data (Context context){

        sharedPreferences = context.getSharedPreferences("myData", Activity.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.apply();

    }


    //To set and get boolean values

    public void setBoolean (String key, boolean value){
        sharedPreferencesEditor.putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }


    //To set and get integer values

    public void setInteger(String key ,int value) {
        sharedPreferencesEditor.putInt(key, value).apply();
    }

    public int getInteger(String key) {
        return sharedPreferences.getInt(key, 0);
    }


    //To set and get String values

    public void setString(String key, String value) {
        sharedPreferencesEditor.putString(key, value).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }


    public void setLanguage (String key, String value){
        sharedPreferencesEditor.putString(key, value).apply();
    }

    public String getLanguage(String key) {
        return sharedPreferences.getString(key, "en");
    }

    public void setCustomObject(String key , CustomObject customObject){
        sharedPreferencesEditor.putString(key,new Gson().toJson(customObject)).apply();
    }

    public CustomObject getCustomObject(String key){
        return new Gson().fromJson(sharedPreferences.getString(key,null),CustomObject.class);
    }


}
