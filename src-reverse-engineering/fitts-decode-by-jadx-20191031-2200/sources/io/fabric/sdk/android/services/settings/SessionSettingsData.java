package io.fabric.sdk.android.services.settings;

public class SessionSettingsData {
    public final int identifierMask;
    public final int logBufferSize;
    public final int maxChainedExceptionDepth;
    public final int maxCompleteSessionsCount;
    public final int maxCustomExceptionEvents;
    public final int maxCustomKeyValuePairs;
    public final boolean sendSessionWithoutCrash;

    public SessionSettingsData(int i, int i2, int i3, int i4, int i5, boolean z, int i6) {
        this.logBufferSize = i;
        this.maxChainedExceptionDepth = i2;
        this.maxCustomExceptionEvents = i3;
        this.maxCustomKeyValuePairs = i4;
        this.identifierMask = i5;
        this.sendSessionWithoutCrash = z;
        this.maxCompleteSessionsCount = i6;
    }
}
