package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzey.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzey<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdf<MessageType, BuilderType> {
    private static Map<Object, zzey<?, ?>> zzaib = new ConcurrentHashMap();
    protected zzhs zzahz = zzhs.zzwq();
    private int zzaia = -1;

    public static abstract class zza<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdh<MessageType, BuilderType> {
        private final MessageType zzahw;
        protected MessageType zzahx;
        private boolean zzahy = false;

        protected zza(MessageType messagetype) {
            this.zzahw = messagetype;
            this.zzahx = (zzey) messagetype.zza(zzd.zzaig, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzuc() {
            if (this.zzahy) {
                MessageType messagetype = (zzey) this.zzahx.zza(zzd.zzaig, (Object) null, (Object) null);
                zza(messagetype, this.zzahx);
                this.zzahx = messagetype;
                this.zzahy = false;
            }
        }

        public final boolean isInitialized() {
            return zzey.zza(this.zzahx, false);
        }

        /* renamed from: zzud */
        public MessageType zzuf() {
            if (this.zzahy) {
                return this.zzahx;
            }
            this.zzahx.zzry();
            this.zzahy = true;
            return this.zzahx;
        }

        /* renamed from: zzue */
        public final MessageType zzug() {
            MessageType messagetype = (zzey) zzuf();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzhq(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzuc();
            zza(this.zzahx, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgt.zzvy().zzw(messagetype).zzc(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzel zzel) throws zzfi {
            zzuc();
            try {
                zzgt.zzvy().zzw(this.zzahx).zza(this.zzahx, bArr, 0, i2 + 0, new zzdk(zzel));
                return this;
            } catch (zzfi e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzfi.zzut();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        private final BuilderType zzb(zzeb zzeb, zzel zzel) throws IOException {
            zzuc();
            try {
                zzgt.zzvy().zzw(this.zzahx).zza(this.zzahx, zzec.zza(zzeb), zzel);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzdh zza(byte[] bArr, int i, int i2, zzel zzel) throws zzfi {
            zzb(bArr, 0, i2, zzel);
            return this;
        }

        public final /* synthetic */ zzdh zza(zzeb zzeb, zzel zzel) throws IOException {
            zzb(zzeb, zzel);
            return this;
        }

        public final /* synthetic */ zzdh zzru() {
            return (zza) clone();
        }

        public final /* synthetic */ zzgi zzuh() {
            return this.zzahw;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzahw.zza(zzd.zzaih, (Object) null, (Object) null);
            zza.zza((MessageType) (zzey) zzuf());
            return zza;
        }
    }

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzey<MessageType, BuilderType> implements zzgk {
        protected zzeo<Object> zzaic = zzeo.zztr();

        /* access modifiers changed from: 0000 */
        public final zzeo<Object> zzuq() {
            if (this.zzaic.isImmutable()) {
                this.zzaic = (zzeo) this.zzaic.clone();
            }
            return this.zzaic;
        }
    }

    public static class zzc<T extends zzey<T, ?>> extends zzdg<T> {
        private final T zzahw;

        public zzc(T t) {
            this.zzahw = t;
        }

        public final /* synthetic */ Object zzc(zzeb zzeb, zzel zzel) throws zzfi {
            return zzey.zza(this.zzahw, zzeb, zzel);
        }
    }

    /* 'enum' access flag removed */
    public static final class zzd {
        public static final int zzaid = 1;
        public static final int zzaie = 2;
        public static final int zzaif = 3;
        public static final int zzaig = 4;
        public static final int zzaih = 5;
        public static final int zzaii = 6;
        public static final int zzaij = 7;
        private static final /* synthetic */ int[] zzaik = {zzaid, zzaie, zzaif, zzaig, zzaih, zzaii, zzaij};
        public static final int zzail = 1;
        public static final int zzaim = 2;
        public static final int zzaio = 1;
        public static final int zzaip = 2;

        static {
            int[] iArr = {zzail, zzaim};
            int[] iArr2 = {zzaio, zzaip};
        }

        public static int[] zzur() {
            return (int[]) zzaik.clone();
        }
    }

    public static class zze<ContainingType extends zzgi, Type> extends zzek<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzgj.zza(this, super.toString());
    }

    public int hashCode() {
        int i = this.zzact;
        if (i != 0) {
            return i;
        }
        this.zzact = zzgt.zzvy().zzw(this).hashCode(this);
        return this.zzact;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzey) zza(zzd.zzaii, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzgt.zzvy().zzw(this).equals(this, (zzey) obj);
    }

    /* access modifiers changed from: protected */
    public final void zzry() {
        zzgt.zzvy().zzw(this).zzj(this);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzui() {
        return (zza) zza(zzd.zzaih, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza((T) this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzuj() {
        BuilderType buildertype = (zza) zza(zzd.zzaih, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: 0000 */
    public final int zzrt() {
        return this.zzaia;
    }

    /* access modifiers changed from: 0000 */
    public final void zzam(int i) {
        this.zzaia = i;
    }

    public final void zzb(zzee zzee) throws IOException {
        zzgt.zzvy().zzf(getClass()).zza(this, zzei.zza(zzee));
    }

    public final int zzuk() {
        if (this.zzaia == -1) {
            this.zzaia = zzgt.zzvy().zzw(this).zzt(this);
        }
        return this.zzaia;
    }

    static <T extends zzey<?, ?>> T zzd(Class<T> cls) {
        T t = (zzey) zzaib.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzey) zzaib.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzey) ((zzey) zzhv.zzh(cls)).zza(zzd.zzaii, (Object) null, (Object) null);
            if (t != null) {
                zzaib.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzey<?, ?>> void zza(Class<T> cls, T t) {
        zzaib.put(cls, t);
    }

    protected static Object zza(zzgi zzgi, String str, Object[] objArr) {
        return new zzgv(zzgi, str, objArr);
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

    protected static final <T extends zzey<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzd.zzaid, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzv = zzgt.zzvy().zzw(t).zzv(t);
        if (z) {
            t.zza(zzd.zzaie, (Object) zzv ? t : null, (Object) null);
        }
        return zzv;
    }

    protected static zzfd zzul() {
        return zzfa.zzus();
    }

    protected static zzfg zzum() {
        return zzfw.zzvk();
    }

    protected static zzfg zza(zzfg zzfg) {
        int size = zzfg.size();
        return zzfg.zzbv(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzff<E> zzun() {
        return zzgw.zzwb();
    }

    protected static <E> zzff<E> zza(zzff<E> zzff) {
        int size = zzff.size();
        return zzff.zzap(size == 0 ? 10 : size << 1);
    }

    static <T extends zzey<T, ?>> T zza(T t, zzeb zzeb, zzel zzel) throws zzfi {
        T t2 = (zzey) t.zza(zzd.zzaig, (Object) null, (Object) null);
        try {
            zzgt.zzvy().zzw(t2).zza(t2, zzec.zza(zzeb), zzel);
            t2.zzry();
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzfi) {
                throw ((zzfi) e.getCause());
            }
            throw new zzfi(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzfi) {
                throw ((zzfi) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzey<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzel zzel) throws zzfi {
        T t2 = (zzey) t.zza(zzd.zzaig, (Object) null, (Object) null);
        try {
            zzgt.zzvy().zzw(t2).zza(t2, bArr, 0, i2, new zzdk(zzel));
            t2.zzry();
            if (t2.zzact == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzfi) {
                throw ((zzfi) e.getCause());
            }
            throw new zzfi(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzfi.zzut().zzg(t2);
        }
    }

    protected static <T extends zzey<T, ?>> T zza(T t, byte[] bArr, zzel zzel) throws zzfi {
        T zza2 = zza(t, bArr, 0, bArr.length, zzel);
        if (zza2 == null || zza2.isInitialized()) {
            return zza2;
        }
        throw new zzfi(new zzhq(zza2).getMessage()).zzg(zza2);
    }

    public final /* synthetic */ zzgh zzuo() {
        zza zza2 = (zza) zza(zzd.zzaih, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzgh zzup() {
        return (zza) zza(zzd.zzaih, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgi zzuh() {
        return (zzey) zza(zzd.zzaii, (Object) null, (Object) null);
    }
}
