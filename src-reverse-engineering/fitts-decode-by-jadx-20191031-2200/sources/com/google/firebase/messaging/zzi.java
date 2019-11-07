package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.internal.firebase_messaging.zzn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

final class zzi implements Closeable {
    private final URL zza;
    @Nullable
    private Task<Bitmap> zzb;
    @Nullable
    private volatile InputStream zzc;

    @Nullable
    public static zzi zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzi(new URL(str));
        } catch (MalformedURLException unused) {
            String str2 = "Not downloading image, bad URL: ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                new String(str2);
            }
            return null;
        }
    }

    private zzi(URL url) {
        this.zza = url;
    }

    public final void zza(Executor executor) {
        this.zzb = Tasks.call(executor, new zzj(this));
    }

    public final Task<Bitmap> zza() {
        return (Task) Preconditions.checkNotNull(this.zzb);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        zza(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r0 != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        zza(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a2, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap zzb() throws java.io.IOException {
        /*
            r6 = this;
            java.net.URL r0 = r6.zza
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            int r1 = r1 + 22
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Starting download of: "
            r2.append(r1)
            r2.append(r0)
            r2.toString()
            java.net.URL r0 = r6.zza     // Catch:{ IOException -> 0x00a3 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x00a3 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x00a3 }
            r1 = 1048576(0x100000, double:5.180654E-318)
            java.io.InputStream r1 = com.google.android.gms.internal.firebase_messaging.zzj.zza(r0, r1)     // Catch:{ all -> 0x009a }
            r6.zzc = r0     // Catch:{ all -> 0x0093 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x006c
            java.lang.String r3 = "FirebaseMessaging"
            r4 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r4)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0062
            java.net.URL r3 = r6.zza     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0093 }
            int r4 = r4.length()     // Catch:{ all -> 0x0093 }
            int r4 = r4 + 31
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r5.<init>(r4)     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = "Successfully downloaded image: "
            r5.append(r4)     // Catch:{ all -> 0x0093 }
            r5.append(r3)     // Catch:{ all -> 0x0093 }
            r5.toString()     // Catch:{ all -> 0x0093 }
        L_0x0062:
            r3 = 0
            zza(r3, r1)     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x006b
            zza(r3, r0)     // Catch:{ IOException -> 0x00a3 }
        L_0x006b:
            return r2
        L_0x006c:
            java.net.URL r2 = r6.zza     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0093 }
            int r3 = r3.length()     // Catch:{ all -> 0x0093 }
            int r3 = r3 + 24
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r4.<init>(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "Failed to decode image: "
            r4.append(r3)     // Catch:{ all -> 0x0093 }
            r4.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0093 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0093 }
            r3.<init>(r2)     // Catch:{ all -> 0x0093 }
            throw r3     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r3 = move-exception
            zza(r2, r1)     // Catch:{ all -> 0x009a }
            throw r3     // Catch:{ all -> 0x009a }
        L_0x009a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x009c }
        L_0x009c:
            r2 = move-exception
            if (r0 == 0) goto L_0x00a2
            zza(r1, r0)     // Catch:{ IOException -> 0x00a3 }
        L_0x00a2:
            throw r2     // Catch:{ IOException -> 0x00a3 }
        L_0x00a3:
            r0 = move-exception
            java.net.URL r1 = r6.zza
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to download image: "
            r3.append(r2)
            r3.append(r1)
            r3.toString()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzi.zzb():android.graphics.Bitmap");
    }

    public final void close() {
        zzk.zza(this.zzc);
    }

    private static /* synthetic */ void zza(Throwable th, InputStream inputStream) {
        if (th != null) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                zzn.zza(th, th2);
            }
        } else {
            inputStream.close();
        }
    }
}
