package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Map.Entry;

public abstract class zzaz {
    public abstract void flush() throws IOException;

    public abstract void writeBoolean(boolean z) throws IOException;

    public abstract void writeString(String str) throws IOException;

    public abstract void zza(double d) throws IOException;

    public abstract void zza(float f) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(BigDecimal bigDecimal) throws IOException;

    public abstract void zza(BigInteger bigInteger) throws IOException;

    public abstract void zzad(String str) throws IOException;

    public abstract void zzas() throws IOException;

    public abstract void zzat() throws IOException;

    public abstract void zzau() throws IOException;

    public abstract void zzav() throws IOException;

    public abstract void zzaw() throws IOException;

    public void zzax() throws IOException {
    }

    public abstract void zze(int i) throws IOException;

    public final void zzd(Object obj) throws IOException {
        zza(false, obj);
    }

    private final void zza(boolean z, Object obj) throws IOException {
        zzbr zzbr;
        boolean z2;
        Field field;
        if (obj != null) {
            Class cls = obj.getClass();
            if (zzbt.isNull(obj)) {
                zzaw();
            } else if (obj instanceof String) {
                writeString((String) obj);
            } else {
                boolean z3 = true;
                if (obj instanceof Number) {
                    if (z) {
                        writeString(obj.toString());
                    } else if (obj instanceof BigDecimal) {
                        zza((BigDecimal) obj);
                    } else if (obj instanceof BigInteger) {
                        zza((BigInteger) obj);
                    } else if (obj instanceof Long) {
                        zza(((Long) obj).longValue());
                    } else if (obj instanceof Float) {
                        float floatValue = ((Number) obj).floatValue();
                        if (Float.isInfinite(floatValue) || Float.isNaN(floatValue)) {
                            z3 = false;
                        }
                        if (z3) {
                            zza(floatValue);
                            return;
                        }
                        throw new IllegalArgumentException();
                    } else if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                        zze(((Number) obj).intValue());
                    } else {
                        double doubleValue = ((Number) obj).doubleValue();
                        if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                            z3 = false;
                        }
                        if (z3) {
                            zza(doubleValue);
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                } else if (obj instanceof Boolean) {
                    writeBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof zzbw) {
                    writeString(((zzbw) obj).zzbx());
                } else if ((obj instanceof Iterable) || cls.isArray()) {
                    zzas();
                    for (Object zza : zzco.zzi(obj)) {
                        zza(z, zza);
                    }
                    zzat();
                } else if (cls.isEnum()) {
                    String name = zzbz.zza((Enum) obj).getName();
                    if (name == null) {
                        zzaw();
                    } else {
                        writeString(name);
                    }
                } else {
                    zzau();
                    boolean z4 = (obj instanceof Map) && !(obj instanceof zzby);
                    if (z4) {
                        zzbr = null;
                    } else {
                        zzbr = zzbr.zzc(cls);
                    }
                    for (Entry entry : zzbt.zzf(obj).entrySet()) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String str = (String) entry.getKey();
                            if (z4) {
                                z2 = z;
                            } else {
                                zzbz zzae = zzbr.zzae(str);
                                if (zzae == null) {
                                    field = null;
                                } else {
                                    field = zzae.zzbz();
                                }
                                z2 = (field == null || field.getAnnotation(zzbe.class) == null) ? false : true;
                            }
                            zzad(str);
                            zza(z2, value);
                        }
                    }
                    zzav();
                }
            }
        }
    }
}
