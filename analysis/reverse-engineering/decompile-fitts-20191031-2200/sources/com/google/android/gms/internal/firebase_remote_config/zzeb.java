package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzeb {
    private static final Object zzir;

    @Deprecated
    public static RuntimeException zzb(Throwable th) {
        zzdt.checkNotNull(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new RuntimeException(th);
        }
    }

    private static Object zzck() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzcl() {
        try {
            Method zza = zza("getStackTraceDepth", Throwable.class);
            if (zza == null) {
                return null;
            }
            zza.invoke(zzck(), new Object[]{new Throwable()});
            return zza;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Method zza(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        Object zzck = zzck();
        zzir = zzck;
        if (zzck != null) {
            zza("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (zzir != null) {
            zzcl();
        }
    }
}
