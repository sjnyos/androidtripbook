package com.machamasisuraj.socialapp.Api;

import com.machamasisuraj.socialapp.Model.Item;
import com.machamasisuraj.socialapp.Response.ImageResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ItemApi {
    @GET("item/all")
    Call<List<Item>> getAllItemsLIst();

    @Multipart
    @POST("uploads")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @POST("item/create")
    Call<Void> insertItem(@Body Item item);


}
