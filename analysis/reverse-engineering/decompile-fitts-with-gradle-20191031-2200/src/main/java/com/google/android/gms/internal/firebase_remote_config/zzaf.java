package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public class zzaf extends IOException {
    private final int statusCode;

    public zzaf(zzac zzac) {
        this(new zzae(zzac));
    }

    protected zzaf(zzae zzae) {
        super(zzae.message);
        this.statusCode = zzae.statusCode;
        String str = zzae.zzbv;
        zzw zzw = zzae.zzbc;
        String str2 = zzae.zzby;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public static StringBuilder zzc(zzac zzac) {
        StringBuilder sb = new StringBuilder();
        int statusCode2 = zzac.getStatusCode();
        if (statusCode2 != 0) {
            sb.append(statusCode2);
        }
        String statusMessage = zzac.getStatusMessage();
        if (statusMessage != null) {
            if (statusCode2 != 0) {
                sb.append(' ');
            }
            sb.append(statusMessage);
        }
        return sb;
    }
}
