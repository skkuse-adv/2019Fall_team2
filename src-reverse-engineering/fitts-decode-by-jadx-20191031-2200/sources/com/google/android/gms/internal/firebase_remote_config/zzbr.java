package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class zzbr {
    private static final Map<Class<?>, zzbr> zzem = new WeakHashMap();
    private static final Map<Class<?>, zzbr> zzen = new WeakHashMap();
    private final Class<?> zzeo;
    private final boolean zzep;
    private final IdentityHashMap<String, zzbz> zzeq = new IdentityHashMap<>();
    final List<String> zzer;

    public static zzbr zzc(Class<?> cls) {
        return zza(cls, false);
    }

    public static zzbr zza(Class<?> cls, boolean z) {
        zzbr zzbr;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, zzbr> map = z ? zzen : zzem;
        synchronized (map) {
            zzbr = (zzbr) map.get(cls);
            if (zzbr == null) {
                zzbr = new zzbr(cls, z);
                map.put(cls, zzbr);
            }
        }
        return zzbr;
    }

    public final boolean zzbv() {
        return this.zzep;
    }

    public final zzbz zzae(String str) {
        if (str != null) {
            if (this.zzep) {
                str = str.toLowerCase(Locale.US);
            }
            str = str.intern();
        }
        return (zzbz) this.zzeq.get(str);
    }

    public final boolean isEnum() {
        return this.zzeo.isEnum();
    }

    private zzbr(Class<?> cls, boolean z) {
        Field[] declaredFields;
        Field field;
        this.zzeo = cls;
        this.zzep = z;
        boolean z2 = !z || !cls.isEnum();
        String valueOf = String.valueOf(cls);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("cannot ignore case on an enum: ");
        sb.append(valueOf);
        String sb2 = sb.toString();
        if (z2) {
            TreeSet treeSet = new TreeSet(new zzbq(this));
            for (Field field2 : cls.getDeclaredFields()) {
                zzbz zza = zzbz.zza(field2);
                if (zza != null) {
                    String name = zza.getName();
                    if (z) {
                        name = name.toLowerCase(Locale.US).intern();
                    }
                    zzbz zzbz = (zzbz) this.zzeq.get(name);
                    boolean z3 = zzbz == null;
                    Object[] objArr = new Object[4];
                    objArr[0] = z ? "case-insensitive " : "";
                    objArr[1] = name;
                    objArr[2] = field2;
                    if (zzbz == null) {
                        field = null;
                    } else {
                        field = zzbz.zzbz();
                    }
                    objArr[3] = field;
                    if (z3) {
                        this.zzeq.put(name, zza);
                        treeSet.add(name);
                    } else {
                        throw new IllegalArgumentException(zzdy.zza("two fields have the same %sname <%s>: %s and %s", objArr));
                    }
                }
            }
            Class superclass = cls.getSuperclass();
            if (superclass != null) {
                zzbr zza2 = zza(superclass, z);
                treeSet.addAll(zza2.zzer);
                for (Entry entry : zza2.zzeq.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!this.zzeq.containsKey(str)) {
                        this.zzeq.put(str, (zzbz) entry.getValue());
                    }
                }
            }
            this.zzer = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
            return;
        }
        throw new IllegalArgumentException(String.valueOf(sb2));
    }

    public final Collection<zzbz> zzbw() {
        return Collections.unmodifiableCollection(this.zzeq.values());
    }
}
