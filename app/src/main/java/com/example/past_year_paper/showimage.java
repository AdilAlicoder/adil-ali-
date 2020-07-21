package com.example.past_year_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class showimage extends AppCompatActivity {
    ImageView imageView;
    String board,book,classes,son,objsub;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showimage);
        imageView=findViewById(R.id.image);
        Intent intent=getIntent();
        book=intent.getStringExtra("board");
        board=intent.getStringExtra("book");
        classes=intent.getStringExtra("class");
        son=intent.getStringExtra("son");
        objsub=intent.getStringExtra("obj");
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Gujranwala").child("9thclass").child("Biology").child(son);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String imglink=snapshot.child(objsub).getValue(String.class);
                Picasso.get().load(imglink).into(imageView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}