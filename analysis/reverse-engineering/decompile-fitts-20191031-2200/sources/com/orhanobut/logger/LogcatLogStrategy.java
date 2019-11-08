package com.orhanobut.logger;

import android.util.Log;

public class LogcatLogStrategy implements LogStrategy {
    public void log(int i, String str, String str2) {
        Log.println(i, str, str2);
    }
}
