package com.crashlytics.android.core;

class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {
    private final int maximumStackSize;
    private final MiddleOutStrategy middleOutStrategy;
    private final StackTraceTrimmingStrategy[] trimmingStrategies;

    public MiddleOutFallbackStrategy(int i, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.maximumStackSize = i;
        this.trimmingStrategies = stackTraceTrimmingStrategyArr;
        this.middleOutStrategy = new MiddleOutStrategy(i);
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr;
        if (stackTraceElementArr.length <= this.maximumStackSize) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.trimmingStrategies) {
            if (stackTraceElementArr2.length <= this.maximumStackSize) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.maximumStackSize) {
            stackTraceElementArr2 = this.middleOutStrategy.getTrimmedStackTrace(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
