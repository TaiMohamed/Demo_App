package com.example.lekim.tiki2;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseJSON {
    private static String jsonString;

    /***
     * function to parse json file to string.
     * @return
     */
    public String getAssetJsonData(Context context) {
        jsonString = null;
        try {
            InputStream is = context.getAssets().open("deals.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.e("data", jsonString);
        return jsonString;

    }


    /***
     * Function to parse Array json to list object.
     * @param strJsonArray
     * @return
     */
    public ArrayList<Object> extractObjects(String strJsonArray) {

        // Create an empty ArrayList that we can start adding objects to
        ArrayList<Object> objects = new ArrayList<>();

        // If there's a problem with the way the JSON is formatted, a JSONException exception object
        // will be thrown. Catch the exception so the app doesn't crash, and print the error message
        // to the logs.
        try {

            // build up a list of objects with the corresponding data.
            JSONArray jsonArray = new JSONArray(strJsonArray);

            // Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);

                String name = currentObject.getString("name");
                double price = currentObject.getDouble("price");
                String image = currentObject.getString("thumbnail");

                Object object = new Object(image, name, price);
                objects.add(object);
            }
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("Source", "Problem parsing the object JSON results", e);
        }

        // Return the list of earthquakes
        return objects;
    }
}
