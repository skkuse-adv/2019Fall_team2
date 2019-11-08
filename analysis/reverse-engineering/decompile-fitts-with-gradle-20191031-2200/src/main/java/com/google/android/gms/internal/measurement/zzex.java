package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzel;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzex<T extends zzel> {
    private static final Logger logger = Logger.getLogger(zzee.class.getName());
    private static String zzahv = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzex() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzub();

    static <T extends zzel> T zzc(Class<T> cls) {
        String str;
        Class<zzex> cls2 = zzex.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(zzel.class)) {
            str = zzahv;
        } else if (cls.getPackage().equals(cls2.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzel) cls.cast(((zzex) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzub());
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException(e4);
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzex) it.next()).zzub()));
                } catch (ServiceConfigurationError e5) {
                    ServiceConfigurationError serviceConfigurationError = e5;
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String str2 = "Unable to load ";
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (zzel) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzel) cls.getMethod("combine", new Class[]{Collection.class}).invoke(null, new Object[]{arrayList});
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
