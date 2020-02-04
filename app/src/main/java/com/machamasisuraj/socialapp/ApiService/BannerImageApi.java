package com.machamasisuraj.socialapp.ApiService;

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

public interface BannerImageApi {

    @POST("/banner")
    Call<BannerItem> createBanner(@Body BannerItem bannerItem);

    @GET("/banner/list")
    Call<List<BannerItem>> lstsBanners();

    @GET("/banner/{id}")
    Call<BannerItem> getByID(@Path("id") String id);

    @PUT("/banner/{id}")
    Call<BannerItem> updateBannerItem(@Path("id") String id, @Body BannerItem  banneritem);

    @DELETE("/banner/{id}")
    Call<BannerItem> deleteBanner(@Path("id") String id);

}
