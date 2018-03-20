package com.example.rhenigan.whichanimalareyou;

/**
 * Created by henig on 3/19/2018.
 * ------------------------------
 */

public class Animal {

    private String mName;
    private int mRating = 0;

    public Animal(String name) {
        mName = name;
    }

    public int getmRating() {
        return mRating;
    }

    public void adjustmRating(int rating) {
        mRating = mRating + rating;
    }
}
