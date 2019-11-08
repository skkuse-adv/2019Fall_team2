package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.firebase_messaging.zzn;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzp {
    zzp() {
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzr zza(Context context, String str) throws zzs {
        zzr zzc = zzc(context, str);
        if (zzc != null) {
            return zzc;
        }
        return zzb(context, str);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzr zzb(Context context, String str) {
        zzr zzr = new zzr(zzaf.zza(zza.zza().getPublic()), System.currentTimeMillis());
        zzr zza = zza(context, str, zzr, true);
        String str2 = "FirebaseInstanceId";
        if (zza == null || zza.equals(zzr)) {
            boolean isLoggable = Log.isLoggable(str2, 3);
            zza(context, str, zzr);
            return zzr;
        }
        boolean isLoggable2 = Log.isLoggable(str2, 3);
        return zza;
    }

    static void zza(Context context) {
        File[] listFiles;
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    @Nullable
    private final zzr zzc(Context context, String str) throws zzs {
        try {
            zzr zzd = zzd(context, str);
            if (zzd != null) {
                zza(context, str, zzd);
                return zzd;
            }
            e = null;
            try {
                zzr zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzs e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzs e2) {
            e = e2;
        }
    }

    private static PublicKey zza(String str) throws zzs {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                sb.toString();
                throw new zzs((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzs((Exception) e2);
        }
    }

    @Nullable
    private final zzr zzd(Context context, String str) throws zzs {
        File zze = zze(context, str);
        if (!zze.exists()) {
            return null;
        }
        try {
            return zza(zze);
        } catch (zzs | IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                sb.append("Failed to read ID from file, retrying: ");
                sb.append(valueOf);
                sb.toString();
            }
            try {
                return zza(zze);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                sb2.toString();
                throw new zzs((Exception) e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0090, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r9 != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        zza(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0099, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        zza(r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        throw r11;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0050=Splitter:B:16:0x0050, B:28:0x008a=Splitter:B:28:0x008a} */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzr zza(android.content.Context r9, java.lang.String r10, com.google.firebase.iid.zzr r11, boolean r12) {
        /*
            r8 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r1, r0)
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            java.lang.String r3 = r11.zza()
            java.lang.String r4 = "id"
            r2.setProperty(r4, r3)
            long r3 = r11.zzb
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "cre"
            r2.setProperty(r4, r3)
            java.io.File r9 = zze(r9, r10)
            r10 = 0
            r9.createNewFile()     // Catch:{ IOException -> 0x009e }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x009e }
            java.lang.String r4 = "rw"
            r3.<init>(r9, r4)     // Catch:{ IOException -> 0x009e }
            java.nio.channels.FileChannel r9 = r3.getChannel()     // Catch:{ all -> 0x0097 }
            r9.lock()     // Catch:{ all -> 0x008e }
            r4 = 0
            if (r12 == 0) goto L_0x007b
            long r6 = r9.size()     // Catch:{ all -> 0x008e }
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x007b
            r9.position(r4)     // Catch:{ IOException -> 0x0056, zzs -> 0x0054 }
            com.google.firebase.iid.zzr r11 = zza(r9)     // Catch:{ IOException -> 0x0056, zzs -> 0x0054 }
            if (r9 == 0) goto L_0x0050
            zza(r10, r9)     // Catch:{ all -> 0x0097 }
        L_0x0050:
            zza(r10, r3)     // Catch:{ IOException -> 0x009e }
            return r11
        L_0x0054:
            r12 = move-exception
            goto L_0x0057
        L_0x0056:
            r12 = move-exception
        L_0x0057:
            boolean r0 = android.util.Log.isLoggable(r1, r0)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x007b
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x008e }
            int r0 = r0.length()     // Catch:{ all -> 0x008e }
            int r0 = r0 + 58
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r1.<init>(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = "Tried reading ID before writing new one, but failed with: "
            r1.append(r0)     // Catch:{ all -> 0x008e }
            r1.append(r12)     // Catch:{ all -> 0x008e }
            r1.toString()     // Catch:{ all -> 0x008e }
        L_0x007b:
            r9.truncate(r4)     // Catch:{ all -> 0x008e }
            java.io.OutputStream r12 = java.nio.channels.Channels.newOutputStream(r9)     // Catch:{ all -> 0x008e }
            r2.store(r12, r10)     // Catch:{ all -> 0x008e }
            if (r9 == 0) goto L_0x008a
            zza(r10, r9)     // Catch:{ all -> 0x0097 }
        L_0x008a:
            zza(r10, r3)     // Catch:{ IOException -> 0x009e }
            return r11
        L_0x008e:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r12 = move-exception
            if (r9 == 0) goto L_0x0096
            zza(r11, r9)     // Catch:{ all -> 0x0097 }
        L_0x0096:
            throw r12     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r11 = move-exception
            zza(r9, r3)     // Catch:{ IOException -> 0x009e }
            throw r11     // Catch:{ IOException -> 0x009e }
        L_0x009e:
            r9 = move-exception
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r11 = java.lang.String.valueOf(r9)
            int r11 = r11.length()
            int r11 = r11 + 21
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.lang.String r11 = "Failed to write key: "
            r12.append(r11)
            r12.append(r9)
            r12.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzp.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzr, boolean):com.google.firebase.iid.zzr");
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            return context.getFilesDir();
        }
        return noBackupFilesDir;
    }

    private static File zze(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r8 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        zza(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002f, code lost:
        zza(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzr zza(java.io.File r8) throws com.google.firebase.iid.zzs, java.io.IOException {
        /*
            r7 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r8)
            java.nio.channels.FileChannel r8 = r0.getChannel()     // Catch:{ all -> 0x002c }
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r8
            r1.lock(r2, r4, r6)     // Catch:{ all -> 0x0023 }
            com.google.firebase.iid.zzr r1 = zza(r8)     // Catch:{ all -> 0x0023 }
            r2 = 0
            if (r8 == 0) goto L_0x001f
            zza(r2, r8)     // Catch:{ all -> 0x002c }
        L_0x001f:
            zza(r2, r0)
            return r1
        L_0x0023:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r2 = move-exception
            if (r8 == 0) goto L_0x002b
            zza(r1, r8)     // Catch:{ all -> 0x002c }
        L_0x002b:
            throw r2     // Catch:{ all -> 0x002c }
        L_0x002c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x002e }
        L_0x002e:
            r1 = move-exception
            zza(r8, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzp.zza(java.io.File):com.google.firebase.iid.zzr");
    }

    private static zzr zza(FileChannel fileChannel) throws zzs, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        try {
            long parseLong = Long.parseLong(properties.getProperty("cre"));
            String property = properties.getProperty("id");
            if (property == null) {
                String property2 = properties.getProperty("pub");
                if (property2 != null) {
                    property = zzaf.zza(zza(property2));
                } else {
                    throw new zzs("Invalid properties file");
                }
            }
            return new zzr(property, parseLong);
        } catch (NumberFormatException e) {
            throw new zzs((Exception) e);
        }
    }

    @Nullable
    private static zzr zza(SharedPreferences sharedPreferences, String str) throws zzs {
        long zzb = zzb(sharedPreferences, str);
        String string = sharedPreferences.getString(zzaq.zza(str, "id"), null);
        if (string == null) {
            String string2 = sharedPreferences.getString(zzaq.zza(str, "|P|"), null);
            if (string2 == null) {
                return null;
            }
            string = zzaf.zza(zza(string2));
        }
        return new zzr(string, zzb);
    }

    private final void zza(Context context, String str, zzr zzr) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzr.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzs unused) {
        }
        boolean isLoggable = Log.isLoggable("FirebaseInstanceId", 3);
        Editor edit = sharedPreferences.edit();
        edit.putString(zzaq.zza(str, "id"), zzr.zza());
        edit.putString(zzaq.zza(str, "cre"), String.valueOf(zzr.zzb));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzaq.zza(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            randomAccessFile.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}
