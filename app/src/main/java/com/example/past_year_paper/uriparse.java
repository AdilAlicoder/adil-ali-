package com.example.past_year_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class uriparse extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uriparse);
        button=findViewById(R.id.btn3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v=qRFVCYwPGGk"));
                startActivity(intent);
            }
        });
    }
}