package com.example.java101.Views.ListView;

public class ListViewModel {


    public String name,Info;
    public Integer image;

    public ListViewModel() {
    }

    public ListViewModel(String name, String info, Integer image) {
        this.name = name;
        Info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
