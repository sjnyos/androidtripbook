package com.machamasisuraj.socialapp.BLL;


import com.machamasisuraj.socialapp.ApiService.BannerImageApi;
import com.machamasisuraj.socialapp.ApiService.RetrofitCaller;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.EnableStrictMode.StrictModeClass;

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
        Call<List<BannerItem>> apicaller = bannerImageApi.lstsBanners(BaseUrl.token);
        try {
            lstBanners = apicaller.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstBanners;

    }

    public boolean InsertBanner(BannerItem bannerItem) {
        Call<BannerItem> bannerCaller = bannerImageApi.createBanner(bannerItem,BaseUrl.token);
        bannerCaller.enqueue(new Callback<BannerItem>() {
            @Override
            public void onResponse(Call<BannerItem> call, Response<BannerItem> response) {
                if (response.isSuccessful()) {
                    status = true;
                }
            }

            @Override
            public void onFailure(Call<BannerItem> call, Throwable t) {
                status = false;
            }
        });
        return status;
    }

}
