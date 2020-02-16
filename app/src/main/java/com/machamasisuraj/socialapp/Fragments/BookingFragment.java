package com.machamasisuraj.socialapp.Fragments;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.machamasisuraj.socialapp.Adapter.BookingAdapter;
import com.machamasisuraj.socialapp.Adapter.TripAdapter;
import com.machamasisuraj.socialapp.BLL.ReservationBLL;
import com.machamasisuraj.socialapp.BLL.TripBLL;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Model.ShowReservation;
import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Sensors.ShakeDetector;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {

    private Context mContext;
    private RecyclerView booking_Recycler;
    static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    public BookingFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        booking_Recycler = view.findViewById(R.id.booking_Recycler);


        ReservationBLL reservationBLL = new ReservationBLL();
        List<ShowReservation> list = reservationBLL.getReservationByUser(BaseUrl.UserId);
       final BookingAdapter bookingAdapter = new BookingAdapter(mContext, list);
        booking_Recycler.setAdapter(bookingAdapter);
        booking_Recycler.setLayoutManager(new LinearLayoutManager(mContext));

        mSensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                bookingAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override
    public void onResume() {

        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        super.onResume();

    }

}
