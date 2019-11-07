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

public final class OrderStateDecorator extends ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0 || childLayoutPosition == 1) {
            rect.top = ViewExtensionsKt.dpToPx(view, 20);
        }
        if (childLayoutPosition % 2 == 0) {
            rect.left = ViewExtensionsKt.dpToPx(view, 4);
            rect.bottom = ViewExtensionsKt.dpToPx(view, 9);
            return;
        }
        rect.right = ViewExtensionsKt.dpToPx(view, 4);
        rect.bottom = ViewExtensionsKt.dpToPx(view, 9);
    }
}
