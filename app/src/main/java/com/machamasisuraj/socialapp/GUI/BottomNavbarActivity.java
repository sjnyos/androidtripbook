package com.machamasisuraj.socialapp.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.machamasisuraj.socialapp.R;

public class BottomNavbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BannerActivity firstFragment = new BannerActivity(this);
        fragmentTransaction.replace(R.id.frame_container,firstFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}
