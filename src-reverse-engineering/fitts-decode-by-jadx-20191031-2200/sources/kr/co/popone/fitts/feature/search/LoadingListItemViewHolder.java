package kr.co.popone.fitts.feature.search;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class LoadingListItemViewHolder extends ViewHolder {
    public LoadingListItemViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super(view);
    }
}
