package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    protected final LifecycleFragment mLifecycleFragment;

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onDestroy() {
    }

    @MainThread
    public void onResume() {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }

    protected static LifecycleFragment getFragment(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.isSupport()) {
            return zzc.zza(lifecycleActivity.asFragmentActivity());
        }
        if (lifecycleActivity.zzh()) {
            return zza.zza(lifecycleActivity.asActivity());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static LifecycleFragment getFragment(Activity activity) {
        return getFragment(new LifecycleActivity(activity));
    }

    public static LifecycleFragment getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    public Activity getActivity() {
        return this.mLifecycleFragment.getLifecycleActivity();
    }
}
