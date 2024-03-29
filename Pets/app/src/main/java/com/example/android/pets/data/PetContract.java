package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import static com.example.android.pets.data.PetContract.PetEntry.GENDER_MALE;

/**
 * Created by BappY on 4/1/2017.
 */

public final class PetContract {
    //To prevent accidental instantiating the class.
    private PetContract(){}

    //URI constant information

    //The "Content authority" is a name for the entire content provider
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    //Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //Possible path (appended to base content URI for possible URI's)
    public static final String PATH_PETS = "pets";


    //inner class @PetEntry that defines the table headers
    public static class PetEntry implements BaseColumns{

        //Each entry in the table represents a single pet.
        // The content URI to access the pet data in the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        //Table name constant of our Sheleter app
        public static final String TABLE_NAME = "pets";

        //TABLE column constants
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for the gender of the pet.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }

    /**
     * Returns whether or not the given gender is MALE, FEMALE, UNKNOWN
     */
    public static boolean isValidGender(int gender) {
        if (gender == PetEntry.GENDER_UNKNOWN || gender == GENDER_MALE || gender == PetEntry.GENDER_FEMALE) {
            return true;
        }
        return false;
    }

    // The MIME type of the {@link #CONTENT_URI} for a list of pets.
    public static final String CONTENT_LIST_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

    //The MIME type of the {@link #CONTENT_URI} for a single pet.
    public static final String CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

}
