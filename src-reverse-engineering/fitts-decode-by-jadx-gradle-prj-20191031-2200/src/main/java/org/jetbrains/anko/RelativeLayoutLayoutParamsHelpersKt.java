package org.jetbrains.anko;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.IdRes;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class RelativeLayoutLayoutParamsHelpersKt {
    public static final void topOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(2, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void above(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(2, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void bottomOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(3, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void below(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(3, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void leftOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(0, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    @RequiresApi(17)
    public static final void startOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(16, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void rightOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(1, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    @RequiresApi(17)
    public static final void endOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(17, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void sameLeft(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(5, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    @RequiresApi(17)
    public static final void sameStart(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(18, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void sameTop(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(6, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void sameRight(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(7, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    @RequiresApi(17)
    public static final void sameEnd(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(19, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void sameBottom(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(8, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void topOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(2, i);
    }

    public static final void above(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(2, i);
    }

    public static final void below(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(3, i);
    }

    public static final void bottomOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(3, i);
    }

    public static final void leftOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(0, i);
    }

    @RequiresApi(17)
    public static final void startOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(16, i);
    }

    public static final void rightOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(1, i);
    }

    @RequiresApi(17)
    public static final void endOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(17, i);
    }

    public static final void sameLeft(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(5, i);
    }

    @RequiresApi(17)
    public static final void sameStart(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(18, i);
    }

    public static final void sameTop(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(6, i);
    }

    public static final void sameRight(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(7, i);
    }

    @RequiresApi(17)
    public static final void sameEnd(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(19, i);
    }

    public static final void sameBottom(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(8, i);
    }

    @RequiresApi(17)
    public static final void alignStart(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(18, i);
    }

    @RequiresApi(17)
    public static final void alignEnd(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(19, i);
    }

    public static final void alignParentTop(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(10);
    }

    public static final void alignParentRight(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(11);
    }

    public static final void alignParentBottom(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(12);
    }

    public static final void alignParentLeft(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(9);
    }

    public static final void centerHorizontally(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(14);
    }

    public static final void centerVertically(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(15);
    }

    public static final void centerInParent(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(13);
    }

    @RequiresApi(17)
    public static final void alignParentStart(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(20);
    }

    @RequiresApi(17)
    public static final void alignParentEnd(@NotNull LayoutParams layoutParams) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(21);
    }

    public static final void baselineOf(@NotNull LayoutParams layoutParams, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        int id = view.getId();
        if (id != -1) {
            layoutParams.addRule(4, id);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Id is not set for ");
        sb.append(view);
        throw new AnkoException(sb.toString());
    }

    public static final void baselineOf(@NotNull LayoutParams layoutParams, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(layoutParams, "receiver$0");
        layoutParams.addRule(4, i);
    }
}
