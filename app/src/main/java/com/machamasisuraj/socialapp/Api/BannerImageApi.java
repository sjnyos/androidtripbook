package com.machamasisuraj.socialapp.Api;

import com.machamasisuraj.socialapp.Model.BannerItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BannerImageApi {

    @POST("banner/create")
    Call<Void> insertBanner(@Body BannerItem bannerItem);

    @GET("banner/all")
    Call<List<BannerItem>> getAllBanners();

}
