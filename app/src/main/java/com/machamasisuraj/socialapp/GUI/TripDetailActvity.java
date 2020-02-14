package com.machamasisuraj.socialapp.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.machamasisuraj.socialapp.BLL.ReservationBLL;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Model.Reservation;
import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TripDetailActvity extends AppCompatActivity {
    private Context mContext;
    private TextView tripName,country,destination,duration,
            arrivalDate,departuredate,itenerary,tripdays,desc,price,
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
        price = findViewById(R.id.price);
        btnReserve= findViewById(R.id.btnReserve);

        BaseUrl.tripId=getIntent().getStringExtra("id");
        Toast.makeText(TripDetailActvity.this,BaseUrl.tripId, Toast.LENGTH_SHORT).show();
        Toast.makeText(TripDetailActvity.this,BaseUrl.UserId+ "User id", Toast.LENGTH_SHORT).show();
        tripName.setText(  getIntent().getStringExtra("name"));
        country.setText( getIntent().getStringExtra("country"));
        destination.setText( getIntent().getStringExtra("destination"));
        duration.setText( getIntent().getStringExtra("duration"));
        arrivalDate.setText(convertMongoDate(new Date().toString()));
        departuredate.setText(convertMongoDate(new Date().toString()));
        itenerary.setText(  getIntent().getStringExtra("itenerary"));
        tripdays.setText(getIntent().getStringExtra("tripdays"));
        desc.setText( getIntent().getStringExtra("desc")) ;
        price.setText( getIntent().getStringExtra("price"));

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TripDetailActvity.this, "Reserved", Toast.LENGTH_SHORT).show();
                Reservation reservation = new Reservation(new Date(),new Date(),new Date(),12,6,6,
                        "pickup Address","hotels ",
                        "Standard",BaseUrl.tripId, BaseUrl.UserId,2000);
                ReservationBLL reservationBLL= new ReservationBLL();
                reservationBLL.InsertReservation(reservation);
            }
        });
    }



    private static String convertMongoDate(String val) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String finalStr = outputFormat.format(inputFormat.parse(val));
            System.out.println(finalStr);
            return finalStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String convertMongoTime(String val) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");
        try {
            String finalStr = outputFormat.format(inputFormat.parse(val));
            System.out.println(finalStr);
            return finalStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
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
