package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg.zzg;
import java.util.List;

public final class zzgw$zza extends zzcg<zzgw$zza, zza> implements zzdq {
    private static volatile zzdz<zzgw$zza> zzbg;
    /* access modifiers changed from: private */
    public static final zzgw$zza zzbir = new zzgw$zza();
    private zzcn<zzb> zzbiq = zzcg.zzbb();

    public static final class zza extends com.google.android.gms.internal.clearcut.zzcg.zza<zzgw$zza, zza> implements zzdq {
        private zza() {
            super(zzgw$zza.zzbir);
        }

        /* synthetic */ zza(zzgx zzgx) {
            this();
        }
    }

    public static final class zzb extends zzcg<zzb, zza> implements zzdq {
        private static volatile zzdz<zzb> zzbg;
        /* access modifiers changed from: private */
        public static final zzb zzbiv = new zzb();
        private int zzbb;
        private String zzbis = "";
        private long zzbit;
        private long zzbiu;
        private int zzya;

        public static final class zza extends com.google.android.gms.internal.clearcut.zzcg.zza<zzb, zza> implements zzdq {
            private zza() {
                super(zzb.zzbiv);
            }

            /* synthetic */ zza(zzgx zzgx) {
                this();
            }

            public final zza zzn(String str) {
                zzbf();
                ((zzb) this.zzjt).zzm(str);
                return this;
            }

            public final zza zzr(long j) {
                zzbf();
                ((zzb) this.zzjt).zzp(j);
                return this;
            }

            public final zza zzs(long j) {
                zzbf();
                ((zzb) this.zzjt).zzq(j);
                return this;
            }
        }

        static {
            zzcg.zza(zzb.class, zzbiv);
        }

        private zzb() {
        }

        public static zza zzfz() {
            return (zza) zzbiv.zza(zzg.zzkh, null, null);
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            if (str != null) {
                this.zzbb |= 2;
                this.zzbis = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzbb |= 4;
            this.zzbit = j;
        }

        /* access modifiers changed from: private */
        public final void zzq(long j) {
            this.zzbb |= 8;
            this.zzbiu = j;
        }

        public final int getEventCode() {
            return this.zzya;
        }

        /* JADX WARNING: type inference failed for: r2v9, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>] */
        /* JADX WARNING: type inference failed for: r2v10, types: [java.lang.Object] */
        /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>] */
        /* JADX WARNING: type inference failed for: r2v13 */
        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>] */
        /* JADX WARNING: type inference failed for: r2v17 */
        /* JADX WARNING: type inference failed for: r2v18 */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v13
  assigns: []
  uses: []
  mth insns count: 46
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.clearcut.zzgx.zzba
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005d;
                    case 2: goto L_0x0057;
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
                com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r2 = zzbg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r3 = com.google.android.gms.internal.clearcut.zzgw$zza.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r2 = zzbg     // Catch:{ all -> 0x002c }
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.clearcut.zzcg$zzb r2 = new com.google.android.gms.internal.clearcut.zzcg$zzb     // Catch:{ all -> 0x002c }
                com.google.android.gms.internal.clearcut.zzgw$zza$zzb r4 = zzbiv     // Catch:{ all -> 0x002c }
                r2.<init>(r4)     // Catch:{ all -> 0x002c }
                zzbg = r2     // Catch:{ all -> 0x002c }
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
                com.google.android.gms.internal.clearcut.zzgw$zza$zzb r2 = zzbiv
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbb"
                r2[r3] = r0
                java.lang.String r3 = "zzya"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zzbis"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzbit"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzbiu"
                r2[r3] = r4
                com.google.android.gms.internal.clearcut.zzgw$zza$zzb r3 = zzbiv
                java.lang.String r4 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003"
                java.lang.Object r2 = com.google.android.gms.internal.clearcut.zzcg.zza(r3, r4, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.clearcut.zzgw$zza$zzb r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zzb
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzgw$zza.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final boolean zzfv() {
            return (this.zzbb & 1) == 1;
        }

        public final String zzfw() {
            return this.zzbis;
        }

        public final long zzfx() {
            return this.zzbit;
        }

        public final long zzfy() {
            return this.zzbiu;
        }
    }

    static {
        zzcg.zza(zzgw$zza.class, zzbir);
    }

    private zzgw$zza() {
    }

    public static zzgw$zza zzft() {
        return zzbir;
    }

    public static zzgw$zza zzi(byte[] bArr) throws zzco {
        return (zzgw$zza) zzcg.zzb(zzbir, bArr);
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
    /* JADX WARNING: type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v13
  assigns: []
  uses: []
  mth insns count: 40
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
        /*
            r1 = this;
            int[] r3 = com.google.android.gms.internal.clearcut.zzgx.zzba
            r4 = 1
            int r2 = r2 - r4
            r2 = r3[r2]
            r3 = 0
            switch(r2) {
                case 1: goto L_0x004e;
                case 2: goto L_0x0048;
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
            com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza> r2 = zzbg
            if (r2 != 0) goto L_0x002f
            java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza> r3 = com.google.android.gms.internal.clearcut.zzgw$zza.class
            monitor-enter(r3)
            com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza> r2 = zzbg     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.internal.clearcut.zzcg$zzb r2 = new com.google.android.gms.internal.clearcut.zzcg$zzb     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.clearcut.zzgw$zza r4 = zzbir     // Catch:{ all -> 0x002c }
            r2.<init>(r4)     // Catch:{ all -> 0x002c }
            zzbg = r2     // Catch:{ all -> 0x002c }
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
            com.google.android.gms.internal.clearcut.zzgw$zza r2 = zzbir
            return r2
        L_0x0033:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.String r0 = "zzbiq"
            r2[r3] = r0
            java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r3 = com.google.android.gms.internal.clearcut.zzgw$zza.zzb.class
            r2[r4] = r3
            com.google.android.gms.internal.clearcut.zzgw$zza r3 = zzbir
            java.lang.String r4 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b"
            java.lang.Object r2 = com.google.android.gms.internal.clearcut.zzcg.zza(r3, r4, r2)
            return r2
        L_0x0048:
            com.google.android.gms.internal.clearcut.zzgw$zza$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zza
            r2.<init>(r3)
            return r2
        L_0x004e:
            com.google.android.gms.internal.clearcut.zzgw$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzgw$zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final List<zzb> zzfs() {
        return this.zzbiq;
    }
}
