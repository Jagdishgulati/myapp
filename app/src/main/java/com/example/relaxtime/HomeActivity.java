package com.example.relaxtime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.relaxtime.Fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    Fragment homeFragment;

    @Override
    protected void  onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeFragment=new HomeFragment();
        loadFragment(homeFragment);
        getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this,R.color.white));
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_container,homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
