package com.kakao.util.helper.log;

import android.util.Log;
import com.kakao.util.helper.FileUtils;
import com.kakao.util.helper.log.LoggerConfig.Builder;
import java.util.HashSet;
import java.util.Locale;

public class Logger {
    private static final int LOG_SEGMENT_SIZE = 2000;
    private static final LoggerConfig loggerConfig = initLogConfig();
    private static boolean withStack = false;

    private Logger() {
    }

    private static LoggerConfig initLogConfig() {
        Builder printLoggerLevel = new Builder().setDefaultTag(Tag.DEFAULT).setStackPrefix(FileUtils.DEFAULT_SDK_DIRECTORY_PATH).setPrintLoggerLevel(5);
        HashSet hashSet = new HashSet();
        hashSet.add(Logger.class.getName());
        printLoggerLevel.setIgnoreSet(hashSet);
        return printLoggerLevel.build();
    }

    private static int printLog(Tag tag, int i, String str) {
        int i2 = 0;
        if (str == null) {
            return 0;
        }
        String message = loggerConfig.getMessage(withStack, str);
        if (!loggerConfig.isPrintLoggable(i)) {
            return 0;
        }
        if (message == null) {
            message = loggerConfig.getMessage(withStack, str);
        }
        if (message == null) {
            return 0;
        }
        String tag2 = tag.tag();
        int length = message.length();
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = length - i2;
            if (i5 > 2000) {
                i5 = 2000;
            }
            int i6 = i5 + i2;
            i3 += printLogPartially(i, tag2, message.substring(i2, i6), i4);
            i2 = i6;
            i4++;
        }
        return i3;
    }

    private static int printLogPartially(int i, String str, String str2, int i2) {
        String str3;
        int length = str2.length();
        if (i2 > 0) {
            str3 = String.format(Locale.getDefault(), "Cont(%d) ", new Object[]{Integer.valueOf(i2)});
        } else {
            str3 = "";
        }
        if (length > 2000) {
            str2 = str2.substring(0, 2000);
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str2);
            return Log.d(str, sb.toString());
        } else if (i == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str2);
            return Log.v(str, sb2.toString());
        } else if (i == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str2);
            return Log.d(str, sb3.toString());
        } else if (i == 4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(str2);
            return Log.i(str, sb4.toString());
        } else if (i == 5) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            sb5.append(str2);
            return Log.w(str, sb5.toString());
        } else if (i != 6) {
            return 0;
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str3);
            sb6.append(str2);
            return Log.e(str, sb6.toString());
        }
    }

    public static String getCallerTraceInfo(Class cls) {
        if (!loggerConfig.isPrintLoggable(3)) {
            return "unknown caller";
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Thread.currentThread().getName();
        StackTraceElement stackTraceElement = null;
        String name2 = cls.getName();
        int length = stackTrace.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTrace[i];
            if (stackTraceElement2.getClassName().startsWith(name2)) {
                z = true;
            } else if (z) {
                stackTraceElement = stackTraceElement2;
                break;
            }
            i++;
        }
        if (stackTraceElement == null) {
            return "";
        }
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        return String.format(Locale.US, "{%s}-[%s.%s():%d]", new Object[]{name, className, methodName, Integer.valueOf(lineNumber)});
    }

    public static String getStackTraceString(Throwable th) {
        return th == null ? "" : Log.getStackTraceString(th);
    }

    public static int vt(Tag tag, Throwable th) {
        return vt(tag, getStackTraceString(th));
    }

    public static int vt(Tag tag, String str, Throwable th) {
        return vt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int vt(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.isPrintLoggable(2)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 2, str);
    }

    public static int vt(Tag tag, String str) {
        return printLog(tag, 2, str);
    }

    public static int v(String str, Object... objArr) {
        return vt(loggerConfig.getDefaultTag(), str, objArr);
    }

    public static int v(Throwable th) {
        return vt(loggerConfig.getDefaultTag(), th);
    }

    public static int v(String str, Throwable th) {
        return vt(loggerConfig.getDefaultTag(), str, th);
    }

    public static int dt(Tag tag, Throwable th) {
        return dt(tag, getStackTraceString(th));
    }

    public static int dt(Tag tag, String str, Throwable th) {
        return dt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int dt(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.isPrintLoggable(3)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 3, str);
    }

    public static int dt(Tag tag, String str) {
        return printLog(tag, 3, str);
    }

    public static int d(String str, Object... objArr) {
        return dt(loggerConfig.getDefaultTag(), str, objArr);
    }

    public static int d(String str) {
        return dt(loggerConfig.getDefaultTag(), str);
    }

    public static int d(Throwable th) {
        return dt(loggerConfig.getDefaultTag(), th);
    }

    public static int d(String str, Throwable th) {
        return dt(loggerConfig.getDefaultTag(), str, th);
    }

    public static int it(Tag tag, Throwable th) {
        return it(tag, getStackTraceString(th));
    }

    public static int it(Tag tag, String str, Throwable th) {
        return it(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int it(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.isPrintLoggable(4)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 4, str);
    }

    public static int it(Tag tag, String str) {
        return printLog(tag, 4, str);
    }

    public static int i(String str, Object... objArr) {
        return it(loggerConfig.getDefaultTag(), str, objArr);
    }

    public static int i(Throwable th) {
        return it(loggerConfig.getDefaultTag(), th);
    }

    public static int i(String str, Throwable th) {
        return it(loggerConfig.getDefaultTag(), str, th);
    }

    public static int wt(Tag tag, Throwable th) {
        return wt(tag, getStackTraceString(th));
    }

    public static int wt(Tag tag, String str, Throwable th) {
        return wt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int wt(Tag tag, String str, Object... objArr) {
        if (loggerConfig.isPrintLoggable(5)) {
            return printLog(tag, 5, String.format(str, objArr));
        }
        return 0;
    }

    public static int wt(Tag tag, String str) {
        return printLog(tag, 5, str);
    }

    public static int w(String str, Object... objArr) {
        return wt(loggerConfig.getDefaultTag(), str, objArr);
    }

    public static int w(String str) {
        return wt(loggerConfig.getDefaultTag(), str);
    }

    public static int w(Throwable th) {
        return wt(loggerConfig.getDefaultTag(), th);
    }

    public static int w(String str, Throwable th) {
        return wt(loggerConfig.getDefaultTag(), str, th);
    }

    public static int et(Tag tag, Throwable th) {
        return et(tag, getStackTraceString(th));
    }

    public static int et(Tag tag, String str, Throwable th) {
        return et(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int et(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.isPrintLoggable(6)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 6, str);
    }

    public static int et(Tag tag, String str) {
        return printLog(tag, 6, str);
    }

    public static int e(String str, Object... objArr) {
        return et(loggerConfig.getDefaultTag(), str, objArr);
    }

    public static int e(String str) {
        return et(loggerConfig.getDefaultTag(), str);
    }

    public static int e(Throwable th) {
        return et(loggerConfig.getDefaultTag(), th);
    }

    public static int e(String str, Throwable th) {
        return et(loggerConfig.getDefaultTag(), str, th);
    }

    public static int devt(Tag tag, Throwable th) {
        return devt(tag, getStackTraceString(th));
    }

    public static int devt(Tag tag, String str, Throwable th) {
        return devt(tag, "%s\n%s", str, getStackTraceString(th));
    }

    private static int devt(Tag tag, String str, Object... objArr) {
        if (!loggerConfig.isPrintLoggable(0)) {
            return 0;
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return printLog(tag, 0, str);
    }

    public static int devt(Tag tag, String str) {
        return printLog(tag, 0, str);
    }

    public static int dev(String str, Object... objArr) {
        return devt(loggerConfig.getDefaultTag(), str, objArr);
    }

    public static int dev(String str) {
        return devt(loggerConfig.getDefaultTag(), str);
    }

    public static int dev(Throwable th) {
        return devt(loggerConfig.getDefaultTag(), th);
    }

    public static int dev(String str, Throwable th) {
        return devt(loggerConfig.getDefaultTag(), str, th);
    }
}
