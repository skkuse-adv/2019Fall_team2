package kr.co.popone.fitts.model.datamodel.action;

import androidx.lifecycle.Lifecycle;
import org.jetbrains.annotations.Nullable;

public interface LifecycleInjector {
    @Nullable
    Lifecycle getProvidedLifecycle();
}
