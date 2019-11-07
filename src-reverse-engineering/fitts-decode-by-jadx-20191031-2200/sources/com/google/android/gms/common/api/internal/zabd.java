package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;

public interface zabd {
    void begin();

    void connect();

    boolean disconnect();

    <A extends AnyClient, R extends Result, T extends BaseImplementation$ApiMethodImpl<R, A>> T enqueue(T t);

    <A extends AnyClient, T extends BaseImplementation$ApiMethodImpl<? extends Result, A>> T execute(T t);

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);

    void zaa(ConnectionResult connectionResult, Api<?> api, boolean z);
}
