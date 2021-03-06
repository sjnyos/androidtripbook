package com.machamasisuraj.socialapp.Model.Response;

import com.machamasisuraj.socialapp.Model.User;

public class LoginAndSignUpResponse {

    private String status;
    private String token;
    private User user;
    public LoginAndSignUpResponse(String status, String token, User user) {
        this.status = status;
        this.token = token;
        this.user= user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
