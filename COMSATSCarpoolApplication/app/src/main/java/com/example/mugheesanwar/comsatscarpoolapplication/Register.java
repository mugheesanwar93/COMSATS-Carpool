package com.example.mugheesanwar.comsatscarpoolapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mugheesanwar.comsatscarpoolapplication.datasource.RegisterService;
import com.example.mugheesanwar.comsatscarpoolapplication.pojo.UserModel;

import java.util.Observable;
import java.util.Observer;

public class Register extends Activity implements View.OnClickListener,Observer {

    Button bRegister;
    EditText etName,etAge,etUsername,etPassword;
    RegisterService registerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerService = new RegisterService();


        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bRegister:
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String age = etAge.getText().toString();

                registerService.Register(name, username, password, age);

                break;
        }
    }


    @Override
    public void update(Observable observable, Object data) {
        if(observable==registerService){
            if (registerService.getResponse().getStatus().compareTo("200") == 0) {  //string comparing with server for response
//                UserModel user = registerService.getResponse().getUser();
//                user.getUsername();

 //               Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,DesignationSelect.class));
            } else {
                Toast.makeText(this, registerService.getResponse().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        registerService.deleteObserver(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerService.deleteObserver(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerService.addObserver(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerService.addObserver(this);
    }
}
