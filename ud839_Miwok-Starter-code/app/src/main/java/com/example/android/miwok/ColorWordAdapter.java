package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BappY on 3/16/2017.
 * ColorWordAdapter will work as a custom job data structure to allow our List view to support
 * our requirements of grouping elements together for our ListView.
 */

public class ColorWordAdapter extends ArrayAdapter<Color> {

    public ColorWordAdapter(Context context, List<Color>colors){
        super(context,0,colors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false); // parent is the ListView
        }
        //getting the position of the color from ListView
        Color currentColorWord = getItem(position);

        //Getting the miwok color list view text
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //insrting the Color in our ColorWordAdapter class defined structure. Using a Setter function
        miwokTextView.setText(currentColorWord.getmMiwokTranslation());

        //Geetting the Default Color list view TEXT from the xml layout.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //insrting the Color in our ColorWordAdapter class defined structure. Using a Setter function
        defaultTextView.setText(currentColorWord.getmDefaultTranslation());

        // Now returning the current listItemView to the caller
        return listItemView;
    }
}
