package com.example.android.practiceset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // PASTE CODE YOU WANT TO TEST HERE
        /**
         * int weekday = 5;
         int weekend = 9;
         int optimalHours = 7 * 8;

         int actualHours;
         actualHours = weekday*5 + weekend * 2;
         int solution = optimalHours - actualHours;
         display(solution);
         */
        int day1 = 15;
        int day2 = 18;
        int day3 = 22;
        display(day1+day2+day3/3);

    }

    /**
     * Display methods that allow the text to appear on the screen. Don't worry if you don't know
     * how these work yet. We'll be covering them in lesson 3.
     */

    public void display(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text);
    }

    public void display(int text) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(text + "");
    }

    public void display1(String text) {
        display(text);
    }

    public void display2(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view_2);
        t.setText(text);
    }

    public void display3(String text) {
        TextView t = (TextView) findViewById(R.id.display_text_view_3);
        t.setText(text);
    }
}