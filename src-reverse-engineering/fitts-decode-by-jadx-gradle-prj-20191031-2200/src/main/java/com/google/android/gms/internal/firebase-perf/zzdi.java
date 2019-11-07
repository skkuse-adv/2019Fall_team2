package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzdg;
import com.google.android.gms.internal.firebase-perf.zzdi;

public abstract class zzdi<MessageType extends zzdg<MessageType, BuilderType>, BuilderType extends zzdi<MessageType, BuilderType>> implements zzga {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzgb */
    public abstract BuilderType clone();

    public final /* synthetic */ zzga zza(zzfx zzfx) {
        if (zzhj().getClass().isInstance(zzfx)) {
            return zza((MessageType) (zzdg) zzfx);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
