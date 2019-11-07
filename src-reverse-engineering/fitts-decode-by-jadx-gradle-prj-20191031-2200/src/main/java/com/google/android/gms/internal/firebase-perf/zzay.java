package com.google.android.gms.internal.firebase-perf;

import android.os.Bundle;

public final class zzay {
    private final Bundle zzhh;

    public zzay() {
        this(new Bundle());
    }

    public zzay(Bundle bundle) {
        this.zzhh = (Bundle) bundle.clone();
    }

    public final boolean containsKey(String str) {
        return this.zzhh.containsKey(str);
    }

    public final boolean getBoolean(String str, boolean z) {
        return this.zzhh.getBoolean(str, z);
    }

    public final int getInt(String str, int i) {
        return this.zzhh.getInt(str, i);
    }

    public final float getFloat(String str, float f) {
        return this.zzhh.getFloat(str, f);
    }
}
