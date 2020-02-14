package com.machamasisuraj.socialapp.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TripDetailActvity extends AppCompatActivity {
    private Context mContext;
    private TextView tripName,country,destination,duration,
            arrivalDate,departuredate,itenerary,tripdays,desc,
            grade;
    private Button btnReserve;
    private ImageView tripImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail_actvity);
        bindControls();

    }

    public void bindControls(){
        tripName = findViewById(R.id.tripName);
        country= findViewById(R.id.country);
        destination=findViewById(R.id.destination);
        duration= findViewById(R.id.duration);
        arrivalDate= findViewById(R.id.arrivalDate);
        departuredate=findViewById(R.id.departuredate);
        itenerary= findViewById(R.id.itenerary);
        tripdays= findViewById(R.id.tripdays);
        desc=findViewById(R.id.desc);

        tripName.setText(  getIntent().getStringExtra("name"));
        country.setText( getIntent().getStringExtra("country"));
        destination.setText( getIntent().getStringExtra("destination"));
        duration.setText( getIntent().getStringExtra("duration"));
        arrivalDate.setText(getIntent().getStringExtra("arrivalDate"));
        departuredate.setText(getIntent().getStringExtra("departureDate"));
        itenerary.setText(  getIntent().getStringExtra("itenerary"));
        tripdays.setText(getIntent().getStringExtra("tripdays"));
        desc.setText( getIntent().getStringExtra("desc"));
    }

//    public Trip initTripObject() {
//        Date arrivalDate = new Date();
//        try {
//            arrivalDate = new SimpleDateFormat("dd/MM/yyyy").parse();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date departureDate = new Date();
//        try {
//            departureDate = new SimpleDateFormat("dd/MM/yyyy").parse(getIntent().getStringExtra("arrivaldate"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Trip trip = new Trip(
//              ,
//               ,
//               ,
//              ,
//                getIntent().getStringExtra("food"),
//                getIntent().getStringExtra("maproute"),
//                getIntent().getStringExtra("image"),
//               ,
//                getIntent().getStringExtra("grade"),
//                Integer.parseInt(),
//                Integer.parseInt(),
//                Integer.parseInt(getIntent().getStringExtra("size")),
//                arrivalDate,
//                departureDate,
//                Float.parseFloat(getIntent().getStringExtra("price")),
//                Boolean.parseBoolean(getIntent().getStringExtra("receiveTransportation"))
//
//        );
//        return  trip;
//
//    }
}
