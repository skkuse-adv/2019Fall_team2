package kr.co.popone.fitts.feature.ncommerce;

import android.view.ViewGroup;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import kr.co.popone.fitts.ui.custom.RecyclerLoadingItemView;
import kr.co.popone.fitts.utils.DateExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointHistoryAdapter extends PagedListAdapter<PaymentHistory, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<PaymentHistory> COMPARATOR = new PointHistoryAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final int TYPE_HOLDER = 1;
    private final int TYPE_HOLDER_SHORT = 2;
    private final int TYPE_LOADING;
    private NetworkState networkState;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<PaymentHistory> getCOMPARATOR() {
            return PointHistoryAdapter.COMPARATOR;
        }
    }

    public PointHistoryAdapter() {
        super(COMPARATOR);
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == this.TYPE_HOLDER) {
            return PointHistoryHolder.Companion.create(viewGroup);
        }
        if (i == this.TYPE_HOLDER_SHORT) {
            return PointHistoryShortHolder.Companion.create(viewGroup);
        }
        if (i == this.TYPE_LOADING) {
            return RecyclerLoadingItemView.Companion.create(viewGroup);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        boolean z = true;
        if (viewHolder instanceof PointHistoryHolder) {
            PointHistoryHolder pointHistoryHolder = (PointHistoryHolder) viewHolder;
            PaymentHistory paymentHistory = (PaymentHistory) getItem(i);
            boolean z2 = i == 0;
            if (i != getItemCount()) {
                z = false;
            }
            pointHistoryHolder.bindTo(paymentHistory, z2, z);
        } else if (viewHolder instanceof PointHistoryShortHolder) {
            PointHistoryShortHolder pointHistoryShortHolder = (PointHistoryShortHolder) viewHolder;
            PaymentHistory paymentHistory2 = (PaymentHistory) getItem(i);
            if (i != getItemCount()) {
                z = false;
            }
            pointHistoryShortHolder.bindTo(paymentHistory2, z);
        }
    }

    public int getItemViewType(int i) {
        if (hasExtraRow() && i == getItemCount() - 1) {
            return this.TYPE_LOADING;
        }
        if (i == 0) {
            return this.TYPE_HOLDER;
        }
        return getViewTypeCompareDate(i);
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
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true) && (Intrinsics.areEqual((Object) this.networkState, (Object) NetworkState.Companion.getINIT_LOADED()) ^ true);
    }

    private final int getViewTypeCompareDate(int i) {
        PaymentHistory paymentHistory = (PaymentHistory) getItem(i - 1);
        PaymentHistory paymentHistory2 = (PaymentHistory) getItem(i);
        if (paymentHistory == null) {
            Intrinsics.throwNpe();
        }
        Date createdAt = paymentHistory.getCreatedAt();
        if (paymentHistory2 == null) {
            Intrinsics.throwNpe();
        }
        return DateExtensionsKt.isSameDay(createdAt, paymentHistory2.getCreatedAt()) ? this.TYPE_HOLDER_SHORT : this.TYPE_HOLDER;
    }
}
