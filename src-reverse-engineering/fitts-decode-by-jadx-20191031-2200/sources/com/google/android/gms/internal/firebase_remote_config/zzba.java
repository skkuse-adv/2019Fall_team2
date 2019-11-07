package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzbc.zza;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class zzba {
    private static WeakHashMap<Class<?>, Field> zzdd = new WeakHashMap<>();
    private static final Lock zzde = new ReentrantLock();

    public abstract void close() throws IOException;

    public abstract int getIntValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract zzaw zzay();

    public abstract zzbg zzaz() throws IOException;

    public abstract zzbg zzba();

    public abstract String zzbb() throws IOException;

    public abstract zzba zzbc() throws IOException;

    public abstract byte zzbd() throws IOException;

    public abstract short zzbe() throws IOException;

    public abstract float zzbf() throws IOException;

    public abstract long zzbg() throws IOException;

    public abstract double zzbh() throws IOException;

    public abstract BigInteger zzbi() throws IOException;

    public abstract BigDecimal zzbj() throws IOException;

    public final <T> T zza(Class<T> cls, zzau zzau) throws IOException {
        try {
            return zza(cls, false, null);
        } finally {
            close();
        }
    }

    public final String zza(Set<String> set) throws IOException {
        zzbg zzbl = zzbl();
        while (zzbl == zzbg.FIELD_NAME) {
            String text = getText();
            zzaz();
            if (set.contains(text)) {
                return text;
            }
            zzbc();
            zzbl = zzaz();
        }
        return null;
    }

    private final zzbg zzbk() throws IOException {
        zzbg zzba = zzba();
        if (zzba == null) {
            zzba = zzaz();
        }
        if (zzba != null) {
            return zzba;
        }
        throw new IllegalArgumentException("no JSON input found");
    }

    private final zzbg zzbl() throws IOException {
        zzbg zzbk = zzbk();
        int i = zzbd.zzdg[zzbk.ordinal()];
        boolean z = true;
        if (i == 1) {
            zzbg zzaz = zzaz();
            if (!(zzaz == zzbg.FIELD_NAME || zzaz == zzbg.END_OBJECT)) {
                z = false;
            }
            if (z) {
                return zzaz;
            }
            throw new IllegalArgumentException(String.valueOf(zzaz));
        } else if (i != 2) {
            return zzbk;
        } else {
            return zzaz();
        }
    }

    public final Object zza(Type type, boolean z, zzau zzau) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                zzbk();
            }
            return zza(null, type, new ArrayList(), null, null, true);
        } finally {
            if (z) {
                close();
            }
        }
    }

    private final void zza(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, zzau zzau) throws IOException {
        zzbg zzbl = zzbl();
        while (zzbl == zzbg.FIELD_NAME) {
            String text = getText();
            zzaz();
            if (zzau == null) {
                map.put(text, zza(field, type, arrayList, map, zzau, true));
                zzbl = zzaz();
            } else {
                throw new NoSuchMethodError();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x01cd A[Catch:{ IllegalArgumentException -> 0x045a }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01d7 A[Catch:{ IllegalArgumentException -> 0x045a }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01ff A[Catch:{ IllegalArgumentException -> 0x045a }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0252 A[Catch:{ IllegalArgumentException -> 0x045a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object zza(java.lang.reflect.Field r20, java.lang.reflect.Type r21, java.util.ArrayList<java.lang.reflect.Type> r22, java.lang.Object r23, com.google.android.gms.internal.firebase_remote_config.zzau r24, boolean r25) throws java.io.IOException {
        /*
            r19 = this;
            r8 = r20
            r0 = r22
            r1 = r21
            java.lang.reflect.Type r9 = com.google.android.gms.internal.firebase_remote_config.zzbt.zza(r0, r1)
            boolean r1 = r9 instanceof java.lang.Class
            r10 = 0
            if (r1 == 0) goto L_0x0013
            r1 = r9
            java.lang.Class r1 = (java.lang.Class) r1
            goto L_0x0014
        L_0x0013:
            r1 = r10
        L_0x0014:
            boolean r2 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x001f
            r1 = r9
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.lang.Class r1 = com.google.android.gms.internal.firebase_remote_config.zzco.zza(r1)
        L_0x001f:
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            if (r1 != r2) goto L_0x0027
            r19.zzbc()
            return r10
        L_0x0027:
            com.google.android.gms.internal.firebase_remote_config.zzbg r2 = r19.zzba()
            int[] r3 = com.google.android.gms.internal.firebase_remote_config.zzbd.zzdg     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzbg r4 = r19.zzba()     // Catch:{ IllegalArgumentException -> 0x045a }
            int r4 = r4.ordinal()     // Catch:{ IllegalArgumentException -> 0x045a }
            r3 = r3[r4]     // Catch:{ IllegalArgumentException -> 0x045a }
            r11 = 0
            r12 = 1
            switch(r3) {
                case 1: goto L_0x025c;
                case 2: goto L_0x01e1;
                case 3: goto L_0x01e1;
                case 4: goto L_0x025c;
                case 5: goto L_0x025c;
                case 6: goto L_0x01b1;
                case 7: goto L_0x01b1;
                case 8: goto L_0x00ef;
                case 9: goto L_0x00ef;
                case 10: goto L_0x0090;
                case 11: goto L_0x0040;
                default: goto L_0x003c;
            }     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x003c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x0437
        L_0x0040:
            if (r1 == 0) goto L_0x0048
            boolean r2 = r1.isPrimitive()     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 != 0) goto L_0x0049
        L_0x0048:
            r11 = 1
        L_0x0049:
            java.lang.String r2 = "primitive number field but found a JSON null"
            if (r11 == 0) goto L_0x008a
            if (r1 == 0) goto L_0x0081
            int r2 = r1.getModifiers()     // Catch:{ IllegalArgumentException -> 0x045a }
            r2 = r2 & 1536(0x600, float:2.152E-42)
            if (r2 == 0) goto L_0x0081
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = com.google.android.gms.internal.firebase_remote_config.zzco.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 == 0) goto L_0x006c
            java.util.Collection r0 = com.google.android.gms.internal.firebase_remote_config.zzbt.zzb(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Class r0 = r0.getClass()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_remote_config.zzbt.zzd(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x006c:
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = com.google.android.gms.internal.firebase_remote_config.zzco.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 == 0) goto L_0x0081
            java.util.Map r0 = com.google.android.gms.internal.firebase_remote_config.zzbt.zze(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Class r0 = r0.getClass()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_remote_config.zzbt.zzd(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x0081:
            java.lang.Class r0 = com.google.android.gms.internal.firebase_remote_config.zzco.zzb(r0, r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_remote_config.zzbt.zzd(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x008a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0090:
            java.lang.String r0 = r19.getText()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r0 = r0.trim()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r0 = r0.toLowerCase(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Class r2 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == r2) goto L_0x00ae
            java.lang.Class<java.lang.Float> r2 = java.lang.Float.class
            if (r1 == r2) goto L_0x00ae
            java.lang.Class r2 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == r2) goto L_0x00ae
            java.lang.Class<java.lang.Double> r2 = java.lang.Double.class
            if (r1 != r2) goto L_0x00c6
        L_0x00ae:
            java.lang.String r2 = "nan"
            boolean r2 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 != 0) goto L_0x00e6
            java.lang.String r2 = "infinity"
            boolean r2 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 != 0) goto L_0x00e6
            java.lang.String r2 = "-infinity"
            boolean r0 = r0.equals(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 != 0) goto L_0x00e6
        L_0x00c6:
            if (r1 == 0) goto L_0x00da
            java.lang.Class<java.lang.Number> r0 = java.lang.Number.class
            boolean r0 = r0.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 == 0) goto L_0x00da
            if (r8 == 0) goto L_0x00db
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzbe> r0 = com.google.android.gms.internal.firebase_remote_config.zzbe.class
            java.lang.annotation.Annotation r0 = r8.getAnnotation(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 == 0) goto L_0x00db
        L_0x00da:
            r11 = 1
        L_0x00db:
            java.lang.String r0 = "number field formatted as a JSON string must use the @JsonString annotation"
            if (r11 == 0) goto L_0x00e0
            goto L_0x00e6
        L_0x00e0:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            r1.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r1     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x00e6:
            java.lang.String r0 = r19.getText()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_remote_config.zzbt.zza(r9, r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x00ef:
            if (r8 == 0) goto L_0x00f9
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzbe> r0 = com.google.android.gms.internal.firebase_remote_config.zzbe.class
            java.lang.annotation.Annotation r0 = r8.getAnnotation(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 != 0) goto L_0x00fa
        L_0x00f9:
            r11 = 1
        L_0x00fa:
            java.lang.String r0 = "number type formatted as a JSON number cannot use @JsonString annotation"
            if (r11 == 0) goto L_0x01ab
            if (r1 == 0) goto L_0x01a6
            java.lang.Class<java.math.BigDecimal> r0 = java.math.BigDecimal.class
            boolean r0 = r1.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 == 0) goto L_0x010a
            goto L_0x01a6
        L_0x010a:
            java.lang.Class<java.math.BigInteger> r0 = java.math.BigInteger.class
            if (r1 != r0) goto L_0x0113
            java.math.BigInteger r0 = r19.zzbi()     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x0113:
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            if (r1 == r0) goto L_0x019d
            java.lang.Class r0 = java.lang.Double.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r0) goto L_0x011d
            goto L_0x019d
        L_0x011d:
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            if (r1 == r0) goto L_0x0194
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r0) goto L_0x0127
            goto L_0x0194
        L_0x0127:
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            if (r1 == r0) goto L_0x018b
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r0) goto L_0x0130
            goto L_0x018b
        L_0x0130:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            if (r1 == r0) goto L_0x0182
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r0) goto L_0x0139
            goto L_0x0182
        L_0x0139:
            java.lang.Class<java.lang.Short> r0 = java.lang.Short.class
            if (r1 == r0) goto L_0x0179
            java.lang.Class r0 = java.lang.Short.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r0) goto L_0x0142
            goto L_0x0179
        L_0x0142:
            java.lang.Class<java.lang.Byte> r0 = java.lang.Byte.class
            if (r1 == r0) goto L_0x0170
            java.lang.Class r0 = java.lang.Byte.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r0) goto L_0x014b
            goto L_0x0170
        L_0x014b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x045a }
            int r2 = r2 + 30
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x045a }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r2 = "expected numeric type but got "
            r3.append(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            r3.append(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0170:
            byte r0 = r19.zzbd()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x0179:
            short r0 = r19.zzbe()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Short r0 = java.lang.Short.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x0182:
            int r0 = r19.getIntValue()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x018b:
            float r0 = r19.zzbf()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x0194:
            long r0 = r19.zzbg()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x019d:
            double r0 = r19.zzbh()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x01a6:
            java.math.BigDecimal r0 = r19.zzbj()     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x01ab:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            r1.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r1     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x01b1:
            if (r9 == 0) goto L_0x01c4
            java.lang.Class r0 = java.lang.Boolean.TYPE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == r0) goto L_0x01c4
            if (r1 == 0) goto L_0x01c2
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            boolean r0 = r1.isAssignableFrom(r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 == 0) goto L_0x01c2
            goto L_0x01c4
        L_0x01c2:
            r0 = 0
            goto L_0x01c5
        L_0x01c4:
            r0 = 1
        L_0x01c5:
            java.lang.String r1 = "expected type Boolean or boolean but got %s"
            java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x045a }
            r3[r11] = r9     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r0 == 0) goto L_0x01d7
            com.google.android.gms.internal.firebase_remote_config.zzbg r0 = com.google.android.gms.internal.firebase_remote_config.zzbg.VALUE_TRUE     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 != r0) goto L_0x01d4
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x01d4:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x01d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = com.google.android.gms.internal.firebase_remote_config.zzdy.zza(r1, r3)     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x01e1:
            boolean r13 = com.google.android.gms.internal.firebase_remote_config.zzco.zzc(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r9 == 0) goto L_0x01f6
            if (r13 != 0) goto L_0x01f6
            if (r1 == 0) goto L_0x01f4
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = com.google.android.gms.internal.firebase_remote_config.zzco.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 == 0) goto L_0x01f4
            goto L_0x01f6
        L_0x01f4:
            r2 = 0
            goto L_0x01f7
        L_0x01f6:
            r2 = 1
        L_0x01f7:
            java.lang.String r3 = "expected collection or array type but got %s"
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x045a }
            r4[r11] = r9     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 == 0) goto L_0x0252
            if (r24 == 0) goto L_0x020a
            if (r8 != 0) goto L_0x0204
            goto L_0x020a
        L_0x0204:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x020a:
            java.util.Collection r11 = com.google.android.gms.internal.firebase_remote_config.zzbt.zzb(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r13 == 0) goto L_0x0215
            java.lang.reflect.Type r10 = com.google.android.gms.internal.firebase_remote_config.zzco.zzd(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x0223
        L_0x0215:
            if (r1 == 0) goto L_0x0223
            java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
            boolean r1 = r2.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == 0) goto L_0x0223
            java.lang.reflect.Type r10 = com.google.android.gms.internal.firebase_remote_config.zzco.zze(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0223:
            java.lang.reflect.Type r9 = com.google.android.gms.internal.firebase_remote_config.zzbt.zza(r0, r10)     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzbg r1 = r19.zzbl()     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x022b:
            com.google.android.gms.internal.firebase_remote_config.zzbg r2 = com.google.android.gms.internal.firebase_remote_config.zzbg.END_ARRAY     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == r2) goto L_0x0246
            r7 = 1
            r1 = r19
            r2 = r20
            r3 = r9
            r4 = r22
            r5 = r11
            r6 = r24
            java.lang.Object r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x045a }
            r11.add(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzbg r1 = r19.zzaz()     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x022b
        L_0x0246:
            if (r13 == 0) goto L_0x0251
            java.lang.Class r0 = com.google.android.gms.internal.firebase_remote_config.zzco.zzb(r0, r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Object r0 = com.google.android.gms.internal.firebase_remote_config.zzco.zza(r11, r0)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x0251:
            return r11
        L_0x0252:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = com.google.android.gms.internal.firebase_remote_config.zzdy.zza(r3, r4)     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x025c:
            boolean r2 = com.google.android.gms.internal.firebase_remote_config.zzco.zzc(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 != 0) goto L_0x0264
            r2 = 1
            goto L_0x0265
        L_0x0264:
            r2 = 0
        L_0x0265:
            java.lang.String r3 = "expected object or map type but got %s"
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x045a }
            r4[r11] = r9     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 == 0) goto L_0x042d
            if (r25 == 0) goto L_0x0275
            java.lang.reflect.Field r2 = zzb(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            r13 = r2
            goto L_0x0276
        L_0x0275:
            r13 = r10
        L_0x0276:
            if (r1 == 0) goto L_0x0281
            if (r24 != 0) goto L_0x027b
            goto L_0x0281
        L_0x027b:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0281:
            if (r1 == 0) goto L_0x028d
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = com.google.android.gms.internal.firebase_remote_config.zzco.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 == 0) goto L_0x028d
            r2 = 1
            goto L_0x028e
        L_0x028d:
            r2 = 0
        L_0x028e:
            if (r13 == 0) goto L_0x0296
            com.google.android.gms.internal.firebase_remote_config.zzax r3 = new com.google.android.gms.internal.firebase_remote_config.zzax     // Catch:{ IllegalArgumentException -> 0x045a }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x02a4
        L_0x0296:
            if (r2 != 0) goto L_0x02a0
            if (r1 != 0) goto L_0x029b
            goto L_0x02a0
        L_0x029b:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_remote_config.zzco.zzf(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x02a4
        L_0x02a0:
            java.util.Map r3 = com.google.android.gms.internal.firebase_remote_config.zzbt.zze(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x02a4:
            r14 = r3
            int r15 = r22.size()     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r9 == 0) goto L_0x02ae
            r0.add(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x02ae:
            if (r2 == 0) goto L_0x02d8
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzby> r2 = com.google.android.gms.internal.firebase_remote_config.zzby.class
            boolean r2 = r2.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r2 != 0) goto L_0x02d8
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r1 = r2.isAssignableFrom(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == 0) goto L_0x02c6
            java.lang.reflect.Type r1 = com.google.android.gms.internal.firebase_remote_config.zzco.zzf(r9)     // Catch:{ IllegalArgumentException -> 0x045a }
            r4 = r1
            goto L_0x02c7
        L_0x02c6:
            r4 = r10
        L_0x02c7:
            if (r4 == 0) goto L_0x02d8
            r3 = r14
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ IllegalArgumentException -> 0x045a }
            r1 = r19
            r2 = r20
            r5 = r22
            r6 = r24
            r1.zza(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r14
        L_0x02d8:
            boolean r1 = r14 instanceof com.google.android.gms.internal.firebase_remote_config.zzax     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == 0) goto L_0x02e6
            r1 = r14
            com.google.android.gms.internal.firebase_remote_config.zzax r1 = (com.google.android.gms.internal.firebase_remote_config.zzax) r1     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzaw r2 = r19.zzay()     // Catch:{ IllegalArgumentException -> 0x045a }
            r1.zza(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x02e6:
            com.google.android.gms.internal.firebase_remote_config.zzbg r1 = r19.zzbl()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Class r2 = r14.getClass()     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzbr r7 = com.google.android.gms.internal.firebase_remote_config.zzbr.zzc(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzby> r3 = com.google.android.gms.internal.firebase_remote_config.zzby.class
            boolean r16 = r3.isAssignableFrom(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r16 != 0) goto L_0x0317
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r3 == 0) goto L_0x0317
            r3 = r14
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ IllegalArgumentException -> 0x045a }
            r4 = 0
            java.lang.reflect.Type r5 = com.google.android.gms.internal.firebase_remote_config.zzco.zzf(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            r1 = r19
            r2 = r4
            r4 = r5
            r5 = r22
            r6 = r24
            r1.zza(r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x03a0
        L_0x0317:
            com.google.android.gms.internal.firebase_remote_config.zzbg r2 = com.google.android.gms.internal.firebase_remote_config.zzbg.FIELD_NAME     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 != r2) goto L_0x03a0
            java.lang.String r6 = r19.getText()     // Catch:{ IllegalArgumentException -> 0x045a }
            r19.zzaz()     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r24 != 0) goto L_0x039a
            com.google.android.gms.internal.firebase_remote_config.zzbz r5 = r7.zzae(r6)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r5 == 0) goto L_0x036c
            boolean r1 = r5.zzca()     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == 0) goto L_0x033f
            boolean r1 = r5.isPrimitive()     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == 0) goto L_0x0337
            goto L_0x033f
        L_0x0337:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = "final array/object fields are not supported"
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x033f:
            java.lang.reflect.Field r2 = r5.zzbz()     // Catch:{ IllegalArgumentException -> 0x045a }
            int r6 = r22.size()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.reflect.Type r1 = r2.getGenericType()     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.add(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.reflect.Type r3 = r5.getGenericType()     // Catch:{ IllegalArgumentException -> 0x045a }
            r17 = 1
            r1 = r19
            r4 = r22
            r10 = r5
            r5 = r14
            r11 = r6
            r6 = r24
            r18 = r7
            r7 = r17
            java.lang.Object r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.remove(r11)     // Catch:{ IllegalArgumentException -> 0x045a }
            r10.zzb(r14, r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x038b
        L_0x036c:
            r18 = r7
            if (r16 == 0) goto L_0x0386
            r10 = r14
            com.google.android.gms.internal.firebase_remote_config.zzby r10 = (com.google.android.gms.internal.firebase_remote_config.zzby) r10     // Catch:{ IllegalArgumentException -> 0x045a }
            r2 = 0
            r3 = 0
            r7 = 1
            r1 = r19
            r4 = r22
            r5 = r14
            r11 = r6
            r6 = r24
            java.lang.Object r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x045a }
            r10.zzb(r11, r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x038b
        L_0x0386:
            if (r24 != 0) goto L_0x0394
            r19.zzbc()     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x038b:
            com.google.android.gms.internal.firebase_remote_config.zzbg r1 = r19.zzaz()     // Catch:{ IllegalArgumentException -> 0x045a }
            r7 = r18
            r10 = 0
            r11 = 0
            goto L_0x0317
        L_0x0394:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x039a:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x03a0:
            if (r9 == 0) goto L_0x03a5
            r0.remove(r15)     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x03a5:
            if (r13 != 0) goto L_0x03a8
            return r14
        L_0x03a8:
            r1 = r14
            com.google.android.gms.internal.firebase_remote_config.zzax r1 = (com.google.android.gms.internal.firebase_remote_config.zzax) r1     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r2 = r13.getName()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r1 == 0) goto L_0x03b7
            r2 = 1
            goto L_0x03b8
        L_0x03b7:
            r2 = 0
        L_0x03b8:
            java.lang.String r3 = "No value specified for @JsonPolymorphicTypeMap field"
            if (r2 == 0) goto L_0x0427
            java.lang.String r1 = r1.toString()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.Class<com.google.android.gms.internal.firebase_remote_config.zzbc> r2 = com.google.android.gms.internal.firebase_remote_config.zzbc.class
            java.lang.annotation.Annotation r2 = r13.getAnnotation(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzbc r2 = (com.google.android.gms.internal.firebase_remote_config.zzbc) r2     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzbc$zza[] r2 = r2.zzbn()     // Catch:{ IllegalArgumentException -> 0x045a }
            int r3 = r2.length     // Catch:{ IllegalArgumentException -> 0x045a }
            r4 = 0
        L_0x03ce:
            if (r4 >= r3) goto L_0x03e5
            r5 = r2[r4]     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r6 = r5.zzbo()     // Catch:{ IllegalArgumentException -> 0x045a }
            boolean r6 = r6.equals(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r6 == 0) goto L_0x03e2
            java.lang.Class r2 = r5.zzbp()     // Catch:{ IllegalArgumentException -> 0x045a }
            r3 = r2
            goto L_0x03e6
        L_0x03e2:
            int r4 = r4 + 1
            goto L_0x03ce
        L_0x03e5:
            r3 = 0
        L_0x03e6:
            if (r3 == 0) goto L_0x03e9
            goto L_0x03ea
        L_0x03e9:
            r12 = 0
        L_0x03ea:
            java.lang.String r2 = "No TypeDef annotation found with key: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            int r4 = r1.length()     // Catch:{ IllegalArgumentException -> 0x045a }
            if (r4 == 0) goto L_0x03fb
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            goto L_0x0400
        L_0x03fb:
            java.lang.String r1 = new java.lang.String     // Catch:{ IllegalArgumentException -> 0x045a }
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0400:
            if (r12 == 0) goto L_0x041d
            com.google.android.gms.internal.firebase_remote_config.zzaw r1 = r19.zzay()     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r2 = r1.toString(r14)     // Catch:{ IllegalArgumentException -> 0x045a }
            com.google.android.gms.internal.firebase_remote_config.zzba r1 = r1.zzac(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            r1.zzbk()     // Catch:{ IllegalArgumentException -> 0x045a }
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r20
            r4 = r22
            java.lang.Object r0 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x045a }
            return r0
        L_0x041d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0427:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x042d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = com.google.android.gms.internal.firebase_remote_config.zzdy.zza(r3, r4)     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x0437:
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            int r2 = r2.length()     // Catch:{ IllegalArgumentException -> 0x045a }
            int r2 = r2 + 27
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x045a }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r2 = "unexpected JSON node type: "
            r3.append(r2)     // Catch:{ IllegalArgumentException -> 0x045a }
            r3.append(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            java.lang.String r1 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x045a }
            r0.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x045a }
            throw r0     // Catch:{ IllegalArgumentException -> 0x045a }
        L_0x045a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r19.zzbb()
            if (r2 == 0) goto L_0x046e
            java.lang.String r3 = "key "
            r1.append(r3)
            r1.append(r2)
        L_0x046e:
            if (r8 == 0) goto L_0x047f
            if (r2 == 0) goto L_0x0477
            java.lang.String r2 = ", "
            r1.append(r2)
        L_0x0477:
            java.lang.String r2 = "field "
            r1.append(r2)
            r1.append(r8)
        L_0x047f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1, r0)
            goto L_0x048a
        L_0x0489:
            throw r2
        L_0x048a:
            goto L_0x0489
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzba.zza(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, com.google.android.gms.internal.firebase_remote_config.zzau, boolean):java.lang.Object");
    }

    private static Field zzb(Class<?> cls) {
        Field field = null;
        if (cls == null) {
            return null;
        }
        zzde.lock();
        try {
            if (zzdd.containsKey(cls)) {
                return (Field) zzdd.get(cls);
            }
            for (zzbz zzbz : zzbr.zzc(cls).zzbw()) {
                Field zzbz2 = zzbz.zzbz();
                zzbc zzbc = (zzbc) zzbz2.getAnnotation(zzbc.class);
                if (zzbc != null) {
                    String str = "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s";
                    Object[] objArr = {cls};
                    if (field == null) {
                        String str2 = "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s";
                        Object[] objArr2 = {cls, zzbz2.getType()};
                        if (zzbt.zza(zzbz2.getType())) {
                            zza[] zzbn = zzbc.zzbn();
                            HashSet hashSet = new HashSet();
                            String str3 = "@JsonPolymorphicTypeMap must have at least one @TypeDef";
                            if (zzbn.length > 0) {
                                int length = zzbn.length;
                                int i = 0;
                                while (i < length) {
                                    zza zza = zzbn[i];
                                    String str4 = "Class contains two @TypeDef annotations with identical key: %s";
                                    Object[] objArr3 = {zza.zzbo()};
                                    if (hashSet.add(zza.zzbo())) {
                                        i++;
                                    } else {
                                        throw new IllegalArgumentException(zzdy.zza(str4, objArr3));
                                    }
                                }
                                field = zzbz2;
                            } else {
                                throw new IllegalArgumentException(str3);
                            }
                        } else {
                            throw new IllegalArgumentException(zzdy.zza(str2, objArr2));
                        }
                    } else {
                        throw new IllegalArgumentException(zzdy.zza(str, objArr));
                    }
                }
            }
            zzdd.put(cls, field);
            zzde.unlock();
            return field;
        } finally {
            zzde.unlock();
        }
    }
}
