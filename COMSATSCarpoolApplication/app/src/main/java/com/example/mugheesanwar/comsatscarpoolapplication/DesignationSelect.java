package com.example.mugheesanwar.comsatscarpoolapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignationSelect extends ActionBarActivity implements View.OnClickListener {

    Button bDriver, bPassenger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designation_select);

        bDriver = (Button) findViewById(R.id.bDriver);
        bPassenger = (Button) findViewById(R.id.bPassenger);

        bDriver.setOnClickListener(this);
        bPassenger.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bDriver:
                startActivity(new Intent(this,OptionSelect.class));
                break;

            case R.id.bPassenger:
                startActivity(new Intent(this,OptionSelect.class));
                break;
        }
    }


}
