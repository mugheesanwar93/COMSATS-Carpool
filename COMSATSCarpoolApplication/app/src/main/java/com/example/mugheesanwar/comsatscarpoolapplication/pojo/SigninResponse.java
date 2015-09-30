package com.example.mugheesanwar.comsatscarpoolapplication.pojo;

/**
 * Created by mugheesanwar on 20/09/15.
 */
public class SigninResponse extends BaseResponse {
    private UserModel data = new UserModel();

    public void setUser(UserModel data) {
        this.data = data;
    }

    public UserModel getUser() {
        return data;
    }
}
