package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import bolts.MeasurementEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbk$zza;
import com.google.android.gms.internal.measurement.zzbk$zzd;
import com.google.android.gms.internal.measurement.zzbs$zzc;
import com.google.android.gms.internal.measurement.zzbs$zze;
import com.google.android.gms.internal.measurement.zzbs$zzg;
import com.google.android.gms.internal.measurement.zzbs$zzg.zza;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzey;
import com.gun0912.tedpermission.TedPermissionBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzx extends zzjh {
    /* access modifiers changed from: private */
    public static final String[] zzek = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzel = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzem = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzen = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzeo = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzep;
    /* access modifiers changed from: private */
    public static final String[] zzeq;
    /* access modifiers changed from: private */
    public static final String[] zzer = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzy zzes = new zzy(this, getContext(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzjd zzet = new zzjd(zzx());

    zzx(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    @WorkerThread
    public final void beginTransaction() {
        zzbi();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzbi();
        getWritableDatabase().setTransactionSuccessful();
    }

    @WorkerThread
    public final void endTransaction() {
        zzbi();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() {
        zzo();
        try {
            return this.zzes.getWritableDatabase();
        } catch (SQLiteException e) {
            zzab().zzgn().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzae zzc(java.lang.String r27, java.lang.String r28) {
        /*
            r26 = this;
            r15 = r27
            r14 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            r26.zzo()
            r26.zzbi()
            com.google.android.gms.measurement.internal.zzs r0 = r26.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziz
            boolean r0 = r0.zze(r15, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            if (r0 == 0) goto L_0x003e
            java.lang.String r2 = "current_session_count"
            r1.add(r2)
        L_0x003e:
            r18 = 0
            android.database.sqlite.SQLiteDatabase r2 = r26.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            java.lang.String r3 = "events"
            r10 = 0
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            r4 = r1
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            java.lang.String r5 = "app_id=? and name=?"
            r1 = 2
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            r6[r10] = r15     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            r11 = 1
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0134, all -> 0x0130 }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            if (r2 != 0) goto L_0x006d
            if (r12 == 0) goto L_0x006c
            r12.close()
        L_0x006c:
            return r18
        L_0x006d:
            long r4 = r12.getLong(r10)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            long r6 = r12.getLong(r11)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            long r16 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r1 = 3
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r8 = 0
            if (r2 == 0) goto L_0x0085
            r19 = r8
            goto L_0x008b
        L_0x0085:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r19 = r1
        L_0x008b:
            r1 = 4
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            if (r2 == 0) goto L_0x0095
            r21 = r18
            goto L_0x009f
        L_0x0095:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r21 = r1
        L_0x009f:
            r1 = 5
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            if (r2 == 0) goto L_0x00a9
            r22 = r18
            goto L_0x00b3
        L_0x00a9:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r22 = r1
        L_0x00b3:
            r1 = 6
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            if (r2 == 0) goto L_0x00bd
            r23 = r18
            goto L_0x00c7
        L_0x00bd:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r23 = r1
        L_0x00c7:
            r1 = 7
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            if (r2 != 0) goto L_0x00e0
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r24 = 1
            int r3 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r3 != 0) goto L_0x00d9
            r10 = 1
        L_0x00d9:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r24 = r1
            goto L_0x00e2
        L_0x00e0:
            r24 = r18
        L_0x00e2:
            if (r0 == 0) goto L_0x00f1
            r0 = 8
            boolean r1 = r12.isNull(r0)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            if (r1 != 0) goto L_0x00f1
            long r0 = r12.getLong(r0)     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r8 = r0
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzae r0 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ SQLiteException -> 0x012c, all -> 0x0128 }
            r1 = r0
            r2 = r27
            r3 = r28
            r10 = r16
            r25 = r12
            r12 = r19
            r14 = r21
            r15 = r22
            r16 = r23
            r17 = r24
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0126 }
            boolean r1 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0126 }
            if (r1 == 0) goto L_0x0120
            com.google.android.gms.measurement.internal.zzef r1 = r26.zzab()     // Catch:{ SQLiteException -> 0x0126 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ SQLiteException -> 0x0126 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r27)     // Catch:{ SQLiteException -> 0x0126 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0126 }
        L_0x0120:
            if (r25 == 0) goto L_0x0125
            r25.close()
        L_0x0125:
            return r0
        L_0x0126:
            r0 = move-exception
            goto L_0x0137
        L_0x0128:
            r0 = move-exception
            r25 = r12
            goto L_0x0159
        L_0x012c:
            r0 = move-exception
            r25 = r12
            goto L_0x0137
        L_0x0130:
            r0 = move-exception
            r25 = r18
            goto L_0x0159
        L_0x0134:
            r0 = move-exception
            r25 = r18
        L_0x0137:
            com.google.android.gms.measurement.internal.zzef r1 = r26.zzab()     // Catch:{ all -> 0x0158 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x0158 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r27)     // Catch:{ all -> 0x0158 }
            com.google.android.gms.measurement.internal.zzed r4 = r26.zzy()     // Catch:{ all -> 0x0158 }
            r5 = r28
            java.lang.String r4 = r4.zzaj(r5)     // Catch:{ all -> 0x0158 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0158 }
            if (r25 == 0) goto L_0x0157
            r25.close()
        L_0x0157:
            return r18
        L_0x0158:
            r0 = move-exception
        L_0x0159:
            if (r25 == 0) goto L_0x015e
            r25.close()
        L_0x015e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    @WorkerThread
    public final void zza(zzae zzae) {
        Preconditions.checkNotNull(zzae);
        zzo();
        zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzae.zzce);
        contentValues.put("name", zzae.name);
        contentValues.put("lifetime_count", Long.valueOf(zzae.zzfg));
        contentValues.put("current_bundle_count", Long.valueOf(zzae.zzfh));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzae.zzfj));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzae.zzfk));
        contentValues.put("last_bundled_day", zzae.zzfl);
        contentValues.put("last_sampled_complex_event_id", zzae.zzfm);
        contentValues.put("last_sampling_rate", zzae.zzfn);
        if (zzad().zze(zzae.zzce, zzak.zziz)) {
            contentValues.put("current_session_count", Long.valueOf(zzae.zzfi));
        }
        Boolean bool = zzae.zzfo;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : Long.valueOf(1));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update event aggregates (got -1). appId", zzef.zzam(zzae.zzce));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing event aggregates. appId", zzef.zzam(zzae.zzce), e);
        }
    }

    @WorkerThread
    public final void zzd(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        zzbi();
        try {
            zzab().zzgs().zza("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error deleting user attribute. appId", zzef.zzam(str), zzy().zzal(str2), e);
        }
    }

    @WorkerThread
    public final boolean zza(zzjp zzjp) {
        Preconditions.checkNotNull(zzjp);
        zzo();
        zzbi();
        if (zze(zzjp.zzce, zzjp.name) == null) {
            if (zzjs.zzbk(zzjp.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzjp.zzce}) >= 25) {
                    return false;
                }
            } else {
                String str = "select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'";
                if (zzad().zze(zzjp.zzce, zzak.zzij)) {
                    if (!"_npa".equals(zzjp.name)) {
                        if (zza(str, new String[]{zzjp.zzce, zzjp.origin}) >= 25) {
                            return false;
                        }
                    }
                } else {
                    if (zza(str, new String[]{zzjp.zzce, zzjp.origin}) >= 25) {
                        return false;
                    }
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjp.zzce);
        contentValues.put("origin", zzjp.origin);
        contentValues.put("name", zzjp.name);
        contentValues.put("set_timestamp", Long.valueOf(zzjp.zztr));
        zza(contentValues, "value", zzjp.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update user property (got -1). appId", zzef.zzam(zzjp.zzce));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing user property. appId", zzef.zzam(zzjp.zzce), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzjp zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzo()
            r18.zzbi()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0076 }
            if (r3 != 0) goto L_0x003f
            if (r10 == 0) goto L_0x003e
            r10.close()
        L_0x003e:
            return r9
        L_0x003f:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0076 }
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzjp r0 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ SQLiteException -> 0x0074 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0074 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzef r1 = r18.zzab()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r19)     // Catch:{ SQLiteException -> 0x0074 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0074 }
        L_0x006e:
            if (r10 == 0) goto L_0x0073
            r10.close()
        L_0x0073:
            return r0
        L_0x0074:
            r0 = move-exception
            goto L_0x0087
        L_0x0076:
            r0 = move-exception
            r11 = r18
            goto L_0x00a7
        L_0x007a:
            r0 = move-exception
            r11 = r18
            goto L_0x0087
        L_0x007e:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto L_0x00a7
        L_0x0083:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0087:
            com.google.android.gms.measurement.internal.zzef r1 = r18.zzab()     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r19)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.measurement.internal.zzed r4 = r18.zzy()     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = r4.zzal(r8)     // Catch:{ all -> 0x00a6 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x00a5
            r10.close()
        L_0x00a5:
            return r9
        L_0x00a6:
            r0 = move-exception
        L_0x00a7:
            if (r10 == 0) goto L_0x00ac
            r10.close()
        L_0x00ac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzjp");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzjp> zzaa(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzo()
            r13.zzbi()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r12 = 0
            r6[r12] = r14     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x003f
            if (r2 == 0) goto L_0x003e
            r2.close()
        L_0x003e:
            return r0
        L_0x003f:
            java.lang.String r7 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x004b
            java.lang.String r3 = ""
        L_0x004b:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0080 }
            r3 = 3
            java.lang.Object r10 = r13.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0080 }
            if (r10 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzef r3 = r13.zzab()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r14)     // Catch:{ SQLiteException -> 0x0080 }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x0074
        L_0x006a:
            com.google.android.gms.measurement.internal.zzjp r3 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ SQLiteException -> 0x0080 }
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0080 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0080 }
        L_0x0074:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x003f
            if (r2 == 0) goto L_0x007f
            r2.close()
        L_0x007f:
            return r0
        L_0x0080:
            r0 = move-exception
            goto L_0x0087
        L_0x0082:
            r14 = move-exception
            r2 = r1
            goto L_0x009f
        L_0x0085:
            r0 = move-exception
            r2 = r1
        L_0x0087:
            com.google.android.gms.measurement.internal.zzef r3 = r13.zzab()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzef.zzam(r14)     // Catch:{ all -> 0x009e }
            r3.zza(r4, r14, r0)     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x009d
            r2.close()
        L_0x009d:
            return r1
        L_0x009e:
            r14 = move-exception
        L_0x009f:
            if (r2 == 0) goto L_0x00a4
            r2.close()
        L_0x00a4:
            goto L_0x00a6
        L_0x00a5:
            throw r14
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzaa(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f9, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0100, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0101, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0104, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0105, code lost:
        r12 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0100 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0127  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzjp> zza(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22)
            r21.zzo()
            r21.zzbi()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            r3 = 3
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            r11 = r22
            r2.add(r11)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
            boolean r5 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x0100 }
            if (r5 != 0) goto L_0x0032
            r5 = r23
            r2.add(r5)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.String r6 = " and origin=?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            goto L_0x0034
        L_0x0032:
            r5 = r23
        L_0x0034:
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            if (r6 != 0) goto L_0x004c
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.String r7 = "*"
            java.lang.String r6 = r6.concat(r7)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            r2.add(r6)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.String r6 = " and name glob ?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
        L_0x004c:
            int r6 = r2.size()     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.Object[] r2 = r2.toArray(r6)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            r16 = r2
            java.lang.String[] r16 = (java.lang.String[]) r16     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            android.database.sqlite.SQLiteDatabase r12 = r21.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.String r13 = "user_attributes"
            java.lang.String r2 = "name"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String r8 = "origin"
            java.lang.String[] r14 = new java.lang.String[]{r2, r6, r7, r8}     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            java.lang.String r15 = r4.toString()     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "1001"
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x0100 }
            boolean r4 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            if (r4 != 0) goto L_0x0088
            if (r2 == 0) goto L_0x0087
            r2.close()
        L_0x0087:
            return r0
        L_0x0088:
            int r4 = r0.size()     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r6) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzef r3 = r21.zzab()     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            r3.zza(r4, r6)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            r12 = r21
            goto L_0x00e3
        L_0x00a4:
            r4 = 0
            java.lang.String r7 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            r4 = 1
            long r8 = r2.getLong(r4)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            r4 = 2
            r12 = r21
            java.lang.Object r10 = r12.zza(r2, r4)     // Catch:{ SQLiteException -> 0x00ee }
            java.lang.String r13 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x00ee }
            if (r10 != 0) goto L_0x00cf
            com.google.android.gms.measurement.internal.zzef r4 = r21.zzab()     // Catch:{ SQLiteException -> 0x00eb }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ SQLiteException -> 0x00eb }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r22)     // Catch:{ SQLiteException -> 0x00eb }
            r14 = r24
            r4.zza(r5, r6, r13, r14)     // Catch:{ SQLiteException -> 0x00eb }
            goto L_0x00dd
        L_0x00cf:
            r14 = r24
            com.google.android.gms.measurement.internal.zzjp r15 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ SQLiteException -> 0x00eb }
            r4 = r15
            r5 = r22
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x00eb }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x00eb }
        L_0x00dd:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00eb }
            if (r4 != 0) goto L_0x00e9
        L_0x00e3:
            if (r2 == 0) goto L_0x00e8
            r2.close()
        L_0x00e8:
            return r0
        L_0x00e9:
            r5 = r13
            goto L_0x0088
        L_0x00eb:
            r0 = move-exception
            r5 = r13
            goto L_0x010c
        L_0x00ee:
            r0 = move-exception
            goto L_0x010c
        L_0x00f0:
            r0 = move-exception
            r12 = r21
            goto L_0x0124
        L_0x00f4:
            r0 = move-exception
            r12 = r21
            goto L_0x010c
        L_0x00f8:
            r0 = move-exception
            r12 = r21
            goto L_0x010b
        L_0x00fc:
            r0 = move-exception
            r12 = r21
            goto L_0x0109
        L_0x0100:
            r0 = move-exception
            r12 = r21
            goto L_0x0125
        L_0x0104:
            r0 = move-exception
            r12 = r21
            r11 = r22
        L_0x0109:
            r5 = r23
        L_0x010b:
            r2 = r1
        L_0x010c:
            com.google.android.gms.measurement.internal.zzef r3 = r21.zzab()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0123 }
            java.lang.String r4 = "(2)Error querying user properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r22)     // Catch:{ all -> 0x0123 }
            r3.zza(r4, r6, r5, r0)     // Catch:{ all -> 0x0123 }
            if (r2 == 0) goto L_0x0122
            r2.close()
        L_0x0122:
            return r1
        L_0x0123:
            r0 = move-exception
        L_0x0124:
            r1 = r2
        L_0x0125:
            if (r1 == 0) goto L_0x012a
            r1.close()
        L_0x012a:
            goto L_0x012c
        L_0x012b:
            throw r0
        L_0x012c:
            goto L_0x012b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zza(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        zzo();
        zzbi();
        if (zze(zzq.packageName, zzq.zzdw.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzq.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzq.packageName);
        contentValues.put("origin", zzq.origin);
        contentValues.put("name", zzq.zzdw.name);
        zza(contentValues, "value", zzq.zzdw.getValue());
        contentValues.put("active", Boolean.valueOf(zzq.active));
        contentValues.put("trigger_event_name", zzq.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzq.triggerTimeout));
        zzz();
        contentValues.put("timed_out_event", zzjs.zza((Parcelable) zzq.zzdx));
        contentValues.put("creation_timestamp", Long.valueOf(zzq.creationTimestamp));
        zzz();
        contentValues.put("triggered_event", zzjs.zza((Parcelable) zzq.zzdy));
        contentValues.put("triggered_timestamp", Long.valueOf(zzq.zzdw.zztr));
        contentValues.put("time_to_live", Long.valueOf(zzq.timeToLive));
        zzz();
        contentValues.put("expired_event", zzjs.zza((Parcelable) zzq.zzdz));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update conditional user property (got -1)", zzef.zzam(zzq.packageName));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing conditional user property", zzef.zzam(zzq.packageName), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzq zzf(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzo()
            r29.zzbi()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00f2 }
            if (r3 != 0) goto L_0x004e
            if (r9 == 0) goto L_0x004d
            r9.close()
        L_0x004d:
            return r8
        L_0x004e:
            java.lang.String r16 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00f2 }
            r10 = r29
            java.lang.Object r5 = r10.zza(r9, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            if (r0 == 0) goto L_0x0061
            r20 = 1
            goto L_0x0063
        L_0x0061:
            r20 = 0
        L_0x0063:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzjo r0 = r29.zzgw()     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r2 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzai r22 = (com.google.android.gms.measurement.internal.zzai) r22     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzjo r0 = r29.zzgw()     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r2 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzai r25 = (com.google.android.gms.measurement.internal.zzai) r25     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzjo r0 = r29.zzgw()     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r2 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable r0 = r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzai r28 = (com.google.android.gms.measurement.internal.zzai) r28     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzjn r17 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzq r0 = new com.google.android.gms.measurement.internal.zzq     // Catch:{ SQLiteException -> 0x00f0 }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00f0 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00f0 }
            if (r1 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.zzef r1 = r29.zzab()     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ SQLiteException -> 0x00f0 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r30)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzed r4 = r29.zzy()     // Catch:{ SQLiteException -> 0x00f0 }
            java.lang.String r4 = r4.zzal(r7)     // Catch:{ SQLiteException -> 0x00f0 }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00f0 }
        L_0x00ea:
            if (r9 == 0) goto L_0x00ef
            r9.close()
        L_0x00ef:
            return r0
        L_0x00f0:
            r0 = move-exception
            goto L_0x0103
        L_0x00f2:
            r0 = move-exception
            r10 = r29
            goto L_0x0123
        L_0x00f6:
            r0 = move-exception
            r10 = r29
            goto L_0x0103
        L_0x00fa:
            r0 = move-exception
            r10 = r29
            r9 = r8
            goto L_0x0123
        L_0x00ff:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x0103:
            com.google.android.gms.measurement.internal.zzef r1 = r29.zzab()     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x0122 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r30)     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzed r4 = r29.zzy()     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = r4.zzal(r7)     // Catch:{ all -> 0x0122 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0122 }
            if (r9 == 0) goto L_0x0121
            r9.close()
        L_0x0121:
            return r8
        L_0x0122:
            r0 = move-exception
        L_0x0123:
            if (r9 == 0) goto L_0x0128
            r9.close()
        L_0x0128:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzf(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    @WorkerThread
    public final int zzg(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        zzbi();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error deleting conditional property", zzef.zzam(str), zzy().zzal(str2), e);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzq> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzo();
        zzbi();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzq> zzb(String str, String[] strArr) {
        zzo();
        zzbi();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    zzai zzai = (zzai) zzgw().zza(cursor.getBlob(7), zzai.CREATOR);
                    long j2 = cursor.getLong(8);
                    zzai zzai2 = (zzai) zzgw().zza(cursor.getBlob(9), zzai.CREATOR);
                    long j3 = cursor.getLong(10);
                    long j4 = cursor.getLong(11);
                    zzai zzai3 = (zzai) zzgw().zza(cursor.getBlob(12), zzai.CREATOR);
                    zzjn zzjn = new zzjn(string3, j3, zza, string2);
                    boolean z2 = z;
                    zzq zzq = r3;
                    zzq zzq2 = new zzq(string, string2, zzjn, j2, z2, string4, zzai, j, zzai2, j4, zzai3);
                    arrayList.add(zzq);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzab().zzgk().zza("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error querying conditional user property value", e);
            List<zzq> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0119 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x011d A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0153 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0155 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0164 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0179 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0195 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0196 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a5 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01c0 A[Catch:{ SQLiteException -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0204  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzab(java.lang.String r34) {
        /*
            r33 = this;
            r1 = r34
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r33.zzo()
            r33.zzbi()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r33.getWritableDatabase()     // Catch:{ SQLiteException -> 0x01e6, all -> 0x01e1 }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "ssaid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32}     // Catch:{ SQLiteException -> 0x01e6, all -> 0x01e1 }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x01e6, all -> 0x01e1 }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x01e6, all -> 0x01e1 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x01e6, all -> 0x01e1 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x01dd, all -> 0x01d9 }
            if (r4 != 0) goto L_0x0069
            if (r3 == 0) goto L_0x0068
            r3.close()
        L_0x0068:
            return r2
        L_0x0069:
            com.google.android.gms.measurement.internal.zzf r4 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ SQLiteException -> 0x01dd, all -> 0x01d9 }
            r5 = r33
            com.google.android.gms.measurement.internal.zzjg r6 = r5.zzkz     // Catch:{ SQLiteException -> 0x01d7 }
            com.google.android.gms.measurement.internal.zzfj r6 = r6.zzjt()     // Catch:{ SQLiteException -> 0x01d7 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x01d7 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zza(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzb(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzd(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zze(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzf(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzf(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzg(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzh(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzi(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r7 != 0) goto L_0x00d7
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r6 == 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r6 = 0
            goto L_0x00d8
        L_0x00d7:
            r6 = 1
        L_0x00d8:
            r4.setMeasurementEnabled(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzp(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzq(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r7 == 0) goto L_0x011d
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0122
        L_0x011d:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x01d7 }
        L_0x0122:
            r4.zzg(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zze(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzs(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzr(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzh(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 22
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r8 = 0
            if (r7 == 0) goto L_0x0155
            r6 = r8
            goto L_0x0159
        L_0x0155:
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01d7 }
        L_0x0159:
            r4.zzt(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 23
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r7 != 0) goto L_0x016d
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r6 == 0) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r6 = 0
            goto L_0x016e
        L_0x016d:
            r6 = 1
        L_0x016e:
            r4.zzb(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            r6 = 24
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r7 != 0) goto L_0x0181
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r6 == 0) goto L_0x0180
            goto L_0x0181
        L_0x0180:
            r0 = 0
        L_0x0181:
            r4.zzc(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zzc(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r6 == 0) goto L_0x0196
            goto L_0x019a
        L_0x0196:
            long r8 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x01d7 }
        L_0x019a:
            r4.zzj(r8)     // Catch:{ SQLiteException -> 0x01d7 }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            if (r6 != 0) goto L_0x01b7
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x01d7 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x01d7 }
            r4.zza(r0)     // Catch:{ SQLiteException -> 0x01d7 }
        L_0x01b7:
            r4.zzaf()     // Catch:{ SQLiteException -> 0x01d7 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x01d7 }
            if (r0 == 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzef r0 = r33.zzab()     // Catch:{ SQLiteException -> 0x01d7 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ SQLiteException -> 0x01d7 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r34)     // Catch:{ SQLiteException -> 0x01d7 }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x01d7 }
        L_0x01d1:
            if (r3 == 0) goto L_0x01d6
            r3.close()
        L_0x01d6:
            return r4
        L_0x01d7:
            r0 = move-exception
            goto L_0x01ea
        L_0x01d9:
            r0 = move-exception
            r5 = r33
            goto L_0x0202
        L_0x01dd:
            r0 = move-exception
            r5 = r33
            goto L_0x01ea
        L_0x01e1:
            r0 = move-exception
            r5 = r33
            r3 = r2
            goto L_0x0202
        L_0x01e6:
            r0 = move-exception
            r5 = r33
            r3 = r2
        L_0x01ea:
            com.google.android.gms.measurement.internal.zzef r4 = r33.zzab()     // Catch:{ all -> 0x0201 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x0201 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzef.zzam(r34)     // Catch:{ all -> 0x0201 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x0201 }
            if (r3 == 0) goto L_0x0200
            r3.close()
        L_0x0200:
            return r2
        L_0x0201:
            r0 = move-exception
        L_0x0202:
            if (r3 == 0) goto L_0x0207
            r3.close()
        L_0x0207:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzab(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    @WorkerThread
    public final void zza(zzf zzf) {
        String str = "apps";
        Preconditions.checkNotNull(zzf);
        zzo();
        zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf.zzag());
        contentValues.put("app_instance_id", zzf.getAppInstanceId());
        contentValues.put("gmp_app_id", zzf.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzf.zzai());
        contentValues.put("last_bundle_index", Long.valueOf(zzf.zzar()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf.zzaj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf.zzak()));
        contentValues.put("app_version", zzf.zzal());
        contentValues.put("app_store", zzf.zzan());
        contentValues.put("gmp_version", Long.valueOf(zzf.zzao()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf.zzap()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzf.zzav()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf.zzaw()));
        contentValues.put("daily_events_count", Long.valueOf(zzf.zzax()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf.zzay()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf.zzas()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf.zzat()));
        contentValues.put("app_version_int", Long.valueOf(zzf.zzam()));
        contentValues.put("firebase_instance_id", zzf.getFirebaseInstanceId());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf.zzba()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf.zzaz()));
        contentValues.put("health_monitor_sample", zzf.zzbb());
        contentValues.put("android_id", Long.valueOf(zzf.zzbd()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf.zzbe()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf.zzbf()));
        contentValues.put("admob_app_id", zzf.zzah());
        contentValues.put("dynamite_version", Long.valueOf(zzf.zzaq()));
        if (zzf.zzbh() != null) {
            if (zzf.zzbh().size() == 0) {
                zzab().zzgn().zza("Safelisted events should not be an empty list. appId", zzf.zzag());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf.zzbh()));
            }
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update(str, contentValues, "app_id = ?", new String[]{zzf.zzag()})) == 0 && writableDatabase.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update app (got -1). appId", zzef.zzam(zzf.zzag()));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing app. appId", zzef.zzam(zzf.zzag()), e);
        }
    }

    public final long zzac(String str) {
        Preconditions.checkNotEmpty(str);
        zzo();
        zzbi();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzad().zzb(str, zzak.zzgu))))});
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error deleting over the limit events. appId", zzef.zzam(str), e);
            return 0;
        }
    }

    @WorkerThread
    public final zzw zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzo();
        zzbi();
        String[] strArr = {str};
        zzw zzw = new zzw();
        Cursor cursor = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            SQLiteDatabase sQLiteDatabase = writableDatabase;
            cursor = sQLiteDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!cursor.moveToFirst()) {
                zzab().zzgn().zza("Not updating daily counts, app is not known. appId", zzef.zzam(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzw;
            }
            if (cursor.getLong(0) == j) {
                zzw.zzeg = cursor.getLong(1);
                zzw.zzef = cursor.getLong(2);
                zzw.zzeh = cursor.getLong(3);
                zzw.zzei = cursor.getLong(4);
                zzw.zzej = cursor.getLong(5);
            }
            if (z) {
                zzw.zzeg++;
            }
            if (z2) {
                zzw.zzef++;
            }
            if (z3) {
                zzw.zzeh++;
            }
            if (z4) {
                zzw.zzei++;
            }
            if (z5) {
                zzw.zzej++;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzw.zzef));
            contentValues.put("daily_events_count", Long.valueOf(zzw.zzeg));
            contentValues.put("daily_conversions_count", Long.valueOf(zzw.zzeh));
            contentValues.put("daily_error_events_count", Long.valueOf(zzw.zzei));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzw.zzej));
            writableDatabase.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzw;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error updating daily counts. appId", zzef.zzam(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzw;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzad(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzo()
            r10.zzbi()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            r9 = 0
            r5[r9] = r11     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0052 }
            if (r2 != 0) goto L_0x0031
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        L_0x0031:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x0052 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0052 }
            if (r3 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzef r3 = r10.zzab()     // Catch:{ SQLiteException -> 0x0052 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ SQLiteException -> 0x0052 }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ SQLiteException -> 0x0052 }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x0052 }
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            return r2
        L_0x0052:
            r2 = move-exception
            goto L_0x0059
        L_0x0054:
            r11 = move-exception
            r1 = r0
            goto L_0x0071
        L_0x0057:
            r2 = move-exception
            r1 = r0
        L_0x0059:
            com.google.android.gms.measurement.internal.zzef r3 = r10.zzab()     // Catch:{ all -> 0x0070 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x0070 }
            r3.zza(r4, r11, r2)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            return r0
        L_0x0070:
            r11 = move-exception
        L_0x0071:
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzad(java.lang.String):byte[]");
    }

    @WorkerThread
    public final boolean zza(zzbs$zzg zzbs_zzg, boolean z) {
        zzo();
        zzbi();
        Preconditions.checkNotNull(zzbs_zzg);
        Preconditions.checkNotEmpty(zzbs_zzg.zzag());
        Preconditions.checkState(zzbs_zzg.zzof());
        zzca();
        long currentTimeMillis = zzx().currentTimeMillis();
        if (zzbs_zzg.zznr() < currentTimeMillis - zzs.zzbs() || zzbs_zzg.zznr() > zzs.zzbs() + currentTimeMillis) {
            zzab().zzgn().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzef.zzam(zzbs_zzg.zzag()), Long.valueOf(currentTimeMillis), Long.valueOf(zzbs_zzg.zznr()));
        }
        try {
            byte[] zzc = zzgw().zzc(zzbs_zzg.toByteArray());
            zzab().zzgs().zza("Saving bundle, size", Integer.valueOf(zzc.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzbs_zzg.zzag());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzbs_zzg.zznr()));
            contentValues.put("data", zzc);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzbs_zzg.zzpn()) {
                contentValues.put("retry_count", Integer.valueOf(zzbs_zzg.zzpo()));
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzab().zzgk().zza("Failed to insert bundle (got -1). appId", zzef.zzam(zzbs_zzg.zzag()));
                return false;
            } catch (SQLiteException e) {
                zzab().zzgk().zza("Error storing bundle. appId", zzef.zzam(zzbs_zzg.zzag()), e);
                return false;
            }
        } catch (IOException e2) {
            zzab().zzgk().zza("Data loss. Failed to serialize bundle. appId", zzef.zzam(zzbs_zzg.zzag()), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzby() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzef r3 = r6.zzab()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzby():java.lang.String");
    }

    public final boolean zzbz() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    @WorkerThread
    public final List<Pair<zzbs$zzg, Long>> zza(String str, int i, int i2) {
        zzo();
        zzbi();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzbs$zzg, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb = zzgw().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb.length + i3 > i2) {
                        break;
                    }
                    try {
                        zza zza = (zza) zzbs$zzg.zzpr().zzf(zzb, zzel.zztq());
                        if (!cursor.isNull(2)) {
                            zza.zzw(cursor.getInt(2));
                        }
                        i3 += zzb.length;
                        arrayList.add(Pair.create((zzbs$zzg) ((zzey) zza.zzug()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzab().zzgk().zza("Failed to merge queued bundle. appId", zzef.zzam(str), e);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzab().zzgk().zza("Failed to unzip queued bundle. appId", zzef.zzam(str), e2);
                }
            } while (i3 <= i2);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzab().zzgk().zza("Error querying bundles. appId", zzef.zzam(str), e3);
            List<Pair<zzbs$zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzca() {
        zzo();
        zzbi();
        if (zzcg()) {
            long j = zzac().zzlm.get();
            long elapsedRealtime = zzx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzak.zzhd.get(null)).longValue()) {
                zzac().zzlm.set(elapsedRealtime);
                zzo();
                zzbi();
                if (zzcg()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzx().currentTimeMillis()), String.valueOf(zzs.zzbs())});
                    if (delete > 0) {
                        zzab().zzgs().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(List<Long> list) {
        zzo();
        zzbi();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzcg()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zza(sb3.toString(), (String[]) null) > 0) {
                zzab().zzgn().zzao("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                writableDatabase.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzab().zzgk().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, zzbv[] zzbvArr) {
        boolean z;
        String str2 = str;
        zzbv[] zzbvArr2 = zzbvArr;
        String str3 = "app_id=? and audience_id=?";
        String str4 = "event_filters";
        String str5 = "app_id=?";
        String str6 = "property_filters";
        zzbi();
        zzo();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbvArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzbi();
            zzo();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete(str6, str5, new String[]{str2});
            writableDatabase2.delete(str4, str5, new String[]{str2});
            for (zzbv zzbv : zzbvArr2) {
                zzbi();
                zzo();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzbv);
                Preconditions.checkNotNull(zzbv.zzzh);
                Preconditions.checkNotNull(zzbv.zzzg);
                if (zzbv.zzzf == null) {
                    zzab().zzgn().zza("Audience with no ID. appId", zzef.zzam(str));
                } else {
                    int intValue = zzbv.zzzf.intValue();
                    zzbk$zza[] zzbk_zzaArr = zzbv.zzzh;
                    int length = zzbk_zzaArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            zzbk$zzd[] zzbk_zzdArr = zzbv.zzzg;
                            int length2 = zzbk_zzdArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    zzbk$zza[] zzbk_zzaArr2 = zzbv.zzzh;
                                    int length3 = zzbk_zzaArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length3) {
                                            z = true;
                                            break;
                                        } else if (!zza(str2, intValue, zzbk_zzaArr2[i3])) {
                                            z = false;
                                            break;
                                        } else {
                                            i3++;
                                        }
                                    }
                                    if (z) {
                                        zzbk$zzd[] zzbk_zzdArr2 = zzbv.zzzg;
                                        int length4 = zzbk_zzdArr2.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length4) {
                                                break;
                                            } else if (!zza(str2, intValue, zzbk_zzdArr2[i4])) {
                                                z = false;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzbi();
                                        zzo();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                        writableDatabase3.delete(str6, str3, new String[]{str2, String.valueOf(intValue)});
                                        writableDatabase3.delete(str4, str3, new String[]{str2, String.valueOf(intValue)});
                                    }
                                } else if (!zzbk_zzdArr[i2].zzkb()) {
                                    zzab().zzgn().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzef.zzam(str), zzbv.zzzf);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else if (!zzbk_zzaArr[i].zzkb()) {
                            zzab().zzgn().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzef.zzam(str), zzbv.zzzf);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv zzbv2 : zzbvArr2) {
                arrayList.add(zzbv2.zzzf);
            }
            zza(str2, (List<Integer>) arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbk$zza zzbk_zza) {
        zzbi();
        zzo();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbk_zza);
        Integer num = null;
        if (TextUtils.isEmpty(zzbk_zza.zzjz())) {
            zzeh zzgn = zzab().zzgn();
            Object zzam = zzef.zzam(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzbk_zza.zzkb()) {
                num = Integer.valueOf(zzbk_zza.getId());
            }
            zzgn.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzam, valueOf, String.valueOf(num));
            return false;
        }
        byte[] byteArray = zzbk_zza.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbk_zza.zzkb() ? Integer.valueOf(zzbk_zza.getId()) : null);
        contentValues.put(MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY, zzbk_zza.zzjz());
        if (zzad().zze(str, zzak.zziy)) {
            contentValues.put("session_scoped", zzbk_zza.zzkh() ? Boolean.valueOf(zzbk_zza.zzki()) : null);
        }
        contentValues.put("data", byteArray);
        try {
            if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert event filter (got -1). appId", zzef.zzam(str));
            }
            return true;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing event filter. appId", zzef.zzam(str), e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbk$zzd zzbk_zzd) {
        zzbi();
        zzo();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbk_zzd);
        Integer num = null;
        if (TextUtils.isEmpty(zzbk_zzd.getPropertyName())) {
            zzeh zzgn = zzab().zzgn();
            Object zzam = zzef.zzam(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzbk_zzd.zzkb()) {
                num = Integer.valueOf(zzbk_zzd.getId());
            }
            zzgn.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzam, valueOf, String.valueOf(num));
            return false;
        }
        byte[] byteArray = zzbk_zzd.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbk_zzd.zzkb() ? Integer.valueOf(zzbk_zzd.getId()) : null);
        contentValues.put("property_name", zzbk_zzd.getPropertyName());
        if (zzad().zze(str, zzak.zziy)) {
            contentValues.put("session_scoped", zzbk_zzd.zzkh() ? Boolean.valueOf(zzbk_zzd.zzki()) : null);
        }
        contentValues.put("data", byteArray);
        try {
            if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert property filter (got -1). appId", zzef.zzam(str));
            return false;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing property filter. appId", zzef.zzam(str), e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbk$zza>> zzh(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzbi()
            r12.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.getWritableDatabase()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x008c }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x008c }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x008c }
            com.google.android.gms.internal.measurement.zzel r2 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x006e }
            com.google.android.gms.internal.measurement.zzbk$zza r1 = com.google.android.gms.internal.measurement.zzbk$zza.zza(r1, r2)     // Catch:{ IOException -> 0x006e }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x008c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x008c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x008c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x008c }
            if (r3 != 0) goto L_0x006a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x008c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x008c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x008c }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x008c }
        L_0x006a:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x008c }
            goto L_0x0080
        L_0x006e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzef r2 = r12.zzab()     // Catch:{ SQLiteException -> 0x008c }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ SQLiteException -> 0x008c }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ SQLiteException -> 0x008c }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x008c }
        L_0x0080:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x008c }
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x008b
            r14.close()
        L_0x008b:
            return r0
        L_0x008c:
            r0 = move-exception
            goto L_0x0093
        L_0x008e:
            r13 = move-exception
            r14 = r9
            goto L_0x00ab
        L_0x0091:
            r0 = move-exception
            r14 = r9
        L_0x0093:
            com.google.android.gms.measurement.internal.zzef r1 = r12.zzab()     // Catch:{ all -> 0x00aa }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x00aa }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x00aa }
            if (r14 == 0) goto L_0x00a9
            r14.close()
        L_0x00a9:
            return r9
        L_0x00aa:
            r13 = move-exception
        L_0x00ab:
            if (r14 == 0) goto L_0x00b0
            r14.close()
        L_0x00b0:
            goto L_0x00b2
        L_0x00b1:
            throw r13
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzh(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbk$zzd>> zzi(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzbi()
            r12.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.getWritableDatabase()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008e }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x008c }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x008c }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x008c }
            com.google.android.gms.internal.measurement.zzel r2 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x006e }
            com.google.android.gms.internal.measurement.zzbk$zzd r1 = com.google.android.gms.internal.measurement.zzbk$zzd.zzb(r1, r2)     // Catch:{ IOException -> 0x006e }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x008c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x008c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x008c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x008c }
            if (r3 != 0) goto L_0x006a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x008c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x008c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x008c }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x008c }
        L_0x006a:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x008c }
            goto L_0x0080
        L_0x006e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzef r2 = r12.zzab()     // Catch:{ SQLiteException -> 0x008c }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ SQLiteException -> 0x008c }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ SQLiteException -> 0x008c }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x008c }
        L_0x0080:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x008c }
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x008b
            r14.close()
        L_0x008b:
            return r0
        L_0x008c:
            r0 = move-exception
            goto L_0x0093
        L_0x008e:
            r13 = move-exception
            r14 = r9
            goto L_0x00ab
        L_0x0091:
            r0 = move-exception
            r14 = r9
        L_0x0093:
            com.google.android.gms.measurement.internal.zzef r1 = r12.zzab()     // Catch:{ all -> 0x00aa }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x00aa }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x00aa }
            if (r14 == 0) goto L_0x00a9
            r14.close()
        L_0x00a9:
            return r9
        L_0x00aa:
            r13 = move-exception
        L_0x00ab:
            if (r14 == 0) goto L_0x00b0
            r14.close()
        L_0x00b0:
            goto L_0x00b2
        L_0x00b1:
            throw r13
        L_0x00b2:
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzi(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzae(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzbi()
            r7.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r8
        L_0x0032:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0065 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0065 }
            if (r4 != 0) goto L_0x004e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0065 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0065 }
        L_0x004e:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0065 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            goto L_0x006c
        L_0x0067:
            r8 = move-exception
            r1 = r2
            goto L_0x0084
        L_0x006a:
            r0 = move-exception
            r1 = r2
        L_0x006c:
            com.google.android.gms.measurement.internal.zzef r3 = r7.zzab()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ all -> 0x0083 }
            r3.zza(r4, r8, r0)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0082
            r1.close()
        L_0x0082:
            return r2
        L_0x0083:
            r8 = move-exception
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            goto L_0x008b
        L_0x008a:
            throw r8
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzae(java.lang.String):java.util.Map");
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzbi();
        zzo();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(TedPermissionBase.REQ_CODE_REQUEST_SETTING, zzad().zzb(str, zzak.zzhk)));
            if (zza <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Database error querying filters. appId", zzef.zzam(str), e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzbs$zzi> zzaf(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzbi()
            r11.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
            r10 = 0
            r4[r10] = r12     // Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r1 != 0) goto L_0x0033
            if (r0 == 0) goto L_0x0032
            r0.close()
        L_0x0032:
            return r8
        L_0x0033:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0072 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0072 }
        L_0x0038:
            int r2 = r0.getInt(r10)     // Catch:{ SQLiteException -> 0x0072 }
            byte[] r3 = r0.getBlob(r9)     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.internal.measurement.zzel r4 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x0050 }
            com.google.android.gms.internal.measurement.zzbs$zzi r3 = com.google.android.gms.internal.measurement.zzbs$zzi.zze(r3, r4)     // Catch:{ IOException -> 0x0050 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0072 }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x0072 }
            goto L_0x0066
        L_0x0050:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzef r4 = r11.zzab()     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r12)     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0072 }
            r4.zza(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0072 }
        L_0x0066:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0072 }
            if (r2 != 0) goto L_0x0038
            if (r0 == 0) goto L_0x0071
            r0.close()
        L_0x0071:
            return r1
        L_0x0072:
            r1 = move-exception
            goto L_0x0079
        L_0x0074:
            r12 = move-exception
            r0 = r8
            goto L_0x0091
        L_0x0077:
            r1 = move-exception
            r0 = r8
        L_0x0079:
            com.google.android.gms.measurement.internal.zzef r2 = r11.zzab()     // Catch:{ all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r12)     // Catch:{ all -> 0x0090 }
            r2.zza(r3, r12, r1)     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            return r8
        L_0x0090:
            r12 = move-exception
        L_0x0091:
            if (r0 == 0) goto L_0x0096
            r0.close()
        L_0x0096:
            goto L_0x0098
        L_0x0097:
            throw r12
        L_0x0098:
            goto L_0x0097
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzaf(java.lang.String):java.util.Map");
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzab().zzgk().zzao("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzab().zzgk().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzab().zzgk().zzao("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    public final long zzcb() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final long zzj(String str, String str2) {
        long j;
        String str3;
        String str4;
        String str5 = str;
        String str6 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        zzbi();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str6);
            sb.append(" from app2 where app_id=?");
            try {
                j = zza(sb.toString(), new String[]{str5}, -1);
                str3 = "app2";
                str4 = "app_id";
                if (j == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(str4, str5);
                    contentValues.put("first_open_count", Integer.valueOf(0));
                    contentValues.put("previous_install_count", Integer.valueOf(0));
                    if (writableDatabase.insertWithOnConflict(str3, null, contentValues, 5) == -1) {
                        zzab().zzgk().zza("Failed to insert column (got -1). appId", zzef.zzam(str), str6);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    j = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                j = 0;
                try {
                    zzab().zzgk().zza("Error inserting column. appId", zzef.zzam(str), str6, e);
                    writableDatabase.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(str4, str5);
                contentValues2.put(str6, Long.valueOf(1 + j));
                if (((long) writableDatabase.update(str3, contentValues2, "app_id = ?", new String[]{str5})) == 0) {
                    zzab().zzgk().zza("Failed to update column (got 0). appId", zzef.zzam(str), str6);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                zzab().zzgk().zza("Error inserting column. appId", zzef.zzam(str), str6, e);
                writableDatabase.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzab().zzgk().zza("Error inserting column. appId", zzef.zzam(str), str6, e);
            writableDatabase.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public final long zzcc() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzbs$zzg zzbs_zzg) throws IOException {
        zzo();
        zzbi();
        Preconditions.checkNotNull(zzbs_zzg);
        Preconditions.checkNotEmpty(zzbs_zzg.zzag());
        byte[] byteArray = zzbs_zzg.toByteArray();
        long zza = zzgw().zza(byteArray);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbs_zzg.zzag());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", byteArray);
        try {
            getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing raw event metadata. appId", zzef.zzam(zzbs_zzg.zzag()), e);
            throw e;
        }
    }

    public final boolean zzcd() {
        return zza("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzce() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzag(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzu(long r5) {
        /*
            r4 = this;
            r4.zzo()
            r4.zzbi()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzef r6 = r4.zzab()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgs()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zzao(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0045
        L_0x0040:
            r6 = move-exception
            r5 = r0
            goto L_0x0059
        L_0x0043:
            r6 = move-exception
            r5 = r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzef r1 = r4.zzab()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0058 }
            if (r5 == 0) goto L_0x0057
            r5.close()
        L_0x0057:
            return r0
        L_0x0058:
            r6 = move-exception
        L_0x0059:
            if (r5 == 0) goto L_0x005e
            r5.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzu(long):java.lang.String");
    }

    public final long zzcf() {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzbs$zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzo()
            r7.zzbi()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x006d }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzef r8 = r7.zzab()     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgs()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r9 = "Main event not found"
            r8.zzao(r9)     // Catch:{ SQLiteException -> 0x006d }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x006d }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x006d }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.internal.measurement.zzel r4 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = com.google.android.gms.internal.measurement.zzbs$zzc.zzc(r2, r4)     // Catch:{ IOException -> 0x0055 }
            android.util.Pair r8 = android.util.Pair.create(r8, r3)     // Catch:{ SQLiteException -> 0x006d }
            if (r1 == 0) goto L_0x0054
            r1.close()
        L_0x0054:
            return r8
        L_0x0055:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzef r3 = r7.zzab()     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ SQLiteException -> 0x006d }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x006d }
            if (r1 == 0) goto L_0x006c
            r1.close()
        L_0x006c:
            return r0
        L_0x006d:
            r8 = move-exception
            goto L_0x0074
        L_0x006f:
            r8 = move-exception
            r1 = r0
            goto L_0x0088
        L_0x0072:
            r8 = move-exception
            r1 = r0
        L_0x0074:
            com.google.android.gms.measurement.internal.zzef r9 = r7.zzab()     // Catch:{ all -> 0x0087 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgk()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            return r0
        L_0x0087:
            r8 = move-exception
        L_0x0088:
            if (r1 == 0) goto L_0x008d
            r1.close()
        L_0x008d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzbs$zzc zzbs_zzc) {
        zzo();
        zzbi();
        Preconditions.checkNotNull(zzbs_zzc);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] byteArray = zzbs_zzc.toByteArray();
        zzab().zzgs().zza("Saving complex main event, appId, data size", zzy().zzaj(str), Integer.valueOf(byteArray.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", byteArray);
        try {
            if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert complex main event (got -1). appId", zzef.zzam(str));
            return false;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing complex main event. appId", zzef.zzam(str), e);
            return false;
        }
    }

    public final boolean zza(zzaf zzaf, long j, boolean z) {
        zzo();
        zzbi();
        Preconditions.checkNotNull(zzaf);
        Preconditions.checkNotEmpty(zzaf.zzce);
        zzbs$zzc.zza zzah = zzbs$zzc.zzmq().zzah(zzaf.zzfp);
        Iterator it = zzaf.zzfq.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzbs$zze.zza zzbz = zzbs$zze.zzng().zzbz(str);
            zzgw().zza(zzbz, zzaf.zzfq.get(str));
            zzah.zza(zzbz);
        }
        byte[] byteArray = ((zzbs$zzc) zzah.zzug()).toByteArray();
        zzab().zzgs().zza("Saving event, name, data size", zzy().zzaj(zzaf.name), Integer.valueOf(byteArray.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaf.zzce);
        contentValues.put("name", zzaf.name);
        contentValues.put("timestamp", Long.valueOf(zzaf.timestamp));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", byteArray);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert raw event (got -1). appId", zzef.zzam(zzaf.zzce));
            return false;
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error storing raw event. appId", zzef.zzam(zzaf.zzce), e);
            return false;
        }
    }

    private final boolean zzcg() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    static {
        String str = "session_scoped";
        zzep = new String[]{str, "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzeq = new String[]{str, "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    }
}
