package com.example.relaxtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MattressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mattress);
        String type = getIntent().getStringExtra("type");
        Toast.makeText(this, ""+type, Toast.LENGTH_SHORT).show();
    }
}