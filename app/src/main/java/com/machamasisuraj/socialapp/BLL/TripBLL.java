package com.machamasisuraj.socialapp.BLL;

import com.machamasisuraj.socialapp.ApiService.RetrofitCaller;
import com.machamasisuraj.socialapp.ApiService.TripApi;
import com.machamasisuraj.socialapp.EnableStrictMode.StrictModeClass;
import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.Model.Reservation;
import com.machamasisuraj.socialapp.Model.Trip;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripBLL {

    private List<Trip> tripList;
    TripApi tripApi;
    Boolean status;


    public TripBLL(){
         tripApi = RetrofitCaller.getInstance().create(TripApi.class);
         status= false;
    }

    public List<Trip> getTripLists(){
        StrictModeClass.StrictMode();
        Call<List<Trip>> apicaller = tripApi.lIstTrip();
        try {
            tripList = apicaller.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tripList;

    }
    public Boolean CreateTrip( Trip trip){
        Call<Trip> reservationCall = tripApi.createTrip(trip);
        reservationCall.enqueue(new Callback<Trip>() {
            @Override
            public void onResponse(Call<Trip> call, Response<Trip> response) {
                if(response.isSuccessful()){
                    status = true;
                }
            }
            @Override
            public void onFailure(Call<Trip> call, Throwable t) {
                status=false;
            }

        });
        return status;
    }
}
