package com.machamasisuraj.socialapp.Fragments;


import android.content.Context;
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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {

    private Context mContext;
    private RecyclerView booking_Recycler;

    public BookingFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_booking, container, false);

        booking_Recycler= view.findViewById(R.id.booking_Recycler);


        ReservationBLL reservationBLL= new ReservationBLL();
        List<ShowReservation> list= reservationBLL.getReservationByUser(BaseUrl.UserId);
        BookingAdapter bookingAdapter = new BookingAdapter(mContext,list);
        booking_Recycler.setAdapter(bookingAdapter);
        booking_Recycler.setLayoutManager( new LinearLayoutManager(mContext));
        return view;
    }

}
