package com.example.android.miwok;

/**
 * Created by BappY on 3/16/2017. This Class would be used for vocabs on Colors of miwok language.
 * it will be translation of miwok language to english - default language.
 */

public class Color {
    //default Translation of the word
    private String mDefaultTranslation;

    // miwok translation of the word
    private String mMiwokTranslation;

    //creating a new object of Word class so that we can manipulate our app behaviors.
    //we will use a constructor to do so. which takes in two parameters of String type.
    //mDefaultTranslation, mMiwokTranslation.
    public Color(String DefaultTranslation, String MiwokTranslation){
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
    }

    //Get the Miwok Translation using getter Method on Miwok Translation.
    public String getmMiwokTranslation(){
        return mMiwokTranslation;
    }

    //Get the Default Translation using getter method fro english Translation of miwok language.
    public  String getmDefaultTranslation(){
        return mDefaultTranslation;
    }
}
