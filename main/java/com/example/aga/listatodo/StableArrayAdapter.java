package com.example.aga.listatodo;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by aga on 27.03.15.
 */
public class StableArrayAdapter extends ArrayAdapter<String> {

        ArrayList<String> data;
        Context context;

public StableArrayAdapter(Context context, int textViewResourceId,
        ArrayList<String> objects) {
    super(context,textViewResourceId, objects);
    this.context = context;
    this.data = objects;
}
    public View getView(int position, View row, ViewGroup parent) {

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_in_list, null);

            TextView itemName = (TextView)row.findViewById(R.id.textView2);
            itemName.setText(data.get(position));

        }
        return row;
    }

}



