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

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.machamasisuraj.socialapp.Adapter.BookingAdapter;
import com.machamasisuraj.socialapp.Adapter.UserListAdapter;
import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Fragments.BookingFragment;
import com.machamasisuraj.socialapp.Fragments.TripListFragment;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Sensors.LightSensor;
import com.machamasisuraj.socialapp.Sensors.ProximitySensor;
import com.machamasisuraj.socialapp.Sensors.ShakeDetector;
import com.machamasisuraj.socialapp.Utilities.NotificationViewer;

public class BottomNavbarActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private BottomNavigationView bottomnavigation;
    static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;
    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;



    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.unregisterListener(mShakeDetector);
    }



    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);
        TextView tokendisplay = findViewById(R.id.tokendisplay);
        tokendisplay.setText(getIntent().getExtras().getString("token"));
        bottomnavigation = findViewById(R.id.bottomnavigation);
        bottomnavigation.setSelectedItemId(R.id.homego);

        //display notification
        NotificationViewer notificationViewer= new NotificationViewer(this,"New Exotic Places Nearby","Tap to View");
        notificationViewer.PopupDisplayNotification();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TripListFragment firstFragment = new TripListFragment(this);
        fragmentTransaction.replace(R.id.frame_container, firstFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
       //sensor
        SensorInit();
        //drawer navigation
        navigations();
        //bottom navigation
        BottomNavitaionMenus();
        //chat head on the top of the layout
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
                if (item.getItemId() == R.id.logout)
                {
                    BaseUrl.UserId="";
                    BaseUrl.token="";
                    startActivity(new Intent(BottomNavbarActivity.this,LoginActivity.class));
                }
                return true;

            }
        });
    }

    public void PopulatatChatHead() {
        RecyclerView recyclerView = findViewById(R.id.userchatRecyclerView);

        //make sute to use active users
        try {
            UserBLL userBLL = new UserBLL();
            final UserListAdapter userListAdapter = new UserListAdapter(this, userBLL.GetAllActiveUsers());

            recyclerView.setAdapter(userListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
                @Override
                public void onShake() {
                        userListAdapter.notifyDataSetChanged();
                }
            });
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void BottomNavitaionMenus() {

        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.homego) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    TripListFragment firstFragment = new TripListFragment(BottomNavbarActivity.this);
                    fragmentTransaction.replace(R.id.frame_container, firstFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(BottomNavbarActivity.this, "qqqqq", Toast.LENGTH_SHORT).show();
                } else if (menuItem.getItemId() == R.id.bookings) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    BookingFragment bookingFragment = new BookingFragment(BottomNavbarActivity.this);
                    fragmentTransaction.replace(R.id.frame_container, bookingFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                } else if (menuItem.getItemId() == R.id.navigation_nearby) {
                    Toast.makeText(BottomNavbarActivity.this, "Nearby", Toast.LENGTH_SHORT).show();

                } else if (menuItem.getItemId() == R.id.navigation_aboutus) {
                    Toast.makeText(BottomNavbarActivity.this, "Abot us page", Toast.LENGTH_SHORT).show();

                } else if (menuItem.getItemId() == R.id.navigation_trips) {

                    startActivity(new Intent(BottomNavbarActivity.this, MapsActivity.class));

                }
                return true;
            }
        });


    }

    public void SensorInit() {

        LightSensor lightSensor= new LightSensor(this);
        lightSensor.getLightInstance();
        ProximitySensor proximitySensor= new ProximitySensor(this);
        proximitySensor.ProximitySensor();

    }

}

