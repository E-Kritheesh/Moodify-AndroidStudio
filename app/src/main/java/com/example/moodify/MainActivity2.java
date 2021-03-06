package com.example.moodify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private static int SPLASH_SCREEN= 10000;

    Animation top_anim, bottom_anim;
    ImageView img1,img2;
    TextView t;
    ConstraintLayout c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        top_anim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_anim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img1=findViewById(R.id.imageView);
        img2=findViewById(R.id.imageView2);
        t=findViewById(R.id.textView);
        c=findViewById(R.id.bg);

        img1.setAnimation(top_anim);
        img2.setAnimation(top_anim);
        c.setAnimation(top_anim);
        t.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}