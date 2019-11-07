package com.jakewharton.rxbinding2.internal;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class Functions {
    private static final Always ALWAYS_TRUE = new Always(Boolean.valueOf(true));
    public static final Callable<Boolean> CALLABLE_ALWAYS_TRUE;
    public static final Predicate<Object> PREDICATE_ALWAYS_TRUE;

    private static final class Always implements Callable<Boolean>, Predicate<Object> {
        private final Boolean value;

        Always(Boolean bool) {
            this.value = bool;
        }

        public Boolean call() {
            return this.value;
        }

        public boolean test(Object obj) throws Exception {
            return this.value.booleanValue();
        }
    }

    static {
        Always always = ALWAYS_TRUE;
        CALLABLE_ALWAYS_TRUE = always;
        PREDICATE_ALWAYS_TRUE = always;
    }
}
