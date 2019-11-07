package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zzb;
import java.io.IOException;
import java.io.InputStream;

public final class zzfi$zze extends zzhi<zzfi$zze, zza> implements zzis {
    private static volatile zziz<zzfi$zze> zzml;
    /* access modifiers changed from: private */
    public static final zzfi$zze zznb = new zzfi$zze();
    private int zzmg;
    private zzfi$zza zzmw;
    private zzfi$zza zzmx;
    private zzfi$zza zzmy;
    private zzfi$zzc zzmz;
    private zzhn<zzfi$zzf> zzna = zzhi.zzgt();

    public static final class zza extends zzb<zzfi$zze, zza> implements zzis {
        private zza() {
            super(zzfi$zze.zznb);
        }

        /* synthetic */ zza(zzfh zzfh) {
            this();
        }
    }

    private zzfi$zze() {
    }

    public final zzfi$zza zzdt() {
        zzfi$zza zzfi_zza = this.zzmw;
        return zzfi_zza == null ? zzfi$zza.zzdm() : zzfi_zza;
    }

    public final zzfi$zza zzdu() {
        zzfi$zza zzfi_zza = this.zzmx;
        return zzfi_zza == null ? zzfi$zza.zzdm() : zzfi_zza;
    }

    public final zzfi$zza zzdv() {
        zzfi$zza zzfi_zza = this.zzmy;
        return zzfi_zza == null ? zzfi$zza.zzdm() : zzfi_zza;
    }

    public static zzfi$zze zzb(InputStream inputStream) throws IOException {
        return (zzfi$zze) zzhi.zza(zznb, inputStream);
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zze>] */
    /* JADX WARNING: type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zze>] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zze>, com.google.android.gms.internal.firebase_remote_config.zzhi$zza] */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v13
  assigns: []
  uses: []
  mth insns count: 50
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
            int[] r3 = com.google.android.gms.internal.firebase_remote_config.zzfh.zzmf
            r4 = 1
            int r2 = r2 - r4
            r2 = r3[r2]
            r3 = 0
            switch(r2) {
                case 1: goto L_0x0067;
                case 2: goto L_0x0061;
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
            com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zze> r2 = zzml
            if (r2 != 0) goto L_0x002f
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzfi$zze> r3 = com.google.android.gms.internal.firebase_remote_config.zzfi$zze.class
            monitor-enter(r3)
            com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfi$zze> r2 = zzml     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.firebase_remote_config.zzhi$zza r2 = new com.google.android.gms.internal.firebase_remote_config.zzhi$zza     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze r4 = zznb     // Catch:{ all -> 0x002c }
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
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze r2 = zznb
            return r2
        L_0x0033:
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.String r0 = "zzmg"
            r2[r3] = r0
            java.lang.String r3 = "zzmw"
            r2[r4] = r3
            r3 = 2
            java.lang.String r4 = "zzmx"
            r2[r3] = r4
            r3 = 3
            java.lang.String r4 = "zzmy"
            r2[r3] = r4
            r3 = 4
            java.lang.String r4 = "zzmz"
            r2[r3] = r4
            r3 = 5
            java.lang.String r4 = "zzna"
            r2[r3] = r4
            r3 = 6
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzfi$zzf> r4 = com.google.android.gms.internal.firebase_remote_config.zzfi$zzf.class
            r2[r3] = r4
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze r3 = zznb
            java.lang.String r4 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b"
            java.lang.Object r2 = com.google.android.gms.internal.firebase_remote_config.zzhi.zza(r3, r4, r2)
            return r2
        L_0x0061:
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze$zza r2 = new com.google.android.gms.internal.firebase_remote_config.zzfi$zze$zza
            r2.<init>(r3)
            return r2
        L_0x0067:
            com.google.android.gms.internal.firebase_remote_config.zzfi$zze r2 = new com.google.android.gms.internal.firebase_remote_config.zzfi$zze
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfi$zze.zzb(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    static {
        zzhi.zza(zzfi$zze.class, zznb);
    }
}
