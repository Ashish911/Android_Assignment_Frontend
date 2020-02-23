package com.example.onlinefoodportal;

import com.example.onlinefoodportal.bll.SignUpBll;
import com.example.onlinefoodportal.model.Users;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class SignUpTest {
    @Test
    public void SignUpPass(){
        Users users = new Users("xxx","xxx","xxx@xxx.com","1212313","xxx");
        SignUpBll signUpBll = new SignUpBll();
        boolean result = signUpBll.Useradd(users);
        assertEquals(true,result);
    }
}
