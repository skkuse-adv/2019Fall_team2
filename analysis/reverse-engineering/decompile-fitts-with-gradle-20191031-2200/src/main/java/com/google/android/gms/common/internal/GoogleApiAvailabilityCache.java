package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;

public class GoogleApiAvailabilityCache {
    private final SparseIntArray zaos;
    private GoogleApiAvailabilityLight zaot;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
    }

    public GoogleApiAvailabilityCache(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaos = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zaot = googleApiAvailabilityLight;
    }

    public int getClientAvailability(@NonNull Context context, @NonNull Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.zaos.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.zaos.size()) {
                break;
            }
            int keyAt = this.zaos.keyAt(i2);
            if (keyAt > minApkVersion && this.zaos.get(keyAt) == 0) {
                i = 0;
                break;
            }
            i2++;
        }
        if (i == -1) {
            i = this.zaot.isGooglePlayServicesAvailable(context, minApkVersion);
        }
        this.zaos.put(minApkVersion, i);
        return i;
    }

    public void flush() {
        this.zaos.clear();
    }
}
