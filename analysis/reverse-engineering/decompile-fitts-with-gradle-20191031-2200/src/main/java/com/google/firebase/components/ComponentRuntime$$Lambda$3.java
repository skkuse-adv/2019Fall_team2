package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

final /* synthetic */ class ComponentRuntime$$Lambda$3 implements Provider {
    private static final ComponentRuntime$$Lambda$3 instance = new ComponentRuntime$$Lambda$3();

    private ComponentRuntime$$Lambda$3() {
    }

    public static Provider lambdaFactory$() {
        return instance;
    }

    public Object get() {
        return Collections.emptySet();
    }
}
