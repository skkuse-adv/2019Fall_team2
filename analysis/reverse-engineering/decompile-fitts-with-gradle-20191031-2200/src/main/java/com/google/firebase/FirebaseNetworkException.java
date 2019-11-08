package com.google.firebase;

import androidx.annotation.NonNull;

public class FirebaseNetworkException extends FirebaseException {
    public FirebaseNetworkException(@NonNull String str) {
        super(str);
    }
}
