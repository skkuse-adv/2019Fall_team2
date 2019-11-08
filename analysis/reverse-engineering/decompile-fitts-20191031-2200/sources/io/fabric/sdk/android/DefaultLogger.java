package io.fabric.sdk.android;

import android.util.Log;

public class DefaultLogger implements Logger {
    private int logLevel;

    public DefaultLogger(int i) {
        this.logLevel = i;
    }

    public DefaultLogger() {
        this.logLevel = 4;
    }

    public boolean isLoggable(String str, int i) {
        return this.logLevel <= i || Log.isLoggable(str, i);
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public void d(String str, String str2, Throwable th) {
        boolean isLoggable = isLoggable(str, 3);
    }

    public void v(String str, String str2, Throwable th) {
        boolean isLoggable = isLoggable(str, 2);
    }

    public void i(String str, String str2, Throwable th) {
        boolean isLoggable = isLoggable(str, 4);
    }

    public void w(String str, String str2, Throwable th) {
        boolean isLoggable = isLoggable(str, 5);
    }

    public void e(String str, String str2, Throwable th) {
        boolean isLoggable = isLoggable(str, 6);
    }

    public void d(String str, String str2) {
        d(str, str2, null);
    }

    public void v(String str, String str2) {
        v(str, str2, null);
    }

    public void i(String str, String str2) {
        i(str, str2, null);
    }

    public void w(String str, String str2) {
        w(str, str2, null);
    }

    public void e(String str, String str2) {
        e(str, str2, null);
    }

    public void log(int i, String str, String str2) {
        log(i, str, str2, false);
    }

    public void log(int i, String str, String str2, boolean z) {
        if (z || isLoggable(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
