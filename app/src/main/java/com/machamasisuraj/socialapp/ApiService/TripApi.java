package com.machamasisuraj.socialapp.ApiService;

import com.machamasisuraj.socialapp.Model.Trip;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TripApi {

    @POST("/trip")
    Call<Trip> createTrip(@Body Trip trip,@Header("Authorization") String authHeader);

    @GET("/trip")
    Call<List<Trip>> lIstTrip(@Header("Authorization") String authHeader);

    @GET("/trip/{id}")
    Call<Trip> getByID(@Path("id") String id,@Header("Authorization") String authHeader);

    @PUT("/trip/{id}")
    Call<Trip> updateTrip(@Path("id") String id, @Body Trip  trip,@Header("Authorization") String authHeader);

    @DELETE("/trip/{id}")
    Call<Trip> deleteTrip(@Path("id") String id,@Header("Authorization") String authHeader);



}
