package kotlin.internal;

import com.facebook.internal.NativeProtocol;
import kotlin.KotlinVersion;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PlatformImplementationsKt {
    @NotNull
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        PlatformImplementations platformImplementations;
        Object newInstance;
        Object newInstance2;
        Class<PlatformImplementations> cls = PlatformImplementations.class;
        int javaVersion = getJavaVersion();
        String str = "ClassCastException(\"Inst…baseTypeCL\").initCause(e)";
        String str2 = ", base type classloader: ";
        String str3 = "Instance classloader: ";
        String str4 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
        String str5 = "Class.forName(\"kotlin.in…entations\").newInstance()";
        if (javaVersion >= 65544) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                Intrinsics.checkExpressionValueIsNotNull(newInstance2, str5);
                if (newInstance2 != null) {
                    platformImplementations = (PlatformImplementations) newInstance2;
                    IMPLEMENTATIONS = platformImplementations;
                }
                throw new TypeCastException(str4);
            } catch (ClassCastException e) {
                ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader2 = cls.getClassLoader();
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(classLoader);
                sb.append(str2);
                sb.append(classLoader2);
                Throwable initCause = new ClassCastException(sb.toString()).initCause(e);
                Intrinsics.checkExpressionValueIsNotNull(initCause, str);
                throw initCause;
            } catch (ClassNotFoundException unused) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    Intrinsics.checkExpressionValueIsNotNull(newInstance3, str5);
                    if (newInstance3 != null) {
                        try {
                            platformImplementations = (PlatformImplementations) newInstance3;
                        } catch (ClassCastException e2) {
                            ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader4 = cls.getClassLoader();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(classLoader3);
                            sb2.append(str2);
                            sb2.append(classLoader4);
                            Throwable initCause2 = new ClassCastException(sb2.toString()).initCause(e2);
                            Intrinsics.checkExpressionValueIsNotNull(initCause2, str);
                            throw initCause2;
                        }
                    } else {
                        throw new TypeCastException(str4);
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        if (javaVersion >= 65543) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                Intrinsics.checkExpressionValueIsNotNull(newInstance, str5);
                if (newInstance != null) {
                    platformImplementations = (PlatformImplementations) newInstance;
                    IMPLEMENTATIONS = platformImplementations;
                }
                throw new TypeCastException(str4);
            } catch (ClassCastException e3) {
                ClassLoader classLoader5 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader6 = cls.getClassLoader();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(classLoader5);
                sb3.append(str2);
                sb3.append(classLoader6);
                Throwable initCause3 = new ClassCastException(sb3.toString()).initCause(e3);
                Intrinsics.checkExpressionValueIsNotNull(initCause3, str);
                throw initCause3;
            } catch (ClassNotFoundException unused3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    Intrinsics.checkExpressionValueIsNotNull(newInstance4, str5);
                    if (newInstance4 != null) {
                        try {
                            platformImplementations = (PlatformImplementations) newInstance4;
                        } catch (ClassCastException e4) {
                            ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                            ClassLoader classLoader8 = cls.getClassLoader();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str3);
                            sb4.append(classLoader7);
                            sb4.append(str2);
                            sb4.append(classLoader8);
                            Throwable initCause4 = new ClassCastException(sb4.toString()).initCause(e4);
                            Intrinsics.checkExpressionValueIsNotNull(initCause4, str);
                            throw initCause4;
                        }
                    } else {
                        throw new TypeCastException(str4);
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
        }
        platformImplementations = new PlatformImplementations();
        IMPLEMENTATIONS = platformImplementations;
    }

    private static final int getJavaVersion() {
        String property = System.getProperty("java.specification.version");
        int i = NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            try {
                i = Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
            }
            return i;
        }
        int i2 = indexOf$default + 1;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', i2, false, 4, (Object) null);
        if (indexOf$default2 < 0) {
            indexOf$default2 = property.length();
        }
        String str = "null cannot be cast to non-null type java.lang.String";
        if (property != null) {
            String substring = property.substring(0, indexOf$default);
            String str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            Intrinsics.checkExpressionValueIsNotNull(substring, str2);
            if (property != null) {
                String substring2 = property.substring(i2, indexOf$default2);
                Intrinsics.checkExpressionValueIsNotNull(substring2, str2);
                try {
                    i = (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                } catch (NumberFormatException unused2) {
                }
                return i;
            }
            throw new TypeCastException(str);
        }
        throw new TypeCastException(str);
    }

    public static final boolean apiVersionIsAtLeast(int i, int i2, int i3) {
        return KotlinVersion.CURRENT.isAtLeast(i, i2, i3);
    }
}
