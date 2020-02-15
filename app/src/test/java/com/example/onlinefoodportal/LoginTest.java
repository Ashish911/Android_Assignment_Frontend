package com.example.onlinefoodportal;

import com.example.onlinefoodportal.bll.LoginBll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void testLogin(){
        LoginBll loginBll = new LoginBll();
        boolean result = loginBll.checkUser("kkk@kkk.com", "kkk");
        assertEquals(true, result);
    }

    //Login Failed
    @Test
    public void testLoginFailed(){
        LoginBll loginBll = new LoginBll();
        boolean result = loginBll.checkUser("mmm@mmm.com", "mmm");
        assertEquals(true, result);
    }
}
