package com.google.firebase.iid.internal;

import androidx.annotation.Nullable;

public interface FirebaseInstanceIdInternal {
    String getId();

    @Nullable
    String getToken();
}
