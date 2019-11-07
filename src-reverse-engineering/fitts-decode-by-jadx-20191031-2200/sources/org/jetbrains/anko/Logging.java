package org.jetbrains.anko;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.kakao.usermgmt.StringSet;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Logging {
    @NotNull
    public static final AnkoLogger AnkoLogger(@NotNull Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clazz");
        return new Logging$AnkoLogger$1(cls);
    }

    @NotNull
    public static final AnkoLogger AnkoLogger(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, StringSet.tag);
        return new Logging$AnkoLogger$2(str);
    }

    private static final <T> AnkoLogger AnkoLogger() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return AnkoLogger(Object.class);
    }

    public static /* synthetic */ void verbose$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        verbose(ankoLogger, obj, th);
    }

    public static /* synthetic */ void debug$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        debug(ankoLogger, obj, th);
    }

    public static /* synthetic */ void info$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        info(ankoLogger, obj, th);
    }

    public static /* synthetic */ void warn$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        warn(ankoLogger, obj, th);
    }

    public static /* synthetic */ void error$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        error(ankoLogger, obj, th);
    }

    public static /* synthetic */ void wtf$default(AnkoLogger ankoLogger, Object obj, Throwable th, int i, Object obj2) {
        if ((i & 2) != 0) {
            th = null;
        }
        wtf(ankoLogger, obj, th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r2 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r2 != null) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void wtf(@org.jetbrains.annotations.NotNull org.jetbrains.anko.AnkoLogger r1, @org.jetbrains.annotations.Nullable java.lang.Object r2, @org.jetbrains.annotations.Nullable java.lang.Throwable r3) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "null"
            if (r3 == 0) goto L_0x001b
            java.lang.String r1 = r1.getLoggerTag()
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r2 = r0
        L_0x0017:
            android.util.Log.wtf(r1, r2, r3)
            goto L_0x002c
        L_0x001b:
            java.lang.String r1 = r1.getLoggerTag()
            if (r2 == 0) goto L_0x0028
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r2 = r0
        L_0x0029:
            android.util.Log.wtf(r1, r2)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.Logging.wtf(org.jetbrains.anko.AnkoLogger, java.lang.Object, java.lang.Throwable):void");
    }

    public static final void verbose(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (Log.isLoggable(ankoLogger.getLoggerTag(), 2)) {
            Object invoke = function0.invoke();
            if (invoke != null) {
                String obj = invoke.toString();
            }
        }
    }

    public static final void debug(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (Log.isLoggable(ankoLogger.getLoggerTag(), 3)) {
            Object invoke = function0.invoke();
            if (invoke != null) {
                String obj = invoke.toString();
            }
        }
    }

    public static final void info(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (Log.isLoggable(ankoLogger.getLoggerTag(), 4)) {
            Object invoke = function0.invoke();
            if (invoke != null) {
                String obj = invoke.toString();
            }
        }
    }

    public static final void warn(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (Log.isLoggable(ankoLogger.getLoggerTag(), 5)) {
            Object invoke = function0.invoke();
            if (invoke != null) {
                String obj = invoke.toString();
            }
        }
    }

    public static final void error(@NotNull AnkoLogger ankoLogger, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (Log.isLoggable(ankoLogger.getLoggerTag(), 6)) {
            Object invoke = function0.invoke();
            if (invoke != null) {
                String obj = invoke.toString();
            }
        }
    }

    @NotNull
    public static final String getStackTraceString(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "receiver$0");
        String stackTraceString = Log.getStackTraceString(th);
        Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(this)");
        return stackTraceString;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r1 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r1 != null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void log(org.jetbrains.anko.AnkoLogger r0, java.lang.Object r1, java.lang.Throwable r2, int r3, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> r4, kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> r5) {
        /*
            java.lang.String r0 = r0.getLoggerTag()
            boolean r3 = android.util.Log.isLoggable(r0, r3)
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = "null"
            if (r2 == 0) goto L_0x001c
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = r3
        L_0x0018:
            r5.invoke(r0, r1, r2)
            goto L_0x0029
        L_0x001c:
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r3
        L_0x0026:
            r4.invoke(r0, r1)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jetbrains.anko.Logging.log(org.jetbrains.anko.AnkoLogger, java.lang.Object, java.lang.Throwable, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3):void");
    }

    /* access modifiers changed from: private */
    public static final String getTag(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        int length = simpleName.length();
        String str = StringSet.tag;
        if (length <= 23) {
            Intrinsics.checkExpressionValueIsNotNull(simpleName, str);
            return simpleName;
        }
        Intrinsics.checkExpressionValueIsNotNull(simpleName, str);
        if (simpleName != null) {
            String substring = simpleName.substring(0, 23);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void verbose(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        if (!Log.isLoggable(ankoLogger.getLoggerTag(), 2)) {
            return;
        }
        if (th != null) {
            if (obj != null) {
                String obj2 = obj.toString();
            }
        } else if (obj != null) {
            String obj3 = obj.toString();
        }
    }

    public static final void debug(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        if (!Log.isLoggable(ankoLogger.getLoggerTag(), 3)) {
            return;
        }
        if (th != null) {
            if (obj != null) {
                String obj2 = obj.toString();
            }
        } else if (obj != null) {
            String obj3 = obj.toString();
        }
    }

    public static final void info(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        if (!Log.isLoggable(ankoLogger.getLoggerTag(), 4)) {
            return;
        }
        if (th != null) {
            if (obj != null) {
                String obj2 = obj.toString();
            }
        } else if (obj != null) {
            String obj3 = obj.toString();
        }
    }

    public static final void warn(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        if (!Log.isLoggable(ankoLogger.getLoggerTag(), 5)) {
            return;
        }
        if (th != null) {
            if (obj != null) {
                String obj2 = obj.toString();
            }
        } else if (obj != null) {
            String obj3 = obj.toString();
        }
    }

    public static final void error(@NotNull AnkoLogger ankoLogger, @Nullable Object obj, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(ankoLogger, "receiver$0");
        if (!Log.isLoggable(ankoLogger.getLoggerTag(), 6)) {
            return;
        }
        if (th != null) {
            if (obj != null) {
                String obj2 = obj.toString();
            }
        } else if (obj != null) {
            String obj3 = obj.toString();
        }
    }
}
