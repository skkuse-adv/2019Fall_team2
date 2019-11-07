package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder.Factory;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataRewinderRegistry {
    private static final Factory<?> DEFAULT_FACTORY = new Factory<Object>() {
        @NonNull
        public DataRewinder<Object> build(@NonNull Object obj) {
            return new DefaultRewinder(obj);
        }

        @NonNull
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };
    private final Map<Class<?>, Factory<?>> rewinders = new HashMap();

    private static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object data;

        public void cleanup() {
        }

        DefaultRewinder(@NonNull Object obj) {
            this.data = obj;
        }

        @NonNull
        public Object rewindAndGet() {
            return this.data;
        }
    }

    public synchronized void register(@NonNull Factory<?> factory) {
        this.rewinders.put(factory.getDataClass(), factory);
    }

    @NonNull
    public synchronized <T> DataRewinder<T> build(@NonNull T t) {
        Factory factory;
        Preconditions.checkNotNull(t);
        factory = (Factory) this.rewinders.get(t.getClass());
        if (factory == null) {
            Iterator it = this.rewinders.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Factory factory2 = (Factory) it.next();
                if (factory2.getDataClass().isAssignableFrom(t.getClass())) {
                    factory = factory2;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = DEFAULT_FACTORY;
        }
        return factory.build(t);
    }
}
