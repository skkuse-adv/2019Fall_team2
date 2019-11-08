package org.jetbrains.anko;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@AnkoContextDslMarker
public interface AnkoContext<T> extends ViewManager {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public static /* synthetic */ AnkoContext create$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.create(context, z);
        }

        @NotNull
        public final AnkoContext<Context> create(@NotNull Context context, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new AnkoContextImpl(context, context, z);
        }

        @NotNull
        public static /* synthetic */ AnkoContext createReusable$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createReusable(context, z);
        }

        @NotNull
        public final AnkoContext<Context> createReusable(@NotNull Context context, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new ReusableAnkoContext(context, context, z);
        }

        @NotNull
        public static /* synthetic */ AnkoContext create$default(Companion companion, Context context, Object obj, boolean z, int i, Object obj2) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.create(context, obj, z);
        }

        @NotNull
        public final <T> AnkoContext<T> create(@NotNull Context context, T t, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new AnkoContextImpl(context, t, z);
        }

        @NotNull
        public static /* synthetic */ AnkoContext createReusable$default(Companion companion, Context context, Object obj, boolean z, int i, Object obj2) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.createReusable(context, obj, z);
        }

        @NotNull
        public final <T> AnkoContext<T> createReusable(@NotNull Context context, T t, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            return new ReusableAnkoContext(context, t, z);
        }

        @NotNull
        public final <T extends ViewGroup> AnkoContext<T> createDelegate(@NotNull T t) {
            Intrinsics.checkParameterIsNotNull(t, "owner");
            return new DelegatingAnkoContext(t);
        }
    }

    public static final class DefaultImpls {
        public static <T> void updateViewLayout(AnkoContext<? extends T> ankoContext, @NotNull View view, @NotNull LayoutParams layoutParams) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
            throw new UnsupportedOperationException();
        }

        public static <T> void removeView(AnkoContext<? extends T> ankoContext, @NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            throw new UnsupportedOperationException();
        }
    }

    @NotNull
    Context getCtx();

    T getOwner();

    @NotNull
    View getView();

    void removeView(@NotNull View view);

    void updateViewLayout(@NotNull View view, @NotNull LayoutParams layoutParams);
}
