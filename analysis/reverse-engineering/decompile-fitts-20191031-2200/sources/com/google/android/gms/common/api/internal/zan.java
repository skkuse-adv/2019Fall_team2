package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zan implements Runnable {
    private final zam zadj;
    final /* synthetic */ zal zadk;

    zan(zal zal, zam zam) {
        this.zadk = zal;
        this.zadj = zam;
    }

    @MainThread
    public final void run() {
        if (this.zadk.mStarted) {
            ConnectionResult connectionResult = this.zadj.getConnectionResult();
            if (connectionResult.hasResolution()) {
                zal zal = this.zadk;
                zal.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zal.getActivity(), connectionResult.getResolution(), this.zadj.zar(), false), 1);
            } else if (this.zadk.zacd.isUserResolvableError(connectionResult.getErrorCode())) {
                zal zal2 = this.zadk;
                zal2.zacd.zaa(zal2.getActivity(), this.zadk.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zadk);
            } else if (connectionResult.getErrorCode() == 18) {
                Dialog zaa = GoogleApiAvailability.zaa(this.zadk.getActivity(), (OnCancelListener) this.zadk);
                zal zal3 = this.zadk;
                zal3.zacd.zaa(zal3.getActivity().getApplicationContext(), (zabr) new zao(this, zaa));
            } else {
                this.zadk.zaa(connectionResult, this.zadj.zar());
            }
        }
    }
}
