package com.login_signup.controller;

import com.login_signup.doa.SignupDao;
import com.login_signup.model.Signup;

public class SignupController {

    SignupDao signupDao = new SignupDao();

public   boolean signup(Signup signup){
    return signupDao.signup(signup);
}

public Signup login(String email, String password){
    return signupDao.login(email, password);
}



}
