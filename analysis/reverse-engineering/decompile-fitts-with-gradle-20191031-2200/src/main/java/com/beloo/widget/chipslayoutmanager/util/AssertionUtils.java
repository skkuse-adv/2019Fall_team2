package com.beloo.widget.chipslayoutmanager.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AssertionUtils {
    public static <T> void assertNotNull(@Nullable T t, @NonNull String str) throws AssertionError {
        if (t == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" can't be null.");
            throw new AssertionError(sb.toString());
        }
    }

    public static <T> void assertInstanceOf(@NonNull T t, @NonNull Class<?> cls, @NonNull String str) throws AssertionError {
        boolean z = !cls.isInstance(t);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" is not instance of ");
        sb.append(cls.getName());
        sb.append(".");
        check(z, sb.toString());
    }

    public static <T> void assertNotEquals(@NonNull T t, @NonNull T t2, @NonNull String str) throws AssertionError {
        boolean z = t == t2 || t.equals(t2);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" can't be equal to ");
        sb.append(String.valueOf(t2));
        sb.append(".");
        check(z, sb.toString());
    }

    public static void assertNotEmpty(String str, String str2) throws AssertionError {
        boolean z = TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim());
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(" can't be empty.");
        check(z, sb.toString());
    }

    public static void check(boolean z, @NonNull String str) {
        if (z) {
            throw new AssertionError(str);
        }
    }
}
