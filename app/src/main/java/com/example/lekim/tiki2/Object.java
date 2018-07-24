package com.example.lekim.tiki2;

/**
 * {@link Object} represents a Object
 * It contains a image, a name, and a price.
 */
public class Object {

    private String mImage;
    /**
     * Name resource ID for the object
     */
    private String mName;
    /**
     * Price resource ID for the object
     */
    private double mPrice;

    /**
     * Create a new Object object.
     *
     * @param image is the image associated with this object
     * @param name  is the name associated with this object
     * @param price is the price associated with this object
     */
    public Object(String image, String name, double price) {
        mImage = image;
        mName = name;
        mPrice = price;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    /**
     * Get the image of the object
     */
    public String getImage() {
        return mImage;
    }

    /**
     * Get the name of the object
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the price of the object
     */
    public double getPrice() {
        return mPrice;
    }
}
