package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public class ApiExceptionUtil {
    @NonNull
    public static ApiException fromStatus(@NonNull Status status) {
        if (status.hasResolution()) {
            return new ResolvableApiException(status);
        }
        return new ApiException(status);
    }
}
