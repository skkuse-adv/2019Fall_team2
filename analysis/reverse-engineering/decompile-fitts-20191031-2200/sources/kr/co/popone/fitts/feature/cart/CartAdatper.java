package kr.co.popone.fitts.feature.cart;

import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.cart.CartContentViewHolder.Delegate;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;
import kr.co.popone.fitts.model.cart.CartVariantsItem;
import org.jetbrains.annotations.NotNull;

public final class CartAdatper extends Adapter<ViewHolder> implements Delegate {
    private CartLineItemsDomain cartLineItemsDomain;
    private List<CartLineItemViewData> items = new ArrayList();
    @NotNull
    private final MutableLiveData<Integer> variantsCountLiveData = new MutableLiveData<>();

    private final void setItems(List<CartLineItemViewData> list) {
        this.items = list;
        this.variantsCountLiveData.setValue(Integer.valueOf(this.items.size()));
    }

    @NotNull
    public final MutableLiveData<Integer> getVariantsCountLiveData() {
        return this.variantsCountLiveData;
    }

    public final void setCartLineItems(@NotNull CartLineItemsDomain cartLineItemsDomain2) {
        Intrinsics.checkParameterIsNotNull(cartLineItemsDomain2, "domain");
        setItems(cartLineItemsDomain2.getCartLineItemViewDatas());
        this.cartLineItemsDomain = cartLineItemsDomain2;
        notifyDataSetChanged();
    }

    public final void removeCartLineItems(@NotNull CartLineItemsDomain cartLineItemsDomain2) {
        Intrinsics.checkParameterIsNotNull(cartLineItemsDomain2, "domain");
        setItems(cartLineItemsDomain2.getCartLineItemViewDatas());
        this.cartLineItemsDomain = cartLineItemsDomain2;
        notifyDataSetChanged();
    }

    public final void updateTotalPrice(@NotNull CartLineItemsDomain cartLineItemsDomain2) {
        Intrinsics.checkParameterIsNotNull(cartLineItemsDomain2, "domain");
        CartLineItemsDomain cartLineItemsDomain3 = this.cartLineItemsDomain;
        if (cartLineItemsDomain3 != null) {
            cartLineItemsDomain3.setTotalOrderPrice(cartLineItemsDomain2.getTotalOrderPrice());
            cartLineItemsDomain3.setTotalProductPrice(cartLineItemsDomain2.getTotalProductPrice());
            cartLineItemsDomain3.setTotalProductCount(cartLineItemsDomain2.getTotalProductCount());
            cartLineItemsDomain3.setTotalShippingPrice(cartLineItemsDomain2.getTotalShippingPrice());
            notifyItemChanged(this.items.size(), this.cartLineItemsDomain);
        }
        int size = this.items.size();
        for (int i = 0; i < size; i++) {
            for (CartLineItemViewData cartLineItemViewData : cartLineItemsDomain2.getCartLineItemViewDatas()) {
                if (((CartLineItemViewData) this.items.get(i)).getStoreId() == cartLineItemViewData.getStoreId()) {
                    ((CartLineItemViewData) this.items.get(i)).setLineItemShippingPrice(cartLineItemViewData.getLineItemShippingPrice());
                    ((CartLineItemViewData) this.items.get(i)).setLineItemProductPrice(cartLineItemViewData.getLineItemProductPrice());
                    ((CartLineItemViewData) this.items.get(i)).setLineItemOrderPrice(cartLineItemViewData.getLineItemOrderPrice());
                    notifyItemChanged(i, this.items.get(i));
                }
            }
        }
    }

    public final void updateEmptyLineItem() {
        CartLineItemsDomain cartLineItemsDomain2 = this.cartLineItemsDomain;
        if (cartLineItemsDomain2 != null) {
            cartLineItemsDomain2.setTotalOrderPrice(0);
            cartLineItemsDomain2.setTotalProductPrice(0);
            cartLineItemsDomain2.setTotalProductCount(0);
            cartLineItemsDomain2.setTotalShippingPrice(0);
            notifyItemChanged(this.items.size(), this.cartLineItemsDomain);
        }
        int size = this.items.size();
        for (int i = 0; i < size; i++) {
            ((CartLineItemViewData) this.items.get(i)).setLineItemOrderPrice(0);
            ((CartLineItemViewData) this.items.get(i)).setLineItemProductPrice(0);
            ((CartLineItemViewData) this.items.get(i)).setLineItemShippingPrice(0);
            notifyItemChanged(i, this.items.get(i));
        }
    }

    public final void updateAllCheckBox(boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        List<CartLineItemViewData> list = this.items;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartLineItemViewData productVariants : list) {
            List<CartVariantsItem> productVariants2 = productVariants.getProductVariants();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(productVariants2, 10));
            for (CartVariantsItem cartVariantsItem : productVariants2) {
                if (cartVariantsItem.isSoldOut()) {
                    cartVariantsItem.setCheckedOption(false);
                } else {
                    cartVariantsItem.setCheckedOption(z);
                }
                arrayList2.add(Unit.INSTANCE);
            }
            arrayList.add(arrayList2);
        }
        notifyDataSetChanged();
        function0.invoke();
    }

    @NotNull
    public final String getCheckedVariantsAsJson() {
        return CartEntityExtensionKt.mapToLineItemsJson(this.items);
    }

    @NotNull
    public final String getPreOrderableVariantsJson() {
        return CartEntityExtensionKt.mapToVariantIdListAsJson(this.items);
    }

    public final boolean isAllVariantsChecked() {
        return CartEntityExtensionKt.getTotalVariantsCount(this.items) == CartEntityExtensionKt.getCheckedVariantsCount(this.items);
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558623) {
            return CartSummarizeViewHolder.Companion.create(viewGroup);
        }
        if (i == 2131558710) {
            return CartContentViewHolder.Companion.create(viewGroup);
        }
        throw new IllegalArgumentException("unknown view type");
    }

    public int getItemCount() {
        if (this.items.isEmpty()) {
            return 0;
        }
        return this.items.size() + 1;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof CartSummarizeViewHolder) {
            ((CartSummarizeViewHolder) viewHolder).bindTo(this.cartLineItemsDomain);
        } else if (viewHolder instanceof CartContentViewHolder) {
            ((CartContentViewHolder) viewHolder).bindTo((CartLineItemViewData) this.items.get(i));
        }
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        if (!(!list.isEmpty())) {
            onBindViewHolder(viewHolder, i);
        } else if (viewHolder instanceof CartSummarizeViewHolder) {
            ((CartSummarizeViewHolder) viewHolder).updateCartLineItemsDomain(this.cartLineItemsDomain);
        } else if (viewHolder instanceof CartContentViewHolder) {
            ((CartContentViewHolder) viewHolder).updateLineItem((CartLineItemViewData) this.items.get(i));
        }
    }

    public int getItemViewType(int i) {
        return i == this.items.size() ? C0013R$layout.item_cart_summarize : C0013R$layout.item_recycler_with_title;
    }

    public void onLineItemCleared(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "cartItemViewData");
        if (this.items.contains(cartLineItemViewData)) {
            int indexOf = this.items.indexOf(cartLineItemViewData);
            List<CartLineItemViewData> list = this.items;
            if (list != null) {
                ((ArrayList) list).remove(indexOf);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<kr.co.popone.fitts.model.cart.CartLineItemViewData>");
        }
    }
}
