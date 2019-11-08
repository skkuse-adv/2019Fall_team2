package kr.co.popone.fitts.utils;

import java.text.NumberFormat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class IntExtensionsKt {
    @NotNull
    public static final String commaString(int i) {
        String format = NumberFormat.getIntegerInstance().format(Integer.valueOf(i));
        Intrinsics.checkExpressionValueIsNotNull(format, "NumberFormat.getIntegerInstance().format(this)");
        return format;
    }

    @NotNull
    public static final String commaString(long j) {
        String format = NumberFormat.getIntegerInstance().format(j);
        Intrinsics.checkExpressionValueIsNotNull(format, "NumberFormat.getIntegerInstance().format(this)");
        return format;
    }

    @NotNull
    public static final String percentString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        return sb.toString();
    }

    @NotNull
    public static final String percentString(double d) {
        StringBuilder sb = new StringBuilder();
        sb.append(MathKt__MathJVMKt.roundToInt(d));
        sb.append('%');
        return sb.toString();
    }
}
