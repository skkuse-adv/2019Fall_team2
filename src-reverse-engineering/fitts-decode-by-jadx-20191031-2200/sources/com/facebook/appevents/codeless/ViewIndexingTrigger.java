package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class ViewIndexingTrigger implements SensorEventListener {
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mListener != null) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            double d = (double) (f / 9.80665f);
            double d2 = (double) (fArr[1] / 9.80665f);
            double d3 = (double) (fArr[2] / 9.80665f);
            Double.isNaN(d);
            Double.isNaN(d);
            double d4 = d * d;
            Double.isNaN(d2);
            Double.isNaN(d2);
            double d5 = d4 + (d2 * d2);
            Double.isNaN(d3);
            Double.isNaN(d3);
            if (Math.sqrt(d5 + (d3 * d3)) > 2.299999952316284d) {
                this.mListener.onShake();
            }
        }
    }
}
