package com.example.past_year_paper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class videoplay extends AppCompatActivity {
ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);
        imageButton=findViewById(R.id.backbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        YouTubePlayerView youTubePlayerView1 = findViewById(R.id.youtube_player_view1);
        getLifecycle().addObserver(youTubePlayerView1);
        YouTubePlayerView youTubePlayerView2 = findViewById(R.id.youtube_player_view2);
        getLifecycle().addObserver(youTubePlayerView2);
        YouTubePlayerView youTubePlayerView3 = findViewById(R.id.youtube_player_view3);
        getLifecycle().addObserver(youTubePlayerView3);
        YouTubePlayerView youTubePlayerView4 = findViewById(R.id.youtube_player_view4);
        getLifecycle().addObserver(youTubePlayerView4);
        YouTubePlayerView youTubePlayerView5 = findViewById(R.id.youtube_player_view5);
        getLifecycle().addObserver(youTubePlayerView5);
        YouTubePlayerView youTubePlayerView6 = findViewById(R.id.youtube_player_view6);
        getLifecycle().addObserver(youTubePlayerView6);
    }
}