package com.machamasisuraj.socialapp.BLL;

import android.content.Context;

import com.machamasisuraj.socialapp.Api.ItemApi;
import com.machamasisuraj.socialapp.Api.RetrofitCaller;
import com.machamasisuraj.socialapp.Response.ImageResponse;
import com.machamasisuraj.socialapp.StrictMode.StrictModeClass;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class ImageUploadBll {
    private String imagepath;
    private Context mContext;

    public ImageUploadBll(String imagepath, Context mContext) {
        this.imagepath = imagepath;
        this.mContext = mContext;

    }

    public String uploadFile() {

        File file = new File(imagepath);
        RequestBody requestBody= RequestBody.create(MediaType.parse("multipart/from-data"),file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("imageFile",file.getName(),requestBody);

        ItemApi itemApi= RetrofitCaller.getInstance().create(ItemApi.class);
        Call<ImageResponse> imageResponseCall= itemApi.uploadImage(part);
        StrictModeClass.StrictMode();
        try {
            Response<ImageResponse> imageResponseResponse = imageResponseCall.execute();
               return imageResponseResponse.body().getFilename();

            } catch (IOException e) {
            e.printStackTrace();
                return "Error";
            }
    }


}
