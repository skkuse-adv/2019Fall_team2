package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SystemPropsKt {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static final int getAVAILABLE_PROCESSORS() {
        return AVAILABLE_PROCESSORS;
    }

    @Nullable
    public static final String systemProp(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final boolean systemProp(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        try {
            String property = System.getProperty(str);
            return property != null ? Boolean.parseBoolean(property) : z;
        } catch (SecurityException unused) {
            return z;
        }
    }

    public static /* synthetic */ int systemProp$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return systemProp(str, i, i2, i3);
    }

    public static final int systemProp(@NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        return (int) systemProp(str, (long) i, (long) i2, (long) i3);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return systemProp(str, j, j4, j3);
    }

    public static final long systemProp(@NotNull String str, long j, long j2, long j3) {
        Intrinsics.checkParameterIsNotNull(str, "propertyName");
        String systemProp = systemProp(str);
        if (systemProp == null) {
            return j;
        }
        Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(systemProp);
        String str2 = "System property '";
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (j2 <= longValue && j3 >= longValue) {
                return longValue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            sb.append("' should be in range ");
            sb.append(j2);
            sb.append("..");
            sb.append(j3);
            sb.append(", but is '");
            sb.append(longValue);
            sb.append('\'');
            throw new IllegalStateException(sb.toString().toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        sb2.append("' has unrecognized value '");
        sb2.append(systemProp);
        sb2.append('\'');
        throw new IllegalStateException(sb2.toString().toString());
    }
}
