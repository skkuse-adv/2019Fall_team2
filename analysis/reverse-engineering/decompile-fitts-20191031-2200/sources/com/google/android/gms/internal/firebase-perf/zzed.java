package com.google.android.gms.internal.firebase-perf;

import java.util.Collections;
import java.util.HashMap;

public class zzed {
    private static volatile zzed zznm;
    private static final zzed zznn = new zzed(true);

    private static Class<?> zzgr() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzed zzgs() {
        zzed zzed = zznm;
        if (zzed == null) {
            synchronized (zzed.class) {
                zzed = zznm;
                if (zzed == null) {
                    zzed = zznn;
                    zznm = zzed;
                }
            }
        }
        return zzed;
    }

    zzed() {
        new HashMap();
    }

    private zzed(boolean z) {
        Collections.emptyMap();
    }

    static {
        zzgr();
    }
}
