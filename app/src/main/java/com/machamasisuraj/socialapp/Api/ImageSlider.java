package com.machamasisuraj.socialapp.Api;

import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.Model.Trip;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ImageSlider {

    @POST("/trip")
    Call<BannerItem> createBanner(@Body Trip trip);

    @GET("/trip")
    Call<List<BannerItem>> lstsBanners();

    @GET("/trip/{id}")
    Call<BannerItem> getByID(@Path("id") String id);

    @PUT("/trip/{id}")
    Call<BannerItem> updateBannerItem(@Path("id") String id, @Body Trip  trip);

    @DELETE("/trip/{id}")
    Call<BannerItem> deleteBanner(@Path("id") String id);

}
