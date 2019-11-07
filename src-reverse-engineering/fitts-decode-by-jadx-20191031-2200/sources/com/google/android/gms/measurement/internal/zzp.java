package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbk$zza;
import com.google.android.gms.internal.measurement.zzbk$zzb;
import com.google.android.gms.internal.measurement.zzbk$zzc;
import com.google.android.gms.internal.measurement.zzbk$zzd;
import com.google.android.gms.internal.measurement.zzbk$zze;
import com.google.android.gms.internal.measurement.zzbk$zze.zza;
import com.google.android.gms.internal.measurement.zzbs$zzb;
import com.google.android.gms.internal.measurement.zzbs$zze;
import com.google.android.gms.internal.measurement.zzbs$zzk;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzp extends zzjh {
    zzp(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0cf4, code lost:
        if (r0.zzkb() == false) goto L_0x0cff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0cf6, code lost:
        r8 = java.lang.Integer.valueOf(r0.getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0cff, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x0d00, code lost:
        r1.zza("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r8));
        r14.add(java.lang.Integer.valueOf(r5));
        r11 = r72;
        r1 = r73;
        r46 = r4;
        r47 = r7;
        r0 = r16;
        r3 = r17;
        r15 = r37;
        r68 = r43;
        r24 = r44;
        r69 = r48;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x047d  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x049a  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c4  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x064e  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x066f  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x075e  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x09e4  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0d62  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01dd  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbs$zza> zza(java.lang.String r72, java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r73, java.util.List<com.google.android.gms.internal.measurement.zzbs$zzk> r74) {
        /*
            r71 = this;
            r7 = r71
            r9 = r72
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r73)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r74)
            java.util.HashSet r15 = new java.util.HashSet
            r15.<init>()
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            androidx.collection.ArrayMap r14 = new androidx.collection.ArrayMap
            r14.<init>()
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap
            r11.<init>()
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzad()
            boolean r25 = r0.zzq(r9)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziq
            boolean r26 = r0.zzd(r9, r1)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziy
            boolean r27 = r0.zzd(r9, r1)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziz
            boolean r28 = r0.zzd(r9, r1)
            if (r27 != 0) goto L_0x0055
            if (r28 == 0) goto L_0x007c
        L_0x0055:
            java.util.Iterator r0 = r73.iterator()
        L_0x0059:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007c
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzbs$zzc r1 = (com.google.android.gms.internal.measurement.zzbs$zzc) r1
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "_s"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0059
            long r0 = r1.getTimestampMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r29 = r0
            goto L_0x007e
        L_0x007c:
            r29 = 0
        L_0x007e:
            r6 = 1
            r4 = 0
            if (r29 == 0) goto L_0x00c1
            if (r28 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            r1.zzbi()
            r1.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.String r3 = "current_session_count"
            r0.put(r3, r2)
            android.database.sqlite.SQLiteDatabase r2 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00af }
            java.lang.String r3 = "events"
            java.lang.String r5 = "app_id = ?"
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00af }
            r8[r4] = r9     // Catch:{ SQLiteException -> 0x00af }
            r2.update(r3, r0, r5, r8)     // Catch:{ SQLiteException -> 0x00af }
            goto L_0x00c1
        L_0x00af:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r72)
            java.lang.String r3 = "Error resetting session-scoped event counts. appId"
            r1.zza(r3, r2, r0)
        L_0x00c1:
            com.google.android.gms.measurement.internal.zzx r0 = r71.zzgy()
            java.util.Map r0 = r0.zzaf(r9)
            if (r0 == 0) goto L_0x034d
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x034d
            java.util.HashSet r1 = new java.util.HashSet
            java.util.Set r2 = r0.keySet()
            r1.<init>(r2)
            if (r27 == 0) goto L_0x01d2
            if (r29 == 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzp r2 = r71.zzgx()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzx r5 = r2.zzgy()
            java.util.Map r5 = r5.zzae(r9)
            java.util.Set r8 = r0.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0103:
            boolean r17 = r8.hasNext()
            if (r17 == 0) goto L_0x01d3
            java.lang.Object r17 = r8.next()
            java.lang.Integer r17 = (java.lang.Integer) r17
            int r17 = r17.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            java.lang.Object r6 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzbs$zzi r6 = (com.google.android.gms.internal.measurement.zzbs$zzi) r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Object r4 = r5.get(r4)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x01bb
            boolean r20 = r4.isEmpty()
            if (r20 == 0) goto L_0x0131
            goto L_0x01bb
        L_0x0131:
            r20 = r5
            com.google.android.gms.measurement.internal.zzjo r5 = r2.zzgw()
            r21 = r8
            java.util.List r8 = r6.zzpy()
            java.util.List r5 = r5.zza(r8, r4)
            boolean r8 = r5.isEmpty()
            if (r8 != 0) goto L_0x01b6
            com.google.android.gms.internal.measurement.zzey$zza r8 = r6.zzuj()
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r8 = (com.google.android.gms.internal.measurement.zzbs$zzi.zza) r8
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r8 = r8.zzqr()
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r5 = r8.zzo(r5)
            com.google.android.gms.measurement.internal.zzjo r8 = r2.zzgw()
            r22 = r2
            java.util.List r2 = r6.zzpv()
            java.util.List r2 = r8.zza(r2, r4)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r8 = r5.zzqq()
            r8.zzn(r2)
            r2 = 0
        L_0x016b:
            int r8 = r6.zzqc()
            if (r2 >= r8) goto L_0x0189
            com.google.android.gms.internal.measurement.zzbs$zzb r8 = r6.zzae(r2)
            int r8 = r8.getIndex()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r4.contains(r8)
            if (r8 == 0) goto L_0x0186
            r5.zzaj(r2)
        L_0x0186:
            int r2 = r2 + 1
            goto L_0x016b
        L_0x0189:
            r2 = 0
        L_0x018a:
            int r8 = r6.zzqf()
            if (r2 >= r8) goto L_0x01a8
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = r6.zzag(r2)
            int r8 = r8.getIndex()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r4.contains(r8)
            if (r8 == 0) goto L_0x01a5
            r5.zzak(r2)
        L_0x01a5:
            int r2 = r2 + 1
            goto L_0x018a
        L_0x01a8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            com.google.android.gms.internal.measurement.zzgi r4 = r5.zzug()
            com.google.android.gms.internal.measurement.zzbs$zzi r4 = (com.google.android.gms.internal.measurement.zzbs$zzi) r4
            r3.put(r2, r4)
            goto L_0x01c8
        L_0x01b6:
            r5 = r20
            r8 = r21
            goto L_0x01ce
        L_0x01bb:
            r22 = r2
            r20 = r5
            r21 = r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r3.put(r2, r6)
        L_0x01c8:
            r5 = r20
            r8 = r21
            r2 = r22
        L_0x01ce:
            r4 = 0
            r6 = 1
            goto L_0x0103
        L_0x01d2:
            r3 = r0
        L_0x01d3:
            java.util.Iterator r1 = r1.iterator()
        L_0x01d7:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x034d
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object r4 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzbs$zzi r4 = (com.google.android.gms.internal.measurement.zzbs$zzi) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            java.lang.Object r5 = r14.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.Object r6 = r11.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            if (r25 == 0) goto L_0x026a
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r4 == 0) goto L_0x025e
            int r17 = r4.zzqc()
            if (r17 != 0) goto L_0x0215
            goto L_0x025e
        L_0x0215:
            java.util.List r17 = r4.zzqb()
            java.util.Iterator r17 = r17.iterator()
        L_0x021d:
            boolean r20 = r17.hasNext()
            if (r20 == 0) goto L_0x025e
            java.lang.Object r20 = r17.next()
            com.google.android.gms.internal.measurement.zzbs$zzb r20 = (com.google.android.gms.internal.measurement.zzbs$zzb) r20
            boolean r21 = r20.zzme()
            if (r21 == 0) goto L_0x0255
            int r21 = r20.getIndex()
            r22 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)
            boolean r21 = r20.zzmf()
            if (r21 == 0) goto L_0x024e
            long r20 = r20.zzmg()
            java.lang.Long r20 = java.lang.Long.valueOf(r20)
            r70 = r20
            r20 = r3
            r3 = r70
            goto L_0x0251
        L_0x024e:
            r20 = r3
            r3 = 0
        L_0x0251:
            r8.put(r1, r3)
            goto L_0x0259
        L_0x0255:
            r22 = r1
            r20 = r3
        L_0x0259:
            r3 = r20
            r1 = r22
            goto L_0x021d
        L_0x025e:
            r22 = r1
            r20 = r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r12.put(r1, r8)
            goto L_0x026f
        L_0x026a:
            r22 = r1
            r20 = r3
            r8 = 0
        L_0x026f:
            if (r5 != 0) goto L_0x0289
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r14.put(r1, r5)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r11.put(r1, r6)
        L_0x0289:
            if (r4 == 0) goto L_0x02e6
            r1 = 0
        L_0x028c:
            int r3 = r4.zzpw()
            int r3 = r3 << 6
            if (r1 >= r3) goto L_0x02e6
            java.util.List r3 = r4.zzpv()
            boolean r3 = com.google.android.gms.measurement.internal.zzjo.zza(r3, r1)
            if (r3 == 0) goto L_0x02cb
            com.google.android.gms.measurement.internal.zzef r3 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgs()
            r17 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
            r21 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r23 = r14
            java.lang.String r14 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r14, r11, r12)
            r6.set(r1)
            java.util.List r3 = r4.zzpy()
            boolean r3 = com.google.android.gms.measurement.internal.zzjo.zza(r3, r1)
            if (r3 == 0) goto L_0x02d1
            r5.set(r1)
            r3 = 1
            goto L_0x02d2
        L_0x02cb:
            r17 = r11
            r21 = r12
            r23 = r14
        L_0x02d1:
            r3 = 0
        L_0x02d2:
            if (r8 == 0) goto L_0x02dd
            if (r3 != 0) goto L_0x02dd
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r8.remove(r3)
        L_0x02dd:
            int r1 = r1 + 1
            r11 = r17
            r12 = r21
            r14 = r23
            goto L_0x028c
        L_0x02e6:
            r17 = r11
            r21 = r12
            r23 = r14
            com.google.android.gms.internal.measurement.zzbs$zza$zza r1 = com.google.android.gms.internal.measurement.zzbs$zza.zzmc()
            r3 = 0
            com.google.android.gms.internal.measurement.zzbs$zza$zza r1 = r1.zzk(r3)
            if (r27 == 0) goto L_0x0305
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzbs$zzi r3 = (com.google.android.gms.internal.measurement.zzbs$zzi) r3
            r1.zza(r3)
            goto L_0x0308
        L_0x0305:
            r1.zza(r4)
        L_0x0308:
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r3 = com.google.android.gms.internal.measurement.zzbs$zzi.zzqh()
            java.util.List r4 = com.google.android.gms.measurement.internal.zzjo.zza(r5)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r3 = r3.zzo(r4)
            java.util.List r4 = com.google.android.gms.measurement.internal.zzjo.zza(r6)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r3 = r3.zzn(r4)
            if (r25 == 0) goto L_0x0331
            java.util.List r4 = zza(r8)
            r3.zzp(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            r10.put(r4, r5)
        L_0x0331:
            r1.zza(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzgi r1 = r1.zzug()
            com.google.android.gms.internal.measurement.zzbs$zza r1 = (com.google.android.gms.internal.measurement.zzbs$zza) r1
            r13.put(r2, r1)
            r11 = r17
            r3 = r20
            r12 = r21
            r1 = r22
            r14 = r23
            goto L_0x01d7
        L_0x034d:
            r17 = r11
            r21 = r12
            r23 = r14
            boolean r0 = r73.isEmpty()
            java.lang.String r14 = "Filter definition"
            java.lang.String r8 = "Skipping failed audience ID"
            java.lang.String r30 = "null"
            if (r0 != 0) goto L_0x09cf
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
            java.util.Iterator r31 = r73.iterator()
            r32 = 0
            r2 = r32
            r0 = 0
            r1 = 0
        L_0x036e:
            boolean r4 = r31.hasNext()
            if (r4 == 0) goto L_0x09cf
            java.lang.Object r4 = r31.next()
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs$zzc) r4
            java.lang.String r5 = r4.getName()
            java.util.List r20 = r4.zzmj()
            r71.zzgw()
            java.lang.String r11 = "_eid"
            java.lang.Object r24 = com.google.android.gms.measurement.internal.zzjo.zzb(r4, r11)
            r12 = r24
            java.lang.Long r12 = (java.lang.Long) r12
            if (r12 == 0) goto L_0x0394
            r24 = 1
            goto L_0x0396
        L_0x0394:
            r24 = 0
        L_0x0396:
            r35 = r2
            if (r24 == 0) goto L_0x03a4
            java.lang.String r2 = "_ep"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x03a4
            r2 = 1
            goto L_0x03a5
        L_0x03a4:
            r2 = 0
        L_0x03a5:
            r37 = 1
            if (r2 == 0) goto L_0x04e6
            r71.zzgw()
            java.lang.String r2 = "_en"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzjo.zzb(r4, r2)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x03ce
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.String r3 = "Extra parameter without an event name. eventId"
            r2.zza(r3, r12)
            r41 = r6
            r18 = r8
            goto L_0x04de
        L_0x03ce:
            if (r0 == 0) goto L_0x03e5
            if (r1 == 0) goto L_0x03e5
            long r2 = r12.longValue()
            long r39 = r1.longValue()
            int r24 = (r2 > r39 ? 1 : (r2 == r39 ? 0 : -1))
            if (r24 == 0) goto L_0x03df
            goto L_0x03e5
        L_0x03df:
            r11 = r0
            r24 = r1
            r0 = r35
            goto L_0x040b
        L_0x03e5:
            com.google.android.gms.measurement.internal.zzx r2 = r71.zzgy()
            android.util.Pair r2 = r2.zza(r9, r12)
            if (r2 == 0) goto L_0x04cc
            java.lang.Object r3 = r2.first
            if (r3 != 0) goto L_0x03f5
            goto L_0x04cc
        L_0x03f5:
            com.google.android.gms.internal.measurement.zzbs$zzc r3 = (com.google.android.gms.internal.measurement.zzbs$zzc) r3
            java.lang.Object r0 = r2.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r71.zzgw()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzjo.zzb(r3, r11)
            java.lang.Long r2 = (java.lang.Long) r2
            r24 = r2
            r11 = r3
        L_0x040b:
            long r35 = r0 - r37
            int r0 = (r35 > r32 ? 1 : (r35 == r32 ? 0 : -1))
            if (r0 > 0) goto L_0x0452
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            r1.zzo()
            com.google.android.gms.measurement.internal.zzef r0 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()
            java.lang.String r2 = "Clearing complex main event info. appId"
            r0.zza(r2, r9)
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x043a }
            java.lang.String r2 = "delete from main_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r12 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0438 }
            r18 = 0
            r12[r18] = r9     // Catch:{ SQLiteException -> 0x0436 }
            r0.execSQL(r2, r12)     // Catch:{ SQLiteException -> 0x0436 }
            goto L_0x044b
        L_0x0436:
            r0 = move-exception
            goto L_0x043e
        L_0x0438:
            r0 = move-exception
            goto L_0x043c
        L_0x043a:
            r0 = move-exception
            r3 = 1
        L_0x043c:
            r18 = 0
        L_0x043e:
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()
            java.lang.String r2 = "Error clearing complex main event"
            r1.zza(r2, r0)
        L_0x044b:
            r12 = r4
            r41 = r6
            r18 = r8
            r8 = r5
            goto L_0x046a
        L_0x0452:
            r3 = 1
            r18 = 0
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            r2 = r72
            r19 = 1
            r3 = r12
            r12 = r4
            r18 = r8
            r8 = r5
            r4 = r35
            r41 = r6
            r6 = r11
            r1.zza(r2, r3, r4, r6)
        L_0x046a:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = r11.zzmj()
            java.util.Iterator r1 = r1.iterator()
        L_0x0477:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0494
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbs$zze r2 = (com.google.android.gms.internal.measurement.zzbs$zze) r2
            r71.zzgw()
            java.lang.String r3 = r2.getName()
            com.google.android.gms.internal.measurement.zzbs$zze r3 = com.google.android.gms.measurement.internal.zzjo.zza(r12, r3)
            if (r3 != 0) goto L_0x0477
            r0.add(r2)
            goto L_0x0477
        L_0x0494:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04b5
            java.util.Iterator r1 = r20.iterator()
        L_0x049e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04ae
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbs$zze r2 = (com.google.android.gms.internal.measurement.zzbs$zze) r2
            r0.add(r2)
            goto L_0x049e
        L_0x04ae:
            r42 = r0
            r0 = r8
            r39 = r11
            r11 = r12
            goto L_0x04c8
        L_0x04b5:
            com.google.android.gms.measurement.internal.zzef r0 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r1 = "No unique parameters in main event. eventName"
            r0.zza(r1, r8)
            r0 = r8
            r39 = r11
            r11 = r12
            r42 = r20
        L_0x04c8:
            r40 = r24
            goto L_0x0533
        L_0x04cc:
            r41 = r6
            r18 = r8
            r8 = r5
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.String r3 = "Extra parameter without existing main event. eventName, eventId"
            r2.zza(r3, r8, r12)
        L_0x04de:
            r8 = r18
            r2 = r35
            r6 = r41
            goto L_0x036e
        L_0x04e6:
            r11 = r4
            r41 = r6
            r18 = r8
            if (r24 == 0) goto L_0x052b
            r71.zzgw()
            java.lang.Long r0 = java.lang.Long.valueOf(r32)
            java.lang.String r1 = "_epc"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzjo.zzb(r11, r1)
            if (r1 != 0) goto L_0x04fd
            goto L_0x04fe
        L_0x04fd:
            r0 = r1
        L_0x04fe:
            java.lang.Long r0 = (java.lang.Long) r0
            long r35 = r0.longValue()
            int r0 = (r35 > r32 ? 1 : (r35 == r32 ? 0 : -1))
            if (r0 > 0) goto L_0x0517
            com.google.android.gms.measurement.internal.zzef r0 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r1 = "Complex event with zero extra param count. eventName"
            r0.zza(r1, r5)
            r8 = r5
            goto L_0x0525
        L_0x0517:
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            r2 = r72
            r3 = r12
            r8 = r5
            r4 = r35
            r6 = r11
            r1.zza(r2, r3, r4, r6)
        L_0x0525:
            r0 = r8
            r39 = r11
            r40 = r12
            goto L_0x0531
        L_0x052b:
            r8 = r5
            r39 = r0
            r40 = r1
            r0 = r8
        L_0x0531:
            r42 = r20
        L_0x0533:
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            java.lang.String r2 = r11.getName()
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc(r9, r2)
            if (r1 != 0) goto L_0x05c4
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r72)
            com.google.android.gms.measurement.internal.zzed r3 = r71.zzy()
            java.lang.String r3 = r3.zzaj(r0)
            java.lang.String r4 = "Event aggregate wasn't created during raw event logging. appId, event"
            r1.zza(r4, r2, r3)
            if (r28 == 0) goto L_0x0590
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            r5 = r18
            r6 = 0
            r8 = r1
            java.lang.String r2 = r11.getName()
            r4 = r10
            r10 = r2
            r2 = 1
            r34 = r11
            r43 = r17
            r44 = r21
            r11 = r2
            r46 = r13
            r48 = r14
            r47 = r23
            r13 = r2
            r49 = r15
            r15 = r2
            long r17 = r34.getTimestampMillis()
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r3 = r9
            r9 = r72
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)
            goto L_0x05c1
        L_0x0590:
            r3 = r9
            r4 = r10
            r34 = r11
            r46 = r13
            r48 = r14
            r49 = r15
            r43 = r17
            r5 = r18
            r44 = r21
            r47 = r23
            r6 = 0
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            java.lang.String r10 = r34.getName()
            r11 = 1
            r13 = 1
            long r15 = r34.getTimestampMillis()
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r8 = r1
            r9 = r72
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)
        L_0x05c1:
            r7 = r1
            goto L_0x063b
        L_0x05c4:
            r3 = r9
            r4 = r10
            r34 = r11
            r46 = r13
            r48 = r14
            r49 = r15
            r43 = r17
            r5 = r18
            r44 = r21
            r47 = r23
            r6 = 0
            if (r28 == 0) goto L_0x060d
            com.google.android.gms.measurement.internal.zzae r2 = new com.google.android.gms.measurement.internal.zzae
            r50 = r2
            java.lang.String r8 = r1.zzce
            r51 = r8
            java.lang.String r8 = r1.name
            r52 = r8
            long r8 = r1.zzfg
            long r53 = r8 + r37
            long r8 = r1.zzfh
            long r55 = r8 + r37
            long r8 = r1.zzfi
            long r57 = r8 + r37
            long r8 = r1.zzfj
            r59 = r8
            long r8 = r1.zzfk
            r61 = r8
            java.lang.Long r8 = r1.zzfl
            r63 = r8
            java.lang.Long r8 = r1.zzfm
            r64 = r8
            java.lang.Long r8 = r1.zzfn
            r65 = r8
            java.lang.Boolean r1 = r1.zzfo
            r66 = r1
            r50.<init>(r51, r52, r53, r55, r57, r59, r61, r63, r64, r65, r66)
            goto L_0x063a
        L_0x060d:
            com.google.android.gms.measurement.internal.zzae r2 = new com.google.android.gms.measurement.internal.zzae
            r8 = r2
            java.lang.String r9 = r1.zzce
            java.lang.String r10 = r1.name
            long r11 = r1.zzfg
            long r11 = r11 + r37
            long r13 = r1.zzfh
            long r13 = r13 + r37
            long r6 = r1.zzfi
            r15 = r6
            long r6 = r1.zzfj
            r17 = r6
            long r6 = r1.zzfk
            r19 = r6
            java.lang.Long r6 = r1.zzfl
            r21 = r6
            java.lang.Long r6 = r1.zzfm
            r22 = r6
            java.lang.Long r6 = r1.zzfn
            r23 = r6
            java.lang.Boolean r1 = r1.zzfo
            r24 = r1
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)
        L_0x063a:
            r7 = r2
        L_0x063b:
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            r1.zza(r7)
            long r8 = r7.zzfg
            r10 = r41
            java.lang.Object r1 = r10.get(r0)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 != 0) goto L_0x0660
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzgy()
            java.util.Map r1 = r1.zzh(r3, r0)
            if (r1 != 0) goto L_0x065d
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
        L_0x065d:
            r10.put(r0, r1)
        L_0x0660:
            r11 = r1
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r12 = r1.iterator()
        L_0x0669:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x09b5
            java.lang.Object r1 = r12.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r13 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14 = r49
            boolean r1 = r14.contains(r1)
            if (r1 == 0) goto L_0x0697
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r1.zza(r5, r2)
            r49 = r14
            goto L_0x0669
        L_0x0697:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r15 = r47
            java.lang.Object r1 = r15.get(r1)
            java.util.BitSet r1 = (java.util.BitSet) r1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r6 = r43
            java.lang.Object r2 = r6.get(r2)
            java.util.BitSet r2 = (java.util.BitSet) r2
            r16 = r1
            if (r25 == 0) goto L_0x06ce
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r17 = r8
            r8 = r44
            java.lang.Object r1 = r8.get(r1)
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)
            java.lang.Object r9 = r4.get(r9)
            java.util.Map r9 = (java.util.Map) r9
            r19 = r1
            goto L_0x06d5
        L_0x06ce:
            r17 = r8
            r8 = r44
            r9 = 0
            r19 = 0
        L_0x06d5:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r20 = r9
            r9 = r46
            java.lang.Object r1 = r9.get(r1)
            com.google.android.gms.internal.measurement.zzbs$zza r1 = (com.google.android.gms.internal.measurement.zzbs$zza) r1
            if (r1 != 0) goto L_0x0742
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            com.google.android.gms.internal.measurement.zzbs$zza$zza r2 = com.google.android.gms.internal.measurement.zzbs$zza.zzmc()
            r41 = r10
            r10 = 1
            com.google.android.gms.internal.measurement.zzbs$zza$zza r2 = r2.zzk(r10)
            com.google.android.gms.internal.measurement.zzgi r2 = r2.zzug()
            com.google.android.gms.internal.measurement.zzbs$zza r2 = (com.google.android.gms.internal.measurement.zzbs$zza) r2
            r9.put(r1, r2)
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r15.put(r2, r1)
            java.util.BitSet r2 = new java.util.BitSet
            r2.<init>()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            r6.put(r10, r2)
            if (r25 == 0) goto L_0x073d
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            r16 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r8.put(r1, r10)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            r21 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r4.put(r2, r1)
            r19 = r10
            r10 = r16
            r2 = r21
            r16 = r12
            r12 = r1
            goto L_0x074a
        L_0x073d:
            r16 = r1
            r21 = r2
            goto L_0x0744
        L_0x0742:
            r41 = r10
        L_0x0744:
            r10 = r16
            r16 = r12
            r12 = r20
        L_0x074a:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            java.lang.Object r1 = r11.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r20 = r1.iterator()
        L_0x0758:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x09a3
            java.lang.Object r1 = r20.next()
            com.google.android.gms.internal.measurement.zzbk$zza r1 = (com.google.android.gms.internal.measurement.zzbk$zza) r1
            if (r28 == 0) goto L_0x0775
            if (r27 == 0) goto L_0x0775
            boolean r21 = r1.zzki()
            if (r21 == 0) goto L_0x0775
            r21 = r2
            long r2 = r7.zzfi
            r22 = r2
            goto L_0x0779
        L_0x0775:
            r21 = r2
            r22 = r17
        L_0x0779:
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            r3 = 2
            boolean r2 = r2.isLoggable(r3)
            if (r2 == 0) goto L_0x07d5
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            boolean r24 = r1.zzkb()
            if (r24 == 0) goto L_0x07a7
            int r24 = r1.getId()
            java.lang.Integer r24 = java.lang.Integer.valueOf(r24)
            r37 = r5
            r70 = r24
            r24 = r4
            r4 = r70
            goto L_0x07ac
        L_0x07a7:
            r24 = r4
            r37 = r5
            r4 = 0
        L_0x07ac:
            com.google.android.gms.measurement.internal.zzed r5 = r71.zzy()
            r43 = r6
            java.lang.String r6 = r1.zzjz()
            java.lang.String r5 = r5.zzaj(r6)
            java.lang.String r6 = "Evaluating filter. audience, filter, event"
            r2.zza(r6, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            com.google.android.gms.measurement.internal.zzjo r3 = r71.zzgw()
            java.lang.String r3 = r3.zza(r1)
            r5 = r48
            r2.zza(r5, r3)
            goto L_0x07dd
        L_0x07d5:
            r24 = r4
            r37 = r5
            r43 = r6
            r5 = r48
        L_0x07dd:
            boolean r2 = r1.zzkb()
            if (r2 == 0) goto L_0x094d
            int r2 = r1.getId()
            r6 = 256(0x100, float:3.59E-43)
            if (r2 <= r6) goto L_0x07ed
            goto L_0x094d
        L_0x07ed:
            java.lang.String r4 = "Event filter result"
            if (r25 == 0) goto L_0x08c8
            boolean r2 = r1.zzkf()
            boolean r38 = r1.zzkg()
            if (r27 == 0) goto L_0x0803
            boolean r3 = r1.zzki()
            if (r3 == 0) goto L_0x0803
            r3 = 1
            goto L_0x0804
        L_0x0803:
            r3 = 0
        L_0x0804:
            if (r2 != 0) goto L_0x080e
            if (r38 != 0) goto L_0x080e
            if (r3 == 0) goto L_0x080b
            goto L_0x080e
        L_0x080b:
            r44 = 0
            goto L_0x0810
        L_0x080e:
            r44 = 1
        L_0x0810:
            int r2 = r1.getId()
            boolean r2 = r10.get(r2)
            if (r2 == 0) goto L_0x084b
            if (r44 != 0) goto L_0x084b
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            boolean r4 = r1.zzkb()
            if (r4 == 0) goto L_0x0837
            int r1 = r1.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0838
        L_0x0837:
            r1 = 0
        L_0x0838:
            java.lang.String r4 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r2.zza(r4, r3, r1)
            r3 = r72
            r48 = r5
            r2 = r21
            r4 = r24
            r5 = r37
            r6 = r43
            goto L_0x0758
        L_0x084b:
            r3 = r19
            r19 = r1
            r1 = r71
            r45 = r7
            r7 = r21
            r2 = r19
            r46 = r9
            r21 = r11
            r11 = r72
            r9 = r3
            r3 = r0
            r67 = r24
            r24 = r8
            r8 = r4
            r4 = r42
            r69 = r5
            r47 = r15
            r15 = r37
            r68 = r43
            r5 = r22
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            if (r1 != 0) goto L_0x0881
            r3 = r30
            goto L_0x0882
        L_0x0881:
            r3 = r1
        L_0x0882:
            r2.zza(r8, r3)
            if (r1 != 0) goto L_0x0890
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14.add(r1)
            goto L_0x098c
        L_0x0890:
            int r2 = r19.getId()
            r7.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x098c
            int r1 = r19.getId()
            r10.set(r1)
            if (r44 == 0) goto L_0x098c
            boolean r1 = r34.zzml()
            if (r1 == 0) goto L_0x098c
            if (r38 == 0) goto L_0x08bb
            int r1 = r19.getId()
            long r2 = r34.getTimestampMillis()
            zzb(r12, r1, r2)
            goto L_0x098c
        L_0x08bb:
            int r1 = r19.getId()
            long r2 = r34.getTimestampMillis()
            zza(r9, r1, r2)
            goto L_0x098c
        L_0x08c8:
            r69 = r5
            r45 = r7
            r46 = r9
            r47 = r15
            r9 = r19
            r7 = r21
            r67 = r24
            r15 = r37
            r68 = r43
            r19 = r1
            r24 = r8
            r21 = r11
            r11 = r72
            r8 = r4
            int r1 = r19.getId()
            boolean r1 = r10.get(r1)
            if (r1 == 0) goto L_0x0910
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            boolean r3 = r19.zzkb()
            if (r3 == 0) goto L_0x0908
            int r3 = r19.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L_0x0909
        L_0x0908:
            r8 = 0
        L_0x0909:
            java.lang.String r3 = "Event filter already evaluated true. audience ID, filter ID"
            r1.zza(r3, r2, r8)
            goto L_0x098c
        L_0x0910:
            r1 = r71
            r2 = r19
            r3 = r0
            r4 = r42
            r5 = r22
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzef r2 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            if (r1 != 0) goto L_0x092a
            r3 = r30
            goto L_0x092b
        L_0x092a:
            r3 = r1
        L_0x092b:
            r2.zza(r8, r3)
            if (r1 != 0) goto L_0x0938
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14.add(r1)
            goto L_0x098c
        L_0x0938:
            int r2 = r19.getId()
            r7.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x098c
            int r1 = r19.getId()
            r10.set(r1)
            goto L_0x098c
        L_0x094d:
            r69 = r5
            r45 = r7
            r46 = r9
            r47 = r15
            r9 = r19
            r7 = r21
            r67 = r24
            r15 = r37
            r68 = r43
            r19 = r1
            r24 = r8
            r21 = r11
            r11 = r72
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r72)
            boolean r3 = r19.zzkb()
            if (r3 == 0) goto L_0x0982
            int r3 = r19.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L_0x0983
        L_0x0982:
            r8 = 0
        L_0x0983:
            java.lang.String r3 = java.lang.String.valueOf(r8)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zza(r4, r2, r3)
        L_0x098c:
            r2 = r7
            r19 = r9
            r3 = r11
            r5 = r15
            r11 = r21
            r8 = r24
            r7 = r45
            r9 = r46
            r15 = r47
            r4 = r67
            r6 = r68
            r48 = r69
            goto L_0x0758
        L_0x09a3:
            r43 = r6
            r44 = r8
            r46 = r9
            r49 = r14
            r47 = r15
            r12 = r16
            r8 = r17
            r10 = r41
            goto L_0x0669
        L_0x09b5:
            r7 = r71
            r9 = r3
            r8 = r5
            r6 = r10
            r2 = r35
            r0 = r39
            r1 = r40
            r17 = r43
            r21 = r44
            r13 = r46
            r23 = r47
            r14 = r48
            r15 = r49
            r10 = r4
            goto L_0x036e
        L_0x09cf:
            r11 = r9
            r67 = r10
            r46 = r13
            r69 = r14
            r14 = r15
            r68 = r17
            r24 = r21
            r47 = r23
            r15 = r8
            boolean r0 = r74.isEmpty()
            if (r0 != 0) goto L_0x0d45
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r1 = r74.iterator()
        L_0x09ed:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0d45
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbs$zzk r2 = (com.google.android.gms.internal.measurement.zzbs$zzk) r2
            java.lang.String r3 = r2.getName()
            java.lang.Object r3 = r0.get(r3)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L_0x0a1f
            com.google.android.gms.measurement.internal.zzx r3 = r71.zzgy()
            java.lang.String r4 = r2.getName()
            java.util.Map r3 = r3.zzi(r11, r4)
            if (r3 != 0) goto L_0x0a18
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
        L_0x0a18:
            java.lang.String r4 = r2.getName()
            r0.put(r4, r3)
        L_0x0a1f:
            java.util.Set r4 = r3.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0a27:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0d3f
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            boolean r6 = r14.contains(r6)
            if (r6 == 0) goto L_0x0a51
            com.google.android.gms.measurement.internal.zzef r6 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgs()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.zza(r15, r5)
            goto L_0x0a27
        L_0x0a51:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r7 = r47
            java.lang.Object r6 = r7.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r9 = r68
            java.lang.Object r8 = r9.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            if (r25 == 0) goto L_0x0a88
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            r12 = r24
            java.lang.Object r10 = r12.get(r10)
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            r73 = r1
            r1 = r67
            java.lang.Object r13 = r1.get(r13)
            java.util.Map r13 = (java.util.Map) r13
            r16 = r0
            goto L_0x0a92
        L_0x0a88:
            r73 = r1
            r12 = r24
            r1 = r67
            r16 = r0
            r10 = 0
            r13 = 0
        L_0x0a92:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r74 = r4
            r4 = r46
            java.lang.Object r0 = r4.get(r0)
            com.google.android.gms.internal.measurement.zzbs$zza r0 = (com.google.android.gms.internal.measurement.zzbs$zza) r0
            if (r0 != 0) goto L_0x0aea
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzbs$zza$zza r6 = com.google.android.gms.internal.measurement.zzbs$zza.zzmc()
            r8 = 1
            com.google.android.gms.internal.measurement.zzbs$zza$zza r6 = r6.zzk(r8)
            com.google.android.gms.internal.measurement.zzgi r6 = r6.zzug()
            com.google.android.gms.internal.measurement.zzbs$zza r6 = (com.google.android.gms.internal.measurement.zzbs$zza) r6
            r4.put(r0, r6)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r7.put(r0, r6)
            java.util.BitSet r8 = new java.util.BitSet
            r8.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r9.put(r0, r8)
            if (r25 == 0) goto L_0x0aea
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r12.put(r0, r10)
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r1.put(r0, r13)
        L_0x0aea:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r3.get(r0)
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0af8:
            boolean r17 = r0.hasNext()
            if (r17 == 0) goto L_0x0d25
            java.lang.Object r17 = r0.next()
            r18 = r0
            r0 = r17
            com.google.android.gms.internal.measurement.zzbk$zzd r0 = (com.google.android.gms.internal.measurement.zzbk$zzd) r0
            r17 = r3
            com.google.android.gms.measurement.internal.zzef r3 = r71.zzab()
            r37 = r15
            r15 = 2
            boolean r3 = r3.isLoggable(r15)
            if (r3 == 0) goto L_0x0b62
            com.google.android.gms.measurement.internal.zzef r3 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgs()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r5)
            boolean r19 = r0.zzkb()
            if (r19 == 0) goto L_0x0b36
            int r19 = r0.getId()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r67 = r1
            r11 = r19
            goto L_0x0b39
        L_0x0b36:
            r67 = r1
            r11 = 0
        L_0x0b39:
            com.google.android.gms.measurement.internal.zzed r1 = r71.zzy()
            r44 = r12
            java.lang.String r12 = r0.getPropertyName()
            java.lang.String r1 = r1.zzal(r12)
            java.lang.String r12 = "Evaluating filter. audience, filter, property"
            r3.zza(r12, r15, r11, r1)
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            com.google.android.gms.measurement.internal.zzjo r3 = r71.zzgw()
            java.lang.String r3 = r3.zza(r0)
            r11 = r69
            r1.zza(r11, r3)
            goto L_0x0b68
        L_0x0b62:
            r67 = r1
            r44 = r12
            r11 = r69
        L_0x0b68:
            boolean r1 = r0.zzkb()
            if (r1 == 0) goto L_0x0cde
            int r1 = r0.getId()
            r3 = 256(0x100, float:3.59E-43)
            if (r1 <= r3) goto L_0x0b78
            goto L_0x0cde
        L_0x0b78:
            java.lang.String r1 = "Property filter result"
            if (r25 == 0) goto L_0x0c67
            boolean r12 = r0.zzkf()
            boolean r15 = r0.zzkg()
            if (r27 == 0) goto L_0x0b8f
            boolean r19 = r0.zzki()
            if (r19 == 0) goto L_0x0b8f
            r19 = 1
            goto L_0x0b91
        L_0x0b8f:
            r19 = 0
        L_0x0b91:
            if (r12 != 0) goto L_0x0b9a
            if (r15 != 0) goto L_0x0b9a
            if (r19 == 0) goto L_0x0b98
            goto L_0x0b9a
        L_0x0b98:
            r12 = 0
            goto L_0x0b9b
        L_0x0b9a:
            r12 = 1
        L_0x0b9b:
            int r3 = r0.getId()
            boolean r3 = r6.get(r3)
            if (r3 == 0) goto L_0x0bd8
            if (r12 != 0) goto L_0x0bd8
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            boolean r12 = r0.zzkb()
            if (r12 == 0) goto L_0x0bc2
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0bc3
        L_0x0bc2:
            r0 = 0
        L_0x0bc3:
            java.lang.String r12 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zza(r12, r3, r0)
            r69 = r11
            r3 = r17
            r0 = r18
            r15 = r37
            r12 = r44
            r1 = r67
            r11 = r72
            goto L_0x0af8
        L_0x0bd8:
            r3 = r71
            java.lang.Boolean r20 = r3.zza(r0, r2)
            com.google.android.gms.measurement.internal.zzef r21 = r71.zzab()
            r48 = r11
            com.google.android.gms.measurement.internal.zzeh r11 = r21.zzgs()
            r43 = r9
            if (r20 != 0) goto L_0x0bef
            r9 = r30
            goto L_0x0bf1
        L_0x0bef:
            r9 = r20
        L_0x0bf1:
            r11.zza(r1, r9)
            if (r20 != 0) goto L_0x0bff
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r14.add(r0)
            goto L_0x0c98
        L_0x0bff:
            int r1 = r0.getId()
            r8.set(r1)
            if (r27 == 0) goto L_0x0c10
            if (r19 == 0) goto L_0x0c10
            boolean r1 = r20.booleanValue()
            if (r1 == 0) goto L_0x0c98
        L_0x0c10:
            if (r26 == 0) goto L_0x0c2e
            int r1 = r0.getId()
            boolean r1 = r6.get(r1)
            if (r1 == 0) goto L_0x0c22
            boolean r1 = r0.zzkf()
            if (r1 == 0) goto L_0x0c39
        L_0x0c22:
            int r1 = r0.getId()
            boolean r9 = r20.booleanValue()
            r6.set(r1, r9)
            goto L_0x0c39
        L_0x0c2e:
            int r1 = r0.getId()
            boolean r9 = r20.booleanValue()
            r6.set(r1, r9)
        L_0x0c39:
            boolean r1 = r20.booleanValue()
            if (r1 == 0) goto L_0x0c98
            if (r12 == 0) goto L_0x0c98
            boolean r1 = r2.zzqs()
            if (r1 == 0) goto L_0x0c98
            long r11 = r2.zzqt()
            if (r27 == 0) goto L_0x0c55
            if (r19 == 0) goto L_0x0c55
            if (r29 == 0) goto L_0x0c55
            long r11 = r29.longValue()
        L_0x0c55:
            if (r15 == 0) goto L_0x0c5f
            int r0 = r0.getId()
            zzb(r13, r0, r11)
            goto L_0x0c98
        L_0x0c5f:
            int r0 = r0.getId()
            zza(r10, r0, r11)
            goto L_0x0c98
        L_0x0c67:
            r3 = r71
            r43 = r9
            r48 = r11
            int r9 = r0.getId()
            boolean r9 = r6.get(r9)
            if (r9 == 0) goto L_0x0caa
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            boolean r11 = r0.zzkb()
            if (r11 == 0) goto L_0x0c92
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0c93
        L_0x0c92:
            r0 = 0
        L_0x0c93:
            java.lang.String r11 = "Property filter already evaluated true. audience ID, filter ID"
            r1.zza(r11, r9, r0)
        L_0x0c98:
            r11 = r72
            r3 = r17
            r0 = r18
            r15 = r37
            r9 = r43
            r12 = r44
            r69 = r48
            r1 = r67
            goto L_0x0af8
        L_0x0caa:
            java.lang.Boolean r9 = r3.zza(r0, r2)
            com.google.android.gms.measurement.internal.zzef r11 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgs()
            if (r9 != 0) goto L_0x0cbb
            r12 = r30
            goto L_0x0cbc
        L_0x0cbb:
            r12 = r9
        L_0x0cbc:
            r11.zza(r1, r12)
            if (r9 != 0) goto L_0x0cc9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r14.add(r0)
            goto L_0x0c98
        L_0x0cc9:
            int r1 = r0.getId()
            r8.set(r1)
            boolean r1 = r9.booleanValue()
            if (r1 == 0) goto L_0x0c98
            int r0 = r0.getId()
            r6.set(r0)
            goto L_0x0c98
        L_0x0cde:
            r3 = r71
            r43 = r9
            r48 = r11
            com.google.android.gms.measurement.internal.zzef r1 = r71.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r72)
            boolean r8 = r0.zzkb()
            if (r8 == 0) goto L_0x0cff
            int r0 = r0.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            goto L_0x0d00
        L_0x0cff:
            r8 = 0
        L_0x0d00:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r1.zza(r8, r6, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r14.add(r0)
            r11 = r72
            r1 = r73
            r46 = r4
            r47 = r7
            r0 = r16
            r3 = r17
            r15 = r37
            r68 = r43
            r24 = r44
            r69 = r48
            goto L_0x0d3b
        L_0x0d25:
            r17 = r3
            r3 = r71
            r11 = r72
            r67 = r1
            r46 = r4
            r47 = r7
            r68 = r9
            r24 = r12
            r0 = r16
            r3 = r17
            r1 = r73
        L_0x0d3b:
            r4 = r74
            goto L_0x0a27
        L_0x0d3f:
            r3 = r71
            r11 = r72
            goto L_0x09ed
        L_0x0d45:
            r3 = r71
            r44 = r24
            r4 = r46
            r7 = r47
            r43 = r68
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r2 = r0.iterator()
        L_0x0d5c:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0ff6
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            boolean r5 = r14.contains(r5)
            if (r5 != 0) goto L_0x0fec
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r5 = r4.get(r5)
            com.google.android.gms.internal.measurement.zzbs$zza r5 = (com.google.android.gms.internal.measurement.zzbs$zza) r5
            if (r5 != 0) goto L_0x0d87
            com.google.android.gms.internal.measurement.zzbs$zza$zza r5 = com.google.android.gms.internal.measurement.zzbs$zza.zzmc()
            goto L_0x0d8d
        L_0x0d87:
            com.google.android.gms.internal.measurement.zzey$zza r5 = r5.zzuj()
            com.google.android.gms.internal.measurement.zzbs$zza$zza r5 = (com.google.android.gms.internal.measurement.zzbs$zza.zza) r5
        L_0x0d8d:
            r5.zzi(r0)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r6 = com.google.android.gms.internal.measurement.zzbs$zzi.zzqh()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            java.lang.Object r8 = r7.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            java.util.List r8 = com.google.android.gms.measurement.internal.zzjo.zza(r8)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r6 = r6.zzo(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r9 = r43
            java.lang.Object r8 = r9.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            java.util.List r8 = com.google.android.gms.measurement.internal.zzjo.zza(r8)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r6 = r6.zzn(r8)
            if (r25 == 0) goto L_0x0f54
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r10 = r44
            java.lang.Object r8 = r10.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            java.util.List r8 = zza(r8)
            r6.zzp(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r11 = r67
            java.lang.Object r8 = r11.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            if (r8 != 0) goto L_0x0de8
            java.util.List r8 = java.util.Collections.emptyList()
            r73 = r2
            r47 = r7
            r12 = r8
            goto L_0x0e58
        L_0x0de8:
            java.util.ArrayList r12 = new java.util.ArrayList
            int r13 = r8.size()
            r12.<init>(r13)
            java.util.Set r13 = r8.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0df9:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x0e54
            java.lang.Object r15 = r13.next()
            java.lang.Integer r15 = (java.lang.Integer) r15
            r73 = r2
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r2 = com.google.android.gms.internal.measurement.zzbs$zzj.zzqo()
            int r3 = r15.intValue()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r2 = r2.zzal(r3)
            java.lang.Object r3 = r8.get(r15)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0e3e
            java.util.Collections.sort(r3)
            java.util.Iterator r3 = r3.iterator()
        L_0x0e22:
            boolean r15 = r3.hasNext()
            if (r15 == 0) goto L_0x0e3e
            java.lang.Object r15 = r3.next()
            java.lang.Long r15 = (java.lang.Long) r15
            r47 = r7
            r74 = r8
            long r7 = r15.longValue()
            r2.zzbj(r7)
            r8 = r74
            r7 = r47
            goto L_0x0e22
        L_0x0e3e:
            r47 = r7
            r74 = r8
            com.google.android.gms.internal.measurement.zzgi r2 = r2.zzug()
            com.google.android.gms.internal.measurement.zzbs$zzj r2 = (com.google.android.gms.internal.measurement.zzbs$zzj) r2
            r12.add(r2)
            r3 = r71
            r2 = r73
            r8 = r74
            r7 = r47
            goto L_0x0df9
        L_0x0e54:
            r73 = r2
            r47 = r7
        L_0x0e58:
            if (r26 == 0) goto L_0x0e6e
            boolean r2 = r5.zzlw()
            if (r2 == 0) goto L_0x0e6e
            com.google.android.gms.internal.measurement.zzbs$zzi r2 = r5.zzlx()
            java.util.List r2 = r2.zzqe()
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0e71
        L_0x0e6e:
            r15 = 0
            goto L_0x0f50
        L_0x0e71:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r12)
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0e7f:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0eb3
            java.lang.Object r8 = r2.next()
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs$zzj) r8
            boolean r12 = r8.zzme()
            if (r12 == 0) goto L_0x0eb1
            int r12 = r8.zzql()
            if (r12 <= 0) goto L_0x0eb1
            int r12 = r8.getIndex()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            int r13 = r8.zzql()
            r15 = 1
            int r13 = r13 - r15
            long r16 = r8.zzai(r13)
            java.lang.Long r8 = java.lang.Long.valueOf(r16)
            r7.put(r12, r8)
            goto L_0x0e7f
        L_0x0eb1:
            r15 = 1
            goto L_0x0e7f
        L_0x0eb3:
            r15 = 1
            r2 = 0
        L_0x0eb5:
            int r8 = r3.size()
            if (r2 >= r8) goto L_0x0f12
            java.lang.Object r8 = r3.get(r2)
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs$zzj) r8
            boolean r12 = r8.zzme()
            if (r12 == 0) goto L_0x0ed0
            int r12 = r8.getIndex()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0ed1
        L_0x0ed0:
            r12 = 0
        L_0x0ed1:
            java.lang.Object r12 = r7.remove(r12)
            java.lang.Long r12 = (java.lang.Long) r12
            if (r12 == 0) goto L_0x0f0d
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            long r16 = r12.longValue()
            r15 = 0
            long r18 = r8.zzai(r15)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L_0x0eee
            r13.add(r12)
        L_0x0eee:
            java.util.List r12 = r8.zzqk()
            r13.addAll(r12)
            com.google.android.gms.internal.measurement.zzey$zza r8 = r8.zzuj()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = (com.google.android.gms.internal.measurement.zzbs$zzj.zza) r8
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = r8.zzqw()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = r8.zzr(r13)
            com.google.android.gms.internal.measurement.zzgi r8 = r8.zzug()
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs$zzj) r8
            r3.set(r2, r8)
            goto L_0x0f0e
        L_0x0f0d:
            r15 = 0
        L_0x0f0e:
            int r2 = r2 + 1
            r15 = 1
            goto L_0x0eb5
        L_0x0f12:
            r15 = 0
            java.util.Set r2 = r7.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0f1b:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0f4f
            java.lang.Object r8 = r2.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r12 = com.google.android.gms.internal.measurement.zzbs$zzj.zzqo()
            int r13 = r8.intValue()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r12 = r12.zzal(r13)
            java.lang.Object r8 = r7.get(r8)
            java.lang.Long r8 = (java.lang.Long) r8
            r74 = r7
            long r7 = r8.longValue()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r7 = r12.zzbj(r7)
            com.google.android.gms.internal.measurement.zzgi r7 = r7.zzug()
            com.google.android.gms.internal.measurement.zzbs$zzj r7 = (com.google.android.gms.internal.measurement.zzbs$zzj) r7
            r3.add(r7)
            r7 = r74
            goto L_0x0f1b
        L_0x0f4f:
            r12 = r3
        L_0x0f50:
            r6.zzq(r12)
            goto L_0x0f5d
        L_0x0f54:
            r73 = r2
            r47 = r7
            r10 = r44
            r11 = r67
            r15 = 0
        L_0x0f5d:
            r5.zza(r6)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            com.google.android.gms.internal.measurement.zzgi r3 = r5.zzug()
            com.google.android.gms.internal.measurement.zzbs$zza r3 = (com.google.android.gms.internal.measurement.zzbs$zza) r3
            r4.put(r2, r3)
            com.google.android.gms.internal.measurement.zzgi r2 = r5.zzug()
            com.google.android.gms.internal.measurement.zzbs$zza r2 = (com.google.android.gms.internal.measurement.zzbs$zza) r2
            r1.add(r2)
            com.google.android.gms.measurement.internal.zzx r2 = r71.zzgy()
            com.google.android.gms.internal.measurement.zzbs$zzi r3 = r5.zzlv()
            r2.zzbi()
            r2.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.toByteArray()
            android.content.ContentValues r5 = new android.content.ContentValues
            r5.<init>()
            java.lang.String r6 = "app_id"
            r7 = r72
            r5.put(r6, r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r6 = "audience_id"
            r5.put(r6, r0)
            java.lang.String r0 = "current_results"
            r5.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0fce }
            java.lang.String r3 = "audience_filter_values"
            r6 = 5
            r8 = 0
            long r5 = r0.insertWithOnConflict(r3, r8, r5, r6)     // Catch:{ SQLiteException -> 0x0fcc }
            r12 = -1
            int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0fe1
            com.google.android.gms.measurement.internal.zzef r0 = r2.zzab()     // Catch:{ SQLiteException -> 0x0fcc }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ SQLiteException -> 0x0fcc }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r72)     // Catch:{ SQLiteException -> 0x0fcc }
            r0.zza(r3, r5)     // Catch:{ SQLiteException -> 0x0fcc }
            goto L_0x0fe1
        L_0x0fcc:
            r0 = move-exception
            goto L_0x0fd0
        L_0x0fce:
            r0 = move-exception
            r8 = 0
        L_0x0fd0:
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r72)
            java.lang.String r5 = "Error storing filter results. appId"
            r2.zza(r5, r3, r0)
        L_0x0fe1:
            r3 = r71
            r2 = r73
            r43 = r9
            r44 = r10
            r67 = r11
            goto L_0x0ff2
        L_0x0fec:
            r47 = r7
            r7 = r72
            r3 = r71
        L_0x0ff2:
            r7 = r47
            goto L_0x0d5c
        L_0x0ff6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(java.lang.String, java.util.List, java.util.List):java.util.List");
    }

    private final Boolean zza(zzbk$zza zzbk_zza, String str, List<zzbs$zze> list, long j) {
        Boolean bool;
        boolean zzkd = zzbk_zza.zzkd();
        Boolean valueOf = Boolean.valueOf(false);
        if (zzkd) {
            Boolean zza = zza(j, zzbk_zza.zzke());
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return valueOf;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzbk$zzb zzbk_zzb : zzbk_zza.zzkc()) {
            if (zzbk_zzb.zzkr().isEmpty()) {
                zzab().zzgn().zza("null or empty param name in filter. event", zzy().zzaj(str));
                return null;
            }
            hashSet.add(zzbk_zzb.zzkr());
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzbs$zze zzbs_zze : list) {
            if (hashSet.contains(zzbs_zze.getName())) {
                if (zzbs_zze.zzna()) {
                    arrayMap.put(zzbs_zze.getName(), zzbs_zze.zzna() ? Long.valueOf(zzbs_zze.zznb()) : null);
                } else if (zzbs_zze.zznd()) {
                    arrayMap.put(zzbs_zze.getName(), zzbs_zze.zznd() ? Double.valueOf(zzbs_zze.zzne()) : null);
                } else if (zzbs_zze.zzmx()) {
                    arrayMap.put(zzbs_zze.getName(), zzbs_zze.zzmy());
                } else {
                    zzab().zzgn().zza("Unknown value for param. event, param", zzy().zzaj(str), zzy().zzak(zzbs_zze.getName()));
                    return null;
                }
            }
        }
        Iterator it = zzbk_zza.zzkc().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return Boolean.valueOf(true);
            }
            zzbk$zzb zzbk_zzb2 = (zzbk$zzb) it.next();
            if (!zzbk_zzb2.zzkp() || !zzbk_zzb2.zzkq()) {
                z = false;
            }
            String zzkr = zzbk_zzb2.zzkr();
            if (zzkr.isEmpty()) {
                zzab().zzgn().zza("Event has empty param name. event", zzy().zzaj(str));
                return null;
            }
            Object obj = arrayMap.get(zzkr);
            if (obj instanceof Long) {
                if (!zzbk_zzb2.zzkn()) {
                    zzab().zzgn().zza("No number filter for long param. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                    return null;
                }
                Boolean zza2 = zza(((Long) obj).longValue(), zzbk_zzb2.zzko());
                if (zza2 == null) {
                    return null;
                }
                if (zza2.booleanValue() == z) {
                    return valueOf;
                }
            } else if (obj instanceof Double) {
                if (!zzbk_zzb2.zzkn()) {
                    zzab().zzgn().zza("No number filter for double param. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                    return null;
                }
                Boolean zza3 = zza(((Double) obj).doubleValue(), zzbk_zzb2.zzko());
                if (zza3 == null) {
                    return null;
                }
                if (zza3.booleanValue() == z) {
                    return valueOf;
                }
            } else if (obj instanceof String) {
                if (zzbk_zzb2.zzkl()) {
                    bool = zza((String) obj, zzbk_zzb2.zzkm());
                } else if (zzbk_zzb2.zzkn()) {
                    String str2 = (String) obj;
                    if (zzjo.zzbj(str2)) {
                        bool = zza(str2, zzbk_zzb2.zzko());
                    } else {
                        zzab().zzgn().zza("Invalid param value for number filter. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                        return null;
                    }
                } else {
                    zzab().zzgn().zza("No filter for String param. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if (bool.booleanValue() == z) {
                    return valueOf;
                }
            } else if (obj == null) {
                zzab().zzgs().zza("Missing param for filter. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                return valueOf;
            } else {
                zzab().zzgn().zza("Unknown param type. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                return null;
            }
        }
    }

    private final Boolean zza(zzbk$zzd zzbk_zzd, zzbs$zzk zzbs_zzk) {
        zzbk$zzb zzli = zzbk_zzd.zzli();
        boolean zzkq = zzli.zzkq();
        if (zzbs_zzk.zzna()) {
            if (zzli.zzkn()) {
                return zza(zza(zzbs_zzk.zznb(), zzli.zzko()), zzkq);
            }
            zzab().zzgn().zza("No number filter for long property. property", zzy().zzal(zzbs_zzk.getName()));
            return null;
        } else if (zzbs_zzk.zznd()) {
            if (zzli.zzkn()) {
                return zza(zza(zzbs_zzk.zzne(), zzli.zzko()), zzkq);
            }
            zzab().zzgn().zza("No number filter for double property. property", zzy().zzal(zzbs_zzk.getName()));
            return null;
        } else if (!zzbs_zzk.zzmx()) {
            zzab().zzgn().zza("User property has no value, property", zzy().zzal(zzbs_zzk.getName()));
            return null;
        } else if (zzli.zzkl()) {
            return zza(zza(zzbs_zzk.zzmy(), zzli.zzkm()), zzkq);
        } else {
            if (!zzli.zzkn()) {
                zzab().zzgn().zza("No string or number filter defined. property", zzy().zzal(zzbs_zzk.getName()));
            } else if (zzjo.zzbj(zzbs_zzk.zzmy())) {
                return zza(zza(zzbs_zzk.zzmy(), zzli.zzko()), zzkq);
            } else {
                zzab().zzgn().zza("Invalid user property value for Numeric number filter. property, value", zzy().zzal(zzbs_zzk.getName()), zzbs_zzk.zzmy());
            }
            return null;
        }
    }

    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    private final Boolean zza(String str, zzbk$zze zzbk_zze) {
        String str2;
        List list;
        Preconditions.checkNotNull(zzbk_zze);
        if (str == null || !zzbk_zze.zzlk() || zzbk_zze.zzll() == zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzbk_zze.zzll() == zza.IN_LIST) {
            if (zzbk_zze.zzlr() == 0) {
                return null;
            }
        } else if (!zzbk_zze.zzlm()) {
            return null;
        }
        zza zzll = zzbk_zze.zzll();
        boolean zzlp = zzbk_zze.zzlp();
        if (zzlp || zzll == zza.REGEXP || zzll == zza.IN_LIST) {
            str2 = zzbk_zze.zzln();
        } else {
            str2 = zzbk_zze.zzln().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzbk_zze.zzlr() == 0) {
            list = null;
        } else {
            List<String> zzlq = zzbk_zze.zzlq();
            if (!zzlp) {
                ArrayList arrayList = new ArrayList(zzlq.size());
                for (String upperCase : zzlq) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzlq = Collections.unmodifiableList(arrayList);
            }
            list = zzlq;
        }
        return zza(str, zzll, zzlp, str3, list, zzll == zza.REGEXP ? str3 : null);
    }

    private final Boolean zza(String str, zza zza, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (zza == zza.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zza != zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzo.zzdu[zza.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzab().zzgn().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzbk$zzc zzbk_zzc) {
        try {
            return zza(new BigDecimal(j), zzbk_zzc, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(double d, zzbk$zzc zzbk_zzc) {
        try {
            return zza(new BigDecimal(d), zzbk_zzc, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzbk$zzc zzbk_zzc) {
        if (!zzjo.zzbj(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzbk_zzc, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        if (r2 != null) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.zzbk$zzc r10, double r11) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            boolean r0 = r10.zzku()
            r1 = 0
            if (r0 == 0) goto L_0x0110
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r0 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r2 = com.google.android.gms.internal.measurement.zzbk$zzc.zzb.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0110
        L_0x0014:
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r0 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r2 = com.google.android.gms.internal.measurement.zzbk$zzc.zzb.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r10.zzla()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r10.zzlc()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r10.zzky()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r0 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r2 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r3 = com.google.android.gms.internal.measurement.zzbk$zzc.zzb.BETWEEN
            if (r2 != r3) goto L_0x0067
            java.lang.String r2 = r10.zzlb()
            boolean r2 = com.google.android.gms.measurement.internal.zzjo.zzbj(r2)
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r10.zzld()
            boolean r2 = com.google.android.gms.measurement.internal.zzjo.zzbj(r2)
            if (r2 != 0) goto L_0x0051
            goto L_0x0066
        L_0x0051:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r3 = r10.zzlb()     // Catch:{ NumberFormatException -> 0x0066 }
            r2.<init>(r3)     // Catch:{ NumberFormatException -> 0x0066 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r10 = r10.zzld()     // Catch:{ NumberFormatException -> 0x0066 }
            r3.<init>(r10)     // Catch:{ NumberFormatException -> 0x0066 }
            r10 = r2
            r2 = r1
            goto L_0x007d
        L_0x0066:
            return r1
        L_0x0067:
            java.lang.String r2 = r10.zzkz()
            boolean r2 = com.google.android.gms.measurement.internal.zzjo.zzbj(r2)
            if (r2 != 0) goto L_0x0072
            return r1
        L_0x0072:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r10 = r10.zzkz()     // Catch:{ NumberFormatException -> 0x0110 }
            r2.<init>(r10)     // Catch:{ NumberFormatException -> 0x0110 }
            r10 = r1
            r3 = r10
        L_0x007d:
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r4 = com.google.android.gms.internal.measurement.zzbk$zzc.zzb.BETWEEN
            if (r0 != r4) goto L_0x0085
            if (r10 == 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            return r1
        L_0x0085:
            if (r2 == 0) goto L_0x0110
        L_0x0087:
            int[] r4 = com.google.android.gms.measurement.internal.zzo.zzdv
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = -1
            r5 = 0
            r6 = 1
            if (r0 == r6) goto L_0x0104
            r7 = 2
            if (r0 == r7) goto L_0x00f8
            r8 = 3
            if (r0 == r8) goto L_0x00b0
            r11 = 4
            if (r0 == r11) goto L_0x009e
            goto L_0x0110
        L_0x009e:
            int r10 = r9.compareTo(r10)
            if (r10 == r4) goto L_0x00ab
            int r9 = r9.compareTo(r3)
            if (r9 == r6) goto L_0x00ab
            r5 = 1
        L_0x00ab:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00b0:
            r0 = 0
            int r10 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r10 == 0) goto L_0x00ec
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r0)
            java.math.BigDecimal r10 = r2.subtract(r10)
            int r10 = r9.compareTo(r10)
            if (r10 != r6) goto L_0x00e7
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r11)
            java.math.BigDecimal r10 = r2.add(r10)
            int r9 = r9.compareTo(r10)
            if (r9 != r4) goto L_0x00e7
            r5 = 1
        L_0x00e7:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00ec:
            int r9 = r9.compareTo(r2)
            if (r9 != 0) goto L_0x00f3
            r5 = 1
        L_0x00f3:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00f8:
            int r9 = r9.compareTo(r2)
            if (r9 != r6) goto L_0x00ff
            r5 = 1
        L_0x00ff:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x0104:
            int r9 = r9.compareTo(r2)
            if (r9 != r4) goto L_0x010b
            r5 = 1
        L_0x010b:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x0110:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbk$zzc, double):java.lang.Boolean");
    }

    private static List<zzbs$zzb> zza(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            arrayList.add((zzbs$zzb) zzbs$zzb.zzmh().zzk(intValue2).zzae(((Long) map.get(Integer.valueOf(intValue2))).longValue()).zzug());
        }
        return arrayList;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = (Long) map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List list = (List) map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
