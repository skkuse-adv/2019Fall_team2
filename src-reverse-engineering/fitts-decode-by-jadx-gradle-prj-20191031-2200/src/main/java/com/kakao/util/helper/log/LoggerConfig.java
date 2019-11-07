package com.kakao.util.helper.log;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LoggerConfig {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int DEV = 0;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    /* access modifiers changed from: private */
    public Tag defaultTag;
    /* access modifiers changed from: private */
    public Set<String> ignoreStackSet;
    /* access modifiers changed from: private */
    public int printLoggerLevel;
    /* access modifiers changed from: private */
    public String stackPrefix;

    public static class Builder {
        private Tag defaultTag = Tag.DEFAULT;
        private Set<String> ignoreStackSet = new HashSet();
        private int printLoggerLevel = 0;
        private String stackPrefix;

        public Builder setDefaultTag(Tag tag) {
            this.defaultTag = tag;
            return this;
        }

        public Builder setPrintLoggerLevel(int i) {
            this.printLoggerLevel = i;
            return this;
        }

        public Builder setIgnoreSet(Set<String> set) {
            if (set == null) {
                return this;
            }
            this.ignoreStackSet = set;
            return this;
        }

        public Builder setStackPrefix(String str) {
            this.stackPrefix = str;
            return this;
        }

        public LoggerConfig build() {
            LoggerConfig loggerConfig = new LoggerConfig();
            loggerConfig.defaultTag = this.defaultTag;
            loggerConfig.printLoggerLevel = this.printLoggerLevel;
            loggerConfig.stackPrefix = this.stackPrefix;
            loggerConfig.ignoreStackSet = this.ignoreStackSet;
            return loggerConfig;
        }
    }

    public static String toSimpleStringLogLevel(int i) {
        if (i == 0) {
            return "DEV";
        }
        switch (i) {
            case 2:
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return ExifInterface.LONGITUDE_WEST;
            case 6:
                return ExifInterface.LONGITUDE_EAST;
            case 7:
                return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
            default:
                return "NONE";
        }
    }

    private String getTraceInfo() {
        return getTraceInfo(Thread.currentThread().getStackTrace());
    }

    private String getTraceInfo(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        String canonicalName = LoggerConfig.class.getCanonicalName();
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTraceElementArr[i];
            String className = stackTraceElement.getClassName();
            if (!this.ignoreStackSet.contains(className) && !className.startsWith(canonicalName)) {
                String str = this.stackPrefix;
                if (str == null || className.startsWith(str)) {
                    break;
                }
            }
            i++;
        }
        if (stackTraceElement == null) {
            return null;
        }
        String fileName = stackTraceElement.getFileName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        return String.format(Locale.getDefault(), "[%s:%s():%d]", new Object[]{fileName, methodName, Integer.valueOf(lineNumber)});
    }

    public Tag getDefaultTag() {
        return this.defaultTag;
    }

    private String getMessageWithTrace(String str) {
        String traceInfo = getTraceInfo();
        Object[] objArr = new Object[2];
        if (traceInfo == null) {
            traceInfo = "";
        }
        objArr[0] = traceInfo;
        objArr[1] = str;
        return String.format("%s %s", objArr);
    }

    public boolean isPrintLoggable(int i) {
        return i >= this.printLoggerLevel;
    }

    public String getMessage(boolean z, String str) {
        return z ? getMessageWithTrace(str) : str;
    }
}
