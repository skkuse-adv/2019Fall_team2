package com.kakao.auth.helper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

public class StartActivityWrapper {
    private static final String ERROR_MESSAGE = "StartActivityWrapper does not contain any activity or fragment.";
    private Activity activity;
    private Fragment fragment;
    private androidx.fragment.app.Fragment supportFragment;

    public Activity getActivity() {
        return this.activity;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public StartActivityWrapper(Activity activity2) {
        this.activity = activity2;
    }

    public StartActivityWrapper(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public StartActivityWrapper(androidx.fragment.app.Fragment fragment2) {
        this.supportFragment = fragment2;
    }

    public void startActivity(Intent intent) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivity(intent);
            return;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            fragment2.startActivity(intent);
            return;
        }
        androidx.fragment.app.Fragment fragment3 = this.supportFragment;
        if (fragment3 != null) {
            fragment3.startActivity(intent);
            return;
        }
        throw new IllegalStateException(ERROR_MESSAGE);
    }

    public void startActivityForResult(Intent intent, int i) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.startActivityForResult(intent, i);
            return;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            fragment2.startActivityForResult(intent, i);
            return;
        }
        androidx.fragment.app.Fragment fragment3 = this.supportFragment;
        if (fragment3 != null) {
            fragment3.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalStateException(ERROR_MESSAGE);
    }

    public Context getContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            return fragment2.getActivity();
        }
        androidx.fragment.app.Fragment fragment3 = this.supportFragment;
        if (fragment3 != null) {
            return fragment3.getActivity();
        }
        throw new IllegalStateException(ERROR_MESSAGE);
    }
}
