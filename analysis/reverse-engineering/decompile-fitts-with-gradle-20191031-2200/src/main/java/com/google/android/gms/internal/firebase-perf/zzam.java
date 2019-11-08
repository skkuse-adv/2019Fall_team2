package com.google.android.gms.internal.firebase-perf;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzam {
    private final ConcurrentHashMap<zzal, List<Throwable>> zzam = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzan = new ReferenceQueue<>();

    zzam() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference poll = this.zzan.poll();
        while (poll != null) {
            this.zzam.remove(poll);
            poll = this.zzan.poll();
        }
        List<Throwable> list = (List) this.zzam.get(new zzal(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> list2 = (List) this.zzam.putIfAbsent(new zzal(th, this.zzan), vector);
        return list2 == null ? vector : list2;
    }
}
