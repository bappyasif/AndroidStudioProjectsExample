package com.example.android.miwok;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BappY on 3/16/2017.
 * Word adapter will work as a custom job for our data structure to allow our List view can support
 * our requirements of grouping elements together for our ListView.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Context context, List<Word>words, int colorResourceId){
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false); // parent is the ListView
        }
        //getting the position of the word from ListView
        Word currentWord = getItem(position);

        //Getting the miwok word list view text
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //insrting the Word in our preffered structure
        miwokTextView.setText(currentWord.getmMiwokTranslation());
        //Getting the default translation for the miwok word
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //Inserting the default translation of miwok word into our preferred structure.
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        // getting the drawable resource view to list view
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);

        // Check if an image is provided for this word or not eeveer though my cod runs just fine.
        if (currentWord.hasImage()) {
            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);
        }

        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentWord.getmImageResourceId());


        /* Find the color that the resource ID maps to */
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        /* Set the background color of the text container View */
        textContainer.setBackgroundColor(color);

        //Find the sound that the resource ID maps to.
//        Button playButton = (Button) listItemView.findViewById(R.id.play_text_view);
//        View soundPlay = listItemView.findViewById(R.id.play_text_view);
//        currentWord.getmSoundResourceId();
//        int sound = ContextCompat.g
        //Now set the soundResource to playButton
        //playButton.setOnClickListener(view);

        //returning the combined listItemView of miwok and default word together.
        return listItemView;
    }
}
