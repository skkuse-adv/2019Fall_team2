package kr.co.popone.fitts.feature.home;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class PostItemDecoration extends ItemDecoration {
    private final boolean hasHeader;
    private boolean isGrid;

    public PostItemDecoration(boolean z, boolean z2) {
        this.hasHeader = z;
        this.isGrid = z2;
    }

    public /* synthetic */ PostItemDecoration(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        this(z, z2);
    }

    public final boolean isGrid() {
        return this.isGrid;
    }

    public final void setGrid(boolean z) {
        this.isGrid = z;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        if (this.isGrid) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            if (!this.hasHeader || childLayoutPosition != 0) {
                int i = childLayoutPosition % 2;
                boolean z = this.hasHeader;
                if (i == (!z)) {
                    rect.right = ViewExtensionsKt.dpToPx(view, 8);
                    rect.left = ViewExtensionsKt.dpToPx(view, 4);
                    rect.bottom = ViewExtensionsKt.dpToPx(view, 18);
                } else if (i == z) {
                    rect.left = ViewExtensionsKt.dpToPx(view, 8);
                    rect.right = ViewExtensionsKt.dpToPx(view, 4);
                    rect.bottom = ViewExtensionsKt.dpToPx(view, 18);
                }
            }
        }
    }
}
