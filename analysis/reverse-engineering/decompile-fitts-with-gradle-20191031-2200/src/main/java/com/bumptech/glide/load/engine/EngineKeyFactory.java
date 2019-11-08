package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

class EngineKeyFactory {
    EngineKeyFactory() {
    }

    /* access modifiers changed from: 0000 */
    public EngineKey buildKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        EngineKey engineKey = new EngineKey(obj, key, i, i2, map, cls, cls2, options);
        return engineKey;
    }
}
