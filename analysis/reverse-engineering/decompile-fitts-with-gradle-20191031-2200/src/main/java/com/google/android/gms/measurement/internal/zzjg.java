package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbs$zzc;
import com.google.android.gms.internal.measurement.zzbs$zze;
import com.google.android.gms.internal.measurement.zzbs$zzg;
import com.google.android.gms.internal.measurement.zzbs$zzk;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.coroutines.DebugKt;

public class zzjg implements zzgh {
    private static volatile zzjg zzsn;
    private boolean zzdh;
    private final zzfj zzj;
    private zzfd zzso;
    private zzej zzsp;
    private zzx zzsq;
    private zzem zzsr;
    private zzjc zzss;
    private zzp zzst;
    private final zzjo zzsu;
    private zzhp zzsv;
    private boolean zzsw;
    private boolean zzsx;
    private long zzsy;
    private List<Runnable> zzsz;
    private int zzta;
    private int zztb;
    private boolean zztc;
    private boolean zztd;
    private boolean zzte;
    private FileLock zztf;
    private FileChannel zztg;
    private List<Long> zzth;
    private List<Long> zzti;
    private long zztj;

    class zza implements zzz {
        zzbs$zzg zztn;
        List<Long> zzto;
        List<zzbs$zzc> zztp;
        private long zztq;

        private zza(zzjg zzjg) {
        }

        public final void zzb(zzbs$zzg zzbs_zzg) {
            Preconditions.checkNotNull(zzbs_zzg);
            this.zztn = zzbs_zzg;
        }

