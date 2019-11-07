package com.google.android.gms.internal.firebase-perf;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzgs extends zzgp<FieldDescriptorType, Object> {
    zzgs(int i) {
        super(i, null);
    }

    public final void zzgf() {
        if (!isImmutable()) {
            for (int i = 0; i < zzis(); i++) {
                Entry zzau = zzau(i);
                if (((zzej) zzau.getKey()).zzhb()) {
                    zzau.setValue(Collections.unmodifiableList((List) zzau.getValue()));
                }
            }
            for (Entry entry : zzit()) {
                if (((zzej) entry.getKey()).zzhb()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzgf();
    }
}
