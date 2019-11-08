package org.jetbrains.anko;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ViewChildrenSequencesKt {
    public static final void forEachChild(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(i)");
                function1.invoke(childAt);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void forEachChildWithIndex(@NotNull ViewGroup viewGroup, @NotNull Function2<? super Integer, ? super View, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                Integer valueOf = Integer.valueOf(i);
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(i)");
                function2.invoke(valueOf, childAt);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Nullable
    public static final View firstChildOrNull(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                if (!((Boolean) function1.invoke(childAt)).booleanValue()) {
                    if (i == childCount) {
                        break;
                    }
                    i++;
                } else {
                    return childAt;
                }
            }
        }
        return null;
    }

    @NotNull
    public static final Sequence<View> childrenSequence(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return new ViewChildrenSequence(view);
    }

    @NotNull
    public static final Sequence<View> childrenRecursiveSequence(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return new ViewChildrenRecursiveSequence(view);
    }

    @NotNull
    public static final View firstChild(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Boolean> function1) {
        View view;
        Intrinsics.checkParameterIsNotNull(viewGroup, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                view = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(view, "child");
                if (!((Boolean) function1.invoke(view)).booleanValue()) {
                    if (i == childCount) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        view = null;
        if (view != null) {
            return view;
        }
        throw new NoSuchElementException("No element matching predicate was found.");
    }
}
