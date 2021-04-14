package com.example.squashapp_test;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    VideoView videoView;
    int videoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView=findViewById(R.id.videoView);

        videoPosition=getIntent().getIntExtra("POSITION",0);
        if (videoPosition==0||videoPosition==3)
        {
            Uri videoUri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_video_one);
            videoView.setVideoURI(videoUri);
            videoView.start();
        }

        if (videoPosition==1||videoPosition==4)
        {
            Uri videoUri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_video_two);
            videoView.setVideoURI(videoUri);
            videoView.start();
        }

        if (videoPosition==2||videoPosition==5)
        {
            Uri videoUri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_video_three);
            videoView.setVideoURI(videoUri);
            videoView.start();
        }

    }
}