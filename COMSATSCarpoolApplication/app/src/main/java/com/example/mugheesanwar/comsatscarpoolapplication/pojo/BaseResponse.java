package com.example.mugheesanwar.comsatscarpoolapplication.pojo;

import com.google.gson.annotations.Expose;

/**
 * Created by mugheesanwar on 20/09/15.
 */
public class BaseResponse {
    @Expose
    private String status;
    @Expose
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
