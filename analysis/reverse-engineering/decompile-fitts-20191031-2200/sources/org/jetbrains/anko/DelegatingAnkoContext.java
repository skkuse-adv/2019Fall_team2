package org.jetbrains.anko;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DelegatingAnkoContext<T extends ViewGroup> implements AnkoContext<T> {
    @NotNull
    private final Context ctx;
    @NotNull
    private final T owner;
    @NotNull
    private final View view = getOwner();

    public DelegatingAnkoContext(@NotNull T t) {
        Intrinsics.checkParameterIsNotNull(t, "owner");
        this.owner = t;
        Context context = getOwner().getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "owner.context");
        this.ctx = context;
    }

    @NotNull
    public T getOwner() {
        return this.owner;
    }

    public void removeView(@NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        DefaultImpls.removeView(this, view2);
    }

    public void updateViewLayout(@NotNull View view2, @NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        Intrinsics.checkParameterIsNotNull(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        DefaultImpls.updateViewLayout(this, view2, layoutParams);
    }

    @NotNull
    public Context getCtx() {
        return this.ctx;
    }

    @NotNull
    public View getView() {
        return this.view;
    }

    public void addView(@Nullable View view2, @Nullable LayoutParams layoutParams) {
        if (view2 != null) {
            if (layoutParams == null) {
                getOwner().addView(view2);
            } else {
                getOwner().addView(view2, layoutParams);
            }
        }
    }
}
