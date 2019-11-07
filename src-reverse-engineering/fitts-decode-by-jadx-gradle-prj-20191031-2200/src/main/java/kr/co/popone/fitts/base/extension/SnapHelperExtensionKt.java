package kr.co.popone.fitts.base.extension;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SnapHelperExtensionKt {
    public static final int getSnapPosition(@NotNull SnapHelper snapHelper, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(snapHelper, "receiver$0");
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            Intrinsics.checkExpressionValueIsNotNull(layoutManager, "recyclerView.layoutManag… RecyclerView.NO_POSITION");
            View findSnapView = snapHelper.findSnapView(layoutManager);
            if (findSnapView != null) {
                Intrinsics.checkExpressionValueIsNotNull(findSnapView, "findSnapView(layoutManag… RecyclerView.NO_POSITION");
                return layoutManager.getPosition(findSnapView);
            }
        }
        return -1;
    }
}
