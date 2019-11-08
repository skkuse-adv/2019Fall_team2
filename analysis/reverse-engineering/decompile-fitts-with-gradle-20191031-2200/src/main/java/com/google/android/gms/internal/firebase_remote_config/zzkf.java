package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class zzkf implements PrivilegedExceptionAction<Unsafe> {
    zzkf() {
    }

    public final /* synthetic */ Object run() throws Exception {
        Field[] declaredFields;
        Class<Unsafe> cls = Unsafe.class;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (cls.isInstance(obj)) {
                return (Unsafe) cls.cast(obj);
            }
        }
        return null;
    }
}
