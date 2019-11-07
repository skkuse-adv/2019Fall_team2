package kr.co.popone.fitts.utils;

import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DateExtensionsKt {
    public static final boolean isSameDay(@NotNull Date date, @NotNull Date date2) {
        Intrinsics.checkParameterIsNotNull(date, "receiver$0");
        Intrinsics.checkParameterIsNotNull(date2, "date");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "cal1");
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "cal2");
        instance2.setTime(date2);
        if (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) {
            return true;
        }
        return false;
    }
}
