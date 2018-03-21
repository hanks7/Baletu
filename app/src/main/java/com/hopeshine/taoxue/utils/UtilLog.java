package com.hopeshine.taoxue.utils;

import android.util.Log;

import com.google.gson.Gson;


/**
 * Created by CC on 2016/6/4.
 */

public class UtilLog {
    private static final String TAG = "-CC-";

    public static void D(String msg) {
        Log.d(TAG, String.valueOf(msg));
    }

    public static void V(String msg) {
        Log.v(TAG, String.valueOf(msg));
    }

    public static void I(String msg) {
        Log.i(TAG, String.valueOf(msg));
    }

    public static void i(Object str, Object msg) {
        Log.i(TAG + str, "  " + msg);
    }

    public static void i(Object msg) {
        Log.i(TAG + "hj", "  " + msg);
    }

    public static void E(String msg) {
        Log.e(TAG, String.valueOf(msg));
    }

    public static String objToString(Object object) {
        return new Gson().toJson(object);
    }

}
