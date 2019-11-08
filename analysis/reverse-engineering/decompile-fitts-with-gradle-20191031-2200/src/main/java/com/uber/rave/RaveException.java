package com.uber.rave;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class RaveException extends Exception {
    final List<RaveError> errors;

    RaveException(List<RaveError> list) {
        super(getFirstString(list));
        this.errors = list;
    }

    public final String getMessage() {
        StringBuilder sb = new StringBuilder();
        List<RaveError> list = this.errors;
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            sb.append(((RaveError) listIterator.previous()).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public final Iterator<RaveError> getRaveErrorIterator() {
        return this.errors.iterator();
    }

    private static String getFirstString(List<RaveError> list) {
        return list.isEmpty() ? "" : ((RaveError) list.get(0)).toString();
    }
}
