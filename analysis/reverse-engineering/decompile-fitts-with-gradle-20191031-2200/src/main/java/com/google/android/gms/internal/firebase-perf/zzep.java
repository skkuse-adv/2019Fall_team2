package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep;
import com.google.android.gms.internal.firebase-perf.zzep.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzep<MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdg<MessageType, BuilderType> {
    private static Map<Object, zzep<?, ?>> zzqr = new ConcurrentHashMap();
    protected zzhf zzqp = zzhf.zzjf();
    private int zzqq = -1;

    public static abstract class zza<MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdi<MessageType, BuilderType> {
        private final MessageType zzqm;
        protected MessageType zzqn;
        private boolean zzqo = false;

        protected zza(MessageType messagetype) {
            this.zzqm = messagetype;
            this.zzqn = (zzep) messagetype.zza(zzd.zzqy, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzhe() {
            if (this.zzqo) {
                MessageType messagetype = (zzep) this.zzqn.zza(zzd.zzqy, (Object) null, (Object) null);
                zza(messagetype, this.zzqn);
                this.zzqn = messagetype;
                this.zzqo = false;
            }
        }

        public final boolean isInitialized() {
            return zzep.zza(this.zzqn, false);
        }

        /* renamed from: zzhf */
        public MessageType zzhh() {
            if (this.zzqo) {
                return this.zzqn;
            }
            MessageType messagetype = this.zzqn;
            zzgj.zzio().zzn(messagetype).zze(messagetype);
            this.zzqo = true;
            return this.zzqn;
        }

        /* renamed from: zzhg */
        public final MessageType zzhi() {
            MessageType messagetype = (zzep) zzhh();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzhd(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzhe();
            zza(this.zzqn, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgj.zzio().zzn(messagetype).zze(messagetype, messagetype2);
        }

        public final /* synthetic */ zzdi zzgb() {
            return (zza) clone();
        }

        public final /* synthetic */ zzfx zzhj() {
            return this.zzqm;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzqm.zza(zzd.zzqz, (Object) null, (Object) null);
            zza.zza((MessageType) (zzep) zzhh());
            return zza;
        }
    }

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzep<MessageType, BuilderType> implements zzfz {
        protected zzeh<Object> zzqs = zzeh.zzgu();
    }

    public static class zzc<T extends zzep<T, ?>> extends zzdh<T> {
        public zzc(T t) {
        }
    }

    /* 'enum' access flag removed */
    public static final class zzd {
        public static final int zzqv = 1;
        public static final int zzqw = 2;
        public static final int zzqx = 3;
        public static final int zzqy = 4;
        public static final int zzqz = 5;
        public static final int zzra = 6;
        public static final int zzrb = 7;
        private static final /* synthetic */ int[] zzrc = {zzqv, zzqw, zzqx, zzqy, zzqz, zzra, zzrb};
        public static final int zzrd = 1;
        public static final int zzre = 2;
        public static final int zzrg = 1;
        public static final int zzrh = 2;

        static {
            int[] iArr = {zzrd, zzre};
            int[] iArr2 = {zzrg, zzrh};
        }

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzrc.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzgc.zza(this, super.toString());
    }

    public int hashCode() {
        int i = this.zzmo;
        if (i != 0) {
            return i;
        }
        this.zzmo = zzgj.zzio().zzn(this).hashCode(this);
        return this.zzmo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzep) zza(zzd.zzra, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzgj.zzio().zzn(this).equals(this, (zzep) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzhk() {
        return (zza) zza(zzd.zzqz, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza((T) this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzhl() {
        BuilderType buildertype = (zza) zza(zzd.zzqz, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: 0000 */
    public final int zzga() {
        return this.zzqq;
    }

    /* access modifiers changed from: 0000 */
    public final void zzp(int i) {
        this.zzqq = i;
    }

    public final void zzb(zzec zzec) throws IOException {
        zzgj.zzio().zzn(this).zza(this, zzee.zza(zzec));
    }

    public final int zzhm() {
        if (this.zzqq == -1) {
            this.zzqq = zzgj.zzio().zzn(this).zzl(this);
        }
        return this.zzqq;
    }

    static <T extends zzep<?, ?>> T zzc(Class<T> cls) {
        T t = (zzep) zzqr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzep) zzqr.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzep) ((zzep) zzhm.zzg(cls)).zza(zzd.zzra, (Object) null, (Object) null);
            if (t != null) {
                zzqr.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzep<?, ?>> void zza(Class<T> cls, T t) {
        zzqr.put(cls, t);
    }

    protected static Object zza(zzfx zzfx, String str, Object[] objArr) {
        return new zzgl(zzfx, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzep<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzd.zzqv, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzm = zzgj.zzio().zzn(t).zzm(t);
        if (z) {
            t.zza(zzd.zzqw, (Object) zzm ? t : null, (Object) null);
        }
        return zzm;
    }

    protected static zzew zzhn() {
        return zzeq.zzhq();
    }

    protected static <E> zzey<E> zzho() {
        return zzgm.zzir();
    }

    protected static <E> zzey<E> zza(zzey<E> zzey) {
        int size = zzey.size();
        return zzey.zzao(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzga zzhp() {
        zza zza2 = (zza) zza(zzd.zzqz, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzfx zzhj() {
        return (zzep) zza(zzd.zzra, (Object) null, (Object) null);
    }
}
