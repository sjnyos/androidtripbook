package com.machamasisuraj.socialapp.ApiService;

import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.Model.Reservation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReservationAPI {

    @POST("/reserve")
    Call<Reservation> create(@Body Reservation reservation,@Header("Authorization") String authHeader);

    @GET("/reserve")
    Call<List<Reservation>> lists(@Header("Authorization") String authHeader);

    @GET("/reserve/{id}")
    Call<Reservation> getByID(@Path("id") String id,@Header("Authorization") String authHeader);

    @GET("/reserve/users/{id}")
    Call<List< Reservation>> getByUserid(@Path("id") String id,@Header("Authorization") String authHeader);

    @PUT("/reserve/{id}")
    Call<Reservation> update(@Path("id") String id, @Body Reservation  reservation,@Header("Authorization") String authHeader);

    @DELETE("/reserve/{id}")
    Call<Reservation> delete(@Path("id") String id,@Header("Authorization") String authHeader);
}
