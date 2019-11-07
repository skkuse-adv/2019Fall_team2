package kr.co.popone.fitts.feature.feeds;

import android.view.ViewGroup;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.ui.custom.RecyclerLoadingItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BasePagedListAdapter<T, VH extends ViewHolder> extends PagedListAdapter<T, VH> {
    private NetworkState networkState;

    public abstract int getItemViewTypeWithoutLoading(int i);

    public abstract void onBindViewHolderWithoutLoading(@NotNull VH vh, int i);

    @NotNull
    public abstract VH onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i);

    public BasePagedListAdapter(@NotNull ItemCallback<T> itemCallback) {
        Intrinsics.checkParameterIsNotNull(itemCallback, "diff");
        super(itemCallback);
    }

    @NotNull
    public VH onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i != RecyclerLoadingItemView.Companion.getId()) {
            return onCreateViewHolderWithoutLoading(viewGroup, i);
        }
        VH create = RecyclerLoadingItemView.Companion.create(viewGroup);
        if (create != null) {
            return create;
        }
        throw new TypeCastException("null cannot be cast to non-null type VH");
    }

    public void onBindViewHolder(@NotNull VH vh, int i) {
        Intrinsics.checkParameterIsNotNull(vh, "holder");
        if (vh instanceof RecyclerLoadingItemView) {
            ((RecyclerLoadingItemView) vh).bindTo(this.networkState);
        } else {
            onBindViewHolderWithoutLoading(vh, i);
        }
    }

    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
    }

    public int getItemViewType(int i) {
        if (!hasExtraRow() || i != getItemCount() - 1) {
            return getItemViewTypeWithoutLoading(i);
        }
        return RecyclerLoadingItemView.Companion.getId();
    }

    public final void updateNetworkState(@Nullable NetworkState networkState2) {
        NetworkState networkState3 = this.networkState;
        boolean hasExtraRow = hasExtraRow();
        this.networkState = networkState2;
        boolean hasExtraRow2 = hasExtraRow();
        if (hasExtraRow != hasExtraRow2) {
            if (hasExtraRow) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (hasExtraRow2 && (!Intrinsics.areEqual((Object) networkState3, (Object) networkState2))) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    public final boolean hasExtraRow() {
        NetworkState networkState2 = this.networkState;
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true);
    }
}
