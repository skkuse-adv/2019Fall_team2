package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import java.util.Locale;
import java.util.Map;

class AnswersEventValidator {
    boolean failFast;
    final int maxNumAttributes;
    final int maxStringLength;

    public AnswersEventValidator(int i, int i2, boolean z) {
        this.maxNumAttributes = i;
        this.maxStringLength = i2;
        this.failFast = z;
    }

    public String limitStringLength(String str) {
        int length = str.length();
        int i = this.maxStringLength;
        if (length <= i) {
            return str;
        }
        logOrThrowException(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", new Object[]{Integer.valueOf(i)})));
        return str.substring(0, this.maxStringLength);
    }

    public boolean isNull(Object obj, String str) {
        if (obj != null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" must not be null");
        logOrThrowException(new NullPointerException(sb.toString()));
        return true;
    }

    public boolean isFullMap(Map<String, Object> map, String str) {
        if (map.size() < this.maxNumAttributes || map.containsKey(str)) {
            return false;
        }
        logOrThrowException(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", new Object[]{Integer.valueOf(this.maxNumAttributes)})));
        return true;
    }

    private void logOrThrowException(RuntimeException runtimeException) {
        if (!this.failFast) {
            Fabric.getLogger().e(Answers.TAG, "Invalid user input detected", runtimeException);
            return;
        }
        throw runtimeException;
    }
}
