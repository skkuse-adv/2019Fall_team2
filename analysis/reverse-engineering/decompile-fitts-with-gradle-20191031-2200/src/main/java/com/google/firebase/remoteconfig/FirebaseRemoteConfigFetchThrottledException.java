package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    private final long zzjo;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this("Fetch was throttled.", j);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
        this.zzjo = j;
    }

    public long getThrottleEndTimeMillis() {
        return this.zzjo;
    }
}
