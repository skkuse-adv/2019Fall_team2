package kr.co.popone.fitts.ui.decorator;

import android.content.Context;
import android.graphics.Canvas;
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
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class DrawerMenuItemDecoration extends ItemDecoration {
    @NotNull
    private final Context context;
    private Drawable divider = ContextCompat.getDrawable(this.context, this.resId);
    private final int resId;

    public DrawerMenuItemDecoration(@NotNull Context context2, int i) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        this.resId = i;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final int getResId() {
        return this.resId;
    }

    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(canvas, "c");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int dpToPx = ViewExtensionsKt.dpToPx((View) recyclerView, 19);
        int width = recyclerView.getWidth() - ViewExtensionsKt.dpToPx((View) recyclerView, 20);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams != null) {
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                Drawable drawable = this.divider;
                if (drawable == null) {
                    Intrinsics.throwNpe();
                }
                int intrinsicHeight = drawable.getIntrinsicHeight() + bottom;
                Drawable drawable2 = this.divider;
                if (drawable2 == null) {
                    Intrinsics.throwNpe();
                }
                drawable2.setBounds(dpToPx, bottom, width, intrinsicHeight);
                Drawable drawable3 = this.divider;
                if (drawable3 == null) {
                    Intrinsics.throwNpe();
                }
                drawable3.draw(canvas);
                i++;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }
}
