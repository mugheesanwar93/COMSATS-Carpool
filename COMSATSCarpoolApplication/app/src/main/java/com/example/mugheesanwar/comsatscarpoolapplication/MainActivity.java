package com.example.mugheesanwar.comsatscarpoolapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import junit.framework.Test;

public class MainActivity extends Activity implements View.OnClickListener {

    Button bLogin, bRegister;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bLogin = (Button) findViewById(R.id.bLogin);
        bRegister = (Button) findViewById(R.id.bRegister);

        bLogin.setOnClickListener(this);
        bRegister.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                startActivity(new Intent(this,Login.class));
                break;

            case R.id.bRegister:
                startActivity(new Intent(this,Register.class));
                break;

        }
    }
}
