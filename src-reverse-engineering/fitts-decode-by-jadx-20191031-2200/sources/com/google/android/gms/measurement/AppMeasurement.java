package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.measurement.internal.zzjn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zzi;
    private final zzfj zzj;
    private final zzhi zzk;
    private final boolean zzl;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                this.mValue = zzho.zza(obj);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }

        private ConditionalUserProperty(@NonNull Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzgg.zza(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzgg.zza(bundle, "origin", String.class, null);
            this.mName = (String) zzgg.zza(bundle, "name", String.class, null);
            this.mValue = zzgg.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgg.zza(bundle, "trigger_event_name", String.class, null);
            Long valueOf = Long.valueOf(0);
            this.mTriggerTimeout = ((Long) zzgg.zza(bundle, "trigger_timeout", Long.class, valueOf)).longValue();
            this.mTimedOutEventName = (String) zzgg.zza(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) zzgg.zza(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzgg.zza(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) zzgg.zza(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzgg.zza(bundle, "time_to_live", Long.class, valueOf)).longValue();
            this.mExpiredEventName = (String) zzgg.zza(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) zzgg.zza(bundle, "expired_event_params", Bundle.class, null);
        }

        /* access modifiers changed from: private */
        public final Bundle zzd() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgg.zza(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    public interface EventInterceptor extends zzgk {
        @WorkerThread
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    public interface OnEventListener extends zzgn {
        @WorkerThread
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Deprecated
    @Keep
    public static AppMeasurement getInstance(Context context) {
        return zza(context, null, null);
    }

    private static AppMeasurement zza(Context context, String str, String str2) {
        if (zzi == null) {
            synchronized (AppMeasurement.class) {
                if (zzi == null) {
                    zzhi zzb = zzb(context, null);
                    if (zzb != null) {
                        zzi = new AppMeasurement(zzb);
                    } else {
                        zzi = new AppMeasurement(zzfj.zza(context, null, null, null));
                    }
                }
            }
        }
        return zzi;
    }

    public static AppMeasurement zza(Context context, Bundle bundle) {
        if (zzi == null) {
            synchronized (AppMeasurement.class) {
                if (zzi == null) {
                    zzhi zzb = zzb(context, bundle);
                    if (zzb != null) {
                        zzi = new AppMeasurement(zzb);
                    } else {
                        zzi = new AppMeasurement(zzfj.zza(context, null, null, bundle));
                    }
                }
            }
        }
        return zzi;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.measurement.internal.zzhi zzb(android.content.Context r8, android.os.Bundle r9) {
        /*
            r0 = 0
            java.lang.String r1 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0027 }
            java.lang.String r2 = "getScionFrontendApiImplementation"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.Class<android.os.Bundle> r5 = android.os.Bundle.class
            r7 = 1
            r4[r7] = r5     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{  }
            r2[r6] = r8     // Catch:{  }
            r2[r7] = r9     // Catch:{  }
            java.lang.Object r8 = r1.invoke(r0, r2)     // Catch:{  }
            com.google.android.gms.measurement.internal.zzhi r8 = (com.google.android.gms.measurement.internal.zzhi) r8     // Catch:{  }
            return r8
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.zzb(android.content.Context, android.os.Bundle):com.google.android.gms.measurement.internal.zzhi");
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        if (this.zzl) {
            this.zzk.setMeasurementEnabled(z);
        } else {
            this.zzj.zzq().setMeasurementEnabled(z);
        }
    }

    public final void zza(boolean z) {
        if (this.zzl) {
            this.zzk.setDataCollectionEnabled(z);
        } else {
            this.zzj.zzq().zza(z);
        }
    }

    private AppMeasurement(zzfj zzfj) {
        Preconditions.checkNotNull(zzfj);
        this.zzj = zzfj;
        this.zzk = null;
        this.zzl = false;
    }

    private AppMeasurement(zzhi zzhi) {
        Preconditions.checkNotNull(zzhi);
        this.zzk = zzhi;
        this.zzj = null;
        this.zzl = true;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.zzl) {
            this.zzk.logEventInternal(str, str2, bundle);
        } else {
            this.zzj.zzq().logEvent(str, str2, bundle);
        }
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        if (this.zzl) {
            this.zzk.logEventInternalNoInterceptor(str, str2, bundle, j);
        } else {
            this.zzj.zzq().logEvent(str, str2, bundle, true, false, j);
        }
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        Preconditions.checkNotEmpty(str);
        if (this.zzl) {
            this.zzk.setUserPropertyInternal(str, str2, obj);
        } else {
            this.zzj.zzq().zzb(str, str2, obj, true);
        }
    }

    @WorkerThread
    public Map<String, Object> getUserProperties(boolean z) {
        if (this.zzl) {
            return this.zzk.getUserProperties(null, null, z);
        }
        List<zzjn> zzh = this.zzj.zzq().zzh(z);
        ArrayMap arrayMap = new ArrayMap(zzh.size());
        for (zzjn zzjn : zzh) {
            arrayMap.put(zzjn.name, zzjn.getValue());
        }
        return arrayMap;
    }

    @WorkerThread
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        if (this.zzl) {
            this.zzk.zza((zzgk) eventInterceptor);
        } else {
            this.zzj.zzq().zza((zzgk) eventInterceptor);
        }
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.zzl) {
            this.zzk.zza((zzgn) onEventListener);
        } else {
            this.zzj.zzq().zza((zzgn) onEventListener);
        }
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        if (this.zzl) {
            this.zzk.zzb((zzgn) onEventListener);
        } else {
            this.zzj.zzq().zzb(onEventListener);
        }
    }

    @Keep
    @Nullable
    public String getCurrentScreenName() {
        if (this.zzl) {
            return this.zzk.getCurrentScreenName();
        }
        return this.zzj.zzq().getCurrentScreenName();
    }

    @Keep
    @Nullable
    public String getCurrentScreenClass() {
        if (this.zzl) {
            return this.zzk.getCurrentScreenClass();
        }
        return this.zzj.zzq().getCurrentScreenClass();
    }

    @Keep
    @Nullable
    public String getAppInstanceId() {
        if (this.zzl) {
            return this.zzk.zzi();
        }
        return this.zzj.zzq().zzi();
    }

    @Keep
    @Nullable
    public String getGmpAppId() {
        if (this.zzl) {
            return this.zzk.getGmpAppId();
        }
        return this.zzj.zzq().getGmpAppId();
    }

    @Keep
    public long generateEventId() {
        if (this.zzl) {
            return this.zzk.generateEventId();
        }
        return this.zzj.zzz().zzjv();
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        if (this.zzl) {
            this.zzk.beginAdUnitExposure(str);
        } else {
            this.zzj.zzp().beginAdUnitExposure(str, this.zzj.zzx().elapsedRealtime());
        }
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        if (this.zzl) {
            this.zzk.endAdUnitExposure(str);
        } else {
            this.zzj.zzp().endAdUnitExposure(str, this.zzj.zzx().elapsedRealtime());
        }
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        if (this.zzl) {
            this.zzk.setConditionalUserProperty(conditionalUserProperty.zzd());
        } else {
            this.zzj.zzq().setConditionalUserProperty(conditionalUserProperty.zzd());
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public void setConditionalUserPropertyAs(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        if (!this.zzl) {
            this.zzj.zzq().zzd(conditionalUserProperty.zzd());
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.zzl) {
            this.zzk.clearConditionalUserProperty(str, str2, bundle);
        } else {
            this.zzj.zzq().clearConditionalUserProperty(str, str2, bundle);
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    public void clearConditionalUserPropertyAs(@Size(min = 1) @NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        if (!this.zzl) {
            this.zzj.zzq().clearConditionalUserPropertyAs(str, str2, str3, bundle);
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @Keep
    public Map<String, Object> getUserProperties(@Nullable String str, @Size(max = 24, min = 1) @Nullable String str2, boolean z) {
        if (this.zzl) {
            return this.zzk.getUserProperties(str, str2, z);
        }
        return this.zzj.zzq().getUserProperties(str, str2, z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @Keep
    public Map<String, Object> getUserPropertiesAs(@Size(min = 1) @NonNull String str, @Nullable String str2, @Size(max = 23, min = 1) @Nullable String str3, boolean z) {
        if (!this.zzl) {
            return this.zzj.zzq().getUserPropertiesAs(str, str2, str3, z);
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Size(max = 23, min = 1) @Nullable String str2) {
        List<Bundle> list;
        int i;
        if (this.zzl) {
            list = this.zzk.getConditionalUserProperties(str, str2);
        } else {
            list = this.zzj.zzq().zzn(str, str2);
        }
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        ArrayList arrayList = new ArrayList(i);
        for (Bundle conditionalUserProperty : list) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @Keep
    public List<ConditionalUserProperty> getConditionalUserPropertiesAs(@Size(min = 1) @NonNull String str, @Nullable String str2, @Size(max = 23, min = 1) @Nullable String str3) {
        int i;
        if (!this.zzl) {
            ArrayList zzd = this.zzj.zzq().zzd(str, str2, str3);
            int i2 = 0;
            if (zzd == null) {
                i = 0;
            } else {
                i = zzd.size();
            }
            ArrayList arrayList = new ArrayList(i);
            int size = zzd.size();
            while (i2 < size) {
                Object obj = zzd.get(i2);
                i2++;
                arrayList.add(new ConditionalUserProperty((Bundle) obj));
            }
            return arrayList;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    @Keep
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        if (this.zzl) {
            return this.zzk.getMaxUserProperties(str);
        }
        this.zzj.zzq();
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    public Boolean getBoolean() {
        if (this.zzl) {
            return (Boolean) this.zzk.zzb(4);
        }
        return this.zzj.zzq().zzig();
    }

    public String getString() {
        if (this.zzl) {
            return (String) this.zzk.zzb(0);
        }
        return this.zzj.zzq().zzih();
    }

    public Long getLong() {
        if (this.zzl) {
            return (Long) this.zzk.zzb(1);
        }
        return this.zzj.zzq().zzii();
    }

    public Integer getInteger() {
        if (this.zzl) {
            return (Integer) this.zzk.zzb(3);
        }
        return this.zzj.zzq().zzij();
    }

    public Double getDouble() {
        if (this.zzl) {
            return (Double) this.zzk.zzb(2);
        }
        return this.zzj.zzq().zzik();
    }
}
