package com.example.past_year_paper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class selectclass extends AppCompatActivity {
    ListView listView;
    ArrayList<getdata> list;
    getadaptar adapter;
    String usersbk;
    ImageButton imageButton;
    String backa;
    String clickt;
    String sactivity;
    CharSequence array[]={"2019","2018","2017","2016","2015","2014"};
    CharSequence arrytwo[]={"Chaptar 1","Chaptar 2","Chaptar 3","Chaptar 4","Chaptar 5","Chaptar 6","Chaptar 7","Chaptar 8"};
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectclass);
        listView=findViewById(R.id.list1);
        list=new ArrayList<>();
        Intent intent=getIntent();
        imageButton=findViewById(R.id.backbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sactivity=intent.getStringExtra("pass");
        usersbk=intent.getStringExtra("sclick");
        backa=intent.getStringExtra("back");
        adapter=new getadaptar(getApplicationContext(),list);
        databaseReference= FirebaseDatabase.getInstance().getReference("class");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    getdata a = dataSnapshot.getValue(getdata.class);
                    list.add(a);
                }
                listView.setAdapter(adapter);
                if (sactivity.equals("ok")) {
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(selectclass.this);
                            builder.setMultiChoiceItems(arrytwo, new boolean[arrytwo.length], new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    if(which==0){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==1){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==2){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==3){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==4){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==5){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==6){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==7){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }
                                    if(which==8){
                                        Intent intent1=new Intent(getApplicationContext(),videoplay.class);
                                        startActivity(intent1);
                                    }

                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
                } else {
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 0) {
                                clickt = "9thclass";
                            }
                            if (position == 1) {
                                clickt = "10thclass";
                            }
                            if (position == 2) {
                                clickt = "11thclass";
                            }
                            if (position == 3) {
                                clickt = "12thclass";
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(selectclass.this);
                            builder.setMultiChoiceItems(array, new boolean[array.length],new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    if (which == 0) {
                                        Intent intent = new Intent(getApplicationContext(), subjective_objective.class);
                                        intent.putExtra("son", "2019");
                                        intent.putExtra("board", backa);
                                        intent.putExtra("book", usersbk);
                                        intent.putExtra("class", clickt);
                                        startActivity(intent);
                                    }
                                    if (which == 1) {
                                        Intent intent = new Intent(getApplicationContext(), subjective_objective.class);
                                        intent.putExtra("son", "2018");
                                        intent.putExtra("board", backa);
                                        intent.putExtra("book", usersbk);
                                        intent.putExtra("class", clickt);
                                        startActivity(intent);
                                    }
                                    if (which == 2) {
                                        Intent intent = new Intent(getApplicationContext(), subjective_objective.class);
                                        intent.putExtra("son", "2017");
                                        intent.putExtra("board", backa);
                                        intent.putExtra("book", usersbk);
                                        intent.putExtra("class", clickt);
                                        startActivity(intent);
                                    }
                                    if (which == 3) {
                                        Intent intent = new Intent(getApplicationContext(), subjective_objective.class);
                                        intent.putExtra("son", "2016");
                                        intent.putExtra("board", backa);
                                        intent.putExtra("book", usersbk);
                                        intent.putExtra("class", clickt);
                                        startActivity(intent);
                                    }
                                    if (which == 4) {
                                        Intent intent = new Intent(getApplicationContext(), subjective_objective.class);
                                        intent.putExtra("son", "2015");
                                        intent.putExtra("board", backa);
                                        intent.putExtra("book", usersbk);
                                        intent.putExtra("class", clickt);
                                        startActivity(intent);
                                    }
                                    if (which == 5) {
                                        Intent intent = new Intent(getApplicationContext(), subjective_objective.class);
                                        intent.putExtra("son", "2014");
                                        intent.putExtra("board", backa);
                                        intent.putExtra("book", usersbk);
                                        intent.putExtra("class", clickt);
                                        startActivity(intent);
                                    }
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}