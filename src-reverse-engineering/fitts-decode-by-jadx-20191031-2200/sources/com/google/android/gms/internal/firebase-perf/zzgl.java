package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzd;

final class zzgl implements zzfv {
    private final int flags;
    private final String info;
    private final Object[] zztc;
    private final zzfx zztf;

    zzgl(zzfx zzfx, String str, Object[] objArr) {
        this.zztf = zzfx;
        this.info = str;
        this.zztc = objArr;
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
    public final String zzip() {
        return this.info;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zziq() {
        return this.zztc;
    }

    public final zzfx zzig() {
        return this.zztf;
    }

    public final int zzie() {
        return (this.flags & 1) == 1 ? zzd.zzrd : zzd.zzre;
    }

    public final boolean zzif() {
        return (this.flags & 2) == 2;
    }
}