        public final boolean zza(long j, zzbs$zzc zzbs_zzc) {
            Preconditions.checkNotNull(zzbs_zzc);
            if (this.zztp == null) {
                this.zztp = new ArrayList();
            }
            if (this.zzto == null) {
                this.zzto = new ArrayList();
            }
            if (this.zztp.size() > 0 && zza((zzbs$zzc) this.zztp.get(0)) != zza(zzbs_zzc)) {
                return false;
            }
            long zzuk = this.zztq + ((long) zzbs_zzc.zzuk());
            if (zzuk >= ((long) Math.max(0, ((Integer) zzak.zzgn.get(null)).intValue()))) {
                return false;
            }
            this.zztq = zzuk;
            this.zztp.add(zzbs_zzc);
            this.zzto.add(Long.valueOf(j));
            if (this.zztp.size() >= Math.max(1, ((Integer) zzak.zzgo.get(null)).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbs$zzc zzbs_zzc) {
            return ((zzbs_zzc.getTimestampMillis() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzjg zzjg, zzjj zzjj) {
            this(zzjg);
        }
    }

    public static zzjg zzm(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzsn == null) {
            synchronized (zzjg.class) {
                if (zzsn == null) {
                    zzsn = new zzjg(new zzjm(context));
                }
            }
        }
        return zzsn;
    }

    private zzjg(zzjm zzjm) {
        this(zzjm, null);
    }

    private zzjg(zzjm zzjm, zzfj zzfj) {
        this.zzdh = false;
        Preconditions.checkNotNull(zzjm);
        this.zzj = zzfj.zza(zzjm.zzob, (zzx) null);
        this.zztj = -1;
        zzjo zzjo = new zzjo(this);
        zzjo.initialize();
        this.zzsu = zzjo;
        zzej zzej = new zzej(this);
        zzej.initialize();
        this.zzsp = zzej;
        zzfd zzfd = new zzfd(this);
        zzfd.initialize();
        this.zzso = zzfd;
        this.zzj.zzaa().zza((Runnable) new zzjj(this, zzjm));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzjm zzjm) {
        this.zzj.zzaa().zzo();
        zzx zzx = new zzx(this);
        zzx.initialize();
        this.zzsq = zzx;
        this.zzj.zzad().zza((zzu) this.zzso);
        zzp zzp = new zzp(this);
        zzp.initialize();
        this.zzst = zzp;
        zzhp zzhp = new zzhp(this);
        zzhp.initialize();
        this.zzsv = zzhp;
        zzjc zzjc = new zzjc(this);
        zzjc.initialize();
        this.zzss = zzjc;
        this.zzsr = new zzem(this);
        if (this.zzta != this.zztb) {
            this.zzj.zzab().zzgk().zza("Not all upload components initialized", Integer.valueOf(this.zzta), Integer.valueOf(this.zztb));
        }
        this.zzdh = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        this.zzj.zzaa().zzo();
        zzgy().zzca();
        if (this.zzj.zzac().zzlj.get() == 0) {
            this.zzj.zzac().zzlj.set(this.zzj.zzx().currentTimeMillis());
        }
        zzjn();
    }

    public final zzr zzae() {
        return this.zzj.zzae();
    }

    public final zzs zzad() {
        return this.zzj.zzad();
    }

    public final zzef zzab() {
        return this.zzj.zzab();
    }

    public final zzfc zzaa() {
        return this.zzj.zzaa();
    }

    public final zzfd zzgz() {
        zza((zzjh) this.zzso);
        return this.zzso;
    }

    public final zzej zzjf() {
        zza((zzjh) this.zzsp);
        return this.zzsp;
    }

    public final zzx zzgy() {
        zza((zzjh) this.zzsq);
        return this.zzsq;
    }

    private final zzem zzjg() {
        zzem zzem = this.zzsr;
        if (zzem != null) {
            return zzem;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjc zzjh() {
        zza((zzjh) this.zzss);
        return this.zzss;
    }

    public final zzp zzgx() {
        zza((zzjh) this.zzst);
        return this.zzst;
    }

    public final zzhp zzji() {
        zza((zzjh) this.zzsv);
        return this.zzsv;
    }

    public final zzjo zzgw() {
        zza((zzjh) this.zzsu);
        return this.zzsu;
    }

    public final zzed zzy() {
        return this.zzj.zzy();
    }

    public final Context getContext() {
        return this.zzj.getContext();
    }

    public final Clock zzx() {
        return this.zzj.zzx();
    }

    public final zzjs zzz() {
        return this.zzj.zzz();
    }

    @WorkerThread
    private final void zzo() {
        this.zzj.zzaa().zzo();
    }

    /* access modifiers changed from: 0000 */
    public final void zzjj() {
        if (!this.zzdh) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzjh zzjh) {
        if (zzjh == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzjh.isInitialized()) {
            String valueOf = String.valueOf(zzjh.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zze(zzn zzn) {
        zzo();
        zzjj();
        Preconditions.checkNotEmpty(zzn.packageName);
        zzg(zzn);
    }

    private final long zzjk() {
        long currentTimeMillis = this.zzj.zzx().currentTimeMillis();
        zzeo zzac = this.zzj.zzac();
        zzac.zzbi();
        zzac.zzo();
        long j = zzac.zzln.get();
        if (j == 0) {
            j = 1 + ((long) zzac.zzz().zzjw().nextInt(86400000));
            zzac.zzln.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzd(zzai zzai, String str) {
        zzai zzai2 = zzai;
        String str2 = str;
        zzf zzab = zzgy().zzab(str2);
        if (zzab == null || TextUtils.isEmpty(zzab.zzal())) {
            this.zzj.zzab().zzgr().zza("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzab);
        if (zzc == null) {
            if (!"_ui".equals(zzai2.name)) {
                this.zzj.zzab().zzgn().zza("Could not find package. appId", zzef.zzam(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzj.zzab().zzgk().zza("App version does not match; dropping event. appId", zzef.zzam(str));
            return;
        }
        zzn zzn = r2;
        zzf zzf = zzab;
        zzn zzn2 = new zzn(str, zzab.getGmpAppId(), zzab.zzal(), zzab.zzam(), zzab.zzan(), zzab.zzao(), zzab.zzap(), (String) null, zzab.isMeasurementEnabled(), false, zzf.getFirebaseInstanceId(), zzf.zzbd(), 0, 0, zzf.zzbe(), zzf.zzbf(), false, zzf.zzah(), zzf.zzbg(), zzf.zzaq(), zzf.zzbh());
        zzc(zzai2, zzn);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzai zzai, zzn zzn) {
        List<zzq> list;
        List<zzq> list2;
        List<zzq> list3;
        zzai zzai2 = zzai;
        zzn zzn2 = zzn;
        Preconditions.checkNotNull(zzn);
        Preconditions.checkNotEmpty(zzn2.packageName);
        zzo();
        zzjj();
        String str = zzn2.packageName;
        long j = zzai2.zzfu;
        if (zzgw().zze(zzai2, zzn2)) {
            if (!zzn2.zzcq) {
                zzg(zzn2);
                return;
            }
            if (this.zzj.zzad().zze(str, zzak.zzix)) {
                List<String> list4 = zzn2.zzcw;
                if (list4 != null) {
                    if (list4.contains(zzai2.name)) {
                        Bundle zzcv = zzai2.zzfq.zzcv();
                        zzcv.putLong("ga_safelisted", 1);
                        zzai zzai3 = new zzai(zzai2.name, new zzah(zzcv), zzai2.origin, zzai2.zzfu);
                        zzai2 = zzai3;
                    } else {
                        this.zzj.zzab().zzgr().zza("Dropping non-safelisted event. appId, event name, origin", str, zzai2.name, zzai2.origin);
                        return;
                    }
                }
            }
            zzgy().beginTransaction();
            try {
                zzx zzgy = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy.zzo();
                zzgy.zzbi();
                if (j < 0) {
                    zzgy.zzab().zzgn().zza("Invalid time querying timed out conditional properties", zzef.zzam(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzgy.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzq zzq : list) {
                    if (zzq != null) {
                        this.zzj.zzab().zzgr().zza("User property timed out", zzq.packageName, this.zzj.zzy().zzal(zzq.zzdw.name), zzq.zzdw.getValue());
                        if (zzq.zzdx != null) {
                            zzd(new zzai(zzq.zzdx, j), zzn2);
                        }
                        zzgy().zzg(str, zzq.zzdw.name);
                    }
                }
                zzx zzgy2 = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy2.zzo();
                zzgy2.zzbi();
                if (j < 0) {
                    zzgy2.zzab().zzgn().zza("Invalid time querying expired conditional properties", zzef.zzam(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzgy2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzq zzq2 : list2) {
                    if (zzq2 != null) {
                        this.zzj.zzab().zzgr().zza("User property expired", zzq2.packageName, this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
                        zzgy().zzd(str, zzq2.zzdw.name);
                        if (zzq2.zzdz != null) {
                            arrayList.add(zzq2.zzdz);
                        }
                        zzgy().zzg(str, zzq2.zzdw.name);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzd(new zzai((zzai) obj, j), zzn2);
                }
                zzx zzgy3 = zzgy();
                String str2 = zzai2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzgy3.zzo();
                zzgy3.zzbi();
                if (j < 0) {
                    zzgy3.zzab().zzgn().zza("Invalid time querying triggered conditional properties", zzef.zzam(str), zzgy3.zzy().zzaj(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzgy3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzq zzq3 : list3) {
                    if (zzq3 != null) {
                        zzjn zzjn = zzq3.zzdw;
                        zzjp zzjp = r4;
                        zzjp zzjp2 = new zzjp(zzq3.packageName, zzq3.origin, zzjn.name, j, zzjn.getValue());
                        if (zzgy().zza(zzjp)) {
                            this.zzj.zzab().zzgr().zza("User property triggered", zzq3.packageName, this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                        } else {
                            this.zzj.zzab().zzgk().zza("Too many active user properties, ignoring", zzef.zzam(zzq3.packageName), this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                        }
                        if (zzq3.zzdy != null) {
                            arrayList2.add(zzq3.zzdy);
                        }
                        zzq3.zzdw = new zzjn(zzjp);
                        zzq3.active = true;
                        zzgy().zza(zzq3);
                    }
                }
                zzd(zzai2, zzn2);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    zzd(new zzai((zzai) obj2, j), zzn2);
                }
                zzgy().setTransactionSuccessful();
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:249:0x0853 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0883 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0272 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02a9 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02f7 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0324  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(com.google.android.gms.measurement.internal.zzai r28, com.google.android.gms.measurement.internal.zzn r29) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)
            java.lang.String r5 = r3.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r27.zzo()
            r27.zzjj()
            java.lang.String r15 = r3.packageName
            com.google.android.gms.measurement.internal.zzjo r7 = r27.zzgw()
            boolean r7 = r7.zze(r2, r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.zzcq
            if (r7 != 0) goto L_0x002f
            r1.zzg(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.zzfd r7 = r27.zzgz()
            java.lang.String r8 = r2.name
            boolean r7 = r7.zzk(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            r12 = 1
            if (r7 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r15)
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzy()
            java.lang.String r6 = r2.name
            java.lang.String r5 = r5.zzaj(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfd r3 = r27.zzgz()
            boolean r3 = r3.zzbc(r15)
            if (r3 != 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzfd r3 = r27.zzgz()
            boolean r3 = r3.zzbd(r15)
            if (r3 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r3 = 0
            goto L_0x0076
        L_0x0075:
            r3 = 1
        L_0x0076:
            if (r3 != 0) goto L_0x0091
            java.lang.String r4 = r2.name
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzjs r7 = r4.zzz()
            r9 = 11
            java.lang.String r11 = r2.name
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)
        L_0x0091:
            if (r3 == 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzab(r15)
            if (r2 == 0) goto L_0x00da
            long r3 = r2.zzat()
            long r5 = r2.zzas()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzx()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzhe
            java.lang.Object r5 = r5.get(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgr()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zzao(r4)
            r1.zzb(r2)
        L_0x00da:
            return
        L_0x00db:
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()
            r10 = 2
            boolean r7 = r7.isLoggable(r10)
            if (r7 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgs()
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzed r8 = r8.zzy()
            java.lang.String r8 = r8.zzb(r2)
            java.lang.String r9 = "Logging event"
            r7.zza(r9, r8)
        L_0x0101:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()
            r7.beginTransaction()
            r1.zzg(r3)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "_iap"
            java.lang.String r8 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "ecommerce_purchase"
            if (r7 != 0) goto L_0x0125
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0120
            goto L_0x0125
        L_0x0120:
            r23 = r5
            r6 = 0
            goto L_0x02b8
        L_0x0125:
            com.google.android.gms.measurement.internal.zzah r7 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "currency"
            java.lang.String r7 = r7.getString(r9)     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "value"
            if (r8 == 0) goto L_0x018c
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.Double r8 = r8.zzah(r9)     // Catch:{ all -> 0x08c8 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x08c8 }
            r18 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r18
            r20 = 0
            int r8 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r8 != 0) goto L_0x015e
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = r8.getLong(r9)     // Catch:{ all -> 0x08c8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c8 }
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r16 = r8 * r18
        L_0x015e:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 > 0) goto L_0x016f
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 < 0) goto L_0x016f
            long r8 = java.lang.Math.round(r16)     // Catch:{ all -> 0x08c8 }
            goto L_0x0196
        L_0x016f:
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c8 }
            java.lang.Double r10 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x08c8 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x08c8 }
            r23 = r5
            r6 = 0
            r11 = 0
            goto L_0x02a7
        L_0x018c:
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = r8.getLong(r9)     // Catch:{ all -> 0x08c8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c8 }
        L_0x0196:
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r10 != 0) goto L_0x02a3
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.toUpperCase(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = "[A-Z]{3}"
            boolean r10 = r7.matches(r10)     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x02a3
            java.lang.String r10 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            int r16 = r7.length()     // Catch:{ all -> 0x08c8 }
            if (r16 == 0) goto L_0x01bb
            java.lang.String r7 = r10.concat(r7)     // Catch:{ all -> 0x08c8 }
            goto L_0x01c0
        L_0x01bb:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x08c8 }
            r7.<init>(r10)     // Catch:{ all -> 0x08c8 }
        L_0x01c0:
            r10 = r7
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r7 = r7.zze(r15, r10)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0201
            java.lang.Object r11 = r7.value     // Catch:{ all -> 0x08c8 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x08c8 }
            if (r11 != 0) goto L_0x01d2
            goto L_0x0201
        L_0x01d2:
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x08c8 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x08c8 }
            long r19 = r7.longValue()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r17 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r2.origin     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.util.Clock r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            long r21 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c8 }
            long r19 = r19 + r8
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x08c8 }
            r7 = r17
            r8 = r15
            r9 = r11
            r11 = 2
            r23 = r5
            r5 = 1
            r6 = 0
            r11 = r21
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c8 }
            r5 = r17
            goto L_0x0268
        L_0x0201:
            r23 = r5
            r5 = 1
            r6 = 0
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzak.zzhj     // Catch:{ all -> 0x08c8 }
            int r11 = r11.zzb(r15, r12)     // Catch:{ all -> 0x08c8 }
            int r11 = r11 - r5
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x08c8 }
            r7.zzo()     // Catch:{ all -> 0x08c8 }
            r7.zzbi()     // Catch:{ all -> 0x08c8 }
            android.database.sqlite.SQLiteDatabase r12 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x023a }
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x023a }
            r16 = 1
            r5[r16] = r15     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x023a }
            r16 = 2
            r5[r16] = r11     // Catch:{ SQLiteException -> 0x023a }
            r12.execSQL(r13, r5)     // Catch:{ SQLiteException -> 0x023a }
            goto L_0x024d
        L_0x023a:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c8 }
            r7.zza(r11, r12, r5)     // Catch:{ all -> 0x08c8 }
        L_0x024d:
            com.google.android.gms.measurement.internal.zzjp r5 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r2.origin     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.util.Clock r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            long r12 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c8 }
            java.lang.Long r16 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x08c8 }
            r7 = r5
            r8 = r15
            r9 = r11
            r11 = r12
            r13 = r16
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c8 }
        L_0x0268:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zza(r5)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x02a6
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzed r10 = r10.zzy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r5.name     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r10.zzal(r11)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r5 = r5.value     // Catch:{ all -> 0x08c8 }
            r7.zza(r8, r9, r10, r5)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r5.zzz()     // Catch:{ all -> 0x08c8 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x08c8 }
            goto L_0x02a6
        L_0x02a3:
            r23 = r5
            r6 = 0
        L_0x02a6:
            r11 = 1
        L_0x02a7:
            if (r11 != 0) goto L_0x02b8
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x02b8:
            java.lang.String r5 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r5 = com.google.android.gms.measurement.internal.zzjs.zzbk(r5)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r16 = r14.equals(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r8 = r27.zzjk()     // Catch:{ all -> 0x08c8 }
            r11 = 1
            r13 = 0
            r17 = 0
            r10 = r15
            r12 = r5
            r14 = r16
            r18 = r15
            r15 = r17
            com.google.android.gms.measurement.internal.zzw r7 = r7.zza(r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x08c8 }
            long r8 = r7.zzeg     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzak.zzgp     // Catch:{ all -> 0x08c8 }
            r14 = 0
            java.lang.Object r10 = r10.get(r14)     // Catch:{ all -> 0x08c8 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x08c8 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x08c8 }
            long r10 = (long) r10     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 1
            r14 = 0
            int r17 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r17 <= 0) goto L_0x0324
            long r8 = r8 % r10
            int r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c8 }
            long r5 = r7.zzeg     // Catch:{ all -> 0x08c8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c8 }
        L_0x0315:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x0324:
            if (r5 == 0) goto L_0x037c
            long r8 = r7.zzef     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.zzak.zzgr     // Catch:{ all -> 0x08c8 }
            r12 = 0
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x08c8 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x08c8 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x08c8 }
            long r12 = (long) r6     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r12
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x037c
            long r8 = r8 % r10
            r3 = 1
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c8 }
            long r6 = r7.zzef     // Catch:{ all -> 0x08c8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x08c8 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x08c8 }
        L_0x035b:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r3.zzz()     // Catch:{ all -> 0x08c8 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.name     // Catch:{ all -> 0x08c8 }
            r12 = 0
            r8 = r18
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x037c:
            if (r16 == 0) goto L_0x03ce
            long r8 = r7.zzei     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzak.zzgq     // Catch:{ all -> 0x08c8 }
            int r6 = r6.zzb(r10, r11)     // Catch:{ all -> 0x08c8 }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = java.lang.Math.min(r10, r6)     // Catch:{ all -> 0x08c8 }
            r12 = 0
            int r6 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x08c8 }
            long r10 = (long) r6     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r10
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x03cf
            r10 = 1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c8 }
            long r5 = r7.zzei     // Catch:{ all -> 0x08c8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c8 }
        L_0x03bf:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x03ce:
            r12 = 0
        L_0x03cf:
            com.google.android.gms.measurement.internal.zzah r6 = r2.zzfq     // Catch:{ all -> 0x08c8 }
            android.os.Bundle r6 = r6.zzcv()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.origin     // Catch:{ all -> 0x08c8 }
            r7.zza(r6, r8, r9)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            r13 = r18
            boolean r7 = r7.zzbr(r13)     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x0410
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_dbg"
            r9 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c8 }
            r7.zza(r6, r8, r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c8 }
            r7.zza(r6, r11, r8)     // Catch:{ all -> 0x08c8 }
        L_0x0410:
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zzw(r9)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r7 = r7.zze(r9, r8)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0445
            java.lang.Object r9 = r7.value     // Catch:{ all -> 0x08c8 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x08c8 }
            if (r9 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r9 = r9.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x08c8 }
            r9.zza(r6, r8, r7)     // Catch:{ all -> 0x08c8 }
        L_0x0445:
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x08c8 }
            if (r4 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzif     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.zze(r7, r9)     // Catch:{ all -> 0x08c8 }
            if (r4 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.zzw(r7)     // Catch:{ all -> 0x08c8 }
            if (r4 != 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzjn r4 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x08c8 }
            r12 = 0
            r4.<init>(r8, r14, r12)     // Catch:{ all -> 0x08c8 }
            r1.zzc(r4, r3)     // Catch:{ all -> 0x08c8 }
            goto L_0x0476
        L_0x0475:
            r12 = 0
        L_0x0476:
            com.google.android.gms.measurement.internal.zzx r4 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r7 = r4.zzac(r13)     // Catch:{ all -> 0x08c8 }
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x0499
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x08c8 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x08c8 }
        L_0x0499:
            com.google.android.gms.measurement.internal.zzaf r4 = new com.google.android.gms.measurement.internal.zzaf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r2.origin     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x08c8 }
            long r14 = r2.zzfu     // Catch:{ all -> 0x08c8 }
            r19 = 0
            r7 = r4
            r2 = r10
            r10 = r13
            r26 = r11
            r11 = r2
            r16 = r12
            r2 = r13
            r25 = 0
            r12 = r14
            r28 = r16
            r14 = r19
            r16 = r6
            r7.<init>(r8, r9, r10, r11, r12, r14, r16)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r4.name     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc(r2, r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x052c
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r6 = r6.zzag(r2)     // Catch:{ all -> 0x08c8 }
            r8 = 500(0x1f4, double:2.47E-321)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0512
            if (r5 == 0) goto L_0x0512
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzed r7 = r7.zzy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r7.zzaj(r4)     // Catch:{ all -> 0x08c8 }
            r7 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r3.zzz()     // Catch:{ all -> 0x08c8 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x0512:
            com.google.android.gms.measurement.internal.zzae r5 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r4.name     // Catch:{ all -> 0x08c8 }
            r10 = 0
            r12 = 0
            long r14 = r4.timestamp     // Catch:{ all -> 0x08c8 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r5
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x08c8 }
            goto L_0x053a
        L_0x052c:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            long r7 = r6.zzfj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zza(r2, r7)     // Catch:{ all -> 0x08c8 }
            long r7 = r4.timestamp     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzae r5 = r6.zzw(r7)     // Catch:{ all -> 0x08c8 }
        L_0x053a:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.zza(r5)     // Catch:{ all -> 0x08c8 }
            r27.zzo()     // Catch:{ all -> 0x08c8 }
            r27.zzjj()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)     // Catch:{ all -> 0x08c8 }
            java.lang.String r2 = r4.zzce     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x08c8 }
            java.lang.String r2 = r4.zzce     // Catch:{ all -> 0x08c8 }
            java.lang.String r5 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = com.google.android.gms.internal.measurement.zzbs$zzg.zzpr()     // Catch:{ all -> 0x08c8 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r2.zzp(r5)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "android"
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r2.zzcc(r6)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0579
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x08c8 }
            r2.zzch(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0579:
            java.lang.String r6 = r3.zzco     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0586
            java.lang.String r6 = r3.zzco     // Catch:{ all -> 0x08c8 }
            r2.zzcg(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0586:
            java.lang.String r6 = r3.zzcm     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0593
            java.lang.String r6 = r3.zzcm     // Catch:{ all -> 0x08c8 }
            r2.zzci(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0593:
            long r6 = r3.zzcn     // Catch:{ all -> 0x08c8 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05a2
            long r6 = r3.zzcn     // Catch:{ all -> 0x08c8 }
            int r7 = (int) r6     // Catch:{ all -> 0x08c8 }
            r2.zzv(r7)     // Catch:{ all -> 0x08c8 }
        L_0x05a2:
            long r6 = r3.zzr     // Catch:{ all -> 0x08c8 }
            r2.zzas(r6)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = r3.zzcg     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05b4
            java.lang.String r6 = r3.zzcg     // Catch:{ all -> 0x08c8 }
            r2.zzcm(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05b4:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzit     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zza(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x05da
            java.lang.String r6 = r2.getGmpAppId()     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x05e7
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            r2.zzcq(r6)     // Catch:{ all -> 0x08c8 }
            goto L_0x05e7
        L_0x05da:
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c8 }
            r2.zzcq(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05e7:
            long r6 = r3.zzcp     // Catch:{ all -> 0x08c8 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05f4
            long r6 = r3.zzcp     // Catch:{ all -> 0x08c8 }
            r2.zzau(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05f4:
            long r6 = r3.zzs     // Catch:{ all -> 0x08c8 }
            r2.zzax(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzak.zzin     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zze(r7, r10)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0616
            com.google.android.gms.measurement.internal.zzjo r6 = r27.zzgw()     // Catch:{ all -> 0x08c8 }
            java.util.List r6 = r6.zzju()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0616
            r2.zzd(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0616:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzac()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            android.util.Pair r6 = r6.zzap(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0649
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c8 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x0649
            boolean r7 = r3.zzcs     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06ab
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x08c8 }
            r2.zzcj(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r7 = r6.second     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06ab
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x08c8 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x08c8 }
            r2.zzm(r6)     // Catch:{ all -> 0x08c8 }
            goto L_0x06ab
        L_0x0649:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            android.content.Context r7 = r7.getContext()     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zzj(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x06ab
            boolean r6 = r3.zzct     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x06ab
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x08c8 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x068b
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r2.zzag()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r10)     // Catch:{ all -> 0x08c8 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "null"
            goto L_0x06a8
        L_0x068b:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06a8
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgn()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r11 = r2.zzag()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x08c8 }
            r7.zza(r10, r11)     // Catch:{ all -> 0x08c8 }
        L_0x06a8:
            r2.zzco(r6)     // Catch:{ all -> 0x08c8 }
        L_0x06ab:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()     // Catch:{ all -> 0x08c8 }
            r6.zzbi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r2.zzce(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c8 }
            r7.zzbi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzcd(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c8 }
            long r10 = r7.zzcq()     // Catch:{ all -> 0x08c8 }
            int r7 = (int) r10     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzt(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzcr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzcf(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcr     // Catch:{ all -> 0x08c8 }
            r6.zzaw(r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.isEnabled()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0707
            boolean r6 = com.google.android.gms.measurement.internal.zzs.zzbv()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0707
            r2.zzag()     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0707
            r6 = r28
            r2.zzcp(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0707:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzab(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x077a
            com.google.android.gms.measurement.internal.zzf r6 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c8 }
            r6.<init>(r7, r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzjy()     // Catch:{ all -> 0x08c8 }
            r6.zza(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzci     // Catch:{ all -> 0x08c8 }
            r6.zze(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzcg     // Catch:{ all -> 0x08c8 }
            r6.zzb(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzaq(r10)     // Catch:{ all -> 0x08c8 }
            r6.zzd(r7)     // Catch:{ all -> 0x08c8 }
            r6.zzk(r8)     // Catch:{ all -> 0x08c8 }
            r6.zze(r8)     // Catch:{ all -> 0x08c8 }
            r6.zzf(r8)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzcm     // Catch:{ all -> 0x08c8 }
            r6.zzf(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcn     // Catch:{ all -> 0x08c8 }
            r6.zzg(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzco     // Catch:{ all -> 0x08c8 }
            r6.zzg(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzr     // Catch:{ all -> 0x08c8 }
            r6.zzh(r10)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcp     // Catch:{ all -> 0x08c8 }
            r6.zzi(r10)     // Catch:{ all -> 0x08c8 }
            boolean r7 = r3.zzcq     // Catch:{ all -> 0x08c8 }
            r6.setMeasurementEnabled(r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzcr     // Catch:{ all -> 0x08c8 }
            r6.zzt(r10)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzs     // Catch:{ all -> 0x08c8 }
            r6.zzj(r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r7.zza(r6)     // Catch:{ all -> 0x08c8 }
        L_0x077a:
            java.lang.String r7 = r6.getAppInstanceId()     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x078b
            java.lang.String r7 = r6.getAppInstanceId()     // Catch:{ all -> 0x08c8 }
            r2.zzck(r7)     // Catch:{ all -> 0x08c8 }
        L_0x078b:
            java.lang.String r7 = r6.getFirebaseInstanceId()     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x079c
            java.lang.String r6 = r6.getFirebaseInstanceId()     // Catch:{ all -> 0x08c8 }
            r2.zzcn(r6)     // Catch:{ all -> 0x08c8 }
        L_0x079c:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = r3.packageName     // Catch:{ all -> 0x08c8 }
            java.util.List r3 = r6.zzaa(r3)     // Catch:{ all -> 0x08c8 }
            r6 = 0
        L_0x07a7:
            int r7 = r3.size()     // Catch:{ all -> 0x08c8 }
            if (r6 >= r7) goto L_0x07de
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r7 = com.google.android.gms.internal.measurement.zzbs$zzk.zzqu()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r10 = (com.google.android.gms.measurement.internal.zzjp) r10     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r10.name     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r7 = r7.zzdb(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r10 = (com.google.android.gms.measurement.internal.zzjp) r10     // Catch:{ all -> 0x08c8 }
            long r10 = r10.zztr     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r7 = r7.zzbk(r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjo r10 = r27.zzgw()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjp r11 = (com.google.android.gms.measurement.internal.zzjp) r11     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = r11.value     // Catch:{ all -> 0x08c8 }
            r10.zza(r7, r11)     // Catch:{ all -> 0x08c8 }
            r2.zza(r7)     // Catch:{ all -> 0x08c8 }
            int r6 = r6 + 1
            goto L_0x07a7
        L_0x07de:
            com.google.android.gms.measurement.internal.zzx r3 = r27.zzgy()     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzgi r6 = r2.zzug()     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzey r6 = (com.google.android.gms.internal.measurement.zzey) r6     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = (com.google.android.gms.internal.measurement.zzbs$zzg) r6     // Catch:{ IOException -> 0x0856 }
            long r2 = r3.zza(r6)     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzah r7 = r4.zzfq     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x084c
            com.google.android.gms.measurement.internal.zzah r7 = r4.zzfq     // Catch:{ all -> 0x08c8 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x08c8 }
        L_0x07fc:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x0814
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x08c8 }
            r11 = r26
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x0811
            goto L_0x084d
        L_0x0811:
            r26 = r11
            goto L_0x07fc
        L_0x0814:
            com.google.android.gms.measurement.internal.zzfd r7 = r27.zzgz()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r4.zzce     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r4.name     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zzl(r10, r11)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r10 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            long r11 = r27.zzjk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r13 = r4.zzce     // Catch:{ all -> 0x08c8 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzw r10 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x084c
            long r10 = r10.zzej     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x08c8 }
            java.lang.String r12 = r4.zzce     // Catch:{ all -> 0x08c8 }
            int r7 = r7.zzi(r12)     // Catch:{ all -> 0x08c8 }
            long r12 = (long) r7     // Catch:{ all -> 0x08c8 }
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x084c
            goto L_0x084d
        L_0x084c:
            r5 = 0
        L_0x084d:
            boolean r2 = r6.zza(r4, r2, r5)     // Catch:{ all -> 0x08c8 }
            if (r2 == 0) goto L_0x086f
            r1.zzsy = r8     // Catch:{ all -> 0x08c8 }
            goto L_0x086f
        L_0x0856:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzag()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x08c8 }
            r5.zza(r6, r2, r3)     // Catch:{ all -> 0x08c8 }
        L_0x086f:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            r3 = 2
            boolean r2 = r2.isLoggable(r3)     // Catch:{ all -> 0x08c8 }
            if (r2 == 0) goto L_0x089c
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzy()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r5.zza(r4)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x08c8 }
        L_0x089c:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            r27.zzjn()
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x08c8:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzx r3 = r27.zzgy()
            r3.endTransaction()
            goto L_0x08d3
        L_0x08d2:
            throw r2
        L_0x08d3:
            goto L_0x08d2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzd(com.google.android.gms.measurement.internal.zzai, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1.zzj.zzab().zzgk().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzef.zzam(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x02c4 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzjl() {
        /*
            r17 = this;
            r1 = r17
            r17.zzo()
            r17.zzjj()
            r0 = 1
            r1.zzte = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0300 }
            r3.zzae()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzhv r3 = r3.zzs()     // Catch:{ all -> 0x0300 }
            java.lang.Boolean r3 = r3.zzit()     // Catch:{ all -> 0x0300 }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zzao(r3)     // Catch:{ all -> 0x0300 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0300 }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zzao(r3)     // Catch:{ all -> 0x0300 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x004d:
            long r3 = r1.zzsy     // Catch:{ all -> 0x0300 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005e
            r17.zzjn()     // Catch:{ all -> 0x0300 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x005e:
            r17.zzo()     // Catch:{ all -> 0x0300 }
            java.util.List<java.lang.Long> r3 = r1.zzth     // Catch:{ all -> 0x0300 }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zzao(r3)     // Catch:{ all -> 0x0300 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzej r3 = r17.zzjf()     // Catch:{ all -> 0x0300 }
            boolean r3 = r3.zzgv()     // Catch:{ all -> 0x0300 }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zzao(r3)     // Catch:{ all -> 0x0300 }
            r17.zzjn()     // Catch:{ all -> 0x0300 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.common.util.Clock r3 = r3.zzx()     // Catch:{ all -> 0x0300 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0300 }
            long r7 = com.google.android.gms.measurement.internal.zzs.zzbt()     // Catch:{ all -> 0x0300 }
            long r7 = r3 - r7
            r9 = 0
            r1.zzd(r9, r7)     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzlj     // Catch:{ all -> 0x0300 }
            long r7 = r7.get()     // Catch:{ all -> 0x0300 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgr()     // Catch:{ all -> 0x0300 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0300 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0300 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0300 }
        L_0x00de:
            com.google.android.gms.measurement.internal.zzx r5 = r17.zzgy()     // Catch:{ all -> 0x0300 }
            java.lang.String r5 = r5.zzby()     // Catch:{ all -> 0x0300 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0300 }
            r7 = -1
            if (r6 != 0) goto L_0x02d8
            long r10 = r1.zztj     // Catch:{ all -> 0x0300 }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzx r6 = r17.zzgy()     // Catch:{ all -> 0x0300 }
            long r6 = r6.zzcf()     // Catch:{ all -> 0x0300 }
            r1.zztj = r6     // Catch:{ all -> 0x0300 }
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzgl     // Catch:{ all -> 0x0300 }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzak.zzgm     // Catch:{ all -> 0x0300 }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x0300 }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzx r8 = r17.zzgy()     // Catch:{ all -> 0x0300 }
            java.util.List r6 = r8.zza(r5, r6, r7)     // Catch:{ all -> 0x0300 }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0300 }
            if (r7 != 0) goto L_0x02fa
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x0300 }
        L_0x012c:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0300 }
            if (r8 == 0) goto L_0x014b
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0300 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0300 }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = (com.google.android.gms.internal.measurement.zzbs$zzg) r8     // Catch:{ all -> 0x0300 }
            java.lang.String r10 = r8.zzot()     // Catch:{ all -> 0x0300 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0300 }
            if (r10 != 0) goto L_0x012c
            java.lang.String r7 = r8.zzot()     // Catch:{ all -> 0x0300 }
            goto L_0x014c
        L_0x014b:
            r7 = r9
        L_0x014c:
            if (r7 == 0) goto L_0x017b
            r8 = 0
        L_0x014f:
            int r10 = r6.size()     // Catch:{ all -> 0x0300 }
            if (r8 >= r10) goto L_0x017b
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x0300 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0300 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = (com.google.android.gms.internal.measurement.zzbs$zzg) r10     // Catch:{ all -> 0x0300 }
            java.lang.String r11 = r10.zzot()     // Catch:{ all -> 0x0300 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0300 }
            if (r11 != 0) goto L_0x0178
            java.lang.String r10 = r10.zzot()     // Catch:{ all -> 0x0300 }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x0300 }
            if (r10 != 0) goto L_0x0178
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x0300 }
            goto L_0x017b
        L_0x0178:
            int r8 = r8 + 1
            goto L_0x014f
        L_0x017b:
            com.google.android.gms.internal.measurement.zzbs$zzf$zza r7 = com.google.android.gms.internal.measurement.zzbs$zzf.zznj()     // Catch:{ all -> 0x0300 }
            int r8 = r6.size()     // Catch:{ all -> 0x0300 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0300 }
            int r11 = r6.size()     // Catch:{ all -> 0x0300 }
            r10.<init>(r11)     // Catch:{ all -> 0x0300 }
            boolean r11 = com.google.android.gms.measurement.internal.zzs.zzbv()     // Catch:{ all -> 0x0300 }
            if (r11 == 0) goto L_0x01a0
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x0300 }
            boolean r11 = r11.zzl(r5)     // Catch:{ all -> 0x0300 }
            if (r11 == 0) goto L_0x01a0
            r11 = 1
            goto L_0x01a1
        L_0x01a0:
            r11 = 0
        L_0x01a1:
            r12 = 0
        L_0x01a2:
            if (r12 >= r8) goto L_0x020b
            java.lang.Object r13 = r6.get(r12)     // Catch:{ all -> 0x0300 }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x0300 }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg r13 = (com.google.android.gms.internal.measurement.zzbs$zzg) r13     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzey$zza r13 = r13.zzuj()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzbs$zzg.zza) r13     // Catch:{ all -> 0x0300 }
            java.lang.Object r14 = r6.get(r12)     // Catch:{ all -> 0x0300 }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x0300 }
            java.lang.Object r14 = r14.second     // Catch:{ all -> 0x0300 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0300 }
            r10.add(r14)     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzad()     // Catch:{ all -> 0x0300 }
            long r14 = r14.zzao()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r14 = r13.zzat(r14)     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r14 = r14.zzan(r3)     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzfj r15 = r1.zzj     // Catch:{ all -> 0x0300 }
            r15.zzae()     // Catch:{ all -> 0x0300 }
            r14.zzn(r2)     // Catch:{ all -> 0x0300 }
            if (r11 != 0) goto L_0x01e0
            r13.zznw()     // Catch:{ all -> 0x0300 }
        L_0x01e0:
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzad()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzak.zzis     // Catch:{ all -> 0x0300 }
            boolean r14 = r14.zze(r5, r15)     // Catch:{ all -> 0x0300 }
            if (r14 == 0) goto L_0x0205
            com.google.android.gms.internal.measurement.zzgi r14 = r13.zzug()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzey r14 = (com.google.android.gms.internal.measurement.zzey) r14     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = (com.google.android.gms.internal.measurement.zzbs$zzg) r14     // Catch:{ all -> 0x0300 }
            byte[] r14 = r14.toByteArray()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzjo r15 = r17.zzgw()     // Catch:{ all -> 0x0300 }
            long r14 = r15.zza(r14)     // Catch:{ all -> 0x0300 }
            r13.zzay(r14)     // Catch:{ all -> 0x0300 }
        L_0x0205:
            r7.zza(r13)     // Catch:{ all -> 0x0300 }
            int r12 = r12 + 1
            goto L_0x01a2
        L_0x020b:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzab()     // Catch:{ all -> 0x0300 }
            r11 = 2
            boolean r6 = r6.isLoggable(r11)     // Catch:{ all -> 0x0300 }
            if (r6 == 0) goto L_0x0229
            com.google.android.gms.measurement.internal.zzjo r6 = r17.zzgw()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzf r11 = (com.google.android.gms.internal.measurement.zzbs$zzf) r11     // Catch:{ all -> 0x0300 }
            java.lang.String r6 = r6.zza(r11)     // Catch:{ all -> 0x0300 }
            goto L_0x022a
        L_0x0229:
            r6 = r9
        L_0x022a:
            r17.zzgw()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0300 }
            com.google.android.gms.internal.measurement.zzbs$zzf r11 = (com.google.android.gms.internal.measurement.zzbs$zzf) r11     // Catch:{ all -> 0x0300 }
            byte[] r14 = r11.toByteArray()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.String> r11 = com.google.android.gms.measurement.internal.zzak.zzgv     // Catch:{ all -> 0x0300 }
            java.lang.Object r9 = r11.get(r9)     // Catch:{ all -> 0x0300 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0300 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02c4 }
            r13.<init>(r9)     // Catch:{ MalformedURLException -> 0x02c4 }
            boolean r11 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x02c4 }
            if (r11 != 0) goto L_0x024e
            r11 = 1
            goto L_0x024f
        L_0x024e:
            r11 = 0
        L_0x024f:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ MalformedURLException -> 0x02c4 }
            java.util.List<java.lang.Long> r11 = r1.zzth     // Catch:{ MalformedURLException -> 0x02c4 }
            if (r11 == 0) goto L_0x0266
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgk()     // Catch:{ MalformedURLException -> 0x02c4 }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r10.zzao(r11)     // Catch:{ MalformedURLException -> 0x02c4 }
            goto L_0x026d
        L_0x0266:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02c4 }
            r11.<init>(r10)     // Catch:{ MalformedURLException -> 0x02c4 }
            r1.zzth = r11     // Catch:{ MalformedURLException -> 0x02c4 }
        L_0x026d:
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzac()     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzlk     // Catch:{ MalformedURLException -> 0x02c4 }
            r10.set(r3)     // Catch:{ MalformedURLException -> 0x02c4 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0284
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r7.zzo(r2)     // Catch:{ MalformedURLException -> 0x02c4 }
            java.lang.String r3 = r3.zzag()     // Catch:{ MalformedURLException -> 0x02c4 }
        L_0x0284:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ MalformedURLException -> 0x02c4 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x02c4 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02c4 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x02c4 }
            r1.zztd = r0     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzej r11 = r17.zzjf()     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzji r0 = new com.google.android.gms.measurement.internal.zzji     // Catch:{ MalformedURLException -> 0x02c4 }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x02c4 }
            r11.zzo()     // Catch:{ MalformedURLException -> 0x02c4 }
            r11.zzbi()     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzfc r3 = r11.zzaa()     // Catch:{ MalformedURLException -> 0x02c4 }
            com.google.android.gms.measurement.internal.zzen r4 = new com.google.android.gms.measurement.internal.zzen     // Catch:{ MalformedURLException -> 0x02c4 }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x02c4 }
            r3.zzb(r4)     // Catch:{ MalformedURLException -> 0x02c4 }
            goto L_0x02fa
        L_0x02c4:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0300 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r5)     // Catch:{ all -> 0x0300 }
            r0.zza(r3, r4, r9)     // Catch:{ all -> 0x0300 }
            goto L_0x02fa
        L_0x02d8:
            r1.zztj = r7     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzx r0 = r17.zzgy()     // Catch:{ all -> 0x0300 }
            long r5 = com.google.android.gms.measurement.internal.zzs.zzbt()     // Catch:{ all -> 0x0300 }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zzu(r3)     // Catch:{ all -> 0x0300 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0300 }
            if (r3 != 0) goto L_0x02fa
            com.google.android.gms.measurement.internal.zzx r3 = r17.zzgy()     // Catch:{ all -> 0x0300 }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzab(r0)     // Catch:{ all -> 0x0300 }
            if (r0 == 0) goto L_0x02fa
            r1.zzb(r0)     // Catch:{ all -> 0x0300 }
        L_0x02fa:
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x0300:
            r0 = move-exception
            r1.zzte = r2
            r17.zzjo()
            goto L_0x0308
        L_0x0307:
            throw r0
        L_0x0308:
            goto L_0x0307
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzjl():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r6 = r1;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r5 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009b, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:504:0x0c61, code lost:
        if (r26 != r14) goto L_0x0c63;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
  PHI: (r3v50 android.database.Cursor) = (r3v44 android.database.Cursor), (r3v44 android.database.Cursor), (r3v44 android.database.Cursor), (r3v53 android.database.Cursor), (r3v53 android.database.Cursor), (r3v53 android.database.Cursor), (r3v53 android.database.Cursor), (r3v0 android.database.Cursor), (r3v0 android.database.Cursor) binds: [B:47:0x00dc, B:53:0x00e9, B:54:?, B:24:0x007d, B:30:0x008a, B:32:0x008e, B:33:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x028f A[SYNTHETIC, Splitter:B:155:0x028f] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0296 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02a4 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03d6 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x03e1 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03e2 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x05f0 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x061d A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x06b9 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0761 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0777 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0791 A[Catch:{ IOException -> 0x0237, all -> 0x0f18 }] */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0baa A[Catch:{ all -> 0x0ef6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x0bac A[Catch:{ all -> 0x0ef6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0bb4 A[SYNTHETIC, Splitter:B:472:0x0bb4] */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0be2 A[SYNTHETIC, Splitter:B:483:0x0be2] */
    /* JADX WARNING: Removed duplicated region for block: B:511:0x0c7f A[Catch:{ all -> 0x0ef6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0cc7 A[Catch:{ all -> 0x0ef6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x0efa  */
    /* JADX WARNING: Removed duplicated region for block: B:606:0x0f12 A[SYNTHETIC, Splitter:B:606:0x0f12] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r63, long r64) {
        /*
            r62 = this;
            r1 = r62
            com.google.android.gms.measurement.internal.zzx r2 = r62.zzgy()
            r2.beginTransaction()
            com.google.android.gms.measurement.internal.zzjg$zza r2 = new com.google.android.gms.measurement.internal.zzjg$zza     // Catch:{ all -> 0x0f18 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzx r4 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            long r5 = r1.zztj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0f18 }
            r4.zzo()     // Catch:{ all -> 0x0f18 }
            r4.zzbi()     // Catch:{ all -> 0x0f18 }
            r8 = -1
            r10 = 2
            r11 = 0
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            boolean r13 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            if (r13 == 0) goto L_0x009d
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x004c
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            r13[r11] = r14     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            java.lang.String r14 = java.lang.String.valueOf(r64)     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            r13[r12] = r14     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            goto L_0x0054
        L_0x0040:
            r0 = move-exception
            r6 = r1
            r22 = r3
            goto L_0x0275
        L_0x0046:
            r0 = move-exception
            r5 = r3
            r7 = r5
        L_0x0049:
            r3 = r0
            goto L_0x027c
        L_0x004c:
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r14 = java.lang.String.valueOf(r64)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r13[r11] = r14     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
        L_0x0054:
            int r14 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r14 == 0) goto L_0x005b
            java.lang.String r14 = "rowid <= ? and "
            goto L_0x005d
        L_0x005b:
            java.lang.String r14 = ""
        L_0x005d:
            int r7 = r14.length()     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            int r7 = r7 + 148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r3.<init>(r7)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r3.append(r7)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r3.append(r14)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r3.append(r7)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            android.database.Cursor r3 = r15.rawQuery(r3, r13)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x026c, all -> 0x0040 }
            if (r7 != 0) goto L_0x008a
            if (r3 == 0) goto L_0x0292
            r3.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x008a:
            java.lang.String r7 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x026c, all -> 0x0040 }
            java.lang.String r13 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x009a, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x009a, all -> 0x0040 }
            r23 = r3
            r3 = r7
            r7 = r13
            goto L_0x00f4
        L_0x009a:
            r0 = move-exception
            r5 = r3
            goto L_0x0049
        L_0x009d:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00ad
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r7 = 0
            r3[r11] = r7     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r3[r12] = r7     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            goto L_0x00b3
        L_0x00ad:
            r3 = 0
            java.lang.String[] r7 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r3 = r7
        L_0x00b3:
            int r7 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x00ba
            java.lang.String r7 = " and rowid <= ?"
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r7 = ""
        L_0x00bc:
            int r13 = r7.length()     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            int r13 = r13 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r14.<init>(r13)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r13 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r13)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            r14.append(r7)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r7 = " order by rowid limit 1;"
            r14.append(r7)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            java.lang.String r7 = r14.toString()     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            android.database.Cursor r3 = r15.rawQuery(r7, r3)     // Catch:{ SQLiteException -> 0x0278, all -> 0x0271 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x026c, all -> 0x0040 }
            if (r7 != 0) goto L_0x00e9
            if (r3 == 0) goto L_0x0292
            r3.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x00e9:
            java.lang.String r13 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x026c, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x026c, all -> 0x0040 }
            r23 = r3
            r7 = r13
            r3 = 0
        L_0x00f4:
            java.lang.String r14 = "raw_events_metadata"
            java.lang.String r13 = "metadata"
            java.lang.String[] r16 = new java.lang.String[]{r13}     // Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
            java.lang.String r17 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
            r13[r11] = r3     // Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "2"
            r24 = r13
            r13 = r15
            r25 = r15
            r15 = r16
            r16 = r17
            r17 = r24
            android.database.Cursor r15 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
            boolean r13 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            if (r13 != 0) goto L_0x0144
            com.google.android.gms.measurement.internal.zzef r5 = r4.zzab()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            if (r15 == 0) goto L_0x0292
            r15.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x0139:
            r0 = move-exception
            r6 = r1
            r22 = r15
            goto L_0x0275
        L_0x013f:
            r0 = move-exception
            r7 = r3
            r5 = r15
            goto L_0x0049
        L_0x0144:
            byte[] r13 = r15.getBlob(r11)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            com.google.android.gms.internal.measurement.zzel r14 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x0237 }
            com.google.android.gms.internal.measurement.zzbs$zzg r13 = com.google.android.gms.internal.measurement.zzbs$zzg.zzd(r13, r14)     // Catch:{ IOException -> 0x0237 }
            boolean r14 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            if (r14 == 0) goto L_0x0167
            com.google.android.gms.measurement.internal.zzef r14 = r4.zzab()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzgn()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            java.lang.String r10 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r14.zza(r10, r12)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
        L_0x0167:
            r15.close()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r2.zzb(r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0187
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r13[r11] = r3     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r12 = 1
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r6 = 2
            r13[r6] = r5     // Catch:{ SQLiteException -> 0x013f, all -> 0x0139 }
            r16 = r10
            r17 = r13
            goto L_0x0195
        L_0x0187:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r10[r11] = r3     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r6 = 1
            r10[r6] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r16 = r5
            r17 = r10
        L_0x0195:
            java.lang.String r14 = "raw_events"
            java.lang.String r5 = "rowid"
            java.lang.String r6 = "name"
            java.lang.String r7 = "timestamp"
            java.lang.String r10 = "data"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r10}     // Catch:{ SQLiteException -> 0x025b, all -> 0x0255 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            r21 = 0
            r13 = r25
            r6 = r15
            r15 = r5
            android.database.Cursor r5 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0253, all -> 0x0251 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            if (r6 != 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzef r6 = r4.zzab()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgn()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            r6.zza(r7, r10)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            if (r5 == 0) goto L_0x0292
            r5.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x01d1:
            long r6 = r5.getLong(r11)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            r10 = 3
            byte[] r12 = r5.getBlob(r10)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r10 = com.google.android.gms.internal.measurement.zzbs$zzc.zzmq()     // Catch:{ IOException -> 0x020e }
            com.google.android.gms.internal.measurement.zzel r13 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x020e }
            com.google.android.gms.internal.measurement.zzdh r10 = r10.zzf(r12, r13)     // Catch:{ IOException -> 0x020e }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r10 = (com.google.android.gms.internal.measurement.zzbs$zzc.zza) r10     // Catch:{ IOException -> 0x020e }
            r12 = 1
            java.lang.String r13 = r5.getString(r12)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r12 = r10.zzbx(r13)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            r13 = 2
            long r14 = r5.getLong(r13)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            r12.zzag(r14)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.internal.measurement.zzgi r10 = r10.zzug()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs$zzc) r10     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            boolean r6 = r2.zza(r6, r10)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            if (r6 != 0) goto L_0x0221
            if (r5 == 0) goto L_0x0292
            r5.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x020e:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r4.zzab()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            r7.zza(r10, r12, r6)     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
        L_0x0221:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0233, all -> 0x022e }
            if (r6 != 0) goto L_0x01d1
            if (r5 == 0) goto L_0x0292
            r5.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x022e:
            r0 = move-exception
            r6 = r1
            r22 = r5
            goto L_0x0275
        L_0x0233:
            r0 = move-exception
            r7 = r3
            goto L_0x0049
        L_0x0237:
            r0 = move-exception
            r6 = r15
            r5 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r4.zzab()     // Catch:{ SQLiteException -> 0x0253, all -> 0x0251 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ SQLiteException -> 0x0253, all -> 0x0251 }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r3)     // Catch:{ SQLiteException -> 0x0253, all -> 0x0251 }
            r7.zza(r10, r12, r5)     // Catch:{ SQLiteException -> 0x0253, all -> 0x0251 }
            if (r6 == 0) goto L_0x0292
            r6.close()     // Catch:{ all -> 0x0f18 }
            goto L_0x0292
        L_0x0251:
            r0 = move-exception
            goto L_0x0257
        L_0x0253:
            r0 = move-exception
            goto L_0x025d
        L_0x0255:
            r0 = move-exception
            r6 = r15
        L_0x0257:
            r22 = r6
            r6 = r1
            goto L_0x0275
        L_0x025b:
            r0 = move-exception
            r6 = r15
        L_0x025d:
            r7 = r3
            r5 = r6
            goto L_0x0049
        L_0x0261:
            r0 = move-exception
            r6 = r1
            r22 = r23
            goto L_0x0275
        L_0x0266:
            r0 = move-exception
            r7 = r3
            r5 = r23
            goto L_0x0049
        L_0x026c:
            r0 = move-exception
            r5 = r3
            r7 = 0
            goto L_0x0049
        L_0x0271:
            r0 = move-exception
            r6 = r1
            r22 = 0
        L_0x0275:
            r1 = r0
            goto L_0x0f10
        L_0x0278:
            r0 = move-exception
            r3 = r0
            r5 = 0
            r7 = 0
        L_0x027c:
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f0b }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x0f0b }
            java.lang.String r6 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x0f0b }
            r4.zza(r6, r7, r3)     // Catch:{ all -> 0x0f0b }
            if (r5 == 0) goto L_0x0292
            r5.close()     // Catch:{ all -> 0x0f18 }
        L_0x0292:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r3 = r2.zztp     // Catch:{ all -> 0x0f18 }
            if (r3 == 0) goto L_0x02a1
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r3 = r2.zztp     // Catch:{ all -> 0x0f18 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0f18 }
            if (r3 == 0) goto L_0x029f
            goto L_0x02a1
        L_0x029f:
            r3 = 0
            goto L_0x02a2
        L_0x02a1:
            r3 = 1
        L_0x02a2:
            if (r3 != 0) goto L_0x0efa
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r2.zztn     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r3 = r3.zzuj()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r3 = (com.google.android.gms.internal.measurement.zzbs$zzg.zza) r3     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r3 = r3.zznn()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzii     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x0f18 }
            r7 = 0
            r8 = -1
            r9 = -1
            r12 = 0
            r13 = 0
            r15 = 0
            r18 = 0
            r19 = 0
        L_0x02cd:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r11 = r2.zztp     // Catch:{ all -> 0x0f18 }
            int r11 = r11.size()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = "_et"
            java.lang.String r6 = "_e"
            r21 = r12
            r26 = r13
            if (r7 >= r11) goto L_0x07e5
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r11 = r2.zztp     // Catch:{ all -> 0x0f18 }
            java.lang.Object r11 = r11.get(r7)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r11 = (com.google.android.gms.internal.measurement.zzbs$zzc) r11     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r11 = r11.zzuj()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r11 = (com.google.android.gms.internal.measurement.zzbs$zzc.zza) r11     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfd r14 = r62.zzgz()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r10 = r10.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r12 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r10 = r14.zzk(r10, r12)     // Catch:{ all -> 0x0f18 }
            java.lang.String r12 = "_err"
            if (r10 == 0) goto L_0x037d
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgn()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r10 = r10.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r10)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r13 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzed r13 = r13.zzy()     // Catch:{ all -> 0x0f18 }
            java.lang.String r14 = r11.getName()     // Catch:{ all -> 0x0f18 }
            java.lang.String r13 = r13.zzaj(r14)     // Catch:{ all -> 0x0f18 }
            r5.zza(r6, r10, r13)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfd r5 = r62.zzgz()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f18 }
            boolean r5 = r5.zzbc(r6)     // Catch:{ all -> 0x0f18 }
            if (r5 != 0) goto L_0x034b
            com.google.android.gms.measurement.internal.zzfd r5 = r62.zzgz()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f18 }
            boolean r5 = r5.zzbd(r6)     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x0349
            goto L_0x034b
        L_0x0349:
            r5 = 0
            goto L_0x034c
        L_0x034b:
            r5 = 1
        L_0x034c:
            if (r5 != 0) goto L_0x0371
            java.lang.String r5 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r5 = r12.equals(r5)     // Catch:{ all -> 0x0f18 }
            if (r5 != 0) goto L_0x0371
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzjs r28 = r5.zzz()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r29 = r5.zzag()     // Catch:{ all -> 0x0f18 }
            r30 = 11
            java.lang.String r31 = "_ev"
            java.lang.String r32 = r11.getName()     // Catch:{ all -> 0x0f18 }
            r33 = 0
            r28.zza(r29, r30, r31, r32, r33)     // Catch:{ all -> 0x0f18 }
        L_0x0371:
            r31 = r4
            r6 = r9
            r12 = r21
            r13 = r26
            r5 = -1
            r10 = 3
            r9 = r7
            goto L_0x07de
        L_0x037d:
            com.google.android.gms.measurement.internal.zzfd r10 = r62.zzgz()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r13 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r13 = r13.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r14 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r10 = r10.zzl(r13, r14)     // Catch:{ all -> 0x0f18 }
            java.lang.String r13 = "_c"
            if (r10 != 0) goto L_0x03ec
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            java.lang.String r14 = r11.getName()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)     // Catch:{ all -> 0x0f18 }
            r25 = r15
            int r15 = r14.hashCode()     // Catch:{ all -> 0x0f18 }
            r30 = r7
            r7 = 94660(0x171c4, float:1.32647E-40)
            if (r15 == r7) goto L_0x03c9
            r7 = 95025(0x17331, float:1.33158E-40)
            if (r15 == r7) goto L_0x03bf
            r7 = 95027(0x17333, float:1.33161E-40)
            if (r15 == r7) goto L_0x03b5
            goto L_0x03d3
        L_0x03b5:
            java.lang.String r7 = "_ui"
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0f18 }
            if (r7 == 0) goto L_0x03d3
            r7 = 1
            goto L_0x03d4
        L_0x03bf:
            java.lang.String r7 = "_ug"
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0f18 }
            if (r7 == 0) goto L_0x03d3
            r7 = 2
            goto L_0x03d4
        L_0x03c9:
            java.lang.String r7 = "_in"
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0f18 }
            if (r7 == 0) goto L_0x03d3
            r7 = 0
            goto L_0x03d4
        L_0x03d3:
            r7 = -1
        L_0x03d4:
            if (r7 == 0) goto L_0x03de
            r14 = 1
            if (r7 == r14) goto L_0x03de
            r14 = 2
            if (r7 == r14) goto L_0x03de
            r7 = 0
            goto L_0x03df
        L_0x03de:
            r7 = 1
        L_0x03df:
            if (r7 == 0) goto L_0x03e2
            goto L_0x03f0
        L_0x03e2:
            r31 = r4
            r7 = r5
            r32 = r8
            r33 = r9
            r9 = r6
            goto L_0x05ca
        L_0x03ec:
            r30 = r7
            r25 = r15
        L_0x03f0:
            r31 = r4
            r7 = 0
            r14 = 0
            r15 = 0
        L_0x03f5:
            int r4 = r11.zzmk()     // Catch:{ all -> 0x0f18 }
            r32 = r8
            java.lang.String r8 = "_r"
            if (r7 >= r4) goto L_0x045f
            com.google.android.gms.internal.measurement.zzbs$zze r4 = r11.zzl(r7)     // Catch:{ all -> 0x0f18 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r13.equals(r4)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x042c
            com.google.android.gms.internal.measurement.zzbs$zze r4 = r11.zzl(r7)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = r4.zzuj()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbs$zze.zza) r4     // Catch:{ all -> 0x0f18 }
            r33 = r9
            r8 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r8)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs$zze) r4     // Catch:{ all -> 0x0f18 }
            r11.zza(r7, r4)     // Catch:{ all -> 0x0f18 }
            r14 = 1
            goto L_0x0458
        L_0x042c:
            r33 = r9
            com.google.android.gms.internal.measurement.zzbs$zze r4 = r11.zzl(r7)     // Catch:{ all -> 0x0f18 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x0458
            com.google.android.gms.internal.measurement.zzbs$zze r4 = r11.zzl(r7)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = r4.zzuj()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbs$zze.zza) r4     // Catch:{ all -> 0x0f18 }
            r8 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r8)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs$zze) r4     // Catch:{ all -> 0x0f18 }
            r11.zza(r7, r4)     // Catch:{ all -> 0x0f18 }
            r15 = 1
        L_0x0458:
            int r7 = r7 + 1
            r8 = r32
            r9 = r33
            goto L_0x03f5
        L_0x045f:
            r33 = r9
            if (r14 != 0) goto L_0x0496
            if (r10 == 0) goto L_0x0496
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ all -> 0x0f18 }
            java.lang.String r7 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzed r9 = r9.zzy()     // Catch:{ all -> 0x0f18 }
            java.lang.String r14 = r11.getName()     // Catch:{ all -> 0x0f18 }
            java.lang.String r9 = r9.zzaj(r14)     // Catch:{ all -> 0x0f18 }
            r4.zza(r7, r9)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = com.google.android.gms.internal.measurement.zzbs$zze.zzng()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzbz(r13)     // Catch:{ all -> 0x0f18 }
            r7 = r5
            r9 = r6
            r5 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r5)     // Catch:{ all -> 0x0f18 }
            r11.zza(r4)     // Catch:{ all -> 0x0f18 }
            goto L_0x0498
        L_0x0496:
            r7 = r5
            r9 = r6
        L_0x0498:
            if (r15 != 0) goto L_0x04c8
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzed r6 = r6.zzy()     // Catch:{ all -> 0x0f18 }
            java.lang.String r14 = r11.getName()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r6.zzaj(r14)     // Catch:{ all -> 0x0f18 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = com.google.android.gms.internal.measurement.zzbs$zze.zzng()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzbz(r8)     // Catch:{ all -> 0x0f18 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r5)     // Catch:{ all -> 0x0f18 }
            r11.zza(r4)     // Catch:{ all -> 0x0f18 }
        L_0x04c8:
            com.google.android.gms.measurement.internal.zzx r34 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            long r35 = r62.zzjk()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r37 = r4.zzag()     // Catch:{ all -> 0x0f18 }
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 1
            com.google.android.gms.measurement.internal.zzw r4 = r34.zza(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0f18 }
            long r4 = r4.zzej     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r14 = r14.zzag()     // Catch:{ all -> 0x0f18 }
            int r6 = r6.zzi(r14)     // Catch:{ all -> 0x0f18 }
            long r14 = (long) r6     // Catch:{ all -> 0x0f18 }
            int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x04ff
            zza(r11, r8)     // Catch:{ all -> 0x0f18 }
            goto L_0x0501
        L_0x04ff:
            r21 = 1
        L_0x0501:
            java.lang.String r4 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r4 = com.google.android.gms.measurement.internal.zzjs.zzbk(r4)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x05ca
            if (r10 == 0) goto L_0x05ca
            com.google.android.gms.measurement.internal.zzx r34 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            long r35 = r62.zzjk()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r37 = r4.zzag()     // Catch:{ all -> 0x0f18 }
            r38 = 0
            r39 = 0
            r40 = 1
            r41 = 0
            r42 = 0
            com.google.android.gms.measurement.internal.zzw r4 = r34.zza(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0f18 }
            long r4 = r4.zzeh     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzak.zzgs     // Catch:{ all -> 0x0f18 }
            int r6 = r6.zzb(r8, r14)     // Catch:{ all -> 0x0f18 }
            long r14 = (long) r6     // Catch:{ all -> 0x0f18 }
            int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x05ca
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0f18 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f18 }
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = -1
        L_0x055f:
            int r14 = r11.zzmk()     // Catch:{ all -> 0x0f18 }
            if (r4 >= r14) goto L_0x0589
            com.google.android.gms.internal.measurement.zzbs$zze r14 = r11.zzl(r4)     // Catch:{ all -> 0x0f18 }
            java.lang.String r15 = r14.getName()     // Catch:{ all -> 0x0f18 }
            boolean r15 = r13.equals(r15)     // Catch:{ all -> 0x0f18 }
            if (r15 == 0) goto L_0x057b
            com.google.android.gms.internal.measurement.zzey$zza r6 = r14.zzuj()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbs$zze.zza) r6     // Catch:{ all -> 0x0f18 }
            r8 = r4
            goto L_0x0586
        L_0x057b:
            java.lang.String r14 = r14.getName()     // Catch:{ all -> 0x0f18 }
            boolean r14 = r12.equals(r14)     // Catch:{ all -> 0x0f18 }
            if (r14 == 0) goto L_0x0586
            r5 = 1
        L_0x0586:
            int r4 = r4 + 1
            goto L_0x055f
        L_0x0589:
            if (r5 == 0) goto L_0x0591
            if (r6 == 0) goto L_0x0591
            r11.zzm(r8)     // Catch:{ all -> 0x0f18 }
            goto L_0x05ca
        L_0x0591:
            if (r6 == 0) goto L_0x05b1
            java.lang.Object r4 = r6.clone()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbs$zze.zza) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzbz(r12)     // Catch:{ all -> 0x0f18 }
            r5 = 10
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r5)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs$zze) r4     // Catch:{ all -> 0x0f18 }
            r11.zza(r8, r4)     // Catch:{ all -> 0x0f18 }
            goto L_0x05ca
        L_0x05b1:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0f18 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f18 }
        L_0x05ca:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zzs(r5)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x06a3
            if (r10 == 0) goto L_0x06a3
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0f18 }
            java.util.List r5 = r11.zzmj()     // Catch:{ all -> 0x0f18 }
            r4.<init>(r5)     // Catch:{ all -> 0x0f18 }
            r5 = 0
            r6 = -1
            r8 = -1
        L_0x05ea:
            int r10 = r4.size()     // Catch:{ all -> 0x0f18 }
            if (r5 >= r10) goto L_0x061a
            java.lang.String r10 = "value"
            java.lang.Object r12 = r4.get(r5)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r12 = (com.google.android.gms.internal.measurement.zzbs$zze) r12     // Catch:{ all -> 0x0f18 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0f18 }
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0f18 }
            if (r10 == 0) goto L_0x0604
            r6 = r5
            goto L_0x0617
        L_0x0604:
            java.lang.String r10 = "currency"
            java.lang.Object r12 = r4.get(r5)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r12 = (com.google.android.gms.internal.measurement.zzbs$zze) r12     // Catch:{ all -> 0x0f18 }
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x0f18 }
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0f18 }
            if (r10 == 0) goto L_0x0617
            r8 = r5
        L_0x0617:
            int r5 = r5 + 1
            goto L_0x05ea
        L_0x061a:
            r5 = -1
            if (r6 == r5) goto L_0x06a4
            java.lang.Object r5 = r4.get(r6)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r5 = (com.google.android.gms.internal.measurement.zzbs$zze) r5     // Catch:{ all -> 0x0f18 }
            boolean r5 = r5.zzna()     // Catch:{ all -> 0x0f18 }
            if (r5 != 0) goto L_0x0652
            java.lang.Object r5 = r4.get(r6)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r5 = (com.google.android.gms.internal.measurement.zzbs$zze) r5     // Catch:{ all -> 0x0f18 }
            boolean r5 = r5.zznd()     // Catch:{ all -> 0x0f18 }
            if (r5 != 0) goto L_0x0652
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgp()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r4.zzao(r5)     // Catch:{ all -> 0x0f18 }
            r11.zzm(r6)     // Catch:{ all -> 0x0f18 }
            zza(r11, r13)     // Catch:{ all -> 0x0f18 }
            r4 = 18
            java.lang.String r5 = "value"
            zza(r11, r4, r5)     // Catch:{ all -> 0x0f18 }
            goto L_0x06a3
        L_0x0652:
            r5 = -1
            if (r8 != r5) goto L_0x0658
            r4 = 1
            r10 = 3
            goto L_0x0684
        L_0x0658:
            java.lang.Object r4 = r4.get(r8)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs$zze) r4     // Catch:{ all -> 0x0f18 }
            java.lang.String r4 = r4.zzmy()     // Catch:{ all -> 0x0f18 }
            int r8 = r4.length()     // Catch:{ all -> 0x0f18 }
            r10 = 3
            if (r8 == r10) goto L_0x066b
        L_0x0669:
            r4 = 1
            goto L_0x0684
        L_0x066b:
            r8 = 0
        L_0x066c:
            int r12 = r4.length()     // Catch:{ all -> 0x0f18 }
            if (r8 >= r12) goto L_0x0683
            int r12 = r4.codePointAt(r8)     // Catch:{ all -> 0x0f18 }
            boolean r14 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x0f18 }
            if (r14 != 0) goto L_0x067d
            goto L_0x0669
        L_0x067d:
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0f18 }
            int r8 = r8 + r12
            goto L_0x066c
        L_0x0683:
            r4 = 0
        L_0x0684:
            if (r4 == 0) goto L_0x06a5
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgp()     // Catch:{ all -> 0x0f18 }
            java.lang.String r8 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r4.zzao(r8)     // Catch:{ all -> 0x0f18 }
            r11.zzm(r6)     // Catch:{ all -> 0x0f18 }
            zza(r11, r13)     // Catch:{ all -> 0x0f18 }
            r4 = 19
            java.lang.String r6 = "currency"
            zza(r11, r4, r6)     // Catch:{ all -> 0x0f18 }
            goto L_0x06a5
        L_0x06a3:
            r5 = -1
        L_0x06a4:
            r10 = 3
        L_0x06a5:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzak.zzih     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zze(r6, r8)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x0761
            java.lang.String r4 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r9.equals(r4)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x070f
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r11.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs$zzc) r4     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "_fr"
            com.google.android.gms.internal.measurement.zzbs$zze r4 = com.google.android.gms.measurement.internal.zzjo.zza(r4, r6)     // Catch:{ all -> 0x0f18 }
            if (r4 != 0) goto L_0x070c
            if (r19 == 0) goto L_0x0705
            long r12 = r19.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            long r14 = r11.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f18 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 > 0) goto L_0x0705
            java.lang.Object r4 = r19.clone()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r4 = (com.google.android.gms.internal.measurement.zzbs$zzc.zza) r4     // Catch:{ all -> 0x0f18 }
            boolean r6 = r1.zza(r11, r4)     // Catch:{ all -> 0x0f18 }
            if (r6 == 0) goto L_0x0705
            r6 = r33
            r3.zza(r6, r4)     // Catch:{ all -> 0x0f18 }
            r8 = r32
        L_0x0700:
            r18 = 0
            r19 = 0
            goto L_0x0765
        L_0x0705:
            r6 = r33
            r18 = r11
            r8 = r25
            goto L_0x0765
        L_0x070c:
            r6 = r33
            goto L_0x075e
        L_0x070f:
            r6 = r33
            java.lang.String r4 = "_vs"
            java.lang.String r8 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.equals(r8)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x075e
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r11.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs$zzc) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = com.google.android.gms.measurement.internal.zzjo.zza(r4, r7)     // Catch:{ all -> 0x0f18 }
            if (r4 != 0) goto L_0x075e
            if (r18 == 0) goto L_0x0757
            long r12 = r18.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            long r14 = r11.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f18 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 > 0) goto L_0x0757
            java.lang.Object r4 = r18.clone()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r4 = (com.google.android.gms.internal.measurement.zzbs$zzc.zza) r4     // Catch:{ all -> 0x0f18 }
            boolean r8 = r1.zza(r4, r11)     // Catch:{ all -> 0x0f18 }
            if (r8 == 0) goto L_0x0757
            r8 = r32
            r3.zza(r8, r4)     // Catch:{ all -> 0x0f18 }
            goto L_0x0700
        L_0x0757:
            r8 = r32
            r19 = r11
            r6 = r25
            goto L_0x0765
        L_0x075e:
            r8 = r32
            goto L_0x0765
        L_0x0761:
            r8 = r32
            r6 = r33
        L_0x0765:
            if (r31 != 0) goto L_0x07c5
            java.lang.String r4 = r11.getName()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r9.equals(r4)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x07c5
            int r4 = r11.zzmk()     // Catch:{ all -> 0x0f18 }
            if (r4 != 0) goto L_0x0791
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x0f18 }
            java.lang.String r7 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r9 = r9.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r9)     // Catch:{ all -> 0x0f18 }
            r4.zza(r7, r9)     // Catch:{ all -> 0x0f18 }
            goto L_0x07c5
        L_0x0791:
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r11.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs$zzc) r4     // Catch:{ all -> 0x0f18 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzjo.zzb(r4, r7)     // Catch:{ all -> 0x0f18 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0f18 }
            if (r4 != 0) goto L_0x07be
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x0f18 }
            java.lang.String r7 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r9 = r9.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r9)     // Catch:{ all -> 0x0f18 }
            r4.zza(r7, r9)     // Catch:{ all -> 0x0f18 }
            goto L_0x07c5
        L_0x07be:
            long r12 = r4.longValue()     // Catch:{ all -> 0x0f18 }
            long r12 = r26 + r12
            goto L_0x07c7
        L_0x07c5:
            r12 = r26
        L_0x07c7:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r4 = r2.zztp     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r7 = r11.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r7 = (com.google.android.gms.internal.measurement.zzey) r7     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r7 = (com.google.android.gms.internal.measurement.zzbs$zzc) r7     // Catch:{ all -> 0x0f18 }
            r9 = r30
            r4.set(r9, r7)     // Catch:{ all -> 0x0f18 }
            int r15 = r25 + 1
            r3.zza(r11)     // Catch:{ all -> 0x0f18 }
            r13 = r12
            r12 = r21
        L_0x07de:
            int r7 = r9 + 1
            r9 = r6
            r4 = r31
            goto L_0x02cd
        L_0x07e5:
            r31 = r4
            r7 = r5
            r9 = r6
            r25 = r15
            if (r31 == 0) goto L_0x0842
            r5 = r25
            r13 = r26
            r4 = 0
        L_0x07f2:
            if (r4 >= r5) goto L_0x0844
            com.google.android.gms.internal.measurement.zzbs$zzc r6 = r3.zzq(r4)     // Catch:{ all -> 0x0f18 }
            java.lang.String r8 = r6.getName()     // Catch:{ all -> 0x0f18 }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x0f18 }
            if (r8 == 0) goto L_0x0815
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            java.lang.String r8 = "_fr"
            com.google.android.gms.internal.measurement.zzbs$zze r8 = com.google.android.gms.measurement.internal.zzjo.zza(r6, r8)     // Catch:{ all -> 0x0f18 }
            if (r8 == 0) goto L_0x0815
            r3.zzr(r4)     // Catch:{ all -> 0x0f18 }
            int r5 = r5 + -1
            int r4 = r4 + -1
            goto L_0x083f
        L_0x0815:
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r6 = com.google.android.gms.measurement.internal.zzjo.zza(r6, r7)     // Catch:{ all -> 0x0f18 }
            if (r6 == 0) goto L_0x083f
            boolean r8 = r6.zzna()     // Catch:{ all -> 0x0f18 }
            if (r8 == 0) goto L_0x082d
            long r10 = r6.zznb()     // Catch:{ all -> 0x0f18 }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0f18 }
            goto L_0x082e
        L_0x082d:
            r6 = 0
        L_0x082e:
            if (r6 == 0) goto L_0x083f
            long r10 = r6.longValue()     // Catch:{ all -> 0x0f18 }
            r18 = 0
            int r8 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r8 <= 0) goto L_0x083f
            long r10 = r6.longValue()     // Catch:{ all -> 0x0f18 }
            long r13 = r13 + r10
        L_0x083f:
            r6 = 1
            int r4 = r4 + r6
            goto L_0x07f2
        L_0x0842:
            r13 = r26
        L_0x0844:
            r4 = 0
            r1.zza(r3, r13, r4)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzja     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x0891
            java.util.List r4 = r3.zznl()     // Catch:{ all -> 0x0f18 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0f18 }
        L_0x0862:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x087c
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r5 = (com.google.android.gms.internal.measurement.zzbs$zzc) r5     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0f18 }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x0862
            r4 = 1
            goto L_0x087d
        L_0x087c:
            r4 = 0
        L_0x087d:
            if (r4 == 0) goto L_0x088c
            com.google.android.gms.measurement.internal.zzx r4 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "_se"
            r4.zzd(r5, r6)     // Catch:{ all -> 0x0f18 }
        L_0x088c:
            r4 = 1
            r1.zza(r3, r13, r4)     // Catch:{ all -> 0x0f18 }
            goto L_0x08b0
        L_0x0891:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzjb     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x08b0
            com.google.android.gms.measurement.internal.zzx r4 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "_se"
            r4.zzd(r5, r6)     // Catch:{ all -> 0x0f18 }
        L_0x08b0:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzij     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x0955
            com.google.android.gms.measurement.internal.zzjo r4 = r62.zzgw()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r5 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgs()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r5.zzao(r6)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfd r5 = r4.zzgz()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            boolean r5 = r5.zzba(r6)     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x0955
            com.google.android.gms.measurement.internal.zzx r5 = r4.zzgy()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzf r5 = r5.zzab(r6)     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x0955
            boolean r5 = r5.zzbe()     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x0955
            com.google.android.gms.measurement.internal.zzac r5 = r4.zzw()     // Catch:{ all -> 0x0f18 }
            boolean r5 = r5.zzcu()     // Catch:{ all -> 0x0f18 }
            if (r5 == 0) goto L_0x0955
            com.google.android.gms.measurement.internal.zzef r5 = r4.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgr()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r5.zzao(r6)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r5 = com.google.android.gms.internal.measurement.zzbs$zzk.zzqu()     // Catch:{ all -> 0x0f18 }
            java.lang.String r6 = "_npa"
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r5 = r5.zzdb(r6)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzac r4 = r4.zzw()     // Catch:{ all -> 0x0f18 }
            long r6 = r4.zzcs()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r4 = r5.zzbk(r6)     // Catch:{ all -> 0x0f18 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r4 = r4.zzbl(r5)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzk r4 = (com.google.android.gms.internal.measurement.zzbs$zzk) r4     // Catch:{ all -> 0x0f18 }
            r5 = 0
        L_0x0931:
            int r6 = r3.zznp()     // Catch:{ all -> 0x0f18 }
            if (r5 >= r6) goto L_0x094f
            java.lang.String r6 = "_npa"
            com.google.android.gms.internal.measurement.zzbs$zzk r7 = r3.zzs(r5)     // Catch:{ all -> 0x0f18 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0f18 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0f18 }
            if (r6 == 0) goto L_0x094c
            r3.zza(r5, r4)     // Catch:{ all -> 0x0f18 }
            r5 = 1
            goto L_0x0950
        L_0x094c:
            int r5 = r5 + 1
            goto L_0x0931
        L_0x094f:
            r5 = 0
        L_0x0950:
            if (r5 != 0) goto L_0x0955
            r3.zza(r4)     // Catch:{ all -> 0x0f18 }
        L_0x0955:
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r4 = r3.zznv()     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r3.zzag()     // Catch:{ all -> 0x0f18 }
            java.util.List r6 = r3.zzno()     // Catch:{ all -> 0x0f18 }
            java.util.List r7 = r3.zznl()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzp r8 = r62.zzgx()     // Catch:{ all -> 0x0f18 }
            java.util.List r5 = r8.zza(r5, r7, r6)     // Catch:{ all -> 0x0f18 }
            r4.zzc(r5)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f18 }
            boolean r4 = r4.zzm(r5)     // Catch:{ all -> 0x0f18 }
            if (r4 == 0) goto L_0x0d22
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0ef6 }
            r4.<init>()     // Catch:{ all -> 0x0ef6 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0ef6 }
            r5.<init>()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzjs r6 = r6.zzz()     // Catch:{ all -> 0x0ef6 }
            java.security.SecureRandom r6 = r6.zzjw()     // Catch:{ all -> 0x0ef6 }
            r7 = 0
        L_0x099a:
            int r8 = r3.zznm()     // Catch:{ all -> 0x0ef6 }
            if (r7 >= r8) goto L_0x0ced
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = r3.zzq(r7)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzey$zza r8 = r8.zzuj()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzbs$zzc.zza) r8     // Catch:{ all -> 0x0ef6 }
            java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x0ef6 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0ef6 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0a2d
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r9 = r8.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs$zzc) r9     // Catch:{ all -> 0x0f18 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzjo.zzb(r9, r11)     // Catch:{ all -> 0x0f18 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0f18 }
            java.lang.Object r11 = r4.get(r9)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzae r11 = (com.google.android.gms.measurement.internal.zzae) r11     // Catch:{ all -> 0x0f18 }
            if (r11 != 0) goto L_0x09e4
            com.google.android.gms.measurement.internal.zzx r11 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc(r12, r9)     // Catch:{ all -> 0x0f18 }
            r4.put(r9, r11)     // Catch:{ all -> 0x0f18 }
        L_0x09e4:
            java.lang.Long r9 = r11.zzfm     // Catch:{ all -> 0x0f18 }
            if (r9 != 0) goto L_0x0a21
            java.lang.Long r9 = r11.zzfn     // Catch:{ all -> 0x0f18 }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0f18 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x09fc
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            java.lang.Long r9 = r11.zzfn     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzjo.zza(r8, r10, r9)     // Catch:{ all -> 0x0f18 }
        L_0x09fc:
            java.lang.Boolean r9 = r11.zzfo     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0a16
            java.lang.Boolean r9 = r11.zzfo     // Catch:{ all -> 0x0f18 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0a16
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzjo.zza(r8, r9, r12)     // Catch:{ all -> 0x0f18 }
        L_0x0a16:
            com.google.android.gms.internal.measurement.zzgi r9 = r8.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs$zzc) r9     // Catch:{ all -> 0x0f18 }
            r5.add(r9)     // Catch:{ all -> 0x0f18 }
        L_0x0a21:
            r3.zza(r7, r8)     // Catch:{ all -> 0x0f18 }
        L_0x0a24:
            r1 = r3
            r63 = r6
            r3 = r2
            r2 = r7
            r6 = 1
            goto L_0x0ce2
        L_0x0a2d:
            com.google.android.gms.measurement.internal.zzfd r9 = r62.zzgz()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0ef6 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0ef6 }
            long r11 = r9.zzbb(r11)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0ef6 }
            r9.zzz()     // Catch:{ all -> 0x0ef6 }
            long r13 = r8.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            long r13 = com.google.android.gms.measurement.internal.zzjs.zzc(r13, r11)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzgi r9 = r8.zzug()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs$zzc) r9     // Catch:{ all -> 0x0ef6 }
            java.lang.String r15 = "_dbg"
            r26 = r11
            r18 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0ef6 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0ef6 }
            if (r12 != 0) goto L_0x0aba
            if (r11 != 0) goto L_0x0a63
            goto L_0x0aba
        L_0x0a63:
            java.util.List r9 = r9.zzmj()     // Catch:{ all -> 0x0f18 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0f18 }
        L_0x0a6b:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x0f18 }
            if (r12 == 0) goto L_0x0aba
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zze r12 = (com.google.android.gms.internal.measurement.zzbs$zze) r12     // Catch:{ all -> 0x0f18 }
            r63 = r9
            java.lang.String r9 = r12.getName()     // Catch:{ all -> 0x0f18 }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0ab7
            boolean r9 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0a95
            long r18 = r12.zznb()     // Catch:{ all -> 0x0f18 }
            java.lang.Long r9 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0f18 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f18 }
            if (r9 != 0) goto L_0x0ab5
        L_0x0a95:
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0aa3
            java.lang.String r9 = r12.zzmy()     // Catch:{ all -> 0x0f18 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f18 }
            if (r9 != 0) goto L_0x0ab5
        L_0x0aa3:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0aba
            double r18 = r12.zzne()     // Catch:{ all -> 0x0f18 }
            java.lang.Double r9 = java.lang.Double.valueOf(r18)     // Catch:{ all -> 0x0f18 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0aba
        L_0x0ab5:
            r9 = 1
            goto L_0x0abb
        L_0x0ab7:
            r9 = r63
            goto L_0x0a6b
        L_0x0aba:
            r9 = 0
        L_0x0abb:
            if (r9 != 0) goto L_0x0ad0
            com.google.android.gms.measurement.internal.zzfd r9 = r62.zzgz()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r12 = r8.getName()     // Catch:{ all -> 0x0f18 }
            int r12 = r9.zzm(r11, r12)     // Catch:{ all -> 0x0f18 }
            goto L_0x0ad1
        L_0x0ad0:
            r12 = 1
        L_0x0ad1:
            if (r12 > 0) goto L_0x0afa
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgn()     // Catch:{ all -> 0x0f18 }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r11 = r8.getName()     // Catch:{ all -> 0x0f18 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0f18 }
            r9.zza(r10, r11, r12)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r9 = r8.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs$zzc) r9     // Catch:{ all -> 0x0f18 }
            r5.add(r9)     // Catch:{ all -> 0x0f18 }
            r3.zza(r7, r8)     // Catch:{ all -> 0x0f18 }
            goto L_0x0a24
        L_0x0afa:
            java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x0ef6 }
            java.lang.Object r9 = r4.get(r9)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzae r9 = (com.google.android.gms.measurement.internal.zzae) r9     // Catch:{ all -> 0x0ef6 }
            if (r9 != 0) goto L_0x0b93
            com.google.android.gms.measurement.internal.zzx r9 = r62.zzgy()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r15 = r8.getName()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc(r11, r15)     // Catch:{ all -> 0x0f18 }
            if (r9 != 0) goto L_0x0b93
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgn()     // Catch:{ all -> 0x0f18 }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbs$zzg r15 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r15 = r15.zzag()     // Catch:{ all -> 0x0f18 }
            r18 = r13
            java.lang.String r13 = r8.getName()     // Catch:{ all -> 0x0f18 }
            r9.zza(r11, r15, r13)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzs r9 = r9.zzad()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzak.zziz     // Catch:{ all -> 0x0f18 }
            boolean r9 = r9.zze(r11, r13)     // Catch:{ all -> 0x0f18 }
            if (r9 == 0) goto L_0x0b6f
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r31 = r11.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r32 = r8.getName()     // Catch:{ all -> 0x0f18 }
            r33 = 1
            r35 = 1
            r37 = 1
            long r39 = r8.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r30 = r9
            r30.<init>(r31, r32, r33, r35, r37, r39, r41, r43, r44, r45, r46)     // Catch:{ all -> 0x0f18 }
            goto L_0x0b95
        L_0x0b6f:
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r2.zztn     // Catch:{ all -> 0x0f18 }
            java.lang.String r48 = r11.zzag()     // Catch:{ all -> 0x0f18 }
            java.lang.String r49 = r8.getName()     // Catch:{ all -> 0x0f18 }
            r50 = 1
            r52 = 1
            long r54 = r8.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            r56 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r47 = r9
            r47.<init>(r48, r49, r50, r52, r54, r56, r58, r59, r60, r61)     // Catch:{ all -> 0x0f18 }
            goto L_0x0b95
        L_0x0b93:
            r18 = r13
        L_0x0b95:
            r62.zzgw()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzgi r11 = r8.zzug()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzbs$zzc r11 = (com.google.android.gms.internal.measurement.zzbs$zzc) r11     // Catch:{ all -> 0x0ef6 }
            java.lang.String r13 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzjo.zzb(r11, r13)     // Catch:{ all -> 0x0ef6 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0ef6 }
            if (r11 == 0) goto L_0x0bac
            r13 = 1
            goto L_0x0bad
        L_0x0bac:
            r13 = 0
        L_0x0bad:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0ef6 }
            r14 = 1
            if (r12 != r14) goto L_0x0be2
            com.google.android.gms.internal.measurement.zzgi r10 = r8.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs$zzc) r10     // Catch:{ all -> 0x0f18 }
            r5.add(r10)     // Catch:{ all -> 0x0f18 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0f18 }
            if (r10 == 0) goto L_0x0bdd
            java.lang.Long r10 = r9.zzfm     // Catch:{ all -> 0x0f18 }
            if (r10 != 0) goto L_0x0bd1
            java.lang.Long r10 = r9.zzfn     // Catch:{ all -> 0x0f18 }
            if (r10 != 0) goto L_0x0bd1
            java.lang.Boolean r10 = r9.zzfo     // Catch:{ all -> 0x0f18 }
            if (r10 == 0) goto L_0x0bdd
        L_0x0bd1:
            r10 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r10, r10, r10)     // Catch:{ all -> 0x0f18 }
            java.lang.String r10 = r8.getName()     // Catch:{ all -> 0x0f18 }
            r4.put(r10, r9)     // Catch:{ all -> 0x0f18 }
        L_0x0bdd:
            r3.zza(r7, r8)     // Catch:{ all -> 0x0f18 }
            goto L_0x0a24
        L_0x0be2:
            int r14 = r6.nextInt(r12)     // Catch:{ all -> 0x0ef6 }
            if (r14 != 0) goto L_0x0c27
            r62.zzgw()     // Catch:{ all -> 0x0f18 }
            long r11 = (long) r12     // Catch:{ all -> 0x0f18 }
            java.lang.Long r14 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.measurement.internal.zzjo.zza(r8, r10, r14)     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzgi r10 = r8.zzug()     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ all -> 0x0f18 }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs$zzc) r10     // Catch:{ all -> 0x0f18 }
            r5.add(r10)     // Catch:{ all -> 0x0f18 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0f18 }
            if (r10 == 0) goto L_0x0c0d
            java.lang.Long r10 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f18 }
            r11 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r10, r11)     // Catch:{ all -> 0x0f18 }
        L_0x0c0d:
            java.lang.String r10 = r8.getName()     // Catch:{ all -> 0x0f18 }
            long r11 = r8.getTimestampMillis()     // Catch:{ all -> 0x0f18 }
            r14 = r18
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r14)     // Catch:{ all -> 0x0f18 }
            r4.put(r10, r9)     // Catch:{ all -> 0x0f18 }
            r1 = r3
            r63 = r6
            r3 = r2
            r2 = r7
            r6 = 1
            goto L_0x0cdf
        L_0x0c27:
            r63 = r6
            r14 = r18
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0ef6 }
            r18 = r3
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r2.zztn     // Catch:{ all -> 0x0ef6 }
            java.lang.String r3 = r3.zzag()     // Catch:{ all -> 0x0ef6 }
            boolean r3 = r6.zzu(r3)     // Catch:{ all -> 0x0ef6 }
            if (r3 == 0) goto L_0x0c67
            java.lang.Long r3 = r9.zzfl     // Catch:{ all -> 0x0ef6 }
            if (r3 == 0) goto L_0x0c4d
            java.lang.Long r3 = r9.zzfl     // Catch:{ all -> 0x0f18 }
            long r26 = r3.longValue()     // Catch:{ all -> 0x0f18 }
            r3 = r2
            r19 = r7
            goto L_0x0c5f
        L_0x0c4d:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0ef6 }
            r3.zzz()     // Catch:{ all -> 0x0ef6 }
            r3 = r2
            long r1 = r8.zzmm()     // Catch:{ all -> 0x0ef6 }
            r19 = r7
            r6 = r26
            long r26 = com.google.android.gms.measurement.internal.zzjs.zzc(r1, r6)     // Catch:{ all -> 0x0ef6 }
        L_0x0c5f:
            int r1 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0c65
        L_0x0c63:
            r1 = 1
            goto L_0x0c7d
        L_0x0c65:
            r1 = 0
            goto L_0x0c7d
        L_0x0c67:
            r3 = r2
            r19 = r7
            long r1 = r9.zzfk     // Catch:{ all -> 0x0ef6 }
            long r6 = r8.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            long r6 = r6 - r1
            long r1 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x0ef6 }
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            int r23 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r23 < 0) goto L_0x0c65
            goto L_0x0c63
        L_0x0c7d:
            if (r1 == 0) goto L_0x0cc7
            r62.zzgw()     // Catch:{ all -> 0x0ef6 }
            java.lang.String r1 = "_efs"
            r6 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzjo.zza(r8, r1, r2)     // Catch:{ all -> 0x0ef6 }
            r62.zzgw()     // Catch:{ all -> 0x0ef6 }
            long r1 = (long) r12     // Catch:{ all -> 0x0ef6 }
            java.lang.Long r11 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzjo.zza(r8, r10, r11)     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzgi r10 = r8.zzug()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzey r10 = (com.google.android.gms.internal.measurement.zzey) r10     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.internal.measurement.zzbs$zzc r10 = (com.google.android.gms.internal.measurement.zzbs$zzc) r10     // Catch:{ all -> 0x0ef6 }
            r5.add(r10)     // Catch:{ all -> 0x0ef6 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0ef6 }
            if (r10 == 0) goto L_0x0cb7
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ef6 }
            r2 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0ef6 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r2, r1, r10)     // Catch:{ all -> 0x0ef6 }
        L_0x0cb7:
            java.lang.String r1 = r8.getName()     // Catch:{ all -> 0x0ef6 }
            long r10 = r8.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzae r2 = r9.zza(r10, r14)     // Catch:{ all -> 0x0ef6 }
            r4.put(r1, r2)     // Catch:{ all -> 0x0ef6 }
            goto L_0x0cdb
        L_0x0cc7:
            r6 = 1
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0ef6 }
            if (r1 == 0) goto L_0x0cdb
            java.lang.String r1 = r8.getName()     // Catch:{ all -> 0x0ef6 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r2, r2)     // Catch:{ all -> 0x0ef6 }
            r4.put(r1, r9)     // Catch:{ all -> 0x0ef6 }
        L_0x0cdb:
            r1 = r18
            r2 = r19
        L_0x0cdf:
            r1.zza(r2, r8)     // Catch:{ all -> 0x0ef6 }
        L_0x0ce2:
            int r2 = r2 + 1
            r6 = r63
            r7 = r2
            r2 = r3
            r3 = r1
            r1 = r62
            goto L_0x099a
        L_0x0ced:
            r1 = r3
            r3 = r2
            int r2 = r5.size()     // Catch:{ all -> 0x0ef6 }
            int r6 = r1.zznm()     // Catch:{ all -> 0x0ef6 }
            if (r2 >= r6) goto L_0x0d00
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r1.zznn()     // Catch:{ all -> 0x0ef6 }
            r2.zza(r5)     // Catch:{ all -> 0x0ef6 }
        L_0x0d00:
            java.util.Set r2 = r4.entrySet()     // Catch:{ all -> 0x0ef6 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ef6 }
        L_0x0d08:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0ef6 }
            if (r4 == 0) goto L_0x0d24
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0ef6 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzx r5 = r62.zzgy()     // Catch:{ all -> 0x0ef6 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzae r4 = (com.google.android.gms.measurement.internal.zzae) r4     // Catch:{ all -> 0x0ef6 }
            r5.zza(r4)     // Catch:{ all -> 0x0ef6 }
            goto L_0x0d08
        L_0x0d22:
            r1 = r3
            r3 = r2
        L_0x0d24:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r1.zzao(r4)     // Catch:{ all -> 0x0ef6 }
            r4 = -9223372036854775808
            r2.zzap(r4)     // Catch:{ all -> 0x0ef6 }
            r2 = 0
        L_0x0d33:
            int r4 = r1.zznm()     // Catch:{ all -> 0x0ef6 }
            if (r2 >= r4) goto L_0x0d66
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = r1.zzq(r2)     // Catch:{ all -> 0x0ef6 }
            long r5 = r4.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            long r7 = r1.zznq()     // Catch:{ all -> 0x0ef6 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0d50
            long r5 = r4.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            r1.zzao(r5)     // Catch:{ all -> 0x0ef6 }
        L_0x0d50:
            long r5 = r4.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            long r7 = r1.zznr()     // Catch:{ all -> 0x0ef6 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0d63
            long r4 = r4.getTimestampMillis()     // Catch:{ all -> 0x0ef6 }
            r1.zzap(r4)     // Catch:{ all -> 0x0ef6 }
        L_0x0d63:
            int r2 = r2 + 1
            goto L_0x0d33
        L_0x0d66:
            com.google.android.gms.internal.measurement.zzbs$zzg r2 = r3.zztn     // Catch:{ all -> 0x0ef6 }
            java.lang.String r2 = r2.zzag()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzx r4 = r62.zzgy()     // Catch:{ all -> 0x0ef6 }
            com.google.android.gms.measurement.internal.zzf r4 = r4.zzab(r2)     // Catch:{ all -> 0x0ef6 }
            if (r4 != 0) goto L_0x0d92
            r6 = r62
            com.google.android.gms.measurement.internal.zzfj r4 = r6.zzj     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x0f16 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r7 = r3.zztn     // Catch:{ all -> 0x0f16 }
            java.lang.String r7 = r7.zzag()     // Catch:{ all -> 0x0f16 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x0f16 }
            r4.zza(r5, r7)     // Catch:{ all -> 0x0f16 }
            goto L_0x0def
        L_0x0d92:
            r6 = r62
            int r5 = r1.zznm()     // Catch:{ all -> 0x0f16 }
            if (r5 <= 0) goto L_0x0def
            long r7 = r4.zzak()     // Catch:{ all -> 0x0f16 }
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x0da8
            r1.zzar(r7)     // Catch:{ all -> 0x0f16 }
            goto L_0x0dab
        L_0x0da8:
            r1.zznt()     // Catch:{ all -> 0x0f16 }
        L_0x0dab:
            long r9 = r4.zzaj()     // Catch:{ all -> 0x0f16 }
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x0db6
            goto L_0x0db7
        L_0x0db6:
            r7 = r9
        L_0x0db7:
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0dbf
            r1.zzaq(r7)     // Catch:{ all -> 0x0f16 }
            goto L_0x0dc2
        L_0x0dbf:
            r1.zzns()     // Catch:{ all -> 0x0f16 }
        L_0x0dc2:
            r4.zzau()     // Catch:{ all -> 0x0f16 }
            long r7 = r4.zzar()     // Catch:{ all -> 0x0f16 }
            int r5 = (int) r7     // Catch:{ all -> 0x0f16 }
            r1.zzu(r5)     // Catch:{ all -> 0x0f16 }
            long r7 = r1.zznq()     // Catch:{ all -> 0x0f16 }
            r4.zze(r7)     // Catch:{ all -> 0x0f16 }
            long r7 = r1.zznr()     // Catch:{ all -> 0x0f16 }
            r4.zzf(r7)     // Catch:{ all -> 0x0f16 }
            java.lang.String r5 = r4.zzbc()     // Catch:{ all -> 0x0f16 }
            if (r5 == 0) goto L_0x0de5
            r1.zzcl(r5)     // Catch:{ all -> 0x0f16 }
            goto L_0x0de8
        L_0x0de5:
            r1.zznu()     // Catch:{ all -> 0x0f16 }
        L_0x0de8:
            com.google.android.gms.measurement.internal.zzx r5 = r62.zzgy()     // Catch:{ all -> 0x0f16 }
            r5.zza(r4)     // Catch:{ all -> 0x0f16 }
        L_0x0def:
            int r4 = r1.zznm()     // Catch:{ all -> 0x0f16 }
            if (r4 <= 0) goto L_0x0e55
            com.google.android.gms.measurement.internal.zzfj r4 = r6.zzj     // Catch:{ all -> 0x0f16 }
            r4.zzae()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzfd r4 = r62.zzgz()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.internal.measurement.zzbs$zzg r5 = r3.zztn     // Catch:{ all -> 0x0f16 }
            java.lang.String r5 = r5.zzag()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.internal.measurement.zzbw r4 = r4.zzaw(r5)     // Catch:{ all -> 0x0f16 }
            if (r4 == 0) goto L_0x0e19
            java.lang.Long r5 = r4.zzzk     // Catch:{ all -> 0x0f16 }
            if (r5 != 0) goto L_0x0e0f
            goto L_0x0e19
        L_0x0e0f:
            java.lang.Long r4 = r4.zzzk     // Catch:{ all -> 0x0f16 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0f16 }
            r1.zzav(r4)     // Catch:{ all -> 0x0f16 }
            goto L_0x0e44
        L_0x0e19:
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r3.zztn     // Catch:{ all -> 0x0f16 }
            java.lang.String r4 = r4.getGmpAppId()     // Catch:{ all -> 0x0f16 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0f16 }
            if (r4 == 0) goto L_0x0e2b
            r4 = -1
            r1.zzav(r4)     // Catch:{ all -> 0x0f16 }
            goto L_0x0e44
        L_0x0e2b:
            com.google.android.gms.measurement.internal.zzfj r4 = r6.zzj     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x0f16 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r7 = r3.zztn     // Catch:{ all -> 0x0f16 }
            java.lang.String r7 = r7.zzag()     // Catch:{ all -> 0x0f16 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x0f16 }
            r4.zza(r5, r7)     // Catch:{ all -> 0x0f16 }
        L_0x0e44:
            com.google.android.gms.measurement.internal.zzx r4 = r62.zzgy()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.internal.measurement.zzgi r1 = r1.zzug()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.internal.measurement.zzey r1 = (com.google.android.gms.internal.measurement.zzey) r1     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.internal.measurement.zzbs$zzg r1 = (com.google.android.gms.internal.measurement.zzbs$zzg) r1     // Catch:{ all -> 0x0f16 }
            r12 = r21
            r4.zza(r1, r12)     // Catch:{ all -> 0x0f16 }
        L_0x0e55:
            com.google.android.gms.measurement.internal.zzx r1 = r62.zzgy()     // Catch:{ all -> 0x0f16 }
            java.util.List<java.lang.Long> r3 = r3.zzto     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0f16 }
            r1.zzo()     // Catch:{ all -> 0x0f16 }
            r1.zzbi()     // Catch:{ all -> 0x0f16 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f16 }
            java.lang.String r5 = "rowid in ("
            r4.<init>(r5)     // Catch:{ all -> 0x0f16 }
            r5 = 0
        L_0x0e6c:
            int r7 = r3.size()     // Catch:{ all -> 0x0f16 }
            if (r5 >= r7) goto L_0x0e89
            if (r5 == 0) goto L_0x0e79
            java.lang.String r7 = ","
            r4.append(r7)     // Catch:{ all -> 0x0f16 }
        L_0x0e79:
            java.lang.Object r7 = r3.get(r5)     // Catch:{ all -> 0x0f16 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f16 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f16 }
            r4.append(r7)     // Catch:{ all -> 0x0f16 }
            int r5 = r5 + 1
            goto L_0x0e6c
        L_0x0e89:
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ all -> 0x0f16 }
            android.database.sqlite.SQLiteDatabase r5 = r1.getWritableDatabase()     // Catch:{ all -> 0x0f16 }
            java.lang.String r7 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0f16 }
            r8 = 0
            int r4 = r5.delete(r7, r4, r8)     // Catch:{ all -> 0x0f16 }
            int r5 = r3.size()     // Catch:{ all -> 0x0f16 }
            if (r4 == r5) goto L_0x0ebc
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x0f16 }
            java.lang.String r5 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0f16 }
            int r3 = r3.size()     // Catch:{ all -> 0x0f16 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0f16 }
            r1.zza(r5, r4, r3)     // Catch:{ all -> 0x0f16 }
        L_0x0ebc:
            com.google.android.gms.measurement.internal.zzx r1 = r62.zzgy()     // Catch:{ all -> 0x0f16 }
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ all -> 0x0f16 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0ed3 }
            r7 = 0
            r5[r7] = r2     // Catch:{ SQLiteException -> 0x0ed3 }
            r7 = 1
            r5[r7] = r2     // Catch:{ SQLiteException -> 0x0ed3 }
            r3.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x0ed3 }
            goto L_0x0ee6
        L_0x0ed3:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x0f16 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x0f16 }
            r1.zza(r4, r2, r3)     // Catch:{ all -> 0x0f16 }
        L_0x0ee6:
            com.google.android.gms.measurement.internal.zzx r1 = r62.zzgy()     // Catch:{ all -> 0x0f16 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzx r1 = r62.zzgy()
            r1.endTransaction()
            r1 = 1
            return r1
        L_0x0ef6:
            r0 = move-exception
            r6 = r62
            goto L_0x0f1a
        L_0x0efa:
            r6 = r1
            com.google.android.gms.measurement.internal.zzx r1 = r62.zzgy()     // Catch:{ all -> 0x0f16 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0f16 }
            com.google.android.gms.measurement.internal.zzx r1 = r62.zzgy()
            r1.endTransaction()
            r1 = 0
            return r1
        L_0x0f0b:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r22 = r5
        L_0x0f10:
            if (r22 == 0) goto L_0x0f15
            r22.close()     // Catch:{ all -> 0x0f16 }
        L_0x0f15:
            throw r1     // Catch:{ all -> 0x0f16 }
        L_0x0f16:
            r0 = move-exception
            goto L_0x0f1a
        L_0x0f18:
            r0 = move-exception
            r6 = r1
        L_0x0f1a:
            r1 = r0
            com.google.android.gms.measurement.internal.zzx r2 = r62.zzgy()
            r2.endTransaction()
            goto L_0x0f24
        L_0x0f23:
            throw r1
        L_0x0f24:
            goto L_0x0f23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzd(java.lang.String, long):boolean");
    }

    private final void zza(com.google.android.gms.internal.measurement.zzbs$zzg.zza zza2, long j, boolean z) {
        zzjp zzjp;
        String str = z ? "_se" : "_lte";
        zzjp zze = zzgy().zze(zza2.zzag(), str);
        if (zze == null || zze.value == null) {
            zzjp = new zzjp(zza2.zzag(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzx().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzjp = new zzjp(zza2.zzag(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, this.zzj.zzx().currentTimeMillis(), Long.valueOf(((Long) zze.value).longValue() + j));
        }
        zzbs$zzk zzbs_zzk = (zzbs$zzk) zzbs$zzk.zzqu().zzdb(str).zzbk(this.zzj.zzx().currentTimeMillis()).zzbl(((Long) zzjp.value).longValue()).zzug();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= zza2.zznp()) {
                break;
            } else if (str.equals(zza2.zzs(i).getName())) {
                zza2.zza(i, zzbs_zzk);
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (!z2) {
            zza2.zza(zzbs_zzk);
        }
        if (j > 0) {
            zzgy().zza(zzjp);
            this.zzj.zzab().zzgr().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzjp.value);
        }
    }

    private final boolean zza(com.google.android.gms.internal.measurement.zzbs$zzc.zza zza2, com.google.android.gms.internal.measurement.zzbs$zzc.zza zza3) {
        Object obj;
        Preconditions.checkArgument("_e".equals(zza2.getName()));
        zzgw();
        zzbs$zze zza4 = zzjo.zza((zzbs$zzc) zza2.zzug(), "_sc");
        String str = null;
        if (zza4 == null) {
            obj = null;
        } else {
            obj = zza4.zzmy();
        }
        zzgw();
        zzbs$zze zza5 = zzjo.zza((zzbs$zzc) zza3.zzug(), "_pc");
        if (zza5 != null) {
            str = zza5.zzmy();
        }
        if (str == null || !str.equals(obj)) {
            return false;
        }
        zzgw();
        String str2 = "_et";
        zzbs$zze zza6 = zzjo.zza((zzbs$zzc) zza2.zzug(), str2);
        if (zza6.zzna() && zza6.zznb() > 0) {
            long zznb = zza6.zznb();
            zzgw();
            zzbs$zze zza7 = zzjo.zza((zzbs$zzc) zza3.zzug(), str2);
            if (zza7 != null && zza7.zznb() > 0) {
                zznb += zza7.zznb();
            }
            zzgw();
            zzjo.zza(zza3, str2, (Object) Long.valueOf(zznb));
            zzgw();
            zzjo.zza(zza2, "_fr", (Object) Long.valueOf(1));
        }
        return true;
    }

    private static void zza(com.google.android.gms.internal.measurement.zzbs$zzc.zza zza2, @NonNull String str) {
        List zzmj = zza2.zzmj();
        for (int i = 0; i < zzmj.size(); i++) {
            if (str.equals(((zzbs$zze) zzmj.get(i)).getName())) {
                zza2.zzm(i);
                return;
            }
        }
    }

    private static void zza(com.google.android.gms.internal.measurement.zzbs$zzc.zza zza2, int i, String str) {
        List zzmj = zza2.zzmj();
        int i2 = 0;
        while (true) {
            String str2 = "_err";
            if (i2 >= zzmj.size()) {
                zzbs$zze zzbs_zze = (zzbs$zze) zzbs$zze.zzng().zzbz("_ev").zzca(str).zzug();
                zza2.zza((zzbs$zze) zzbs$zze.zzng().zzbz(str2).zzam(Long.valueOf((long) i).longValue()).zzug()).zza(zzbs_zze);
                return;
            } else if (!str2.equals(((zzbs$zze) zzmj.get(i2)).getName())) {
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx zzgy;
        zzo();
        zzjj();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zztd = false;
                zzjo();
                throw th2;
            }
        }
        List<Long> list = this.zzth;
        this.zzth = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzac().zzlj.set(this.zzj.zzx().currentTimeMillis());
                this.zzj.zzac().zzlk.set(0);
                zzjn();
                this.zzj.zzab().zzgs().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzgy().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzgy = zzgy();
                            long longValue = l.longValue();
                            zzgy.zzo();
                            zzgy.zzbi();
                            if (zzgy.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzgy.zzab().zzgk().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzti == null || !this.zzti.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzgy().setTransactionSuccessful();
                    zzgy().endTransaction();
                    this.zzti = null;
                    if (!zzjf().zzgv() || !zzjm()) {
                        this.zztj = -1;
                        zzjn();
                    } else {
                        zzjl();
                    }
                    this.zzsy = 0;
                } catch (Throwable th3) {
                    zzgy().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzab().zzgk().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzsy = this.zzj.zzx().elapsedRealtime();
                this.zzj.zzab().zzgs().zza("Disable upload, time", Long.valueOf(this.zzsy));
            }
        } else {
            this.zzj.zzab().zzgs().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzac().zzlk.set(this.zzj.zzx().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzac().zzll.set(this.zzj.zzx().currentTimeMillis());
            }
            zzgy().zzb(list);
            zzjn();
        }
        this.zztd = false;
        zzjo();
    }

    private final boolean zzjm() {
        zzo();
        zzjj();
        return zzgy().zzcd() || !TextUtils.isEmpty(zzgy().zzby());
    }

    @WorkerThread
    private final void zzb(zzf zzf) {
        zzo();
        if (!TextUtils.isEmpty(zzf.getGmpAppId()) || (zzs.zzbx() && !TextUtils.isEmpty(zzf.zzah()))) {
            zzs zzad = this.zzj.zzad();
            Builder builder = new Builder();
            String gmpAppId = zzf.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzs.zzbx()) {
                gmpAppId = zzf.zzah();
            }
            ArrayMap arrayMap = null;
            Builder encodedAuthority = builder.scheme((String) zzak.zzgj.get(null)).encodedAuthority((String) zzak.zzgk.get(null));
            String str = "config/app/";
            String valueOf = String.valueOf(gmpAppId);
            encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", zzf.getAppInstanceId()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzad.zzao()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzj.zzab().zzgs().zza("Fetching remote configuration", zzf.zzag());
                zzbw zzaw = zzgz().zzaw(zzf.zzag());
                String zzax = zzgz().zzax(zzf.zzag());
                if (zzaw != null && !TextUtils.isEmpty(zzax)) {
                    arrayMap = new ArrayMap();
                    arrayMap.put("If-Modified-Since", zzax);
                }
                ArrayMap arrayMap2 = arrayMap;
                this.zztc = true;
                zzej zzjf = zzjf();
                String zzag = zzf.zzag();
                zzjl zzjl = new zzjl(this);
                zzjf.zzo();
                zzjf.zzbi();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzjl);
                zzfc zzaa = zzjf.zzaa();
                zzen zzen = new zzen(zzjf, zzag, url, null, arrayMap2, zzjl);
                zzaa.zzb((Runnable) zzen);
            } catch (MalformedURLException unused) {
                this.zzj.zzab().zzgk().zza("Failed to parse config URL. Not fetching. appId", zzef.zzam(zzf.zzag()), uri);
            }
        } else {
            zzb(zzf.zzag(), 204, null, null, null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzo()
            r6.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfj r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r1.beginTransaction()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zzgy()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzab(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgn()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfj r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzm(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r10 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r10.zza(r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgs()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfd r9 = r6.zzgz()     // Catch:{ all -> 0x018d }
            r9.zzay(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzlk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzx()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.set(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzll     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzx()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.set(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzjn()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfd r9 = r6.zzgz()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfd r11 = r6.zzgz()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzbw r11 = r11.zzaw(r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfd r11 = r6.zzgz()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfj r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzx()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzl(r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r9 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r9.zza(r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgp()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgs()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzej r7 = r6.zzjf()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zzgv()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzjm()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzjl()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzjn()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzx r8 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r8.endTransaction()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zztc = r0
            r6.zzjo()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c0  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzjn() {
        /*
            r21 = this;
            r0 = r21
            r21.zzo()
            r21.zzjj()
            boolean r1 = r21.zzjr()
            if (r1 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r1 = r1.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzim
            boolean r1 = r1.zza(r2)
            if (r1 != 0) goto L_0x001d
            return
        L_0x001d:
            long r1 = r0.zzsy
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzsy
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x0060:
            r0.zzsy = r3
        L_0x0062:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            boolean r1 = r1.zzie()
            if (r1 == 0) goto L_0x026b
            boolean r1 = r21.zzjm()
            if (r1 != 0) goto L_0x0072
            goto L_0x026b
        L_0x0072:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzhf
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzx r5 = r21.zzgy()
            boolean r5 = r5.zzce()
            if (r5 != 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzx r5 = r21.zzgy()
            boolean r5 = r5.zzbz()
            if (r5 == 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r5 = 0
            goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            if (r5 == 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzfj r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r10 = r10.zzad()
            java.lang.String r10 = r10.zzbu()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00d0
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzha
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzgz
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzgy
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfj r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r12 = r12.zzac()
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzlj
            long r12 = r12.get()
            com.google.android.gms.measurement.internal.zzfj r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r14 = r14.zzac()
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzlk
            long r14 = r14.get()
            com.google.android.gms.measurement.internal.zzx r16 = r21.zzgy()
            r17 = r10
            long r9 = r16.zzcb()
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()
            r19 = r7
            long r6 = r11.zzcc()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0128
        L_0x0125:
            r8 = r3
            goto L_0x019e
        L_0x0128:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x014e
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x014e
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x014e:
            com.google.android.gms.measurement.internal.zzjo r5 = r21.zzgw()
            r12 = r17
            boolean r5 = r5.zzb(r8, r12)
            if (r5 != 0) goto L_0x015c
            long r8 = r8 + r12
            goto L_0x015d
        L_0x015c:
            r8 = r10
        L_0x015d:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x019e
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x019e
            r5 = 0
        L_0x0166:
            r6 = 20
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzhh
            r10 = 0
            java.lang.Object r7 = r7.get(r10)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0125
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzak.zzhg
            java.lang.Object r12 = r12.get(r10)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r8 = r8 + r12
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            int r5 = r5 + 1
            goto L_0x0166
        L_0x019e:
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Next upload time is 0"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x01c0:
            com.google.android.gms.measurement.internal.zzej r1 = r21.zzjf()
            boolean r1 = r1.zzgv()
            if (r1 != 0) goto L_0x01e8
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "No network"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.zzha()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x01e8:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzll
            long r1 = r1.get()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzgw
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzjo r7 = r21.zzgw()
            boolean r7 = r7.zzb(r1, r5)
            if (r7 != 0) goto L_0x0214
            long r1 = r1 + r5
            long r8 = java.lang.Math.max(r8, r1)
        L_0x0214:
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.currentTimeMillis()
            long r8 = r8 - r1
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0250
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzak.zzhb
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r8 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzlj
            com.google.android.gms.measurement.internal.zzfj r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzx()
            long r2 = r2.currentTimeMillis()
            r1.set(r2)
        L_0x0250:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.zzv(r8)
            return
        L_0x026b:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzjn():void");
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzf(Runnable runnable) {
        zzo();
        if (this.zzsz == null) {
            this.zzsz = new ArrayList();
        }
        this.zzsz.add(runnable);
    }

    @WorkerThread
    private final void zzjo() {
        zzo();
        if (this.zztc || this.zztd || this.zzte) {
            this.zzj.zzab().zzgs().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zztc), Boolean.valueOf(this.zztd), Boolean.valueOf(this.zzte));
            return;
        }
        this.zzj.zzab().zzgs().zzao("Stopping uploading service(s)");
        List<Runnable> list = this.zzsz;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzsz.clear();
        }
    }

    @WorkerThread
    private final Boolean zzc(zzf zzf) {
        try {
            if (zzf.zzam() != -2147483648L) {
                if (zzf.zzam() == ((long) Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzf.zzag(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzf.zzag(), 0).versionName;
                if (zzf.zzal() != null && zzf.zzal().equals(str)) {
                    return Boolean.valueOf(true);
                }
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    private final boolean zzjp() {
        zzo();
        String str = "Storage concurrent access okay";
        if (this.zzj.zzad().zza(zzak.zzjh)) {
            FileLock fileLock = this.zztf;
            if (fileLock != null && fileLock.isValid()) {
                this.zzj.zzab().zzgs().zzao(str);
                return true;
            }
        }
        try {
            this.zztg = new RandomAccessFile(new File(this.zzj.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zztf = this.zztg.tryLock();
            if (this.zztf != null) {
                this.zzj.zzab().zzgs().zzao(str);
                return true;
            }
            this.zzj.zzab().zzgk().zzao("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzj.zzab().zzgk().zza("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            this.zzj.zzab().zzgk().zza("Failed to access storage lock file", e2);
        } catch (OverlappingFileLockException e3) {
            this.zzj.zzab().zzgn().zza("Storage lock already acquired", e3);
        }
    }

    @WorkerThread
    private final int zza(FileChannel fileChannel) {
        zzo();
        int i = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzab().zzgk().zzao("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzab().zzgn().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            i = allocate.getInt();
            return i;
        } catch (IOException e) {
            this.zzj.zzab().zzgk().zza("Failed to read from channel", e);
        }
    }

    @WorkerThread
    private final boolean zza(int i, FileChannel fileChannel) {
        zzo();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzab().zzgk().zzao("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzab().zzgk().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzab().zzgk().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzjq() {
        zzo();
        zzjj();
        if (!this.zzsx) {
            this.zzsx = true;
            zzo();
            zzjj();
            if ((this.zzj.zzad().zza(zzak.zzim) || zzjr()) && zzjp()) {
                int zza2 = zza(this.zztg);
                int zzgf = this.zzj.zzr().zzgf();
                zzo();
                if (zza2 > zzgf) {
                    this.zzj.zzab().zzgk().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                } else if (zza2 < zzgf) {
                    if (zza(zzgf, this.zztg)) {
                        this.zzj.zzab().zzgs().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                    } else {
                        this.zzj.zzab().zzgk().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                    }
                }
            }
        }
        if (!this.zzsw && !this.zzj.zzad().zza(zzak.zzim)) {
            this.zzj.zzab().zzgq().zzao("This instance being marked as an uploader");
            this.zzsw = true;
            zzjn();
        }
    }

    @WorkerThread
    private final boolean zzjr() {
        zzo();
        zzjj();
        return this.zzsw;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzd(zzn zzn) {
        String str = "app_id=?";
        if (this.zzth != null) {
            this.zzti = new ArrayList();
            this.zzti.addAll(this.zzth);
        }
        zzx zzgy = zzgy();
        String str2 = zzn.packageName;
        Preconditions.checkNotEmpty(str2);
        zzgy.zzo();
        zzgy.zzbi();
        try {
            SQLiteDatabase writableDatabase = zzgy.getWritableDatabase();
            String[] strArr = {str2};
            int delete = writableDatabase.delete("apps", str, strArr) + 0 + writableDatabase.delete("events", str, strArr) + writableDatabase.delete("user_attributes", str, strArr) + writableDatabase.delete("conditional_properties", str, strArr) + writableDatabase.delete("raw_events", str, strArr) + writableDatabase.delete("raw_events_metadata", str, strArr) + writableDatabase.delete("queue", str, strArr) + writableDatabase.delete("audience_filter_values", str, strArr) + writableDatabase.delete("main_event_params", str, strArr);
            if (delete > 0) {
                zzgy.zzab().zzgs().zza("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgy.zzab().zzgk().zza("Error resetting analytics data. appId, error", zzef.zzam(str2), e);
        }
        zzn zza2 = zza(this.zzj.getContext(), zzn.packageName, zzn.zzcg, zzn.zzcq, zzn.zzcs, zzn.zzct, zzn.zzdr, zzn.zzcu);
        if (zzn.zzcq) {
            zzf(zza2);
        }
    }

    private final zzn zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        int i;
        String str6 = str;
        String str7 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzab().zzgk().zzao("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str6);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzab().zzgk().zza("Error retrieving installer package name. appId", zzef.zzam(str));
            str4 = str7;
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str8 = str4;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str6, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str6);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                String str9 = packageInfo.versionName;
                i = packageInfo.versionCode;
                str5 = str9;
            } else {
                i = Integer.MIN_VALUE;
                str5 = str7;
            }
            this.zzj.zzae();
            zzn zzn = new zzn(str, str2, str5, (long) i, str8, this.zzj.zzad().zzao(), this.zzj.zzz().zzc(context, str6), (String) null, z, false, "", 0, this.zzj.zzad().zzr(str6) ? j : 0, 0, z2, z3, false, str3, (Boolean) null, 0, null);
            return zzn;
        } catch (NameNotFoundException unused2) {
            this.zzj.zzab().zzgk().zza("Error retrieving newly installed package info. appId, appName", zzef.zzam(str), str7);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(zzjn zzjn, zzn zzn) {
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        int zzbm = this.zzj.zzz().zzbm(zzjn.name);
        if (zzbm != 0) {
            this.zzj.zzz();
            String zza2 = zzjs.zza(zzjn.name, 24, true);
            String str = zzjn.name;
            this.zzj.zzz().zza(zzn.packageName, zzbm, "_ev", zza2, str != null ? str.length() : 0);
            return;
        }
        int zzc = this.zzj.zzz().zzc(zzjn.name, zzjn.getValue());
        if (zzc != 0) {
            this.zzj.zzz();
            String zza3 = zzjs.zza(zzjn.name, 24, true);
            Object value = zzjn.getValue();
            this.zzj.zzz().zza(zzn.packageName, zzc, "_ev", zza3, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object zzd = this.zzj.zzz().zzd(zzjn.name, zzjn.getValue());
        if (zzd != null) {
            if ("_sid".equals(zzjn.name) && this.zzj.zzad().zzw(zzn.packageName)) {
                long j = zzjn.zztr;
                String str2 = zzjn.origin;
                long j2 = 0;
                zzjp zze = zzgy().zze(zzn.packageName, "_sno");
                if (zze != null) {
                    Object obj = zze.value;
                    if (obj instanceof Long) {
                        j2 = ((Long) obj).longValue();
                        zzjn zzjn2 = new zzjn("_sno", j, Long.valueOf(j2 + 1), str2);
                        zzb(zzjn2, zzn);
                    }
                }
                if (zze != null) {
                    this.zzj.zzab().zzgn().zza("Retrieved last session number from database does not contain a valid (long) value", zze.value);
                }
                if (this.zzj.zzad().zze(zzn.packageName, zzak.zzie)) {
                    zzae zzc2 = zzgy().zzc(zzn.packageName, "_s");
                    if (zzc2 != null) {
                        j2 = zzc2.zzfg;
                        this.zzj.zzab().zzgs().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                }
                zzjn zzjn22 = new zzjn("_sno", j, Long.valueOf(j2 + 1), str2);
                zzb(zzjn22, zzn);
            }
            zzjp zzjp = new zzjp(zzn.packageName, zzjn.origin, zzjn.name, zzjn.zztr, zzd);
            this.zzj.zzab().zzgr().zza("Setting user property", this.zzj.zzy().zzal(zzjp.name), zzd);
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                boolean zza4 = zzgy().zza(zzjp);
                zzgy().setTransactionSuccessful();
                if (zza4) {
                    this.zzj.zzab().zzgr().zza("User property set", this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                } else {
                    this.zzj.zzab().zzgk().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                    this.zzj.zzz().zza(zzn.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzjn zzjn, zzn zzn) {
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        String str = "User property removed";
        String str2 = "Removing user property";
        if (this.zzj.zzad().zze(zzn.packageName, zzak.zzij)) {
            if (!"_npa".equals(zzjn.name) || zzn.zzcv == null) {
                this.zzj.zzab().zzgr().zza(str2, this.zzj.zzy().zzal(zzjn.name));
                zzgy().beginTransaction();
                try {
                    zzg(zzn);
                    zzgy().zzd(zzn.packageName, zzjn.name);
                    zzgy().setTransactionSuccessful();
                    this.zzj.zzab().zzgr().zza(str, this.zzj.zzy().zzal(zzjn.name));
                } finally {
                    zzgy().endTransaction();
                }
            } else {
                this.zzj.zzab().zzgr().zzao("Falling back to manifest metadata value for ad personalization");
                zzjn zzjn2 = new zzjn("_npa", this.zzj.zzx().currentTimeMillis(), Long.valueOf(zzn.zzcv.booleanValue() ? 1 : 0), DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                zzb(zzjn2, zzn);
            }
        } else {
            this.zzj.zzab().zzgr().zza(str2, this.zzj.zzy().zzal(zzjn.name));
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                zzgy().zzd(zzn.packageName, zzjn.name);
                zzgy().setTransactionSuccessful();
                this.zzj.zzab().zzgr().zza(str, this.zzj.zzy().zzal(zzjn.name));
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzjh zzjh) {
        this.zzta++;
    }

    /* access modifiers changed from: 0000 */
    public final void zzjs() {
        this.zztb++;
    }

    /* access modifiers changed from: 0000 */
    public final zzfj zzjt() {
        return this.zzj;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04a7 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0140 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f5 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0266 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0273 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0285 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sys"
            java.lang.String r4 = "_pfo"
            java.lang.String r5 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzo()
            r21.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r6 = r2.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)
            java.lang.String r6 = r2.zzcg
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x002b
            java.lang.String r6 = r2.zzcu
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x002b
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzx r6 = r21.zzgy()
            java.lang.String r7 = r2.packageName
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzab(r7)
            r7 = 0
            if (r6 == 0) goto L_0x005e
            java.lang.String r9 = r6.getGmpAppId()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x005e
            java.lang.String r9 = r2.zzcg
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x005e
            r6.zzl(r7)
            com.google.android.gms.measurement.internal.zzx r9 = r21.zzgy()
            r9.zza(r6)
            com.google.android.gms.measurement.internal.zzfd r6 = r21.zzgz()
            java.lang.String r9 = r2.packageName
            r6.zzaz(r9)
        L_0x005e:
            boolean r6 = r2.zzcq
            if (r6 != 0) goto L_0x0066
            r21.zzg(r22)
            return
        L_0x0066:
            long r9 = r2.zzdr
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj
            com.google.android.gms.common.util.Clock r6 = r6.zzx()
            long r9 = r6.currentTimeMillis()
        L_0x0076:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()
            java.lang.String r11 = r2.packageName
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzak.zzij
            boolean r6 = r6.zze(r11, r12)
            if (r6 == 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()
            r6.zzct()
        L_0x008f:
            int r6 = r2.zzds
            r15 = 0
            r13 = 1
            if (r6 == 0) goto L_0x00b1
            if (r6 == r13) goto L_0x00b1
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzab()
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgn()
            java.lang.String r12 = r2.packageName
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r12)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r11.zza(r14, r12, r6)
            r6 = 0
        L_0x00b1:
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()
            r11.beginTransaction()
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzak.zzij     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.zze(r12, r14)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0131
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzjp r14 = r11.zze(r12, r14)     // Catch:{ all -> 0x04d2 }
            if (r14 == 0) goto L_0x00e0
            java.lang.String r11 = "auto"
            java.lang.String r12 = r14.origin     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0131
        L_0x00e0:
            java.lang.Boolean r11 = r2.zzcv     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x011b
            com.google.android.gms.measurement.internal.zzjn r12 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "_npa"
            java.lang.Boolean r11 = r2.zzcv     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x00f3
            r17 = 1
            goto L_0x00f5
        L_0x00f3:
            r17 = 0
        L_0x00f5:
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x04d2 }
            java.lang.String r18 = "auto"
            r11 = r12
            r7 = r12
            r12 = r16
            r19 = r3
            r8 = r14
            r3 = 1
            r13 = r9
            r15 = r17
            r16 = r18
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            if (r8 == 0) goto L_0x0117
            java.lang.Object r8 = r8.value     // Catch:{ all -> 0x04d2 }
            java.lang.Long r11 = r7.zzts     // Catch:{ all -> 0x04d2 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x04d2 }
            if (r8 != 0) goto L_0x0134
        L_0x0117:
            r1.zzb(r7, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0134
        L_0x011b:
            r19 = r3
            r8 = r14
            r3 = 1
            if (r8 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzjn r7 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_npa"
            r15 = 0
            java.lang.String r16 = "auto"
            r11 = r7
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r7, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0134
        L_0x0131:
            r19 = r3
            r3 = 1
        L_0x0134:
            com.google.android.gms.measurement.internal.zzx r7 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzab(r8)     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x01f2
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            r11.zzz()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zzcg     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r7.getGmpAppId()     // Catch:{ all -> 0x04d2 }
            java.lang.String r13 = r2.zzcu     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = r7.zzah()     // Catch:{ all -> 0x04d2 }
            boolean r11 = com.google.android.gms.measurement.internal.zzjs.zza(r11, r12, r13, r14)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x01f2
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgn()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r7.zzag()     // Catch:{ all -> 0x04d2 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x04d2 }
            r11.zza(r12, r13)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzag()     // Catch:{ all -> 0x04d2 }
            r11.zzbi()     // Catch:{ all -> 0x04d2 }
            r11.zzo()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x04d2 }
            android.database.sqlite.SQLiteDatabase r12 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01dd }
            r15 = 0
            r13[r15] = r7     // Catch:{ SQLiteException -> 0x01db }
            java.lang.String r14 = "events"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r15
            java.lang.String r8 = "user_attributes"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "conditional_properties"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "apps"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "raw_events"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "raw_events_metadata"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "event_filters"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "property_filters"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "audience_filter_values"
            int r0 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzef r0 = r11.zzab()     // Catch:{ SQLiteException -> 0x01db }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ SQLiteException -> 0x01db }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01db }
            r0.zza(r8, r7, r12)     // Catch:{ SQLiteException -> 0x01db }
            goto L_0x01f0
        L_0x01db:
            r0 = move-exception
            goto L_0x01df
        L_0x01dd:
            r0 = move-exception
            r15 = 0
        L_0x01df:
            com.google.android.gms.measurement.internal.zzef r8 = r11.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "Error deleting application data. appId, error"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x04d2 }
            r8.zza(r11, r7, r0)     // Catch:{ all -> 0x04d2 }
        L_0x01f0:
            r7 = 0
            goto L_0x01f3
        L_0x01f2:
            r15 = 0
        L_0x01f3:
            if (r7 == 0) goto L_0x0260
            long r11 = r7.zzam()     // Catch:{ all -> 0x04d2 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            java.lang.String r0 = "_pv"
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x022d
            long r11 = r7.zzam()     // Catch:{ all -> 0x04d2 }
            long r13 = r2.zzcn     // Catch:{ all -> 0x04d2 }
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x0260
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r8.<init>()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            r8.putString(r0, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r8)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r8 = 0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0261
        L_0x022d:
            r8 = 0
            java.lang.String r11 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0261
            java.lang.String r11 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.zzcm     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04d2 }
            if (r11 != 0) goto L_0x0261
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r11.<init>()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzal()     // Catch:{ all -> 0x04d2 }
            r11.putString(r0, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r11)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0261
        L_0x0260:
            r8 = 0
        L_0x0261:
            r21.zzg(r22)     // Catch:{ all -> 0x04d2 }
            if (r6 != 0) goto L_0x0273
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_f"
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc(r7, r11)     // Catch:{ all -> 0x04d2 }
            goto L_0x0283
        L_0x0273:
            if (r6 != r3) goto L_0x0282
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_v"
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc(r7, r11)     // Catch:{ all -> 0x04d2 }
            goto L_0x0283
        L_0x0282:
            r0 = 0
        L_0x0283:
            if (r0 != 0) goto L_0x04a7
            r11 = 3600000(0x36ee80, double:1.7786363E-317)
            long r13 = r9 / r11
            r15 = 1
            long r13 = r13 + r15
            long r13 = r13 * r11
            java.lang.String r0 = "_dac"
            java.lang.String r7 = "_r"
            java.lang.String r15 = "_c"
            java.lang.String r12 = "_et"
            if (r6 != 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzjn r6 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "_fot"
            java.lang.Long r18 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r20 = "auto"
            r11 = r6
            r13 = r12
            r12 = r16
            r3 = r13
            r13 = r9
            r8 = r15
            r15 = r18
            r16 = r20
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb(r6, r2)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zzcg     // Catch:{ all -> 0x04d2 }
            boolean r6 = r6.zzt(r11)     // Catch:{ all -> 0x04d2 }
            if (r6 == 0) goto L_0x02d0
            r21.zzo()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeu r6 = r6.zzht()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x04d2 }
            r6.zzat(r11)     // Catch:{ all -> 0x04d2 }
        L_0x02d0:
            r21.zzo()     // Catch:{ all -> 0x04d2 }
            r21.zzjj()     // Catch:{ all -> 0x04d2 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r6.<init>()     // Catch:{ all -> 0x04d2 }
            r11 = 1
            r6.putLong(r8, r11)     // Catch:{ all -> 0x04d2 }
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04d2 }
            r7 = 0
            r6.putLong(r5, r7)     // Catch:{ all -> 0x04d2 }
            r6.putLong(r4, r7)     // Catch:{ all -> 0x04d2 }
            r15 = r19
            r6.putLong(r15, r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_sysu"
            r6.putLong(r11, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = r2.packageName     // Catch:{ all -> 0x04d2 }
            boolean r7 = r7.zzz(r8)     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0309
            r7 = 1
            r6.putLong(r3, r7)     // Catch:{ all -> 0x04d2 }
            goto L_0x030b
        L_0x0309:
            r7 = 1
        L_0x030b:
            boolean r11 = r2.zzdt     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0312
            r6.putLong(r0, r7)     // Catch:{ all -> 0x04d2 }
        L_0x0312:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x04d2 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x0335
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r5 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x04d2 }
            r0.zza(r5, r7)     // Catch:{ all -> 0x04d2 }
            goto L_0x03d8
        L_0x0335:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0347 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NameNotFoundException -> 0x0347 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0347 }
            java.lang.String r7 = r2.packageName     // Catch:{ NameNotFoundException -> 0x0347 }
            r8 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x0347 }
            goto L_0x035e
        L_0x0347:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x04d2 }
            r7.zza(r8, r11, r0)     // Catch:{ all -> 0x04d2 }
            r0 = 0
        L_0x035e:
            if (r0 == 0) goto L_0x0394
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04d2 }
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0394
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04d2 }
            long r11 = r0.lastUpdateTime     // Catch:{ all -> 0x04d2 }
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0377
            r7 = 1
            r6.putLong(r5, r7)     // Catch:{ all -> 0x04d2 }
            r0 = 0
            goto L_0x0378
        L_0x0377:
            r0 = 1
        L_0x0378:
            com.google.android.gms.measurement.internal.zzjn r5 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_fi"
            if (r0 == 0) goto L_0x0381
            r7 = 1
            goto L_0x0383
        L_0x0381:
            r7 = 0
        L_0x0383:
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "auto"
            r11 = r5
            r13 = r9
            r7 = r15
            r15 = r0
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb(r5, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0395
        L_0x0394:
            r7 = r15
        L_0x0395:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x03a7 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NameNotFoundException -> 0x03a7 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03a7 }
            java.lang.String r5 = r2.packageName     // Catch:{ NameNotFoundException -> 0x03a7 }
            r8 = 0
            android.content.pm.ApplicationInfo r8 = r0.getApplicationInfo(r5, r8)     // Catch:{ NameNotFoundException -> 0x03a7 }
            goto L_0x03be
        L_0x03a7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x04d2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x04d2 }
            r5.zza(r8, r11, r0)     // Catch:{ all -> 0x04d2 }
            r8 = 0
        L_0x03be:
            if (r8 == 0) goto L_0x03d8
            int r0 = r8.flags     // Catch:{ all -> 0x04d2 }
            r5 = 1
            r0 = r0 & r5
            if (r0 == 0) goto L_0x03cb
            r11 = 1
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04d2 }
        L_0x03cb:
            int r0 = r8.flags     // Catch:{ all -> 0x04d2 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03d8
            java.lang.String r0 = "_sysu"
            r7 = 1
            r6.putLong(r0, r7)     // Catch:{ all -> 0x04d2 }
        L_0x03d8:
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            java.lang.String r5 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x04d2 }
            r0.zzo()     // Catch:{ all -> 0x04d2 }
            r0.zzbi()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "first_open_count"
            long r7 = r0.zzj(r5, r7)     // Catch:{ all -> 0x04d2 }
            r11 = 0
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x03f6
            r6.putLong(r4, r7)     // Catch:{ all -> 0x04d2 }
        L_0x03f6:
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_f"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r6)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0464
        L_0x040a:
            r3 = r12
            r8 = r15
            r4 = 1
            if (r6 != r4) goto L_0x0464
            com.google.android.gms.measurement.internal.zzjn r4 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_fvt"
            java.lang.Long r15 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "auto"
            r11 = r4
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb(r4, r2)     // Catch:{ all -> 0x04d2 }
            r21.zzo()     // Catch:{ all -> 0x04d2 }
            r21.zzjj()     // Catch:{ all -> 0x04d2 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r4.<init>()     // Catch:{ all -> 0x04d2 }
            r5 = 1
            r4.putLong(r8, r5)     // Catch:{ all -> 0x04d2 }
            r4.putLong(r7, r5)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r6 = r2.packageName     // Catch:{ all -> 0x04d2 }
            boolean r5 = r5.zzz(r6)     // Catch:{ all -> 0x04d2 }
            if (r5 == 0) goto L_0x0448
            r5 = 1
            r4.putLong(r3, r5)     // Catch:{ all -> 0x04d2 }
            goto L_0x044a
        L_0x0448:
            r5 = 1
        L_0x044a:
            boolean r7 = r2.zzdt     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0451
            r4.putLong(r0, r5)     // Catch:{ all -> 0x04d2 }
        L_0x0451:
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_v"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r4)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x04d2 }
        L_0x0464:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r4 = r2.packageName     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzii     // Catch:{ all -> 0x04d2 }
            boolean r0 = r0.zze(r4, r5)     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x04c3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r0.<init>()     // Catch:{ all -> 0x04d2 }
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()     // Catch:{ all -> 0x04d2 }
            java.lang.String r4 = r2.packageName     // Catch:{ all -> 0x04d2 }
            boolean r3 = r3.zzz(r4)     // Catch:{ all -> 0x04d2 }
            if (r3 == 0) goto L_0x0493
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d2 }
        L_0x0493:
            com.google.android.gms.measurement.internal.zzai r3 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_e"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r3, r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x04c3
        L_0x04a7:
            boolean r0 = r2.zzdq     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x04c3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r0.<init>()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r3 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_cd"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zzc(r3, r2)     // Catch:{ all -> 0x04d2 }
        L_0x04c3:
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()     // Catch:{ all -> 0x04d2 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzx r0 = r21.zzgy()
            r0.endTransaction()
            return
        L_0x04d2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzx r2 = r21.zzgy()
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzf(com.google.android.gms.measurement.internal.zzn):void");
    }

    @WorkerThread
    private final zzn zzbi(String str) {
        String str2 = str;
        zzf zzab = zzgy().zzab(str2);
        if (zzab == null || TextUtils.isEmpty(zzab.zzal())) {
            this.zzj.zzab().zzgr().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzc = zzc(zzab);
        if (zzc == null || zzc.booleanValue()) {
            zzf zzf = zzab;
            zzn zzn = new zzn(str, zzab.getGmpAppId(), zzab.zzal(), zzab.zzam(), zzab.zzan(), zzab.zzao(), zzab.zzap(), (String) null, zzab.isMeasurementEnabled(), false, zzab.getFirebaseInstanceId(), zzf.zzbd(), 0, 0, zzf.zzbe(), zzf.zzbf(), false, zzf.zzah(), zzf.zzbg(), zzf.zzaq(), zzf.zzbh());
            return zzn;
        }
        this.zzj.zzab().zzgk().zza("App version does not match; dropping. appId", zzef.zzam(str));
        return null;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zze(zzq zzq) {
        zzn zzbi = zzbi(zzq.packageName);
        if (zzbi != null) {
            zzb(zzq, zzbi);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.packageName);
        Preconditions.checkNotNull(zzq.origin);
        Preconditions.checkNotNull(zzq.zzdw);
        Preconditions.checkNotEmpty(zzq.zzdw.name);
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        zzq zzq2 = new zzq(zzq);
        boolean z = false;
        zzq2.active = false;
        zzgy().beginTransaction();
        try {
            zzq zzf = zzgy().zzf(zzq2.packageName, zzq2.zzdw.name);
            if (zzf != null && !zzf.origin.equals(zzq2.origin)) {
                this.zzj.zzab().zzgn().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.origin, zzf.origin);
            }
            if (zzf != null && zzf.active) {
                zzq2.origin = zzf.origin;
                zzq2.creationTimestamp = zzf.creationTimestamp;
                zzq2.triggerTimeout = zzf.triggerTimeout;
                zzq2.triggerEventName = zzf.triggerEventName;
                zzq2.zzdy = zzf.zzdy;
                zzq2.active = zzf.active;
                zzjn zzjn = new zzjn(zzq2.zzdw.name, zzf.zzdw.zztr, zzq2.zzdw.getValue(), zzf.zzdw.origin);
                zzq2.zzdw = zzjn;
            } else if (TextUtils.isEmpty(zzq2.triggerEventName)) {
                zzjn zzjn2 = new zzjn(zzq2.zzdw.name, zzq2.creationTimestamp, zzq2.zzdw.getValue(), zzq2.zzdw.origin);
                zzq2.zzdw = zzjn2;
                zzq2.active = true;
                z = true;
            }
            if (zzq2.active) {
                zzjn zzjn3 = zzq2.zzdw;
                zzjp zzjp = new zzjp(zzq2.packageName, zzq2.origin, zzjn3.name, zzjn3.zztr, zzjn3.getValue());
                if (zzgy().zza(zzjp)) {
                    this.zzj.zzab().zzgr().zza("User property updated immediately", zzq2.packageName, this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                } else {
                    this.zzj.zzab().zzgk().zza("(2)Too many active user properties, ignoring", zzef.zzam(zzq2.packageName), this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                }
                if (z && zzq2.zzdy != null) {
                    zzd(new zzai(zzq2.zzdy, zzq2.creationTimestamp), zzn);
                }
            }
            if (zzgy().zza(zzq2)) {
                this.zzj.zzab().zzgr().zza("Conditional property added", zzq2.packageName, this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
            } else {
                this.zzj.zzab().zzgk().zza("Too many conditional properties, ignoring", zzef.zzam(zzq2.packageName), this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
            }
            zzgy().setTransactionSuccessful();
        } finally {
            zzgy().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzf(zzq zzq) {
        zzn zzbi = zzbi(zzq.packageName);
        if (zzbi != null) {
            zzc(zzq, zzbi);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.packageName);
        Preconditions.checkNotNull(zzq.zzdw);
        Preconditions.checkNotEmpty(zzq.zzdw.name);
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        zzgy().beginTransaction();
        try {
            zzg(zzn);
            zzq zzf = zzgy().zzf(zzq.packageName, zzq.zzdw.name);
            if (zzf != null) {
                this.zzj.zzab().zzgr().zza("Removing conditional user property", zzq.packageName, this.zzj.zzy().zzal(zzq.zzdw.name));
                zzgy().zzg(zzq.packageName, zzq.zzdw.name);
                if (zzf.active) {
                    zzgy().zzd(zzq.packageName, zzq.zzdw.name);
                }
                if (zzq.zzdz != null) {
                    Bundle bundle = null;
                    if (zzq.zzdz.zzfq != null) {
                        bundle = zzq.zzdz.zzfq.zzcv();
                    }
                    Bundle bundle2 = bundle;
                    zzd(this.zzj.zzz().zza(zzq.packageName, zzq.zzdz.name, bundle2, zzf.origin, zzq.zzdz.zzfu, true, false), zzn);
                }
            } else {
                this.zzj.zzab().zzgn().zza("Conditional user property doesn't exist", zzef.zzam(zzq.packageName), this.zzj.zzy().zzal(zzq.zzdw.name));
            }
            zzgy().setTransactionSuccessful();
        } finally {
            zzgy().endTransaction();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0188  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzg(com.google.android.gms.measurement.internal.zzn r11) {
        /*
            r10 = this;
            r10.zzo()
            r10.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            java.lang.String r0 = r11.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzx r0 = r10.zzgy()
            java.lang.String r1 = r11.packageName
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzab(r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            java.lang.String r2 = r11.packageName
            java.lang.String r1 = r1.zzaq(r2)
            r2 = 1
            if (r0 != 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzf r0 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            java.lang.String r4 = r11.packageName
            r0.<init>(r3, r4)
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzjs r3 = r3.zzz()
            java.lang.String r3 = r3.zzjy()
            r0.zza(r3)
            r0.zzd(r1)
        L_0x0040:
            r1 = 1
            goto L_0x005e
        L_0x0042:
            java.lang.String r3 = r0.zzai()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            r0.zzd(r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zzz()
            java.lang.String r1 = r1.zzjy()
            r0.zza(r1)
            goto L_0x0040
        L_0x005d:
            r1 = 0
        L_0x005e:
            java.lang.String r3 = r11.zzcg
            java.lang.String r4 = r0.getGmpAppId()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0070
            java.lang.String r1 = r11.zzcg
            r0.zzb(r1)
            r1 = 1
        L_0x0070:
            java.lang.String r3 = r11.zzcu
            java.lang.String r4 = r0.zzah()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0082
            java.lang.String r1 = r11.zzcu
            r0.zzc(r1)
            r1 = 1
        L_0x0082:
            java.lang.String r3 = r11.zzci
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = r11.zzci
            java.lang.String r4 = r0.getFirebaseInstanceId()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            java.lang.String r1 = r11.zzci
            r0.zze(r1)
            r1 = 1
        L_0x009c:
            long r3 = r11.zzr
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b2
            long r7 = r0.zzao()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00b2
            long r3 = r11.zzr
            r0.zzh(r3)
            r1 = 1
        L_0x00b2:
            java.lang.String r3 = r11.zzcm
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00cc
            java.lang.String r3 = r11.zzcm
            java.lang.String r4 = r0.zzal()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00cc
            java.lang.String r1 = r11.zzcm
            r0.zzf(r1)
            r1 = 1
        L_0x00cc:
            long r3 = r11.zzcn
            long r7 = r0.zzam()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00dc
            long r3 = r11.zzcn
            r0.zzg(r3)
            r1 = 1
        L_0x00dc:
            java.lang.String r3 = r11.zzco
            if (r3 == 0) goto L_0x00f0
            java.lang.String r4 = r0.zzan()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f0
            java.lang.String r1 = r11.zzco
            r0.zzg(r1)
            r1 = 1
        L_0x00f0:
            long r3 = r11.zzcp
            long r7 = r0.zzap()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0100
            long r3 = r11.zzcp
            r0.zzi(r3)
            r1 = 1
        L_0x0100:
            boolean r3 = r11.zzcq
            boolean r4 = r0.isMeasurementEnabled()
            if (r3 == r4) goto L_0x010e
            boolean r1 = r11.zzcq
            r0.setMeasurementEnabled(r1)
            r1 = 1
        L_0x010e:
            java.lang.String r3 = r11.zzdp
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0128
            java.lang.String r3 = r11.zzdp
            java.lang.String r4 = r0.zzbb()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0128
            java.lang.String r1 = r11.zzdp
            r0.zzh(r1)
            r1 = 1
        L_0x0128:
            long r3 = r11.zzcr
            long r7 = r0.zzbd()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0138
            long r3 = r11.zzcr
            r0.zzt(r3)
            r1 = 1
        L_0x0138:
            boolean r3 = r11.zzcs
            boolean r4 = r0.zzbe()
            if (r3 == r4) goto L_0x0146
            boolean r1 = r11.zzcs
            r0.zzb(r1)
            r1 = 1
        L_0x0146:
            boolean r3 = r11.zzct
            boolean r4 = r0.zzbf()
            if (r3 == r4) goto L_0x0154
            boolean r1 = r11.zzct
            r0.zzc(r1)
            r1 = 1
        L_0x0154:
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()
            java.lang.String r4 = r11.packageName
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzij
            boolean r3 = r3.zze(r4, r7)
            if (r3 == 0) goto L_0x0172
            java.lang.Boolean r3 = r11.zzcv
            java.lang.Boolean r4 = r0.zzbg()
            if (r3 == r4) goto L_0x0172
            java.lang.Boolean r1 = r11.zzcv
            r0.zza(r1)
            r1 = 1
        L_0x0172:
            long r3 = r11.zzs
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0186
            long r5 = r0.zzaq()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0186
            long r3 = r11.zzs
            r0.zzj(r3)
            r1 = 1
        L_0x0186:
            if (r1 == 0) goto L_0x018f
            com.google.android.gms.measurement.internal.zzx r11 = r10.zzgy()
            r11.zza(r0)
        L_0x018f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzg(com.google.android.gms.measurement.internal.zzn):com.google.android.gms.measurement.internal.zzf");
    }

    /* access modifiers changed from: 0000 */
    public final String zzh(zzn zzn) {
        try {
            return (String) this.zzj.zzaa().zza((Callable<V>) new zzjk<V>(this, zzn)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzab().zzgk().zza("Failed to get app instance id. appId", zzef.zzam(zzn.packageName), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzj(boolean z) {
        zzjn();
    }
}
