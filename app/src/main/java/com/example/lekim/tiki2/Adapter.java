package com.example.lekim.tiki2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Adapter extends ArrayAdapter {
    /**
     * Create a new {@link Adapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param objects is the list of {@link Object}s to be displayed.
     */
    public Adapter(Context context, ArrayList<Object> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        // Get the Object at the given position in the list of object
        Object currentObject = (Object) getItem(position);

        final ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Display the image of the current object in that ImageView
        InputStream imageStream = null;
        try {
            String strImage = "images/" + currentObject.getImage();
            // get input stream
            imageStream = getContext().getAssets().open(strImage);
            // load image as Drawable
            Drawable drawable = Drawable.createFromStream(imageStream, null);
            imageView.setImageDrawable(drawable);
            if (imageStream != null) {
                imageStream.close();
            }
        } catch (IOException ex) {
            // return;
        }

        // Find the TextView in the list_item.xml layout with view ID name
        TextView nameView = (TextView) listItemView.findViewById(R.id.name);
        // Display the name of the current object in that TextView
        nameView.setText(currentObject.getName());

        // Find the TextView in the list_item.xml layout with view ID price
        TextView priceView = (TextView) listItemView.findViewById(R.id.price);
        // Format the price to show 2 decimal place
        String formattedPrice = formatPrice(currentObject.getPrice());
        // Display the price of the current object in that TextView
        priceView.setText(formattedPrice + " usd");

        // Find the ProgressBarView in the list_item.xml layout with view ID progress_bar
        ProgressBar progressBar = (ProgressBar) listItemView.findViewById(R.id.progress_bar);
        // Set the maximum of the progressBar
        progressBar.setMax(100);

        // Return the whole list item layout so that it can be shown in the GridView.
        return listItemView;
    }

    /**
     * Return the formatted price string showing 2 decimal place (i.e. "10.52")
     * from a decimal price value.
     */
    private String formatPrice(double price) {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        return priceFormat.format(price);
    }
}
