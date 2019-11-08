package kr.co.popone.fitts.feature.order.orderlist;

import android.view.ViewGroup;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import kr.co.popone.fitts.model.order.OrderListViewData;
import kr.co.popone.fitts.ui.custom.RecyclerLoadingItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListAdapter extends PagedListAdapter<OrderListViewData, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<OrderListViewData> COMPARATOR = new OrderListAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @Nullable
    private NetworkState networkState;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<OrderListViewData> getCOMPARATOR() {
            return OrderListAdapter.COMPARATOR;
        }
    }

    public OrderListAdapter() {
        super(COMPARATOR);
    }

    @Nullable
    public final NetworkState getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable NetworkState networkState2) {
        this.networkState = networkState2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558670) {
            return OrderNumberRecyclerHolder.Companion.create(viewGroup);
        }
        if (i == 2131558709) {
            return RecyclerLoadingItemView.Companion.create(viewGroup);
        }
        throw new IllegalAccessException();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof OrderNumberRecyclerHolder) {
            ((OrderNumberRecyclerHolder) viewHolder).bindTo((OrderListViewData) super.getItem(i));
        }
    }

    public int getItemViewType(int i) {
        return (!hasExtraRow() || i != getItemCount() + -1) ? C0013R$layout.item_order_number_recycler : C0013R$layout.item_recycler_loading;
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

    public final void updateOrderLineItemState(long j, @NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "orderLineItems");
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(currentList, 10));
            int i = 0;
            for (Object next : currentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                OrderListViewData orderListViewData = (OrderListViewData) next;
                if (orderListViewData.getOrderId() == j) {
                    orderListViewData.setOrderListItems(list);
                    notifyItemChanged(i);
                }
                arrayList.add(Unit.INSTANCE);
                i = i2;
            }
        }
    }

    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
    }

    private final boolean hasExtraRow() {
        NetworkState networkState2 = this.networkState;
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true);
    }
}
