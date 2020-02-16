package com.machamasisuraj.socialapp.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.machamasisuraj.socialapp.BLL.ReservationBLL;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Model.Reservation;
import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Sensors.LightSensor;
import com.machamasisuraj.socialapp.Sensors.ProximitySensor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TripDetailActvity extends AppCompatActivity {
      private TextView tripName,country,destination,duration,
            arrivalDate,departuredate,itenerary,tripdays,desc,price,
            grade;
    private Button btnReserve;
    private ImageView tripImage;
    private EditText pickupaddress,travellerCount,adult,childCounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail_actvity);
        bindControls();
        //sensorinint
        SensorInit();

    }

    public void SensorInit() {

        LightSensor lightSensor= new LightSensor(this);
        lightSensor.getLightInstance();
        ProximitySensor proximitySensor= new ProximitySensor(this);
        proximitySensor.ProximitySensor();

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

        pickupaddress= findViewById(R.id.pickupaddress);
        travellerCount= findViewById(R.id.travellerCount);
        adult= findViewById(R.id.adult);
        childCounts= findViewById(R.id.childCounts);
        grade= findViewById(R.id.grade);




        BaseUrl.tripId=getIntent().getStringExtra("id");
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
        grade.setText(getIntent().getStringExtra("grade"));

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();

                Toast.makeText(TripDetailActvity.this, "Reserved", Toast.LENGTH_SHORT).show();
                Reservation reservation = new Reservation(new Date(),new Date(),new Date()
                        ,Integer.parseInt(tripdays.getText().toString()),Integer.parseInt(adult.getText().toString())
                        , Integer.parseInt(childCounts.getText().toString()),
                        pickupaddress.getText().toString(),"Travel And Trek Hotel",
                        "Standard",BaseUrl.tripId, BaseUrl.UserId,2000);
                ReservationBLL reservationBLL= new ReservationBLL();
                reservationBLL.InsertReservation(reservation);
            }
        });
    }
    public void Validation(){
      //  pickupaddress,travellerCount,adult,childCounts;
        if(TextUtils.isEmpty(pickupaddress.getText().toString())){
            Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(travellerCount.getText().toString())){
            Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return;

        } else if(TextUtils.isEmpty(adult.getText().toString())){
            Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return;

        }
        else if(TextUtils.isEmpty(childCounts.getText().toString())){
            Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return;

        }


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

}
