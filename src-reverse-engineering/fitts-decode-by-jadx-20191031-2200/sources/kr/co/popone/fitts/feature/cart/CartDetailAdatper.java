package kr.co.popone.fitts.feature.cart;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.cart.CartDetailViewHolder.Delegate;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import kr.co.popone.fitts.model.cart.CartVariantsItem;
import org.jetbrains.annotations.NotNull;

public final class CartDetailAdatper extends Adapter<ViewHolder> implements Delegate {
    private CartLineItemViewData cartItemViewData;
    private List<CartVariantsItem> items = new ArrayList();

    public final void setCartLineItem(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "cartItemViewData");
        this.items = cartLineItemViewData.getProductVariants();
        this.cartItemViewData = cartLineItemViewData;
    }

    public final void updateCartLineItem(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "cartItemViewData");
        updateSummarizeView(cartLineItemViewData.getLineItemShippingPrice(), cartLineItemViewData.getLineItemProductPrice(), cartLineItemViewData.getLineItemOrderPrice());
        this.items = cartLineItemViewData.getProductVariants();
        int size = this.items.size();
        for (int i = 0; i < size; i++) {
            notifyItemChanged(i, this.items.get(i));
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558622) {
            return CartDetailViewHolder.Companion.create(viewGroup, this);
        }
        if (i == 2131558635) {
            return DetailPriceSummarizeViewHolder.Companion.create(viewGroup);
        }
        throw new IllegalArgumentException("unknown view type");
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public int getItemViewType(int i) {
        return i == this.items.size() ? C0013R$layout.item_detail_summarize : C0013R$layout.item_cart_details;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof CartDetailViewHolder) {
            ((CartDetailViewHolder) viewHolder).bindTo((CartVariantsItem) this.items.get(i), i);
        } else if (viewHolder instanceof DetailPriceSummarizeViewHolder) {
            ((DetailPriceSummarizeViewHolder) viewHolder).bindTo(this.cartItemViewData);
        }
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        if (!(!list.isEmpty())) {
            onBindViewHolder(viewHolder, i);
        } else if (viewHolder instanceof CartDetailViewHolder) {
            ((CartDetailViewHolder) viewHolder).updateCartVariantsItem((CartVariantsItem) this.items.get(i));
        } else if (viewHolder instanceof DetailPriceSummarizeViewHolder) {
            ((DetailPriceSummarizeViewHolder) viewHolder).updateCartLineItem(this.cartItemViewData);
        }
    }

    public void onCheckStateChanged(boolean z, int i) {
        ((CartVariantsItem) this.items.get(i)).setCheckedOption(z);
        if (CartEntityExtensionKt.getCheckedVariantCount(this.items) == 0) {
            updateSummarizeView(0, 0, 0);
        }
    }

    private final void updateSummarizeView(int i, int i2, int i3) {
        CartLineItemViewData cartLineItemViewData = this.cartItemViewData;
        if (cartLineItemViewData != null) {
            cartLineItemViewData.setLineItemShippingPrice(i);
            cartLineItemViewData.setLineItemProductPrice(i2);
            cartLineItemViewData.setLineItemOrderPrice(i3);
            notifyItemChanged(this.items.size(), this.cartItemViewData);
        }
    }
}
