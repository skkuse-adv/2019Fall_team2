package kr.co.popone.fitts.ui;

import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CalendarExtensionsKt {
    @NotNull
    public static final String dateString(@NotNull Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(1));
        sb.append('-');
        sb.append(calendar.get(2));
        sb.append('-');
        sb.append(calendar.get(6));
        return sb.toString();
    }

    @NotNull
    public static final String testDateString(@NotNull Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.get(1));
        sb.append('-');
        sb.append(calendar.get(2));
        sb.append('-');
        sb.append(calendar.get(5));
        return sb.toString();
    }
}
