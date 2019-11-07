package com.facebook.marketing.internal;

public final class RemoteConfig {
    private boolean enableButtonIndexing;

    public RemoteConfig(boolean z) {
        this.enableButtonIndexing = z;
    }

    public boolean getEnableButtonIndexing() {
        return this.enableButtonIndexing;
    }
}
