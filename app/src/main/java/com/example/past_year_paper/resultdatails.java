package com.example.past_year_paper;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class resultdatails extends Fragment {
    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,cardView9;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_resultdatails, container, false);
        cardView1=view.findViewById(R.id.c1);
        cardView2=view.findViewById(R.id.c2);
        cardView3=view.findViewById(R.id.c3);
        cardView4=view.findViewById(R.id.c4);
        cardView5=view.findViewById(R.id.c5);
        cardView6=view.findViewById(R.id.c6);
        cardView7=view.findViewById(R.id.c7);
        cardView8=view.findViewById(R.id.c8);
        cardView9=view.findViewById(R.id.c9);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),selectclass.class);
                intent.putExtra("pass","ok");
                startActivity(intent);
            }
        });
        return  view;
    }
}