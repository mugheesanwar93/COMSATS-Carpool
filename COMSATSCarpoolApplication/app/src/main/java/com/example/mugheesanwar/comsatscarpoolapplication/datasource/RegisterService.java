package com.example.mugheesanwar.comsatscarpoolapplication.datasource;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.mugheesanwar.comsatscarpoolapplication.ApplicationController;
import com.example.mugheesanwar.comsatscarpoolapplication.Constants;
import com.example.mugheesanwar.comsatscarpoolapplication.GsonRequest;
import com.example.mugheesanwar.comsatscarpoolapplication.pojo.RegisterResponse;
import com.example.mugheesanwar.comsatscarpoolapplication.pojo.SigninResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mugheesanwar on 20/09/15.
 */
public class RegisterService extends BaseDataSource {
    private RegisterResponse response;

    public RegisterResponse getResponse() {
        return response;
    }


    public void Register(String name, String username, String password, String age) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("age", age);//first token in services and second value of username, mapped = JSON


        RequestQueue requestQueue = ApplicationController.getInstance()
                .getRequestQueue();

        GsonRequest<RegisterResponse> request = new GsonRequest<RegisterResponse>(
                com.android.volley.Request.Method.POST, Constants.url + "Register.php?",
                RegisterResponse.class, params, successListener(),
                errorListener());
        requestQueue.add(request);
    }

    private Response.Listener<RegisterResponse> successListener() {
        return new Response.Listener<RegisterResponse>() {
            @Override
            public void onResponse(RegisterResponse response) {
                try {
                    RegisterService.this.response = response;
                } catch (Exception e) {
                    RegisterService.this.response = new RegisterResponse();
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
                RegisterService.this.response = new RegisterResponse();
                triggerObservers();
            }
        };
    }
}