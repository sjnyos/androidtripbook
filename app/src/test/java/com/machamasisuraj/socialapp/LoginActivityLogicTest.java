package com.machamasisuraj.socialapp;

import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.Model.Response.LoginAndSignUpResponse;
import com.machamasisuraj.socialapp.Model.User;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LoginActivityLogicTest {
    @Test
    public void checkUse() throws  Exception
    {
        UserBLL userBLL = new UserBLL();
        boolean expectedResult=userBLL.checkUser("jaruss", "jaruss");
        boolean actualResult =true;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void GetAllActiveUsers() throws  Exception
    {
        UserBLL userBLL = new UserBLL();
        List<User> list=userBLL.GetAllActiveUsers();
        int expectedResult = list.size();
        assertEquals(expectedResult>0,true);
    }
}
