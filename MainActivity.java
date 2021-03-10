package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;
    //variable
    Animation topanim,bottomanim;
    ImageView Image;
    TextView Welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //Animation
        topanim = AnimationUtils.loadAnimation( this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation );
//Hooks
        Image=findViewById( R.id.imageView2);
        Welcome=findViewById( R.id.editText3);
        Image.setAnimation(topanim);
        Welcome.setAnimation( bottomanim );
        new Handler(  ).postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( MainActivity.this,MyApplication2.class);
                startActivity(intent);
                finish();
            }
        } ,SPLASH_SCREEN);
    }
}



