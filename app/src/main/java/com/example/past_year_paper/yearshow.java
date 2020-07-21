package com.example.past_year_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class yearshow extends AppCompatActivity {
    List<recadaptar> listData;
    RecyclerView recyclerView;
    recgetdata getuser;
    String userbook;
    ImageButton imageButton;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearshow);
        recyclerView = findViewById(R.id.rec);
        Intent intent=getIntent();
        userbook=intent.getStringExtra("click");
        listData=new ArrayList<>();
        imageButton=findViewById(R.id.backbtn);
        getuser=new recgetdata(getApplicationContext(),listData,userbook);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        databaseReference= FirebaseDatabase.getInstance().getReference("Board");
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()) {
                    recadaptar rec=dataSnapshot.getValue(recadaptar.class);
                    listData.add(rec);
                }
                recyclerView.setAdapter(getuser);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}