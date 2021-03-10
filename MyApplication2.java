package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyApplication2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_application2 );}
        public void wAI(View view) {
            Intent intent=new Intent (MyApplication2.this,MyApplication4.class);
            startActivity (intent);


    }


    }