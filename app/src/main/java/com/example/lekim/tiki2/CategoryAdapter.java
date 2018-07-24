package com.example.lekim.tiki2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Tops_Fragment();
        } else if (position == 1) {
            return new Books_Fragment();
        } else if (position == 2) {
            return new Cameras_Fragment();
        } else if (position == 3) {
            return new Laptops_Fragment();
        } else return new Phones_Fragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Top";
        } else if (position == 1) {
            return "Book";
        } else if (position == 2) {
            return "Camera";
        } else if (position == 3) {
            return "Laptop";
        } else return "Phones";
    }
}
