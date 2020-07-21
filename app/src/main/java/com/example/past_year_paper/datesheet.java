package com.example.past_year_paper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class datesheet extends Fragment {
    ListView listView;
    String[] b = {"5th class", "8th class", "9th class", "10th class", "11th class", "12th class"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datesheet, container, false);
        listView = view.findViewById(R.id.list1);
        datesheetadapter adapter = new datesheetadapter();
        listView.setAdapter(adapter);
        return view;
    }

    public class datesheetadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return b.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=getLayoutInflater().inflate(R.layout.datesheetlayout,null);
            TextView textView=v.findViewById(R.id.text1);
            textView.setText(b[position]);
            return v;
        }
    }
}
