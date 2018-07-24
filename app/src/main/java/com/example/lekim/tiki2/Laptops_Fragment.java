package com.example.lekim.tiki2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Laptops_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View categoriesView = inflater.inflate(R.layout.categories_fragment, container, false);
        TextView text = (TextView) categoriesView.findViewById(R.id.categories);
        text.setText("This is a Laptops Collection");
        return categoriesView;
    }
}
