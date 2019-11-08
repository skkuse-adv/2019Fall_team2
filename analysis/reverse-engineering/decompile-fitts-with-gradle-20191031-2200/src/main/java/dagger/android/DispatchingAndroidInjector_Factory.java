package dagger.android;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class DispatchingAndroidInjector_Factory<T> implements Factory<DispatchingAndroidInjector<T>> {
    private final Provider<Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>>> injectorFactoriesProvider;

    public DispatchingAndroidInjector_Factory(Provider<Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>>> provider) {
        this.injectorFactoriesProvider = provider;
    }

    public DispatchingAndroidInjector<T> get() {
        return provideInstance(this.injectorFactoriesProvider);
    }

    public static <T> DispatchingAndroidInjector<T> provideInstance(Provider<Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>>> provider) {
        return new DispatchingAndroidInjector<>((Map) provider.get());
    }

    public static <T> DispatchingAndroidInjector_Factory<T> create(Provider<Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>>> provider) {
        return new DispatchingAndroidInjector_Factory<>(provider);
    }

    public static <T> DispatchingAndroidInjector<T> newDispatchingAndroidInjector(Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>> map) {
        return new DispatchingAndroidInjector<>(map);
    }
}
