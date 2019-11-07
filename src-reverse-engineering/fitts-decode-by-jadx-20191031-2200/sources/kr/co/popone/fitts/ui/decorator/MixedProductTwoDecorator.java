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

public final class MixedProductTwoDecorator extends ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        if (recyclerView.getChildLayoutPosition(view) % 2 == 0) {
            rect.top = ViewExtensionsKt.dpToPx(view, 17);
            rect.left = ViewExtensionsKt.dpToPx(view, 8);
            rect.right = ViewExtensionsKt.dpToPx(view, 4);
            rect.bottom = ViewExtensionsKt.dpToPx(view, 0);
            return;
        }
        rect.top = ViewExtensionsKt.dpToPx(view, 17);
        rect.left = ViewExtensionsKt.dpToPx(view, 4);
        rect.right = ViewExtensionsKt.dpToPx(view, 8);
        rect.bottom = ViewExtensionsKt.dpToPx(view, 0);
    }
}
