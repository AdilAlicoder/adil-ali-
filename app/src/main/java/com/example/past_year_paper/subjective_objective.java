package com.example.past_year_paper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import org.w3c.dom.Text;

public class subjective_objective extends AppCompatActivity {
    CardView cardView1,cardView2;
    String board,book,classes,son;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjective_objective);
        cardView1=findViewById(R.id.obj);
        cardView2=findViewById(R.id.sub);
        imageButton=findViewById(R.id.backbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        board=intent.getStringExtra("board");
        book=intent.getStringExtra("book");
        classes=intent.getStringExtra("class");
        son=intent.getStringExtra("son");
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),showimage.class);
                intent.putExtra("obj","objective");
                intent.putExtra("board",board);
                intent.putExtra("book",book);
                intent.putExtra("class",classes);
                intent.putExtra("son",son);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),showimage.class);
                intent.putExtra("obj","subjective");
                intent.putExtra("board",board);
                intent.putExtra("book",book);
                intent.putExtra("class",classes);
                intent.putExtra("son",son);
                startActivity(intent);
            }
        });
    }
}