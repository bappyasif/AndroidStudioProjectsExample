/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses.
 */

package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.name;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    //int price = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     * display(18*3+4/(2+2)-1);
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.cream_checkbox_view);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolates_checkbox_view);
        boolean hasChocolates = chocolateCheckBox.isChecked();

        EditText userName = (EditText) findViewById(R.id.name_field);
        String nameTextValue = userName.getText().toString();


        //int price = calculatePrice(hasWhippedCream,hasChocolates);
        /* this line is useful to check the state of the variable in android monitor as logs.*/
        //Log.v("MainActivity","Has Whipped Cream? "+ hasWhippedCream);
        //Log.v("MainActivity","The Price is "+price);
        String priceMessage = createOrderSummary(calculatePrice(hasWhippedCream, hasChocolates), hasWhippedCream, hasChocolates, nameTextValue);

        //composeEmail(priceMessage,userName);
        displayMessage(priceMessage);
    }

    /**
     * This method is used for email acttion with an EMAIL_INTENT
     */
    public void composeEmail(String priceMessage, EditText userName) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:youremail@example.com")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order Message for " +userName);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, priceMessage);
        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
    }
}
////
////        try {
////            startActivity(Intent.createChooser(intent, "Send email..."));
////        } catch (android.content.ActivityNotFoundException ex) {
////            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
////        }
//    }

    /**
     * This method creates a Order a summary of price in total.
     */
    public String createOrderSummary(int price, boolean toppingChecked, boolean chocolateChecked, String name){
        String orderSummary = "Name:"+name;
        orderSummary += "\n" + "Add whipped Cream? " + toppingChecked;
        orderSummary += "\n" + "Add Chocolates? " + chocolateChecked +"\n" + "Quantity: " +quantity;
        //String toppingText = "Add whipped Creamd?"+findViewById(R.id.checkbox_view).isActivated();
        return orderSummary + "\n" + "Total: " + "$" + price + "\n" + getString(R.string.Thank_You); /* using stinrg value to translated*/
    }

    /**
     * This method displays the given quantity value on the screen
     */
    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" +number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the order button is clicked.
     * display(18*3+4/(2+2)-1);
     */
    public void increment(View view) {
        if(quantity == 100){
            Toast.makeText(this, "Your order can exceed 100 Cups", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     * display(18*3+4/(2+2)-1);
     */
    public void decrement(View view) {
        if(quantity == 1){
            Toast.makeText(this, "You must order at Least 1 ", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    /**
     * This method calculates for total price on order with topping price adjustmeents.
     */
    private int calculatePrice(boolean hasCream, boolean hasChoco) {
        int coffeeBasePrice = 5;
        if(hasCream) {
            coffeeBasePrice = coffeeBasePrice + 1;
        }
        if(hasChoco) {
            coffeeBasePrice = coffeeBasePrice + 2;
        }
        return quantity * coffeeBasePrice;
    }
}