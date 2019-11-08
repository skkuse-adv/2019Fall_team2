package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public final class zzbt {
    private static final Boolean zzes = new Boolean(true);
    private static final String zzet = new String();
    private static final Character zzeu = new Character(0);
    private static final Byte zzev = new Byte(0);
    private static final Short zzew = new Short(0);
    private static final Integer zzex = new Integer(0);
    private static final Float zzey = new Float(0.0f);
    private static final Long zzez = new Long(0);
    private static final Double zzfa = new Double(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    private static final BigInteger zzfb;
    private static final BigDecimal zzfc;
    private static final zzbw zzfd = new zzbw(0);
    private static final ConcurrentHashMap<Class<?>, Object> zzfe;

    public static <T> T zzd(Class<?> cls) {
        T t = zzfe.get(cls);
        if (t == null) {
            synchronized (zzfe) {
                t = zzfe.get(cls);
                if (t == null) {
                    int i = 0;
                    if (cls.isArray()) {
                        Class<?> cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i++;
                        } while (cls2.isArray());
                        t = Array.newInstance(cls2, new int[i]);
                    } else if (cls.isEnum()) {
                        zzbz zzae = zzbr.zzc(cls).zzae(null);
                        String str = "enum missing constant with @NullValue annotation: %s";
                        Object[] objArr = {cls};
                        if (zzae != null) {
                            t = zzae.zzcb();
                        } else {
                            throw new NullPointerException(zzdy.zza(str, objArr));
                        }
                    } else {
                        t = zzco.zzf(cls);
                    }
                    zzfe.put(cls, t);
                }
            }
        }
        return t;
    }

    public static boolean isNull(Object obj) {
        return obj != null && obj == zzfe.get(obj.getClass());
    }

    public static Map<String, Object> zzf(Object obj) {
        if (obj == null || isNull(obj)) {
            return Collections.emptyMap();
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new zzbs(obj, false);
    }

    public static <T> T clone(T t) {
        T t2;
        if (t == null || zza(t.getClass())) {
            return t;
        }
        if (t instanceof zzby) {
            return (zzby) ((zzby) t).clone();
        }
        Class cls = t.getClass();
        if (cls.isArray()) {
            t2 = Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof zzbl) {
            t2 = (zzbl) ((zzbl) t).clone();
        } else {
            if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
                Object[] array = ((List) t).toArray();
                zza((Object) array, (Object) array);
                return Arrays.asList(array);
            }
            t2 = zzco.zzf(cls);
        }
        zza((Object) t, (Object) t2);
        return t2;
    }

    public static void zza(Object obj, Object obj2) {
        Class cls = obj.getClass();
        boolean z = true;
        int i = 0;
        if (!(cls == obj2.getClass())) {
            throw new IllegalArgumentException();
        } else if (cls.isArray()) {
            if (Array.getLength(obj) != Array.getLength(obj2)) {
                z = false;
            }
            if (z) {
                for (Object clone : zzco.zzi(obj)) {
                    int i2 = i + 1;
                    Array.set(obj2, i, clone(clone));
                    i = i2;
                }
                return;
            }
            throw new IllegalArgumentException();
        } else if (Collection.class.isAssignableFrom(cls)) {
            Collection<Object> collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            for (Object clone2 : collection) {
                collection2.add(clone(clone2));
            }
        } else {
            boolean isAssignableFrom = zzby.class.isAssignableFrom(cls);
            if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
                zzbr zzc = isAssignableFrom ? ((zzby) obj).zzay : zzbr.zzc(cls);
                for (String zzae : zzc.zzer) {
                    zzbz zzae2 = zzc.zzae(zzae);
                    if (!zzae2.zzca() && (!isAssignableFrom || !zzae2.isPrimitive())) {
                        Object zzh = zzae2.zzh(obj);
                        if (zzh != null) {
                            zzae2.zzb(obj2, clone(zzh));
                        }
                    }
                }
            } else if (zzbl.class.isAssignableFrom(cls)) {
                zzbl zzbl = (zzbl) obj2;
                zzbl zzbl2 = (zzbl) obj;
                int size = zzbl2.size();
                while (i < size) {
                    zzbl.set(i, clone(zzbl2.zzg(i)));
                    i++;
                }
            } else {
                Map map = (Map) obj2;
                for (Entry entry : ((Map) obj).entrySet()) {
                    map.put((String) entry.getKey(), clone(entry.getValue()));
                }
            }
        }
    }

    public static boolean zza(Type type) {
        if (type instanceof WildcardType) {
            type = zzco.zza((WildcardType) type);
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Class<Boolean> cls = (Class) type;
        if (cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == zzbw.class || cls == Boolean.class) {
            return true;
        }
        return false;
    }

    public static boolean zzg(Object obj) {
        return obj == null || zza(obj.getClass());
    }

    public static Object zza(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls == Character.class || cls == Character.TYPE) {
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                String valueOf = String.valueOf(cls);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37);
                sb.append("expected type Character/char but got ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            } else if (cls == Boolean.class || cls == Boolean.TYPE) {
                return Boolean.valueOf(str);
            } else {
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(str);
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(str);
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(str);
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(str);
                }
                if (cls == Float.class || cls == Float.TYPE) {
                    return Float.valueOf(str);
                }
                if (cls == Double.class || cls == Double.TYPE) {
                    return Double.valueOf(str);
                }
                if (cls == zzbw.class) {
                    return zzbw.zzaf(str);
                }
                if (cls == BigInteger.class) {
                    return new BigInteger(str);
                }
                if (cls == BigDecimal.class) {
                    return new BigDecimal(str);
                }
                if (cls.isEnum()) {
                    if (zzbr.zzc(cls).zzer.contains(str)) {
                        return zzbr.zzc(cls).zzae(str).zzcb();
                    }
                    throw new IllegalArgumentException(String.format("given enum name %s not part of enumeration", new Object[]{str}));
                }
            }
        }
        String valueOf2 = String.valueOf(type);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 35);
        sb2.append("expected primitive class, but got: ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static Collection<Object> zzb(Type type) {
        if (type instanceof WildcardType) {
            type = zzco.zza((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls == null) {
            String valueOf = String.valueOf(type);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
            sb.append("unable to create new instance of type: ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        } else if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        } else {
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            return (Collection) zzco.zzf(cls);
        }
    }

    public static Map<String, Object> zze(Class<?> cls) {
        if (cls == null || cls.isAssignableFrom(zzbl.class)) {
            return new zzbl();
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
        }
        return (Map) zzco.zzf(cls);
    }

    public static Type zza(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = zzco.zza((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type zza = zzco.zza(list, (TypeVariable) type);
            if (zza != null) {
                type = zza;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }

    static {
        String str = "0";
        zzfb = new BigInteger(str);
        zzfc = new BigDecimal(str);
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = new ConcurrentHashMap<>();
        zzfe = concurrentHashMap;
        concurrentHashMap.put(Boolean.class, zzes);
        zzfe.put(String.class, zzet);
        zzfe.put(Character.class, zzeu);
        zzfe.put(Byte.class, zzev);
        zzfe.put(Short.class, zzew);
        zzfe.put(Integer.class, zzex);
        zzfe.put(Float.class, zzey);
        zzfe.put(Long.class, zzez);
        zzfe.put(Double.class, zzfa);
        zzfe.put(BigInteger.class, zzfb);
        zzfe.put(BigDecimal.class, zzfc);
        zzfe.put(zzbw.class, zzfd);
    }
}
