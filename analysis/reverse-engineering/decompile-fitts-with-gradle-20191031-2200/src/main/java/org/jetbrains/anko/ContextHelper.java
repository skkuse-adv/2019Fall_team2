package org.jetbrains.anko;

import android.os.Handler;
import android.os.Looper;
import org.jetbrains.annotations.NotNull;

final class ContextHelper {
    public static final ContextHelper INSTANCE = new ContextHelper();
    @NotNull
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private ContextHelper() {
    }

    @NotNull
    public final Handler getHandler() {
        return handler;
    }
}
