package com.example.amedfareed.heattransfer;

import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class HeatTransferVideoExplaination extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heat_transfer_video_explaination);
        videoView = findViewById(R.id.video_viewer);
        MediaController mediaController = new MediaController(this);
        String videoUri = "android.resource://" + getPackageName()+"/" + R.raw.ht;
        Uri uri = Uri.parse(videoUri);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
