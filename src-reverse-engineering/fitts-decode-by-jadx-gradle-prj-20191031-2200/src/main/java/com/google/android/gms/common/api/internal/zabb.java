package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zap;

final class zabb extends zap {
    private final /* synthetic */ zaaw zahh;

    zabb(zaaw zaaw, Looper looper) {
        this.zahh = zaaw;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zahh.zaav();
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            sb.toString();
        } else {
            this.zahh.resume();
        }
    }
}
