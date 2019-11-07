package org.jetbrains.anko;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ReusableAnkoContext<T> extends AnkoContextImpl<T> {
    @NotNull
    private final Context ctx;
    private final T owner;

    /* access modifiers changed from: protected */
    public void alreadyHasView() {
    }

    @NotNull
    public Context getCtx() {
        return this.ctx;
    }

    public T getOwner() {
        return this.owner;
    }

    public ReusableAnkoContext(@NotNull Context context, T t, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        super(context, t, z);
        this.ctx = context;
        this.owner = t;
    }
}
