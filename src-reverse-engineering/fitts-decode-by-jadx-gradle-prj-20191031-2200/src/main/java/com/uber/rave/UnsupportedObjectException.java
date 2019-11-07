package com.uber.rave;

import java.util.List;

public final class UnsupportedObjectException extends RaveException {
    public UnsupportedObjectException(List<RaveError> list) {
        super(list);
    }
}
