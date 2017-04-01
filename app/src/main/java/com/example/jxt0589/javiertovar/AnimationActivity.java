package com.example.jxt0589.javiertovar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {

    @OnClick(R.id.bt_animation_alpha)
    public void alpha()
    {
        textView.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.bt_animation_set)
    public void set()
    {
        textView.startAnimation(setAnimation);
    }
    @OnClick(R.id.bt_animation_trans)
    public void trans()
    {
        textView.startAnimation(transAnimation);
    }
    @OnClick(R.id.bt_animation_rotate)
    public void rotate()
    {
        textView.startAnimation(rotateAnimation);
    }
    @OnClick(R.id.bt_animation_scale)
    public void scale()
    {
        textView.startAnimation(scaleAnimation);
    }

    @BindView(R.id.animation_text_view)
    TextView textView;
    Animation alphaAnimation;
    Animation setAnimation;
    Animation transAnimation;
    Animation rotateAnimation;
    Animation scaleAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initAnimation();
    }


    private void initAnimation()
    {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.set);
        transAnimation= AnimationUtils.loadAnimation(this, R.anim.trans);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
    }
}
