package com.uber.rave;

import java.util.List;

public final class InvalidModelException extends RaveException {
    public InvalidModelException(List<RaveError> list) {
        super(list);
    }
}
