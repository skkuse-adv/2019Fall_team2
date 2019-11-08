package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zabs {
    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends AnyClient, R extends Result, T extends BaseImplementation$ApiMethodImpl<R, A>> T enqueue(@NonNull T t);

    <A extends AnyClient, T extends BaseImplementation$ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t);

    @Nullable
    ConnectionResult getConnectionResult(@NonNull Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    boolean maybeSignIn(SignInConnectionListener signInConnectionListener);

    void maybeSignOut();

    void zaw();
}
