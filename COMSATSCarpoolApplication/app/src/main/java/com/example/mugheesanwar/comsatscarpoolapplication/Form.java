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

public class Form extends Activity implements View.OnClickListener {

    Button bPost;
//hello world from mac
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        bPost = (Button) findViewById(R.id.bPost);

        bPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bPost:
                startActivity(new Intent(this,Testing.class));
                break;
        }
    }

}
