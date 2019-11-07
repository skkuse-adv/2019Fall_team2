package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi;
import com.google.android.gms.internal.firebase_remote_config.zzhi.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzhi<MessageType extends zzhi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzfq<MessageType, BuilderType> {
    private static Map<Object, zzhi<?, ?>> zzte = new ConcurrentHashMap();
    protected zzka zztc = zzka.zzja();
    private int zztd = -1;

    public static class zza<T extends zzhi<T, ?>> extends zzfs<T> {
        public zza(T t) {
        }
    }

    public static abstract class zzb<MessageType extends zzhi<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzfp<MessageType, BuilderType> {
        private final MessageType zztg;
        private MessageType zzth;
        private boolean zzti = false;

        protected zzb(MessageType messagetype) {
            this.zztg = messagetype;
            this.zzth = (zzhi) messagetype.zzb(zze.zztp, null, null);
        }

        public final boolean isInitialized() {
            return zzhi.zza(this.zzth, false);
        }

        /* renamed from: zzgy */
        public MessageType zzha() {
            if (this.zzti) {
                return this.zzth;
            }
            this.zzth.zzes();
            this.zzti = true;
            return this.zzth;
        }

        /* renamed from: zzgz */
        public final MessageType zzhb() {
            MessageType messagetype = (zzhi) zzha();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzjy(messagetype);
        }

        /* renamed from: zzb */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzti) {
                MessageType messagetype2 = (zzhi) this.zzth.zzb(zze.zztp, null, null);
                zza(messagetype2, this.zzth);
                this.zzth = messagetype2;
                this.zzti = false;
            }
            zza(this.zzth, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjb.zzii().zzz(messagetype).zze(messagetype, messagetype2);
        }

        public final /* synthetic */ zzfp zzeo() {
            return (zzb) clone();
        }

        public final /* synthetic */ zziq zzgw() {
            return this.zztg;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) this.zztg.zzb(zze.zztq, null, null);
            zzb.zza((zzhi) zzha());
            return zzb;
        }
    }

    public static class zzc<ContainingType extends zziq, Type> extends zzgw<ContainingType, Type> {
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzhi<MessageType, BuilderType> implements zzis {
        protected zzha<Object> zztj = zzha.zzgi();

        /* access modifiers changed from: 0000 */
        public final zzha<Object> zzhc() {
            if (this.zztj.isImmutable()) {
                this.zztj = (zzha) this.zztj.clone();
            }
            return this.zztj;
        }
    }

    /* 'enum' access flag removed */
    public static final class zze {
        public static final int zztm = 1;
        public static final int zztn = 2;
        public static final int zzto = 3;
        public static final int zztp = 4;
        public static final int zztq = 5;
        public static final int zztr = 6;
        public static final int zzts = 7;
        private static final /* synthetic */ int[] zztt = {zztm, zztn, zzto, zztp, zztq, zztr, zzts};
        public static final int zztu = 1;
        public static final int zztv = 2;
        public static final int zztx = 1;
        public static final int zzty = 2;

        static {
            int[] iArr = {zztu, zztv};
            int[] iArr2 = {zztx, zzty};
        }

        public static int[] zzhd() {
            return (int[]) zztt.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i, Object obj, Object obj2);

    public String toString() {
        return zzir.zza(this, super.toString());
    }

    public int hashCode() {
        int i = this.zzoj;
        if (i != 0) {
            return i;
        }
        this.zzoj = zzjb.zzii().zzz(this).hashCode(this);
        return this.zzoj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzhi) zzb(zze.zztr, null, null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzjb.zzii().zzz(this).equals(this, (zzhi) obj);
    }

    /* access modifiers changed from: protected */
    public final void zzes() {
        zzjb.zzii().zzz(this).zzm(this);
    }

    public final boolean isInitialized() {
        return zza((T) this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: 0000 */
    public final int zzeq() {
        return this.zztd;
    }

    /* access modifiers changed from: 0000 */
    public final void zzr(int i) {
        this.zztd = i;
    }

    public final void zzb(zzgs zzgs) throws IOException {
        zzjb.zzii().zzk(getClass()).zza(this, zzgu.zza(zzgs));
    }

    public final int zzgs() {
        if (this.zztd == -1) {
            this.zztd = zzjb.zzii().zzz(this).zzw(this);
        }
        return this.zztd;
    }

    static <T extends zzhi<?, ?>> T zzg(Class<T> cls) {
        T t = (zzhi) zzte.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzhi) zzte.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzhi) ((zzhi) zzkd.zzm(cls)).zzb(zze.zztr, null, null);
            if (t != null) {
                zzte.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzhi<?, ?>> void zza(Class<T> cls, T t) {
        zzte.put(cls, t);
    }

    protected static Object zza(zziq zziq, String str, Object[] objArr) {
        return new zzjd(zziq, str, objArr);
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

    protected static final <T extends zzhi<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zzb(zze.zztm, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzy = zzjb.zzii().zzz(t).zzy(t);
        if (z) {
            t.zzb(zze.zztn, zzy ? t : null, null);
        }
        return zzy;
    }

    protected static <E> zzhn<E> zzgt() {
        return zzje.zzil();
    }

    private static <T extends zzhi<T, ?>> T zza(T t, zzgj zzgj, zzgx zzgx) throws zzhq {
        T t2 = (zzhi) t.zzb(zze.zztp, null, null);
        try {
            zzjb.zzii().zzz(t2).zza(t2, zzgq.zza(zzgj), zzgx);
            t2.zzes();
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzhq) {
                throw ((zzhq) e.getCause());
            }
            throw new zzhq(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzhq) {
                throw ((zzhq) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzhi<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzgx zzgx) throws zzhq {
        T t2 = (zzhi) t.zzb(zze.zztp, null, null);
        try {
            zzjb.zzii().zzz(t2).zza(t2, bArr, 0, i2, new zzfw(zzgx));
            t2.zzes();
            if (t2.zzoj == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzhq) {
                throw ((zzhq) e.getCause());
            }
            throw new zzhq(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhq.zzhe().zzg(t2);
        }
    }

    private static <T extends zzhi<T, ?>> T zza(T t) throws zzhq {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzhq(new zzjy(t).getMessage()).zzg(t);
    }

    protected static <T extends zzhi<T, ?>> T zza(T t, byte[] bArr) throws zzhq {
        T zza2 = zza(t, bArr, 0, bArr.length, zzgx.zzgh());
        zza(zza2);
        return zza2;
    }

    protected static <T extends zzhi<T, ?>> T zza(T t, InputStream inputStream) throws zzhq {
        zzgj zzgj;
        if (inputStream == null) {
            byte[] bArr = zzhm.zzua;
            zzgj = zzgj.zza(bArr, 0, bArr.length, false);
        } else {
            zzgj = new zzgo(inputStream);
        }
        T zza2 = zza(t, zzgj, zzgx.zzgh());
        zza(zza2);
        return zza2;
    }

    public final /* synthetic */ zzip zzgu() {
        zzb zzb2 = (zzb) zzb(zze.zztq, null, null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzip zzgv() {
        return (zzb) zzb(zze.zztq, null, null);
    }

    public final /* synthetic */ zziq zzgw() {
        return (zzhi) zzb(zze.zztr, null, null);
    }
}
