package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zzb;

public final class zzkt$zzb extends zzhi<zzkt$zzb, zza> implements zzis {
    /* access modifiers changed from: private */
    public static final zzkt$zzb zzaac = new zzkt$zzb();
    private static volatile zziz<zzkt$zzb> zzml;
    private int zzaaa;
    private zzhn<zzkt$zza> zzaab = zzhi.zzgt();
    private String zzzo;
    private String zzzq;
    private long zzzr;
    private String zzzs;
    private long zzzt;
    private long zzzu;
    private String zzzv;
    private String zzzw;
    private String zzzx;
    private String zzzy;
    private String zzzz;

    public static final class zza extends zzb<zzkt$zzb, zza> implements zzis {
        private zza() {
            super(zzkt$zzb.zzaac);
        }

        /* synthetic */ zza(zzkv zzkv) {
            this();
        }
    }

    private zzkt$zzb() {
        String str = "";
        this.zzzo = str;
        this.zzzq = str;
        this.zzzs = str;
        this.zzzv = str;
        this.zzzw = str;
        this.zzzx = str;
        this.zzzy = str;
        this.zzzz = str;
    }

    public final String zzjm() {
        return this.zzzo;
    }

    public final String zzjn() {
        return this.zzzq;
    }

    public final long zzjo() {
        return this.zzzr;
    }

    public final String zzjp() {
        return this.zzzs;
    }

    public final long zzjq() {
        return this.zzzt;
    }

    public final long zzjr() {
        return this.zzzu;
    }

    public static zzkt$zzb zzg(byte[] bArr) throws zzhq {
        return (zzkt$zzb) zzhi.zza(zzaac, bArr);
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb>] */
    /* JADX WARNING: type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb>] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v13
  assigns: []
  uses: []
  mth insns count: 64
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
            r1 = this;
            int[] r3 = com.google.android.gms.internal.firebase_remote_config.zzkv.zzmf
            r4 = 1
            int r2 = r2 - r4
            r2 = r3[r2]
            r3 = 0
            switch(r2) {
                case 1: goto L_0x0091;
                case 2: goto L_0x008b;
                case 3: goto L_0x0033;
                case 4: goto L_0x0030;
                case 5: goto L_0x0016;
                case 6: goto L_0x0011;
                case 7: goto L_0x0010;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
            r2.<init>()
            throw r2
        L_0x0010:
            return r3
        L_0x0011:
            java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
            return r2
        L_0x0016:
            com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb> r2 = zzml
            if (r2 != 0) goto L_0x002f
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb> r3 = com.google.android.gms.internal.firebase_remote_config.zzkt$zzb.class
            monitor-enter(r3)
            com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzkt$zzb> r2 = zzml     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.firebase_remote_config.zzhi$zza r2 = new com.google.android.gms.internal.firebase_remote_config.zzhi$zza     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.firebase_remote_config.zzkt$zzb r4 = zzaac     // Catch:{ all -> 0x002c }
            r2.<init>(r4)     // Catch:{ all -> 0x002c }
            zzml = r2     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r3)     // Catch:{ all -> 0x002c }
            goto L_0x002f
        L_0x002c:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002c }
            throw r2
        L_0x002f:
            return r2
        L_0x0030:
            com.google.android.gms.internal.firebase_remote_config.zzkt$zzb r2 = zzaac
            return r2
        L_0x0033:
            r2 = 14
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.String r0 = "zzzo"
            r2[r3] = r0
            java.lang.String r3 = "zzzq"
            r2[r4] = r3
            r3 = 2
            java.lang.String r4 = "zzzr"
            r2[r3] = r4
            r3 = 3
            java.lang.String r4 = "zzzs"
            r2[r3] = r4
            r3 = 4
            java.lang.String r4 = "zzzt"
            r2[r3] = r4
            r3 = 5
            java.lang.String r4 = "zzzu"
            r2[r3] = r4
            r3 = 6
            java.lang.String r4 = "zzzv"
            r2[r3] = r4
            r3 = 7
            java.lang.String r4 = "zzzw"
            r2[r3] = r4
            r3 = 8
            java.lang.String r4 = "zzzx"
            r2[r3] = r4
            r3 = 9
            java.lang.String r4 = "zzzy"
            r2[r3] = r4
            r3 = 10
            java.lang.String r4 = "zzzz"
            r2[r3] = r4
            r3 = 11
            java.lang.String r4 = "zzaaa"
            r2[r3] = r4
            r3 = 12
            java.lang.String r4 = "zzaab"
            r2[r3] = r4
            r3 = 13
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzkt$zza> r4 = com.google.android.gms.internal.firebase_remote_config.zzkt$zza.class
            r2[r3] = r4
            com.google.android.gms.internal.firebase_remote_config.zzkt$zzb r3 = zzaac
            java.lang.String r4 = "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b"
            java.lang.Object r2 = com.google.android.gms.internal.firebase_remote_config.zzhi.zza(r3, r4, r2)
            return r2
        L_0x008b:
            com.google.android.gms.internal.firebase_remote_config.zzkt$zzb$zza r2 = new com.google.android.gms.internal.firebase_remote_config.zzkt$zzb$zza
            r2.<init>(r3)
            return r2
        L_0x0091:
            com.google.android.gms.internal.firebase_remote_config.zzkt$zzb r2 = new com.google.android.gms.internal.firebase_remote_config.zzkt$zzb
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzkt$zzb.zzb(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    static {
        zzhi.zza(zzkt$zzb.class, zzaac);
    }
}
