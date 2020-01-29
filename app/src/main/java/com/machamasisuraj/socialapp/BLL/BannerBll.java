package com.machamasisuraj.socialapp.BLL;


import com.machamasisuraj.socialapp.Api.RetrofitCaller;
import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.StrictMode.StrictModeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerBll {
    List<BannerItem> lstBanners =  new ArrayList<>();
    BannerImageApi bannerImageApi = RetrofitCaller.getInstance().create(BannerImageApi.class);
    boolean status = false;

    public List<BannerItem> getAllBanners() {
        StrictModeClass.StrictMode();
        Call<List<BannerItem>> apicaller = bannerImageApi.getAllBanners();
        try {
            lstBanners = apicaller.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstBanners;

    }

    public boolean InsertBanner(BannerItem bannerItem) {
        Call<Void> bannerCaller = bannerImageApi.insertBanner(bannerItem);
        bannerCaller.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    status = true;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                status = false;
            }
        });
        return status;
    }

}
