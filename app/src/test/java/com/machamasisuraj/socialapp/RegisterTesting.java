package com.machamasisuraj.socialapp;

import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.Model.User;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RegisterTesting {

    @Test
    public void registeUser() throws  Exception
    {
        UserBLL userBLL = new UserBLL();
        boolean expectedResult=userBLL.checkUser("suraj1", "suraj1");
        boolean actualResult =true;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void saveImageOnly(){

    }
}
