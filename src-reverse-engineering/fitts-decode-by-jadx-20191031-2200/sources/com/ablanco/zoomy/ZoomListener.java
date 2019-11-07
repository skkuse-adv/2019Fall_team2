package com.ablanco.zoomy;

import android.view.View;

public interface ZoomListener {
    void onViewEndedZooming(View view);

    void onViewStartedZooming(View view);
}
