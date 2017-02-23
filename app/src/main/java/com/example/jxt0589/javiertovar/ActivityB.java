package com.example.jxt0589.javiertovar;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JXT0589 on 2/22/17.
 */

public class ActivityB extends BaseActivity {

    @BindView(R.id.bt_to_a)
    Button btToA;
    @BindView(R.id.bt_to_b)
    Button btToB;
    @BindView(R.id.bt_to_c)
    Button btToC;
    @BindView(R.id.bt_to_d)
    Button btToD;

    @BindView(R.id.text_for_class_exercise)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);

        textView.setText("B");
    }


    @OnClick(R.id.bt_to_a)
    public void toA(View v)
    {
        toActivity(ActivityA.class);
    }

    @OnClick(R.id.bt_to_b)
    public void toB(View v)
    {
        toActivity(ActivityB.class);
    }

    @OnClick(R.id.bt_to_c)
    public void toC(View v)
    {
        toActivity(ActivityC.class);
    }

    @OnClick(R.id.bt_to_d)
    public void toD(View V)
    {
        toActivity(ActivityD.class);
    }
}
