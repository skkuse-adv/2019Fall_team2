package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import java.util.List;
import java.util.Map;

public class AppMeasurementSdk {
    private final zzz zzo;

    public interface EventInterceptor extends zzgk {
        @WorkerThread
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    public interface OnEventListener extends zzgn {
        @WorkerThread
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static AppMeasurementSdk getInstance(@NonNull Context context) {
        return zzz.zza(context).zzg();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static AppMeasurementSdk getInstance(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, Bundle bundle) {
        return zzz.zza(context, str, str2, str3, bundle).zzg();
    }

    public AppMeasurementSdk(zzz zzz) {
        this.zzo = zzz;
    }

    public void setMeasurementEnabled(boolean z) {
        this.zzo.setMeasurementEnabled(z);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zzo.logEventInternal(str, str2, bundle);
    }

    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzo.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    public void setUserProperty(String str, String str2, Object obj) {
        this.zzo.setUserPropertyInternal(str, str2, obj);
    }

    @WorkerThread
    public Map<String, Object> getUserProperties(@Nullable String str, @Size(max = 24, min = 1) @Nullable String str2, boolean z) {
        return this.zzo.getUserProperties(str, str2, z);
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle) {
        this.zzo.setConditionalUserProperty(bundle);
    }

    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zzo.clearConditionalUserProperty(str, str2, bundle);
    }

    @WorkerThread
    public List<Bundle> getConditionalUserProperties(@Nullable String str, @Size(max = 23, min = 1) @Nullable String str2) {
        return this.zzo.getConditionalUserProperties(str, str2);
    }

    @Nullable
    public String getCurrentScreenName() {
        return this.zzo.getCurrentScreenName();
    }

    @Nullable
    public String getCurrentScreenClass() {
        return this.zzo.getCurrentScreenClass();
    }

    @Nullable
    public String getAppInstanceId() {
        return this.zzo.zzi();
    }

    @Nullable
    public String getGmpAppId() {
        return this.zzo.getGmpAppId();
    }

    public long generateEventId() {
        return this.zzo.generateEventId();
    }

    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzo.beginAdUnitExposure(str);
    }

    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.zzo.endAdUnitExposure(str);
    }

    @WorkerThread
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzo.zza((zzgk) eventInterceptor);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzo.zza((zzgn) onEventListener);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzo.zzb((zzgn) onEventListener);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zzo.zza(bundle, true);
    }

    public void performAction(Bundle bundle) {
        this.zzo.zza(bundle, false);
    }

    @WorkerThread
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.zzo.getMaxUserProperties(str);
    }

    public void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        this.zzo.setCurrentScreen(activity, str, str2);
    }

    public String getAppIdOrigin() {
        return this.zzo.getAppIdOrigin();
    }
}
