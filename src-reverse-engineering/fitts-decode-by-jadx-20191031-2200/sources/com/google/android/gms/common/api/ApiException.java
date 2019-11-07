package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiException extends Exception {
    protected final Status mStatus;

    public ApiException(@NonNull Status status) {
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(statusMessage).length() + 13);
        sb.append(statusCode);
        sb.append(": ");
        sb.append(statusMessage);
        super(sb.toString());
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    @Nullable
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
