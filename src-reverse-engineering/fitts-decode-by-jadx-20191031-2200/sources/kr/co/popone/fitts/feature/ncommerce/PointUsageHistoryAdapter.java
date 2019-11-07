package kr.co.popone.fitts.feature.ncommerce;

import android.view.ViewGroup;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.ui.custom.RecyclerLoadingItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointUsageHistoryAdapter extends PagedListAdapter<PaymentUsage, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<PaymentUsage> COMPARATOR = new PointUsageHistoryAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final int TYPE_HOLDER = 1;
    private final int TYPE_LOADING;
    private NetworkState networkState;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<PaymentUsage> getCOMPARATOR() {
            return PointUsageHistoryAdapter.COMPARATOR;
        }
    }

    public PointUsageHistoryAdapter() {
        super(COMPARATOR);
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == this.TYPE_HOLDER) {
            return PointUsageHistoryHolder.Companion.create(viewGroup);
        }
        if (i == this.TYPE_LOADING) {
            return RecyclerLoadingItemView.Companion.create(viewGroup);
        }
        throw new IllegalAccessException();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof PointUsageHistoryHolder) {
            ((PointUsageHistoryHolder) viewHolder).bindTo((PaymentUsage) getItem(i));
        }
    }

    public int getItemViewType(int i) {
        if (!hasExtraRow() || i != getItemCount() - 1) {
            return this.TYPE_HOLDER;
        }
        return this.TYPE_LOADING;
    }

    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
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

    private final boolean hasExtraRow() {
        NetworkState networkState2 = this.networkState;
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true);
    }
}
