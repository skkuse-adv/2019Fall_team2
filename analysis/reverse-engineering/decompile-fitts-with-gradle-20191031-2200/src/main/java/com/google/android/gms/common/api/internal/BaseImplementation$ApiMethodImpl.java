package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

public abstract class BaseImplementation$ApiMethodImpl<R extends Result, A extends AnyClient> extends BasePendingResult<R> implements BaseImplementation$ResultHolder<R> {
    private final Api<?> mApi;
    private final AnyClientKey<A> mClientKey;

    /* access modifiers changed from: protected */
    public abstract void doExecute(@NonNull A a) throws RemoteException;

    /* access modifiers changed from: protected */
    public void onSetFailedResult(@NonNull R r) {
    }

    protected BaseImplementation$ApiMethodImpl(@NonNull Api<?> api, @NonNull GoogleApiClient googleApiClient) {
        super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
        Preconditions.checkNotNull(api, "Api must not be null");
        this.mClientKey = api.getClientKey();
        this.mApi = api;
    }

    public final AnyClientKey<A> getClientKey() {
        return this.mClientKey;
    }

    public final Api<?> getApi() {
        return this.mApi;
    }

    public final void run(@NonNull A a) throws DeadObjectException {
        if (a instanceof SimpleClientAdapter) {
            a = ((SimpleClientAdapter) a).getClient();
        }
        try {
            doExecute(a);
        } catch (DeadObjectException e) {
            setFailedResult((RemoteException) e);
            throw e;
        } catch (RemoteException e2) {
            setFailedResult(e2);
        }
    }

    public final void setFailedResult(@NonNull Status status) {
        Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
        Result createFailedResult = createFailedResult(status);
        setResult(createFailedResult);
        onSetFailedResult(createFailedResult);
    }

    private void setFailedResult(@NonNull RemoteException remoteException) {
        setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
