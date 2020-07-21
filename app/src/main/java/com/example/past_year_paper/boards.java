package com.example.past_year_paper;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class boards extends Fragment {
    ListView listView;
    String[] a = {"Physics", "Urdu", "English", "Islamiyat", "Math", "Pak Study", "Computer Science","Chemistry","Biology"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boards, container, false);
        listView = view.findViewById(R.id.list);
        adaptar a = new adaptar();
        listView.setAdapter(a);
        clickitem();
        return view;
    }

    private void clickitem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Physics");
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Urdu");
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Eng");
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Islamiyat");
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Math");
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Pak study");
                    startActivity(intent);
                }
                if(position==6){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Computer science");
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Chemistry");
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent=new Intent(getActivity(),yearshow.class);
                    intent.putExtra("click","Biology");
                    startActivity(intent);
                }
            }
        });
    }
    public class adaptar extends BaseAdapter {

        @Override
        public int getCount() {
            return a.length;
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
            View v=getLayoutInflater().inflate(R.layout.halo,null);
            TextView textView=v.findViewById(R.id.text);
            textView.setText(a[position]);
            return v;
        }
    }
}