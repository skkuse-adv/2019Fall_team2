package com.google.firebase.iid;

final /* synthetic */ class zzaa implements Runnable {
    private final zzv zza;

    zzaa(zzv zzv) {
        this.zza = zzv;
    }

    /* JADX INFO: used method not loaded: com.google.firebase.iid.zzu.zza(com.google.firebase.iid.zzu):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r3 = com.google.firebase.iid.zzu.zza(r0.zzf);
        r4 = r0.zzb;
        r5 = android.os.Message.obtain();
        r5.what = r1.zzc;
        r5.arg1 = r1.zza;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zza());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.zzd);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzc.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
        r0.zza(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.firebase.iid.zzv r0 = r8.zza
        L_0x0002:
            monitor-enter(r0)
            int r1 = r0.zza     // Catch:{ all -> 0x00a8 }
            r2 = 2
            if (r1 == r2) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x000a:
            java.util.Queue<com.google.firebase.iid.zzae<?>> r1 = r0.zzd     // Catch:{ all -> 0x00a8 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0017
            r0.zza()     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x0017:
            java.util.Queue<com.google.firebase.iid.zzae<?>> r1 = r0.zzd     // Catch:{ all -> 0x00a8 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x00a8 }
            com.google.firebase.iid.zzae r1 = (com.google.firebase.iid.zzae) r1     // Catch:{ all -> 0x00a8 }
            android.util.SparseArray<com.google.firebase.iid.zzae<?>> r3 = r0.zze     // Catch:{ all -> 0x00a8 }
            int r4 = r1.zza     // Catch:{ all -> 0x00a8 }
            r3.put(r4, r1)     // Catch:{ all -> 0x00a8 }
            com.google.firebase.iid.zzu r3 = r0.zzf     // Catch:{ all -> 0x00a8 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.zzc     // Catch:{ all -> 0x00a8 }
            com.google.firebase.iid.zzz r4 = new com.google.firebase.iid.zzz     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x00a8 }
            r5 = 30
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00a8 }
            r3.schedule(r4, r5, r7)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            r3 = 3
            java.lang.String r4 = "MessengerIpcClient"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L_0x0060
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Sending "
            r5.append(r4)
            r5.append(r3)
            r5.toString()
        L_0x0060:
            com.google.firebase.iid.zzu r3 = r0.zzf
            android.content.Context r3 = r3.zzb
            android.os.Messenger r4 = r0.zzb
            android.os.Message r5 = android.os.Message.obtain()
            int r6 = r1.zzc
            r5.what = r6
            int r6 = r1.zza
            r5.arg1 = r6
            r5.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            boolean r6 = r1.zza()
            java.lang.String r7 = "oneWay"
            r4.putBoolean(r7, r6)
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r6 = "pkg"
            r4.putString(r6, r3)
            android.os.Bundle r1 = r1.zzd
            java.lang.String r3 = "data"
            r4.putBundle(r3, r1)
            r5.setData(r4)
            com.google.firebase.iid.zzac r1 = r0.zzc     // Catch:{ RemoteException -> 0x009e }
            r1.zza(r5)     // Catch:{ RemoteException -> 0x009e }
            goto L_0x0002
        L_0x009e:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.zza(r2, r1)
            goto L_0x0002
        L_0x00a8:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            goto L_0x00ac
        L_0x00ab:
            throw r1
        L_0x00ac:
            goto L_0x00ab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzaa.run():void");
    }
}
