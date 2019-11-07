package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;

public class Strings {
    @Nullable
    public static String emptyToNull(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean isEmptyOrWhitespace(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }

    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }
}
