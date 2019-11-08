package com.google.android.gms.common.internal;

import android.util.Log;

public final class GmsLogger {
    private final String zzeh;
    private final String zzei;

    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.zzeh = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzei = null;
        } else {
            this.zzei = str2;
        }
    }

    public final boolean canLogPii() {
        return false;
    }

    public GmsLogger(String str) {
        this(str, null);
    }

    public final boolean canLog(int i) {
        return Log.isLoggable(this.zzeh, i);
    }

    public final void d(String str, String str2) {
        if (canLog(3)) {
            zzh(str2);
        }
    }

    public final void d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            zzh(str2);
        }
    }

    public final void v(String str, String str2) {
        if (canLog(2)) {
            zzh(str2);
        }
    }

    public final void v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            zzh(str2);
        }
    }

    public final void i(String str, String str2) {
        if (canLog(4)) {
            zzh(str2);
        }
    }

    public final void i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            zzh(str2);
        }
    }

    public final void w(String str, String str2) {
        if (canLog(5)) {
            zzh(str2);
        }
    }

    public final void w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            zzh(str2);
        }
    }

    public final void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            zza(str2, objArr);
        }
    }

    public final void e(String str, String str2) {
        if (canLog(6)) {
            zzh(str2);
        }
    }

    public final void e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            zzh(str2);
        }
    }

    public final void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            zza(str2, objArr);
        }
    }

    public final void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            zzh(str2);
            Log.wtf(str, zzh(str2), th);
        }
    }

    public final void pii(String str, String str2) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String str3 = " PII_LOG";
            if (str3.length() != 0) {
                valueOf.concat(str3);
            } else {
                new String(valueOf);
            }
            zzh(str2);
        }
    }

    public final void pii(String str, String str2, Throwable th) {
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String str3 = " PII_LOG";
            if (str3.length() != 0) {
                valueOf.concat(str3);
            } else {
                new String(valueOf);
            }
            zzh(str2);
        }
    }

    private final String zzh(String str) {
        String str2 = this.zzei;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }

    private final String zza(String str, Object... objArr) {
        String format = String.format(str, objArr);
        String str2 = this.zzei;
        if (str2 == null) {
            return format;
        }
        return str2.concat(format);
    }
}
