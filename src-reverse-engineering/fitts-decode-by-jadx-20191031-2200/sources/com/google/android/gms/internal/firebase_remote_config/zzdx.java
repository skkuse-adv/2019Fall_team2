package com.google.android.gms.internal.firebase_remote_config;

abstract class zzdx extends zzdi<String> {
    private int limit;
    private int offset = 0;
    private final zzdj zzhg;
    private final boolean zzhh;
    final CharSequence zzhl;

    protected zzdx(zzds zzds, CharSequence charSequence) {
        this.zzhg = zzds.zzhg;
        this.zzhh = false;
        this.limit = zzds.limit;
        this.zzhl = charSequence;
    }

    /* access modifiers changed from: 0000 */
    public abstract int zzk(int i);

    /* access modifiers changed from: 0000 */
    public abstract int zzl(int i);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzcg() {
        int i;
        int i2 = this.offset;
        while (true) {
            int i3 = this.offset;
            if (i3 != -1) {
                int zzk = zzk(i3);
                if (zzk == -1) {
                    zzk = this.zzhl.length();
                    this.offset = -1;
                } else {
                    this.offset = zzl(zzk);
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    this.offset = i4 + 1;
                    if (this.offset > this.zzhl.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i2 < zzk && this.zzhg.zzb(this.zzhl.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzhg.zzb(this.zzhl.charAt(i - 1))) {
                        zzk = i - 1;
                    }
                    if (!this.zzhh || i2 != i) {
                        int i5 = this.limit;
                    } else {
                        i2 = this.offset;
                    }
                }
            } else {
                zzch();
                return null;
            }
        }
        int i52 = this.limit;
        if (i52 == 1) {
            i = this.zzhl.length();
            this.offset = -1;
            while (i > i2 && this.zzhg.zzb(this.zzhl.charAt(i - 1))) {
                i--;
            }
        } else {
            this.limit = i52 - 1;
        }
        return this.zzhl.subSequence(i2, i).toString();
    }
}
