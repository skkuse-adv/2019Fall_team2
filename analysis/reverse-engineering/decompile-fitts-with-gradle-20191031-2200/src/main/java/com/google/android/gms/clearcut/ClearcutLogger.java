package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.clearcut.zzaa;
import com.google.android.gms.internal.clearcut.zze;
import com.google.android.gms.internal.clearcut.zzge$zzv$zzb;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzp;
import com.google.android.gms.internal.clearcut.zzr;
import java.util.ArrayList;
import java.util.TimeZone;

public final class ClearcutLogger {
    @Deprecated
    public static final Api<Object> API = new Api<>("ClearcutLogger.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final AbstractClientBuilder<zzj, Object> CLIENT_BUILDER = new zza();
    private static final ClientKey<zzj> CLIENT_KEY = new ClientKey<>();
    /* access modifiers changed from: private */
    public final String packageName;
    /* access modifiers changed from: private */
    public final Context zzh;
    /* access modifiers changed from: private */
    public final int zzi;
    /* access modifiers changed from: private */
    public String zzj;
    /* access modifiers changed from: private */
    public int zzk;
    /* access modifiers changed from: private */
    public String zzl;
    /* access modifiers changed from: private */
    public final boolean zzn;
    /* access modifiers changed from: private */
    public zzge$zzv$zzb zzo;
    /* access modifiers changed from: private */
    public final zzb zzp;
    /* access modifiers changed from: private */
    public final Clock zzq;
    /* access modifiers changed from: private */
    public zzc zzr;
    /* access modifiers changed from: private */
    public final zza zzs;

    public class LogEventBuilder {
        private final zzha zzaa;
        private boolean zzab;
        private String zzj;
        private int zzk;
        private String zzl;
        private String zzm;
        private zzge$zzv$zzb zzo;
        private boolean zzz;

        private LogEventBuilder(ClearcutLogger clearcutLogger, byte[] bArr) {
            this(bArr, (zzb) null);
        }

        private LogEventBuilder(byte[] bArr, zzb zzb) {
            this.zzk = ClearcutLogger.this.zzk;
            this.zzj = ClearcutLogger.this.zzj;
            this.zzl = ClearcutLogger.this.zzl;
            ClearcutLogger clearcutLogger = ClearcutLogger.this;
            this.zzm = null;
            this.zzo = clearcutLogger.zzo;
            this.zzz = true;
            this.zzaa = new zzha();
            this.zzab = false;
            this.zzl = ClearcutLogger.this.zzl;
            this.zzm = null;
            this.zzaa.zzbkc = zzaa.zze(ClearcutLogger.this.zzh);
            this.zzaa.zzbjf = ClearcutLogger.this.zzq.currentTimeMillis();
            this.zzaa.zzbjg = ClearcutLogger.this.zzq.elapsedRealtime();
            zzha zzha = this.zzaa;
            ClearcutLogger.this.zzr;
            zzha.zzbju = (long) (TimeZone.getDefault().getOffset(this.zzaa.zzbjf) / 1000);
            if (bArr != null) {
                this.zzaa.zzbjp = bArr;
            }
        }

        /* synthetic */ LogEventBuilder(ClearcutLogger clearcutLogger, byte[] bArr, zza zza) {
            this(clearcutLogger, bArr);
        }

        public void log() {
            if (!this.zzab) {
                this.zzab = true;
                zzr zzr = new zzr(ClearcutLogger.this.packageName, ClearcutLogger.this.zzi, this.zzk, this.zzj, this.zzl, this.zzm, ClearcutLogger.this.zzn, this.zzo);
                zze zze = new zze(zzr, this.zzaa, null, null, ClearcutLogger.zza(null), null, ClearcutLogger.zza(null), null, null, this.zzz);
                if (ClearcutLogger.this.zzs.zza(zze)) {
                    ClearcutLogger.this.zzp.zzb(zze);
                } else {
                    PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, (GoogleApiClient) null);
                }
            } else {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
        }

        public LogEventBuilder setEventCode(int i) {
            this.zzaa.zzbji = i;
            return this;
        }
    }

    public interface zza {
        boolean zza(zze zze);
    }

    public interface zzb {
        byte[] zza();
    }

    public static class zzc {
    }

    private ClearcutLogger(Context context, int i, String str, String str2, String str3, boolean z, zzb zzb2, Clock clock, zzc zzc2, zza zza2) {
        this.zzk = -1;
        this.zzo = zzge$zzv$zzb.DEFAULT;
        this.zzh = context;
        this.packageName = context.getPackageName();
        this.zzi = zza(context);
        this.zzk = -1;
        this.zzj = str;
        this.zzl = str2;
        this.zzn = z;
        this.zzp = zzb2;
        this.zzq = clock;
        this.zzr = new zzc();
        this.zzo = zzge$zzv$zzb.DEFAULT;
        this.zzs = zza2;
        if (z) {
            Preconditions.checkArgument(str2 == null, "can't be anonymous with an upload account");
        }
    }

    public ClearcutLogger(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, zze.zzb(context), DefaultClock.getInstance(), null, new zzp(context));
    }

    public static ClearcutLogger anonymousLogger(Context context, String str) {
        ClearcutLogger clearcutLogger = new ClearcutLogger(context, -1, str, null, null, true, zze.zzb(context), DefaultClock.getInstance(), null, new zzp(context));
        return clearcutLogger;
    }

    private static int zza(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.", e);
            return i;
        }
    }

    /* access modifiers changed from: private */
    public static int[] zza(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            int i3 = i2 + 1;
            iArr[i2] = ((Integer) obj).intValue();
            i2 = i3;
        }
        return iArr;
    }

    public final LogEventBuilder newEvent(byte[] bArr) {
        return new LogEventBuilder(this, bArr, (zza) null);
    }
}
