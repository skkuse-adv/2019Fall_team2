package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Set;

abstract class GeneratedAppGlideModule extends AppGlideModule {
    /* access modifiers changed from: 0000 */
    @NonNull
    public abstract Set<Class<?>> getExcludedModuleClasses();

    /* access modifiers changed from: 0000 */
    @Nullable
    public RequestManagerFactory getRequestManagerFactory() {
        return null;
    }

    GeneratedAppGlideModule() {
    }
}
