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

public final class BottomOffsetDecorator extends ItemDecoration {
    private final int bottom;
    private final int lastBottom;
    private final int left;
    private final int right;
    private final int top;

    public BottomOffsetDecorator(int i, int i2, int i3, int i4, int i5) {
        this.top = i;
        this.left = i2;
        this.right = i3;
        this.bottom = i4;
        this.lastBottom = i5;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLastBottom() {
        return this.lastBottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();
        rect.set(ViewExtensionsKt.dpToPx(view, this.left), ViewExtensionsKt.dpToPx(view, this.top), ViewExtensionsKt.dpToPx(view, this.right), ViewExtensionsKt.dpToPx(view, (itemCount <= 0 || childAdapterPosition != itemCount + -1) ? this.bottom : this.lastBottom));
    }
}
