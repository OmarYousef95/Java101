package com.example.java101.CustomObjectsBetweenActivites;

import android.os.Parcel;
import android.os.Parcelable;


public class CustomObject implements Parcelable {

    private String name;
    private int age;
    private boolean condition;

    public CustomObject() {
    }


    public CustomObject(String name, int age, boolean condition) {
        this.name = name;
        this.age = age;
        this.condition = condition;
    }

    protected CustomObject(Parcel in) {
        name = in.readString();
        age = in.readInt();
        condition = in.readByte() != 0;
    }

    public static final Creator<CustomObject> CREATOR = new Creator<CustomObject>() {
        @Override
        public CustomObject createFromParcel(Parcel in) {
            return new CustomObject(in);
        }

        @Override
        public CustomObject[] newArray(int size) {
            return new CustomObject[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte) (condition ? 1 : 0));
    }
}
