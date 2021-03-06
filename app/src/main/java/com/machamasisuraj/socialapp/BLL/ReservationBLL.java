package com.machamasisuraj.socialapp.BLL;

import com.machamasisuraj.socialapp.ApiService.ReservationAPI;
import com.machamasisuraj.socialapp.ApiService.RetrofitCaller;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Model.Reservation;
import com.machamasisuraj.socialapp.EnableStrictMode.StrictModeClass;
import com.machamasisuraj.socialapp.Model.ShowReservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationBLL {

    private List<Reservation> mlists = new ArrayList<>();
    private List<ShowReservation> showReservationsList = new ArrayList<>();
    ReservationAPI reservationAPI = RetrofitCaller.getInstance().create(ReservationAPI.class);
    Boolean status = false;
    public List<ShowReservation> getReservationByUser(String userid){
        StrictModeClass.StrictMode();
        Call<List<ShowReservation>> apiCall = reservationAPI.getByUserid(userid, BaseUrl.token);
        try {
            showReservationsList = apiCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return showReservationsList;
    }
    public Boolean InsertReservation(Reservation reservation){
        Call<Reservation> reservationCall = reservationAPI.create(reservation,BaseUrl.token);
        reservationCall.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                if(response.isSuccessful()){
                    status = true;
                }
            }
            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                status=false;
            }

        });
        return status;
    }

    public boolean DeleteReservation(String Id){
        Call<Reservation> reservationCall = reservationAPI.delete(Id,BaseUrl.token);
        reservationCall.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                if(response.isSuccessful()){
                    status=true;
                }
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                status=false;

            }
        });
        return  status;
    }




}
