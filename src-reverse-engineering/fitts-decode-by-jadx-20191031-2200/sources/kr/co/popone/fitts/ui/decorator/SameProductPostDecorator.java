package kr.co.popone.fitts.ui.decorator;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class SameProductPostDecorator extends ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();
        if (childAdapterPosition == 0) {
            rect.set(ViewExtensionsKt.dpToPx(view, 8), ViewExtensionsKt.dpToPx(view, 0), ViewExtensionsKt.dpToPx(view, 2), ViewExtensionsKt.dpToPx(view, 0));
        } else if (childAdapterPosition == itemCount - 1) {
            rect.set(ViewExtensionsKt.dpToPx(view, 2), ViewExtensionsKt.dpToPx(view, 0), ViewExtensionsKt.dpToPx(view, 8), ViewExtensionsKt.dpToPx(view, 0));
        } else {
            rect.set(ViewExtensionsKt.dpToPx(view, 2), ViewExtensionsKt.dpToPx(view, 0), ViewExtensionsKt.dpToPx(view, 2), ViewExtensionsKt.dpToPx(view, 0));
        }
    }
}
