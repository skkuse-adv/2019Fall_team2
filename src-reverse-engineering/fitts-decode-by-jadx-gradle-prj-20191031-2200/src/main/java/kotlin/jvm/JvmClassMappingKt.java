package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

public final class JvmClassMappingKt {
    public static /* synthetic */ void java$annotations(KClass kClass) {
    }

    public static /* synthetic */ void javaClass$annotations(KClass kClass) {
    }

    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "receiver$0");
        Class<T> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass != null) {
            return jClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Class<T> getJavaPrimitiveType(@org.jetbrains.annotations.NotNull kotlin.reflect.KClass<T> r1) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            kotlin.jvm.internal.ClassBasedDeclarationContainer r1 = (kotlin.jvm.internal.ClassBasedDeclarationContainer) r1
            java.lang.Class r1 = r1.getJClass()
            boolean r0 = r1.isPrimitive()
            if (r0 == 0) goto L_0x001c
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.Class<T>"
            r1.<init>(r0)
            throw r1
        L_0x001c:
            java.lang.String r1 = r1.getName()
            if (r1 != 0) goto L_0x0024
            goto L_0x0090
        L_0x0024:
            int r0 = r1.hashCode()
            switch(r0) {
                case -2056817302: goto L_0x0085;
                case -527879800: goto L_0x007a;
                case -515992664: goto L_0x006f;
                case 155276373: goto L_0x0064;
                case 344809556: goto L_0x0059;
                case 398507100: goto L_0x004e;
                case 398795216: goto L_0x0043;
                case 399092968: goto L_0x0038;
                case 761287205: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0090
        L_0x002d:
            java.lang.String r0 = "java.lang.Double"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Double.TYPE
            goto L_0x0091
        L_0x0038:
            java.lang.String r0 = "java.lang.Void"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Void.TYPE
            goto L_0x0091
        L_0x0043:
            java.lang.String r0 = "java.lang.Long"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Long.TYPE
            goto L_0x0091
        L_0x004e:
            java.lang.String r0 = "java.lang.Byte"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Byte.TYPE
            goto L_0x0091
        L_0x0059:
            java.lang.String r0 = "java.lang.Boolean"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Boolean.TYPE
            goto L_0x0091
        L_0x0064:
            java.lang.String r0 = "java.lang.Character"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Character.TYPE
            goto L_0x0091
        L_0x006f:
            java.lang.String r0 = "java.lang.Short"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Short.TYPE
            goto L_0x0091
        L_0x007a:
            java.lang.String r0 = "java.lang.Float"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Float.TYPE
            goto L_0x0091
        L_0x0085:
            java.lang.String r0 = "java.lang.Integer"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0090
            java.lang.Class r1 = java.lang.Integer.TYPE
            goto L_0x0091
        L_0x0090:
            r1 = 0
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.JvmClassMappingKt.getJavaPrimitiveType(kotlin.reflect.KClass):java.lang.Class");
    }

    @NotNull
    public static final <T> Class<T> getJavaObjectType(@NotNull KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "receiver$0");
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        String str = "null cannot be cast to non-null type java.lang.Class<T>";
        if (jClass.isPrimitive()) {
            String name = jClass.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            jClass = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            jClass = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            jClass = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            jClass = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            jClass = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            jClass = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            jClass = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            jClass = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            jClass = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (jClass != null) {
                return jClass;
            }
            throw new TypeCastException(str);
        } else if (jClass != null) {
            return jClass;
        } else {
            throw new TypeCastException(str);
        }
    }

    @NotNull
    public static final <T> KClass<T> getKotlinClass(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "receiver$0");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Class<T> cls = t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    @NotNull
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "receiver$0");
        Class<KClass<T>> cls = kClass.getClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }

    @NotNull
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Class annotationType = t.annotationType();
        Intrinsics.checkExpressionValueIsNotNull(annotationType, "(this as java.lang.annot…otation).annotationType()");
        KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        if (kotlinClass != null) {
            return kotlinClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
