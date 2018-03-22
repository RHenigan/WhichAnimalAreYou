package com.example.rhenigan.whichanimalareyou;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by henig on 3/19/2018.
 * ------------------------------
 */

public class Animal implements Parcelable{

    private String mName;
    private int[] mScore;
    private int mImageid;

    public Animal(String name, int[] score, int imageId) {
        mName = name;
        mScore = score;
        mImageid = imageId;
    }

    public Animal(Parcel in) {
        mName = in.readString();
        mScore = in.createIntArray();
        mImageid = in.readInt();
    }


    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public int[] getmRating() {
        return mScore;
    }

    public String getName(){
        return mName;
    }

    public int getImageid() {
        return mImageid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeIntArray(mScore);
        parcel.writeInt(mImageid);
    }
}
