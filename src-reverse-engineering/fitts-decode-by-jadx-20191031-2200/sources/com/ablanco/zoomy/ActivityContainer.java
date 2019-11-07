package com.ablanco.zoomy;

import android.app.Activity;
import android.view.ViewGroup;

public class ActivityContainer implements TargetContainer {
    private Activity mActivity;

    ActivityContainer(Activity activity) {
        this.mActivity = activity;
    }

    public ViewGroup getDecorView() {
        return (ViewGroup) this.mActivity.getWindow().getDecorView();
    }
}
