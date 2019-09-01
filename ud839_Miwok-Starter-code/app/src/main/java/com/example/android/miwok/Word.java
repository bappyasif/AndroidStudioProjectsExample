package com.example.android.miwok;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by BappY on 3/15/2017.
 * This Word Class will represent a vocabulary word on miwok language and its Default translation.
 * In this case its english.
 */

public class Word {

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    //default Translation of the word
    private String mDefaultTranslation;

    // miwok translation of the word
    private String mMiwokTranslation;

    //miwok image resource declaration
    private int mImageResourceId;

    //miwok sound resource declaration
    private int mSoundResourceId;

    //creating a new object of Word class so that we can manipulate our app behaviors.
    //we will use a constructor to do so. which takes in two parameters of String type.
    //mDefaultTranslation, mMiwokTranslation. Setter functions.
    public Word(String DefaultTranslation, String MiwokTranslation, int soundResourceId){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mSoundResourceId = soundResourceId;
    }

    // creating a new constructor for the Word class so that we can insert this Image view onto the
    //scree. we will do this through a creating another constructor for the Word class,
    //this newly creted constructor will allow the Word class to create this object using the
    //super class constructor which takes in no parameter.
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId){
        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundResourceId = soundResourceId;
    }

    //Get the Miwor sound associate with the word using getter method.
    public int getmSoundResourceId(){return mSoundResourceId;}

    //Get the Miwok Translation using getter Method on Miwok Translation.
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    //Get the Default Translation using getter method fro english Translation of miwok language.
    public  String getmDefaultTranslation(){
        return mDefaultTranslation;
    }

    //Get the Image resource for the List View for the word.
    public int getmImageResourceId(){return mImageResourceId;}

    // Returns whether or not there is an image for this word.
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mSoundResourceId=" + mSoundResourceId +
                '}';
    }
}
