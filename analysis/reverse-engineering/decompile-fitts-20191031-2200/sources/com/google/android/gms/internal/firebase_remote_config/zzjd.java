package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zze;

final class zzjd implements zzio {
    private final int flags;
    private final String info;
    private final Object[] zzvs;
    private final zziq zzvv;

    zzjd(zziq zziq, String str, Object[] objArr) {
        this.zzvv = zziq;
        this.info = str;
        this.zzvs = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzij() {
        return this.info;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzik() {
        return this.zzvs;
    }

    public final zziq zzid() {
        return this.zzvv;
    }

    public final int zzib() {
        return (this.flags & 1) == 1 ? zze.zztu : zze.zztv;
    }

    public final boolean zzic() {
        return (this.flags & 2) == 2;
    }
}
