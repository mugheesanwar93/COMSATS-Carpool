package com.example.mugheesanwar.comsatscarpoolapplication.datasource;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mugheesanwar.comsatscarpoolapplication.ApplicationController;
import com.example.mugheesanwar.comsatscarpoolapplication.Constants;
import com.example.mugheesanwar.comsatscarpoolapplication.GsonRequest;
import com.example.mugheesanwar.comsatscarpoolapplication.R;
import com.example.mugheesanwar.comsatscarpoolapplication.pojo.SigninResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mugheesanwar on 20/09/15.
 */
public class SigninService extends BaseDataSource {
    private SigninResponse response;

    public SigninResponse getResponse() {
        return response;
    }


    public void Signin(String username, String password) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username); //first token in services and second value of username, mapped = JSON
        params.put("password", password);

        RequestQueue requestQueue = ApplicationController.getInstance()
                .getRequestQueue();

        GsonRequest<SigninResponse> request = new GsonRequest<SigninResponse>(
                com.android.volley.Request.Method.POST, Constants.url + "FetchUserData.php?",
                SigninResponse.class, params, successListener(),
                errorListener());
        requestQueue.add(request);
    }

    public void SigninStaff(String rollNo, String password) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("rollNo", rollNo);
        params.put("password", password);

        RequestQueue requestQueue = ApplicationController.getInstance()
                .getRequestQueue();

        GsonRequest<SigninResponse> request = new GsonRequest<SigninResponse>(
                com.android.volley.Request.Method.POST, Constants.url + "FetchUserData.php?",
                SigninResponse.class, params, successListener(),
                errorListener());
        requestQueue.add(request);
    }

    private Response.Listener<SigninResponse> successListener() {
        return new Response.Listener<SigninResponse>() {
            @Override
            public void onResponse(SigninResponse response) {
                try {
                    SigninService.this.response = response;
                } catch (Exception e) {
                    SigninService.this.response = new SigninResponse();
                }
                triggerObservers();
            }

            ;
        };
    }

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                SigninService.this.response = new SigninResponse();
                triggerObservers();
            }
        };
    }
}