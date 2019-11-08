package kr.co.popone.fitts.feature.order;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.cart.DetailPriceSummarizeViewHolder;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import kr.co.popone.fitts.model.cart.CartVariantsItem;
import org.jetbrains.annotations.NotNull;

public final class OrderProductDetailAdapter extends Adapter<ViewHolder> {
    private CartLineItemViewData cartItemViewData;
    private List<CartVariantsItem> items = new ArrayList();

    public final void setCartLineItem(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "cartItemViewData");
        this.items = cartLineItemViewData.getProductVariants();
        this.cartItemViewData = cartLineItemViewData;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558635) {
            return DetailPriceSummarizeViewHolder.Companion.create(viewGroup);
        }
        if (i == 2131558671) {
            return OrderProductDetailItemHolder.Companion.create(viewGroup);
        }
        throw new IllegalArgumentException("unknown view type");
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public int getItemViewType(int i) {
        return i == this.items.size() ? C0013R$layout.item_detail_summarize : C0013R$layout.item_order_product_details;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof OrderProductDetailItemHolder) {
            ((OrderProductDetailItemHolder) viewHolder).bindTo((CartVariantsItem) this.items.get(i));
        } else if (viewHolder instanceof DetailPriceSummarizeViewHolder) {
            ((DetailPriceSummarizeViewHolder) viewHolder).bindTo(this.cartItemViewData);
        }
    }
}
