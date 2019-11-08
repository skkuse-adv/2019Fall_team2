package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzfp;
import com.google.android.gms.internal.firebase_remote_config.zzfq;

public abstract class zzfp<MessageType extends zzfq<MessageType, BuilderType>, BuilderType extends zzfp<MessageType, BuilderType>> implements zzip {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzeo */
    public abstract BuilderType clone();

    public final /* synthetic */ zzip zza(zziq zziq) {
        if (zzgw().getClass().isInstance(zziq)) {
            return zza((MessageType) (zzfq) zziq);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
