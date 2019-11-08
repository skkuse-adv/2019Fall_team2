package kr.co.popone.fitts.feature.feeds;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseViewHolder extends ViewHolder {
    public abstract <T> void bind(@Nullable T t, @Nullable Integer num);

    public abstract void clear();

    public BaseViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public static /* synthetic */ void bind$default(BaseViewHolder baseViewHolder, Object obj, Integer num, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                num = null;
            }
            baseViewHolder.bind(obj, num);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bind");
    }

    public final void recycle() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Context context = view.getContext();
        if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
            clear();
        }
    }
}
