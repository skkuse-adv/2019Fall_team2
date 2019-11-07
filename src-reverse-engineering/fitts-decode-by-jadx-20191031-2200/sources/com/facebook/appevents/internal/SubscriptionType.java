package com.facebook.appevents.internal;

public enum SubscriptionType {
    NEW,
    HEARTBEAT,
    EXPIRE,
    CANCEL,
    RESTORE,
    DUPLICATED,
    UNKNOWN
}
