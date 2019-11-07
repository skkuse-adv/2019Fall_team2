package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.kakao.network.ServerProtocol;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zaj extends zal {
    private final SparseArray<zaa> zacw = new SparseArray<>();

    private class zaa implements OnConnectionFailedListener {
        public final int zacx;
        public final GoogleApiClient zacy;
        public final OnConnectionFailedListener zacz;

        public zaa(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.zacx = i;
            this.zacy = googleApiClient;
            this.zacz = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            sb.toString();
            zaj.this.zab(connectionResult, this.zacx);
        }
    }

    public static zaj zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zaj zaj = (zaj) fragment.getCallbackOrNull("AutoManageHelper", zaj.class);
        if (zaj != null) {
            return zaj;
        }
        return new zaj(fragment);
    }

    private zaj(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public final void zaa(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.zacw.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zam zam = (zam) this.zadf.get();
        boolean z2 = this.mStarted;
        String valueOf = String.valueOf(zam);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        String str = ServerProtocol.AUTHORIZATION_HEADER_DELIMITER;
        sb2.append(str);
        sb2.append(z2);
        sb2.append(str);
        sb2.append(valueOf);
        sb2.toString();
        this.zacw.put(i, new zaa(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && zam == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            sb3.toString();
            googleApiClient.connect();
        }
    }

    public final void zaa(int i) {
        zaa zaa2 = (zaa) this.zacw.get(i);
        this.zacw.remove(i);
        if (zaa2 != null) {
            zaa2.zacy.unregisterConnectionFailedListener(zaa2);
            zaa2.zacy.disconnect();
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zacw);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
        sb.append(valueOf);
        sb.toString();
        if (this.zadf.get() == null) {
            for (int i = 0; i < this.zacw.size(); i++) {
                zaa zab = zab(i);
                if (zab != null) {
                    zab.zacy.connect();
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.zacw.size(); i++) {
            zaa zab = zab(i);
            if (zab != null) {
                zab.zacy.disconnect();
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zacw.size(); i++) {
            zaa zab = zab(i);
            if (zab != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zab.zacx);
                printWriter.println(":");
                zab.zacy.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zaa(ConnectionResult connectionResult, int i) {
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaa zaa2 = (zaa) this.zacw.get(i);
        if (zaa2 != null) {
            zaa(i);
            OnConnectionFailedListener onConnectionFailedListener = zaa2.zacz;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zao() {
        for (int i = 0; i < this.zacw.size(); i++) {
            zaa zab = zab(i);
            if (zab != null) {
                zab.zacy.connect();
            }
        }
    }

    @Nullable
    private final zaa zab(int i) {
        if (this.zacw.size() <= i) {
            return null;
        }
        SparseArray<zaa> sparseArray = this.zacw;
        return (zaa) sparseArray.get(sparseArray.keyAt(i));
    }
}
