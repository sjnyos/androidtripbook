package com.machamasisuraj.socialapp.BLL;

import android.util.Log;

import com.machamasisuraj.socialapp.ApiService.RetrofitCaller;
import com.machamasisuraj.socialapp.ApiService.UsersAPI;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.EnableStrictMode.StrictModeClass;
import com.machamasisuraj.socialapp.Model.Response.LoginAndSignUpResponse;
import com.machamasisuraj.socialapp.Model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

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
        Call<List<User>> userlists = userApi.getActiveUserLists(BaseUrl.token);
        try {

                lstUsers= userlists.execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstUsers;
    }

    public boolean checkUser(String username, String password) {
    User user = new User(username,password);
        UsersAPI usersAPI = RetrofitCaller.getInstance().create(UsersAPI.class);
        Call<LoginAndSignUpResponse> usersCall = usersAPI.checkUser(user);
        StrictModeClass.StrictMode();
        try {
            Response<LoginAndSignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                 BaseUrl.token += loginResponse.body().getToken();
                   BaseUrl.UserId=loginResponse.body().getUser().get_id();

                Log.d("token received", "checkUser: "+ BaseUrl.token);
                status = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
}
