package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzi;

public final class zzjc extends zzjh {
    private final AlarmManager zzsj = ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private final zzaa zzsk;
    private Integer zzsl;

    protected zzjc(zzjg zzjg) {
        super(zzjg);
        this.zzsk = new zzjf(this, zzjg.zzjt(), zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        this.zzsj.cancel(zzje());
        if (VERSION.SDK_INT >= 24) {
            zzjd();
        }
        return false;
    }

    @TargetApi(24)
    private final void zzjd() {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        int jobId = getJobId();
        zzab().zzgs().zza("Cancelling job. JobID", Integer.valueOf(jobId));
        jobScheduler.cancel(jobId);
    }

    public final void zzv(long j) {
        zzbi();
        zzae();
        Context context = getContext();
        if (!zzez.zzl(context)) {
            zzab().zzgr().zzao("Receiver not registered/enabled");
        }
        if (!zzjs.zzb(context, false)) {
            zzab().zzgr().zzao("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzx().elapsedRealtime() + j;
        if (j < Math.max(0, ((Long) zzak.zzhc.get(null)).longValue()) && !this.zzsk.zzcp()) {
            zzab().zzgs().zzao("Scheduling upload with DelayedRunnable");
            this.zzsk.zzv(j);
        }
        zzae();
        if (VERSION.SDK_INT >= 24) {
            zzab().zzgs().zzao("Scheduling upload with JobScheduler");
            Context context2 = getContext();
            ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int jobId = getJobId();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new Builder(jobId, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build();
            zzab().zzgs().zza("Scheduling job. JobID", Integer.valueOf(jobId));
            zzi.zza(context2, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        zzab().zzgs().zzao("Scheduling upload with AlarmManager");
        this.zzsj.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzak.zzgx.get(null)).longValue(), j), zzje());
    }

    private final int getJobId() {
        if (this.zzsl == null) {
            String str = "measurement";
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzsl = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        return this.zzsl.intValue();
    }

    public final void cancel() {
        zzbi();
        this.zzsj.cancel(zzje());
        this.zzsk.cancel();
        if (VERSION.SDK_INT >= 24) {
            zzjd();
        }
    }

    private final PendingIntent zzje() {
        Context context = getContext();
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    public final /* bridge */ /* synthetic */ zzjo zzgw() {
        return super.zzgw();
    }

    public final /* bridge */ /* synthetic */ zzp zzgx() {
        return super.zzgx();
    }

    public final /* bridge */ /* synthetic */ zzx zzgy() {
        return super.zzgy();
    }

    public final /* bridge */ /* synthetic */ zzfd zzgz() {
        return super.zzgz();
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    public final /* bridge */ /* synthetic */ zzeo zzac() {
        return super.zzac();
    }

    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
