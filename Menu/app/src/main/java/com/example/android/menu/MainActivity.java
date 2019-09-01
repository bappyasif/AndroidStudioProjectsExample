package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstMenuView = (TextView) findViewById(R.id.menu_item_1);
        String firstMenu = firstMenuView.getText().toString();
        Log.v("MainActivity",firstMenu);

        // Find second menu item TextView and print the text to the logs
        TextView secondMenuView = (TextView) findViewById(R.id.menu_item_2);
        String secondMenu = secondMenuView.getText().toString();
        Log.v("MainActivity",secondMenu);

        // Find third menu item TextView and print the text to the logs
        TextView thirdMenuView = (TextView) findViewById(R.id.menu_item_3);
        String thirdMenu = thirdMenuView.getText().toString();
        Log.v("MainActivity",thirdMenu);

    }
}