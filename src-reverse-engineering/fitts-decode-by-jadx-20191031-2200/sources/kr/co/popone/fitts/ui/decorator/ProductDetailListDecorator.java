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

public final class ProductDetailListDecorator extends ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        if (childLayoutPosition == 0) {
            rect.top = ViewExtensionsKt.dpToPx(view, 20);
        } else if (childLayoutPosition > 0) {
            Intrinsics.checkExpressionValueIsNotNull(adapter, "it");
            if (childLayoutPosition < adapter.getItemCount() - 1) {
                rect.top = ViewExtensionsKt.dpToPx(view, 24);
            }
        }
    }
}
