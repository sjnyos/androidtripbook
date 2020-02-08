package com.machamasisuraj.socialapp.ApiService;

import com.machamasisuraj.socialapp.Model.User;
import com.machamasisuraj.socialapp.Model.Response.ImageResponse;
import com.machamasisuraj.socialapp.Model.Response.LoginAndSignUpResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {

    @POST("/users/signup")
    Call<LoginAndSignUpResponse> registerUser(@Body User users);

//    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    //@Header("Authorization") String auth
    @POST("/users/login")
    Call<LoginAndSignUpResponse> checkUser(@Body User user);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("/users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

    @GET("/users/active")
    Call<List<User>> getActiveUserLists();

}