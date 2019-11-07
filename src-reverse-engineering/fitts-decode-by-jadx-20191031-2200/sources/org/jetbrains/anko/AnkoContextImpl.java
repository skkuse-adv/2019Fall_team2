package org.jetbrains.anko;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.AnkoContext.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnkoContextImpl<T> implements AnkoContext<T> {
    @NotNull
    private final Context ctx;
    private View myView;
    private final T owner;
    private final boolean setContentView;

    public AnkoContextImpl(@NotNull Context context, T t, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "ctx");
        this.ctx = context;
        this.owner = t;
        this.setContentView = z;
    }

    public void removeView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        DefaultImpls.removeView(this, view);
    }

    public void updateViewLayout(@NotNull View view, @NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        DefaultImpls.updateViewLayout(this, view, layoutParams);
    }

    @NotNull
    public Context getCtx() {
        return this.ctx;
    }

    public T getOwner() {
        return this.owner;
    }

    @NotNull
    public View getView() {
        View view = this.myView;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("View was not set previously");
    }

    public void addView(@Nullable View view, @Nullable LayoutParams layoutParams) {
        if (view != null) {
            if (this.myView != null) {
                alreadyHasView();
            }
            this.myView = view;
            if (this.setContentView) {
                doAddView(getCtx(), view);
            }
        }
    }

    private final void doAddView(Context context, View view) {
        if (context instanceof Activity) {
            ((Activity) context).setContentView(view);
        } else if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkExpressionValueIsNotNull(baseContext, "context.baseContext");
            doAddView(baseContext, view);
        } else {
            throw new IllegalStateException("Context is not an Activity, can't set content view");
        }
    }

    /* access modifiers changed from: protected */
    public void alreadyHasView() {
        StringBuilder sb = new StringBuilder();
        sb.append("View is already set: ");
        sb.append(this.myView);
        throw new IllegalStateException(sb.toString());
    }
}
