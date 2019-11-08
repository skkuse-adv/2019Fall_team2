package com.google.firebase.components;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class ComponentDiscoveryService extends Service {
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }
}
