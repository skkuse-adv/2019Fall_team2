package kr.co.popone.fitts.feature.reward;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.facebook.internal.ServerProtocol;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class RewardItemDecoration extends ItemDecoration {
    private final Drawable divider;
    private final int leftMargin;
    private final int rightMargin;

    public RewardItemDecoration(@NotNull Context context, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.leftMargin = i;
        this.rightMargin = i2;
        Drawable drawable = ContextCompat.getDrawable(context, C0008R$drawable.item_divider);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        this.divider = drawable;
    }

    public /* synthetic */ RewardItemDecoration(Context context, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, i, i2);
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.top = this.divider.getIntrinsicHeight();
        }
    }

    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(canvas, "c");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int paddingLeft = recyclerView.getPaddingLeft() + ViewExtensionsKt.dpToPx((View) recyclerView, this.leftMargin);
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - ViewExtensionsKt.dpToPx((View) recyclerView, this.rightMargin);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams != null) {
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                this.divider.setBounds(paddingLeft, bottom, width, this.divider.getIntrinsicHeight() + bottom);
                this.divider.draw(canvas);
                i++;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }
}
