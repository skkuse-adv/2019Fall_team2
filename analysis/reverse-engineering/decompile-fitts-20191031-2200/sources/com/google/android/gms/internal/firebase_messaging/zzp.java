package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzp {
    private final ConcurrentHashMap<zzo, List<Throwable>> zza = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzb = new ReferenceQueue<>();

    zzp() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference poll = this.zzb.poll();
        while (poll != null) {
            this.zza.remove(poll);
            poll = this.zzb.poll();
        }
        List<Throwable> list = (List) this.zza.get(new zzo(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> list2 = (List) this.zza.putIfAbsent(new zzo(th, this.zzb), vector);
        return list2 == null ? vector : list2;
    }
}
