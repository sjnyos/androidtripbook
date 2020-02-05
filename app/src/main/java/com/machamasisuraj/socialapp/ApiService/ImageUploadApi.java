package com.machamasisuraj.socialapp.ApiService;

import com.machamasisuraj.socialapp.Model.Response.ImageResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ImageUploadApi {

    @Multipart
    @POST("uploads")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

}
