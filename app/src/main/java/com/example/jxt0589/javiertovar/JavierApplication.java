package com.example.jxt0589.javiertovar;

import android.app.Application;

import com.example.jxt0589.javiertovar.util.UtilLog;

/**
 * Created by JXT0589 on 2/6/17.
 */

public class JavierApplication extends Application
{
    public void onCreate()
    {
        super.onCreate();
        UtilLog.setDEBUG(true);

    }
}
