package com.example.amedfareed.heattransfer;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    public static final int SPLASH_TIME_OUT = 6500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView loadingImage = findViewById(R.id.btn_loading);
        ImageView seldom = findViewById(R.id.seldom_view);

        Animation anim = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.forward_rotate);
        loadingImage.setAnimation(anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
