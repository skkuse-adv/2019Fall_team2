package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

class ApplicationLifecycle implements Lifecycle {
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
    }

    ApplicationLifecycle() {
    }

    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
