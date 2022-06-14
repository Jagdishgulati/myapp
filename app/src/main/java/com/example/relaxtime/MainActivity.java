package com.example.relaxtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.status_bar2));
    }


    public void gotToSignup(View view) {
        Intent intent = new Intent(MainActivity.this,SignupActivity.class);
        startActivity(intent);
    }

    public void gotToHome(View view) {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}