package com.example.jxt0589.javiertovar.util;

import android.util.Log;

/**
 * Created by JXT0589 on 2/6/17.
 */

public class UtilLog {

    private  static boolean DEBUG = false;


    public static void setDEBUG(boolean b)
    {
        DEBUG = b;
    }
    public static void logD(String key, String value)
    {
        if(DEBUG) {
            Log.d(key, value);

        }
    }
}
