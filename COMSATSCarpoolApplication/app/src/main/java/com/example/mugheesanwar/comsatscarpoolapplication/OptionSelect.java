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

public class OptionSelect extends Activity implements View.OnClickListener {

    Button bPostad, bSearchad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_select);
        bPostad = (Button) findViewById(R.id.bPostad);
        bSearchad = (Button) findViewById(R.id.bSearchad);

        bPostad.setOnClickListener(this);
        bSearchad.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bPostad:
                startActivity(new Intent(this,Form.class));
                break;

            case R.id.bSearchad:
                startActivity(new Intent(this,Form.class));
                break;

        }
    }

}
