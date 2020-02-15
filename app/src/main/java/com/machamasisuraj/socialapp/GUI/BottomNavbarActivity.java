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

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.machamasisuraj.socialapp.Adapter.BookingAdapter;
import com.machamasisuraj.socialapp.Adapter.UserListAdapter;
import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.Fragments.BookingFragment;
import com.machamasisuraj.socialapp.Fragments.TripListFragment;
import com.machamasisuraj.socialapp.R;

public class BottomNavbarActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private BottomNavigationView bottomnavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);
        TextView tokendisplay = findViewById(R.id.tokendisplay);
        tokendisplay.setText(getIntent().getExtras().getString("token"));
        bottomnavigation = findViewById(R.id.bottomnavigation);
        bottomnavigation.setSelectedItemId(R.id.navigation_home);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TripListFragment firstFragment = new TripListFragment(this);
        fragmentTransaction.replace(R.id.frame_container, firstFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        navigations();
        BottomNavitaionMenus();
        PopulatatChatHead();
    }

    public void navigations() {
        dl = findViewById(R.id.bottomactivityDrawerlayout);
        t = new ActionBarDrawerToggle(this, dl, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                dl.closeDrawer(GravityCompat.START);
                if (item.getItemId() == R.id.navigation_aboutus) {
                }
                return false;

            }
        });
    }

    public void PopulatatChatHead() {
        RecyclerView recyclerView = findViewById(R.id.userchatRecyclerView);

        //make sute to use active users
        try {
            UserBLL userBLL = new UserBLL();
            UserListAdapter userListAdapter = new UserListAdapter(this, userBLL.GetAllActiveUsers());

            recyclerView.setAdapter(userListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void BottomNavitaionMenus() {

        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home: {

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        TripListFragment firstFragment = new TripListFragment(BottomNavbarActivity.this);
                        fragmentTransaction.replace(R.id.frame_container, firstFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        Toast.makeText(BottomNavbarActivity.this, "qqqqq", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.navigation_trips: {

                        Toast.makeText(BottomNavbarActivity.this, "Navigation Maps", Toast.LENGTH_SHORT).show();

                    }
                    case R.id.bookings: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                         BookingFragment bookingFragment= new BookingFragment(BottomNavbarActivity.this);
                        fragmentTransaction.replace(R.id.frame_container, bookingFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();


                    }
                    case R.id.navigation_nearby: {
                        Toast.makeText(BottomNavbarActivity.this, "Nearby", Toast.LENGTH_SHORT).show();

                    }
                    case R.id.navigation_aboutus: {
                        Toast.makeText(BottomNavbarActivity.this, "Abot us page", Toast.LENGTH_SHORT).show();

                    }
                    default:{ return true;}


                }
            }
        });


    }
}
