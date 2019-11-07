package kr.co.popone.fitts.ui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ViewExtensionsKt {
    public static final int dpToPx(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        ViewExtensions viewExtensions = ViewExtensions.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return viewExtensions.dpToPx(context, i);
    }

    public static final int dpToPx(@NotNull View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        ViewExtensions viewExtensions = ViewExtensions.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return viewExtensions.dpToPx(context, f);
    }

    public static final int spToPx(@NotNull View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        ViewExtensions viewExtensions = ViewExtensions.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return viewExtensions.spToPx(context, f);
    }

    public static final int dpToPx(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return ViewExtensions.INSTANCE.dpToPx(context, i);
    }

    public static final int spToPx(@NotNull Context context, float f) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        return ViewExtensions.INSTANCE.spToPx(context, f);
    }

    public static final int dpToPx(@NotNull Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        ViewExtensions viewExtensions = ViewExtensions.INSTANCE;
        Context context = fragment.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return viewExtensions.dpToPx(context, i);
    }

    public static final int spToPx(@NotNull Fragment fragment, float f) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        ViewExtensions viewExtensions = ViewExtensions.INSTANCE;
        Context context = fragment.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return viewExtensions.spToPx(context, f);
    }

    @NotNull
    public static final MarginLayoutParams getMarginLayoutParams(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            return (MarginLayoutParams) layoutParams;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static /* synthetic */ void goneWithAlphaAnimation$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        goneWithAlphaAnimation(view, j);
    }

    public static final void goneWithAlphaAnimation(@NotNull View view, long j) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        if (view.getVisibility() != 8) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(j);
            view.setVisibility(8);
            view.setAnimation(alphaAnimation);
        }
    }

    public static /* synthetic */ void visibleWithAlphaAnimation$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        visibleWithAlphaAnimation(view, j);
    }

    public static final void visibleWithAlphaAnimation(@NotNull View view, long j) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        if (view.getVisibility() != 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(j);
            view.setVisibility(0);
            view.setAnimation(alphaAnimation);
        }
    }

    public static final void visible(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setVisibility(0);
    }

    public static final void invisible(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setVisibility(4);
    }

    public static final void gone(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setVisibility(8);
    }

    public static final void visibleWithWhiteBackground(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "body");
        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf(0), Integer.valueOf((int) 4294967295L)});
        function0.invoke();
        ofObject.setDuration(500);
        view.setTag("white");
        ofObject.start();
    }

    public static final void visibleWithTransparentBackground(@NotNull View view, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "body");
        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), Integer.valueOf(0)});
        function0.invoke();
        ofObject.setDuration(500);
        view.setTag("transparent");
        ofObject.start();
    }

    public static final void setTextWithVisible(@NotNull TextView textView, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(textView, "receiver$0");
        textView.setText(str);
        if (textView.getVisibility() != 0) {
            textView.setVisibility(0);
        }
    }
}
