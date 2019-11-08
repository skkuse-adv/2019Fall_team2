package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzn {
    private Map<Integer, zzgn> zzdk = new ArrayMap();
    zzfj zzj = null;

    class zza implements zzgn {
        private zzq zzdo;

        zza(zzq zzq) {
            this.zzdo = zzq;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zzdo.onEvent(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zzj.zzab().zzgn().zza("Event listener threw exception", e);
            }
        }
    }

    class zzb implements zzgk {
        private zzq zzdo;

        zzb(zzq zzq) {
            this.zzdo = zzq;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zzdo.onEvent(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zzj.zzab().zzgn().zza("Event interceptor threw exception", e);
            }
        }
    }

    private final void zzbi() {
        if (this.zzj == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzx zzx, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfj zzfj = this.zzj;
        if (zzfj == null) {
            this.zzj = zzfj.zza(context, zzx);
        } else {
            zzfj.zzab().zzgn().zzao("Attempting to initialize multiple times");
        }
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().logEvent(str, str2, bundle, z, z2, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void setUserId(String str, long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().zza(null, "_id", str, true, j);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zzbi();
        this.zzj.zzt().setCurrentScreen((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().setMeasurementEnabled(z);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().resetAnalyticsData(j);
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().setMinimumSessionDuration(j);
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzbi();
        this.zzj.zzq().setSessionTimeoutDuration(j);
    }

    public void getMaxUserProperties(String str, zzp zzp) throws RemoteException {
        zzbi();
        this.zzj.zzq();
        Preconditions.checkNotEmpty(str);
        this.zzj.zzz().zza(zzp, 25);
    }

    public void getCurrentScreenName(zzp zzp) throws RemoteException {
        zzbi();
        zza(zzp, this.zzj.zzq().getCurrentScreenName());
    }

    public void getCurrentScreenClass(zzp zzp) throws RemoteException {
        zzbi();
        zza(zzp, this.zzj.zzq().getCurrentScreenClass());
    }

    public void getCachedAppInstanceId(zzp zzp) throws RemoteException {
        zzbi();
        zza(zzp, this.zzj.zzq().zzi());
    }

    public void getAppInstanceId(zzp zzp) throws RemoteException {
        zzbi();
        this.zzj.zzaa().zza((Runnable) new zzh(this, zzp));
    }

    public void getDeepLink(zzp zzp) throws RemoteException {
        zzbi();
        zzgp zzq = this.zzj.zzq();
        zzq.zzo();
        String str = "";
        if (!zzq.zzad().zzd(null, zzak.zzjc)) {
            zzq.zzz().zzb(zzp, str);
        } else if (zzq.zzac().zzme.get() > 0) {
            zzq.zzz().zzb(zzp, str);
        } else {
            zzq.zzac().zzme.set(zzq.zzx().currentTimeMillis());
            zzq.zzj.zza(zzp);
        }
    }

    public void getGmpAppId(zzp zzp) throws RemoteException {
        zzbi();
        zza(zzp, this.zzj.zzq().getGmpAppId());
    }

    public void generateEventId(zzp zzp) throws RemoteException {
        zzbi();
        this.zzj.zzz().zza(zzp, this.zzj.zzz().zzjv());
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zzbi();
        this.zzj.zzp().beginAdUnitExposure(str, j);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zzbi();
        this.zzj.zzp().endAdUnitExposure(str, j);
    }

    public void initForTests(Map map) throws RemoteException {
        zzbi();
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzp zzp, long j) throws RemoteException {
        Bundle bundle2;
        zzbi();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        String str3 = SettingsJsonConstants.APP_KEY;
        bundle2.putString("_o", str3);
        zzai zzai = new zzai(str2, new zzah(bundle), str3, j);
        this.zzj.zzaa().zza((Runnable) new zzj(this, zzp, zzai, str));
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzp zzp, long j) throws RemoteException {
        zzbi();
        zzhj zzhj = this.zzj.zzq().zzpu;
        Bundle bundle = new Bundle();
        if (zzhj != null) {
            this.zzj.zzq().zzif();
            zzhj.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzp.zzb(bundle);
        } catch (RemoteException e) {
            this.zzj.zzab().zzgn().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void performAction(Bundle bundle, zzp zzp, long j) throws RemoteException {
        zzbi();
        zzp.zzb(null);
    }

    public void getUserProperties(String str, String str2, boolean z, zzp zzp) throws RemoteException {
        zzbi();
        zzfc zzaa = this.zzj.zzaa();
        zzi zzi = new zzi(this, zzp, str, str2, z);
        zzaa.zza((Runnable) zzi);
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzbi();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zzj.zzab().zza(i, true, false, str, obj, obj2, obj3);
    }

    public void setEventInterceptor(zzq zzq) throws RemoteException {
        zzbi();
        zzgp zzq2 = this.zzj.zzq();
        zzb zzb2 = new zzb(zzq);
        zzq2.zzm();
        zzq2.zzbi();
        zzq2.zzaa().zza((Runnable) new zzgu(zzq2, zzb2));
    }

    public void registerOnMeasurementEventListener(zzq zzq) throws RemoteException {
        zzbi();
        zzgn zzgn = (zzgn) this.zzdk.get(Integer.valueOf(zzq.id()));
        if (zzgn == null) {
            zzgn = new zza(zzq);
            this.zzdk.put(Integer.valueOf(zzq.id()), zzgn);
        }
        this.zzj.zzq().zza(zzgn);
    }

    public void unregisterOnMeasurementEventListener(zzq zzq) throws RemoteException {
        zzbi();
        zzgn zzgn = (zzgn) this.zzdk.remove(Integer.valueOf(zzq.id()));
        if (zzgn == null) {
            zzgn = new zza(zzq);
        }
        this.zzj.zzq().zzb(zzgn);
    }

    public void setInstanceIdProvider(zzv zzv) throws RemoteException {
        zzbi();
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zzbi();
        if (bundle == null) {
            this.zzj.zzab().zzgk().zzao("Conditional user property must not be null");
        } else {
            this.zzj.zzq().setConditionalUserProperty(bundle, j);
        }
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzbi();
        this.zzj.zzq().clearConditionalUserProperty(str, str2, bundle);
    }

    public void getConditionalUserProperties(String str, String str2, zzp zzp) throws RemoteException {
        zzbi();
        this.zzj.zzaa().zza((Runnable) new zzl(this, zzp, str, str2));
    }

    public void getTestFlag(zzp zzp, int i) throws RemoteException {
        zzbi();
        if (i == 0) {
            this.zzj.zzz().zzb(zzp, this.zzj.zzq().zzih());
        } else if (i == 1) {
            this.zzj.zzz().zza(zzp, this.zzj.zzq().zzii().longValue());
        } else if (i == 2) {
            zzjs zzz = this.zzj.zzz();
            double doubleValue = this.zzj.zzq().zzik().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzp.zzb(bundle);
            } catch (RemoteException e) {
                zzz.zzj.zzab().zzgn().zza("Error returning double value to wrapper", e);
            }
        } else if (i != 3) {
            if (i == 4) {
                this.zzj.zzz().zza(zzp, this.zzj.zzq().zzig().booleanValue());
            }
        } else {
            this.zzj.zzz().zza(zzp, this.zzj.zzq().zzij().intValue());
        }
    }

    private final void zza(zzp zzp, String str) {
        this.zzj.zzz().zzb(zzp, str);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzbi();
        this.zzj.zzq().zza(z);
    }

    public void isDataCollectionEnabled(zzp zzp) throws RemoteException {
        zzbi();
        this.zzj.zzaa().zza((Runnable) new zzk(this, zzp));
    }
}
