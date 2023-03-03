package com.example.multimediaapk;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Spinner spin;
    private VideoView vdoView;
    private String videoSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.pochita;
        vdoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
        MediaController mediaController =  new MediaController(this);
        vdoView.setMediaController(mediaController);
        mediaController.setAnchorView(vdoView);
    }

    public void pochita(View v){
        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.pochita;
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
    }
    public void die(View v){
        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.die;
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
    }
    public void save(View v){
        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.save;
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
    }
    public void tryme(View v){
        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.hola;
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
    }
    public void earn(View v){
        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.earn;
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
    }
    public void eyes(View v){
        videoSource = "android.resource://"+getPackageName()+"/"+R.raw.eyes;
        Uri uri = Uri.parse(videoSource);
        vdoView.setVideoURI(uri);
    }
}