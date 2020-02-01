package com.machamasisuraj.socialapp.GUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.machamasisuraj.socialapp.Adapter.UserListAdapter;
import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.R;

public class BottomNavbarActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TripListFragment firstFragment = new TripListFragment(this);
        fragmentTransaction.replace(R.id.frame_container,firstFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        navigations();
        PopulatatChatHead();
    }

    public void navigations(){
        dl = findViewById(R.id.bottomactivityDrawerlayout);
        t = new ActionBarDrawerToggle(this, dl,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                dl.closeDrawer(GravityCompat.START);
                if(item.getItemId()==R.id.navigation_aboutus){
                }
                return false;

            }
        });
    }

    public void PopulatatChatHead(){
       RecyclerView  recyclerView= findViewById(R.id.userchatRecyclerView);

      //make sute to use active users
        try {
            UserBLL userBLL = new UserBLL();
            UserListAdapter userListAdapter = new UserListAdapter(this, userBLL.GetAllActiveUsers());

            recyclerView.setAdapter(userListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
