package com.example.past_year_paper;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;

public class getadaptar extends BaseAdapter {
    private Context context; //context
    private ArrayList<getdata> items; //data source of the list adapter

    //public constructor
    public getadaptar(Context context, ArrayList<getdata> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.selectclasslayout, parent, false);
        }

        // get current item to be displayed
        getdata currentItem = (getdata) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView) convertView.findViewById(R.id.classtxt);
        textViewItemName.setText(currentItem.getClass9());
        return convertView;
    }
}
