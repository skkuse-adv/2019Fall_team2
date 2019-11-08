package com.google.firebase.abt;

public class AbtException extends Exception {
    public AbtException(String str) {
        super(str);
    }

    public AbtException(String str, Exception exc) {
        super(str, exc);
    }
}
