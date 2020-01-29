package com.machamasisuraj.socialapp.Api;

import com.machamasisuraj.socialapp.Model.Trip;
import com.machamasisuraj.socialapp.Model.User;
import com.machamasisuraj.socialapp.Response.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TripApi {

    @POST("/trip")
    Call<Trip> createTrip(@Body Trip trip);

    @GET("/trip")
    Call<List<Trip>> lIstTrip();

    @GET("/trip/{id}")
    Call<Trip> getByID(@Path("id") String id);

    @PUT("/trip/{id}")
    Call<Trip> updateTrip(@Path("id") String id, @Body Trip  trip);

    @DELETE("/trip/{id}")
    Call<Trip> deleteTrip(@Path("id") String id);



}
