package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;

final class zaf extends zaa {
    private final BaseImplementation$ResultHolder<Status> mResultHolder;

    public zaf(BaseImplementation$ResultHolder<Status> baseImplementation$ResultHolder) {
        this.mResultHolder = baseImplementation$ResultHolder;
    }

    public final void zaj(int i) throws RemoteException {
        this.mResultHolder.setResult(new Status(i));
    }
}
