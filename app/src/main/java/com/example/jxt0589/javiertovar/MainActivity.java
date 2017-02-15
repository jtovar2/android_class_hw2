package com.example.jxt0589.javiertovar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity {


    private ImageButton bt1;
    private ImageButton bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inititialView();
        initialListener();




    }

    private void inititialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);

    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toActivity(ViewPagerActivity.class);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                toActivity(ListViewActivity.class);
            }
        });


    }

    public void onClick(View v) {

        //Toast.makeText(v.getContext(), "Button2 was clicked", Toast.LENGTH_SHORT).show();
        toastLong("button was clicked");
        Log.d("ayeeyeyeyeyeye", "Falcons lost");
    }
}
