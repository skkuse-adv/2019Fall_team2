package com.jakewharton.rxbinding2.internal;

import io.reactivex.functions.Function;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

public final class VoidToUnit implements Function<Object, Unit> {
    public static final VoidToUnit INSTANCE = new VoidToUnit();

    public void apply(@Nullable Object obj) {
    }

    private VoidToUnit() {
    }
}
