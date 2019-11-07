package org.jetbrains.anko.db;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoException;

public final class ClassParserKt {
    private static final <T> RowParser<T> classParser() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return classParser(Object.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r7 != false) goto L_0x0056;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> org.jetbrains.anko.db.RowParser<T> classParser(@org.jetbrains.annotations.NotNull java.lang.Class<T> r11) {
        /*
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.reflect.Constructor[] r0 = r11.getDeclaredConstructors()
            java.lang.String r1 = "clazz.declaredConstructors"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x0016:
            r5 = 1
            if (r4 >= r2) goto L_0x005e
            r6 = r0[r4]
            java.lang.String r7 = "ctr"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            boolean r7 = r6.isVarArgs()
            if (r7 != 0) goto L_0x0055
            int r7 = r6.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isPublic(r7)
            if (r7 != 0) goto L_0x0031
            goto L_0x0055
        L_0x0031:
            java.lang.Class[] r7 = r6.getParameterTypes()
            if (r7 == 0) goto L_0x0055
            int r8 = r7.length
            if (r8 != 0) goto L_0x003c
            r8 = 1
            goto L_0x003d
        L_0x003c:
            r8 = 0
        L_0x003d:
            r8 = r8 ^ r5
            if (r8 == 0) goto L_0x0055
            int r8 = r7.length
            r9 = 0
        L_0x0042:
            if (r9 >= r8) goto L_0x0051
            r10 = r7[r9]
            boolean r10 = hasApplicableType(r10)
            if (r10 != 0) goto L_0x004e
            r7 = 0
            goto L_0x0052
        L_0x004e:
            int r9 = r9 + 1
            goto L_0x0042
        L_0x0051:
            r7 = 1
        L_0x0052:
            if (r7 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            if (r5 == 0) goto L_0x005b
            r1.add(r6)
        L_0x005b:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x005e:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x00a9
            int r11 = r1.size()
            if (r11 <= r5) goto L_0x009d
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r0 = r1.iterator()
        L_0x0073:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x008c
            java.lang.Object r1 = r0.next()
            r2 = r1
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.Class<org.jetbrains.anko.db.ClassParserConstructor> r3 = org.jetbrains.anko.db.ClassParserConstructor.class
            boolean r2 = r2.isAnnotationPresent(r3)
            if (r2 == 0) goto L_0x0073
            r11.add(r1)
            goto L_0x0073
        L_0x008c:
            java.lang.Object r11 = kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull(r11)
            java.lang.reflect.Constructor r11 = (java.lang.reflect.Constructor) r11
            if (r11 == 0) goto L_0x0095
            goto L_0x00a3
        L_0x0095:
            org.jetbrains.anko.AnkoException r11 = new org.jetbrains.anko.AnkoException
            java.lang.String r0 = "Several constructors are annotated with ClassParserConstructor"
            r11.<init>(r0)
            throw r11
        L_0x009d:
            java.lang.Object r11 = r1.get(r3)
            java.lang.reflect.Constructor r11 = (java.lang.reflect.Constructor) r11
        L_0x00a3:
            org.jetbrains.anko.db.ClassParserKt$classParser$1 r0 = new org.jetbrains.anko.db.ClassParserKt$classParser$1
            r0.<init>(r11)
            return r0
        L_0x00a9:
            org.jetbrains.anko.AnkoException r0 = new org.jetbrains.anko.AnkoException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can't initialize object parser for "
            r1.append(r2)
            java.lang.String r11 = r11.getCanonicalName()
            r1.append(r11)
            java.lang.String r11 = ", no acceptable constructors found"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            goto L_0x00ca
        L_0x00c9:
            throw r0
        L_0x00ca:
            goto L_0x00c9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.db.ClassParserKt.classParser(java.lang.Class):org.jetbrains.anko.db.RowParser");
    }

    private static final boolean hasApplicableType(Class<?> cls) {
        boolean z = true;
        if (cls.isPrimitive()) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) cls, (Object) String.class) && !Intrinsics.areEqual((Object) cls, (Object) CharSequence.class) && !Intrinsics.areEqual((Object) cls, (Object) Long.class) && !Intrinsics.areEqual((Object) cls, (Object) Integer.class) && !Intrinsics.areEqual((Object) cls, (Object) Byte.class) && !Intrinsics.areEqual((Object) cls, (Object) Character.class) && !Intrinsics.areEqual((Object) cls, (Object) Boolean.class) && !Intrinsics.areEqual((Object) cls, (Object) Float.class) && !Intrinsics.areEqual((Object) cls, (Object) Double.class) && !Intrinsics.areEqual((Object) cls, (Object) Short.class)) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static final Object castValue(Object obj, Class<?> cls) {
        if (obj == null && cls.isPrimitive()) {
            StringBuilder sb = new StringBuilder();
            sb.append("null can't be converted to the value of primitive type ");
            sb.append(cls.getCanonicalName());
            throw new AnkoException(sb.toString());
        } else if (obj == null || Intrinsics.areEqual((Object) cls, (Object) Object.class)) {
            return obj;
        } else {
            if (cls.isPrimitive() && Intrinsics.areEqual((Object) (Class) JavaSqliteUtils.PRIMITIVES_TO_WRAPPERS.get(cls), (Object) obj.getClass())) {
                return obj;
            }
            if ((obj instanceof Double) && (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Float.class))) {
                return Float.valueOf((float) ((Number) obj).doubleValue());
            }
            if ((obj instanceof Float) && (Intrinsics.areEqual((Object) cls, (Object) Double.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Double.class))) {
                return Double.valueOf((double) ((Number) obj).floatValue());
            }
            if ((obj instanceof Character) && CharSequence.class.isAssignableFrom(cls)) {
                return obj.toString();
            }
            if (obj instanceof Long) {
                if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Integer.class)) {
                    return Integer.valueOf((int) ((Number) obj).longValue());
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Short.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Short.class)) {
                    return Short.valueOf((short) ((int) ((Number) obj).longValue()));
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Byte.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Byte.class)) {
                    return Byte.valueOf((byte) ((int) ((Number) obj).longValue()));
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Boolean.class)) {
                    return Boolean.valueOf(!Intrinsics.areEqual(obj, (Object) Long.valueOf(0)));
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Character.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Character.class)) {
                    return Character.valueOf((char) ((int) ((Number) obj).longValue()));
                }
            }
            if (obj instanceof Integer) {
                if (Intrinsics.areEqual((Object) cls, (Object) Long.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Long.class)) {
                    return Long.valueOf((long) ((Number) obj).intValue());
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Short.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Short.class)) {
                    return Short.valueOf((short) ((Number) obj).intValue());
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Byte.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Byte.class)) {
                    return Byte.valueOf((byte) ((Number) obj).intValue());
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Boolean.class)) {
                    return Boolean.valueOf(!Intrinsics.areEqual(obj, (Object) Integer.valueOf(0)));
                }
                if (Intrinsics.areEqual((Object) cls, (Object) Character.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Character.class)) {
                    return Character.valueOf((char) ((Number) obj).intValue());
                }
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 1 && (Intrinsics.areEqual((Object) cls, (Object) Character.TYPE) || Intrinsics.areEqual((Object) cls, (Object) Character.class))) {
                    return Character.valueOf(str.charAt(0));
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Value ");
            sb2.append(obj);
            sb2.append(" of type ");
            sb2.append(obj.getClass());
            sb2.append(" can't be cast to ");
            sb2.append(cls.getCanonicalName());
            throw new AnkoException(sb2.toString());
        }
    }
}
