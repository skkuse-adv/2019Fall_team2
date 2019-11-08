package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

abstract class AbstractComponentContainer implements ComponentContainer {
    AbstractComponentContainer() {
    }

    public <T> T get(Class<T> cls) {
        Provider provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public <T> Set<T> setOf(Class<T> cls) {
        return (Set) setOfProvider(cls).get();
    }
}
