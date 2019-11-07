package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zap;

final class zabg extends zap {
    private final /* synthetic */ zabe zahv;

    zabg(zabe zabe, Looper looper) {
        this.zahv = zabe;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zabf) message.obj).zac(this.zahv);
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            sb.toString();
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
