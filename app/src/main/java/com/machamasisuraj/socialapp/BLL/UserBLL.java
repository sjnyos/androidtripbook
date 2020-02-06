package com.machamasisuraj.socialapp.BLL;

import com.machamasisuraj.socialapp.ApiService.BannerImageApi;
import com.machamasisuraj.socialapp.ApiService.RetrofitCaller;
import com.machamasisuraj.socialapp.ApiService.UsersAPI;
import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.Model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class UserBLL {

    List<User> lstUsers;
    UsersAPI userApi;
    boolean status;

    public UserBLL(){
        lstUsers=  new ArrayList<>();
        userApi= RetrofitCaller.getInstance().create(UsersAPI.class);
        status=false;

    }
    public List<User>  GetAllActiveUsers(){
        Call<List<User>> userlists = userApi.getActiveUserLists();
        try {
         lstUsers=   userlists.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstUsers;
    }
}
