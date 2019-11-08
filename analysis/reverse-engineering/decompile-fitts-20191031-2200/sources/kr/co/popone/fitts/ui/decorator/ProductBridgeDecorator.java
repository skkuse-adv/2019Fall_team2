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

public final class ProductBridgeDecorator extends ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition > 1) {
            int i = childAdapterPosition % 3;
            if (i == 0) {
                rect.set(ViewExtensionsKt.dpToPx(view, 5.0f), 0, ViewExtensionsKt.dpToPx(view, 5.0f), ViewExtensionsKt.dpToPx(view, 15));
            } else if (i == 1) {
                rect.set(ViewExtensionsKt.dpToPx(view, 2), 0, ViewExtensionsKt.dpToPx(view, 8), ViewExtensionsKt.dpToPx(view, 15));
            } else if (i == 2) {
                rect.set(ViewExtensionsKt.dpToPx(view, 8), 0, ViewExtensionsKt.dpToPx(view, 2), ViewExtensionsKt.dpToPx(view, 15));
            }
        }
    }
}
