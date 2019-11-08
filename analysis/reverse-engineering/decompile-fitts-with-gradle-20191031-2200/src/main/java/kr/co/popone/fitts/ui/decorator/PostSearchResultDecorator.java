package kr.co.popone.fitts.ui.decorator;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class PostSearchResultDecorator extends ItemDecoration {
    private final int targetId;

    private final int getTopPx(int i) {
        return (1 <= i && 3 >= i) ? 10 : 0;
    }

    public PostSearchResultDecorator(int i) {
        this.targetId = i;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition > -1) {
            Adapter adapter = recyclerView.getAdapter();
            if (adapter != null && adapter.getItemViewType(childAdapterPosition) == this.targetId) {
                int topPx = getTopPx(childAdapterPosition);
                if (childAdapterPosition != 0) {
                    int i = childAdapterPosition % 3;
                    if (i == 1) {
                        rect.set(ViewExtensionsKt.dpToPx(view, 8), ViewExtensionsKt.dpToPx(view, topPx), ViewExtensionsKt.dpToPx(view, 0), ViewExtensionsKt.dpToPx(view, 4));
                    } else if (i == 2) {
                        rect.set(ViewExtensionsKt.dpToPx(view, 4), ViewExtensionsKt.dpToPx(view, topPx), ViewExtensionsKt.dpToPx(view, 4), ViewExtensionsKt.dpToPx(view, 4));
                    } else {
                        rect.set(ViewExtensionsKt.dpToPx(view, 0), ViewExtensionsKt.dpToPx(view, topPx), ViewExtensionsKt.dpToPx(view, 8), ViewExtensionsKt.dpToPx(view, 4));
                    }
                }
            }
        }
    }
}
