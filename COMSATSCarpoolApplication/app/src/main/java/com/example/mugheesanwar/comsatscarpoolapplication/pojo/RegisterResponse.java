package com.example.mugheesanwar.comsatscarpoolapplication.pojo;

/**
 * Created by mugheesanwar on 29/09/15.
 */
public class RegisterResponse extends BaseResponse {
    private UserModel data = new UserModel();

    public void setUser(UserModel data) {
        this.data = data;
    }

    public UserModel getUser() {
        return data;
    }
}
