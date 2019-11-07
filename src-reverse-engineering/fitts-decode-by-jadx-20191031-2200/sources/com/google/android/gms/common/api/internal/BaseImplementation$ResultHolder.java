package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

public interface BaseImplementation$ResultHolder<R> {
    void setFailedResult(Status status);

    void setResult(R r);
}
