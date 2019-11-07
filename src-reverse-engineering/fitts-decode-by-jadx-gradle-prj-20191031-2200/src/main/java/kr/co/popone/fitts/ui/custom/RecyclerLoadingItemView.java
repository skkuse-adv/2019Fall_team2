package kr.co.popone.fitts.ui.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RecyclerLoadingItemView extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_recycler_loading;
        }

        public final int toVisibility(boolean z) {
            return z ? 0 : 8;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecyclerLoadingItemView create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recycler_loading, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new RecyclerLoadingItemView(inflate);
        }
    }

    public void clear() {
    }

    public RecyclerLoadingItemView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@Nullable NetworkState networkState) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(C0010R$id.progressBarContainer);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "progressBarContainer");
        constraintLayout.setVisibility(Companion.toVisibility((networkState != null ? networkState.getStatus() : null) == Status.RUNNING));
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof NetworkState) {
            updateLoadingUi((NetworkState) t);
        }
    }

    private final void updateLoadingUi(NetworkState networkState) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(C0010R$id.progressBarContainer);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "progressBarContainer");
        constraintLayout.setVisibility(Companion.toVisibility(networkState.getStatus() == Status.RUNNING));
    }
}
