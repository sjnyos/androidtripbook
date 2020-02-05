package com.machamasisuraj.socialapp.GUI;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.machamasisuraj.socialapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TripListFragment extends Fragment {

private Context mContext;
private RecyclerView recycle_tripList;
    public TripListFragment(Context mContext) {
      this.mContext=mContext;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trip_list, container, false);
        recycle_tripList= view.findViewById(R.id.trip_recycler_view);

    }

}
