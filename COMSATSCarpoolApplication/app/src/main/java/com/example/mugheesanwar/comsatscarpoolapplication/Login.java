package com.example.mugheesanwar.comsatscarpoolapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mugheesanwar.comsatscarpoolapplication.datasource.SigninService;
import com.example.mugheesanwar.comsatscarpoolapplication.pojo.SigninResponse;
import com.example.mugheesanwar.comsatscarpoolapplication.pojo.UserModel;

import java.util.Observable;
import java.util.Observer;

public class Login extends Activity implements View.OnClickListener, Observer {
    Button bLogin;
    EditText etUsername, etPassword;

    UserLocalStore userLocalStore;
    SigninService signinService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        signinService = new SigninService();
        signinService.addObserver(this); //observer added

        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bLogin:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                signinService.Signin(username, password);
                break;
        }
    }

    private void logUserIn(User returnedUser) {
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true); //will be needed to store data

        startActivity(new Intent(this, Testing.class));
    }

    @Override
    public void update(Observable observable, Object data) {
        if (observable == signinService) {
            if (signinService.getResponse().getStatus().compareTo("200") == 0) {  //string comparing with server for response
                UserModel user = signinService.getResponse().getUser();
                user.getUsername();
                Toast.makeText(this, user.getUsername(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,DesignationSelect.class));
            } else {
                Toast.makeText(this, signinService.getResponse().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        signinService.deleteObserver(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        signinService.deleteObserver(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        signinService.addObserver(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        signinService.addObserver(this);
    }
}
