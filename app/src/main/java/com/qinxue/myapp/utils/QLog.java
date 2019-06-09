package com.qinxue.myapp.utils;

import android.util.Log;

public class QLog {
    private static boolean isEnable = true;
    private static final String QTAG = "qinxue_";

    public static int i(String tag, String msg) {
        if (isEnable) {
            return Log.i(QTAG + tag, msg);
        }
        return 0;
    }
}