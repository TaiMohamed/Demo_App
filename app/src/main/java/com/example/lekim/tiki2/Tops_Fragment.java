package com.example.lekim.tiki2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class Tops_Fragment extends Fragment {

    public static final String LOG_TAG = Tops_Fragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tops_fragment, container, false);

        ParseJSON code = new ParseJSON();
        String jsonString = code.getAssetJsonData(getActivity());

        // Get the list of objects from {@link ParseJSON}
        ArrayList<Object> myObjects = code.extractObjects(jsonString);

        // Find a reference to the {@link GridView} in the layout
        GridView objectGridView = (GridView) rootView.findViewById(R.id.grid_view);

        // Create a new adapter that take the list of myObjects as input
        Adapter adapter = new Adapter(getActivity(), myObjects);

        // Set the adapter on the {@link GridView}
        // so the list can be populated in the user interface\
        objectGridView.setAdapter(adapter);
        return rootView;
    }
}
