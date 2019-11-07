package kr.co.popone.fitts.model.cart;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.product.PreOrderVariant;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.product.VariantPrice;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserInfo;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import org.jetbrains.annotations.NotNull;

public final class CartEntityExtensionKt {
    @NotNull
    public static final CartLineItemsDomain mapToCartLineItemDomain(@NotNull CartLineItemEntity cartLineItemEntity) {
        Intrinsics.checkParameterIsNotNull(cartLineItemEntity, "receiver$0");
        CartLineItemsDomain cartLineItemsDomain = new CartLineItemsDomain(cartLineItemEntity.getTotalProductCount(), cartLineItemEntity.getTotalProductPrice(), cartLineItemEntity.getTotalShippingPrice(), cartLineItemEntity.getTotalOrderPrice(), mapToCartLineItems(cartLineItemEntity.getLineItems()));
        return cartLineItemsDomain;
    }

    @NotNull
    public static final CartLineItemsDomain mapToCartLineItemsDomain(@NotNull CartPriceItemEntity cartPriceItemEntity) {
        Intrinsics.checkParameterIsNotNull(cartPriceItemEntity, "receiver$0");
        CartLineItemsDomain cartLineItemsDomain = new CartLineItemsDomain(cartPriceItemEntity.getTotalProductCount(), cartPriceItemEntity.getTotalProductPrice(), cartPriceItemEntity.getTotalShippingPrice(), cartPriceItemEntity.getTotalOrderPrice(), mapToCartLineItemList(cartPriceItemEntity.getLineItems()));
        return cartLineItemsDomain;
    }

    @NotNull
    public static final CartLineItemViewData mapToCartLineItem(@NotNull CartPriceLineItem cartPriceLineItem) {
        Intrinsics.checkParameterIsNotNull(cartPriceLineItem, "receiver$0");
        CartLineItemViewData cartLineItemViewData = new CartLineItemViewData(cartPriceLineItem.getStoreInfo().getId(), cartPriceLineItem.getStoreInfo().getStoreName(), cartPriceLineItem.getLineItemTotalPrice(), cartPriceLineItem.getLineItemShippingTotalPrice(), cartPriceLineItem.getLineItemOrderPrice(), new ArrayList());
        return cartLineItemViewData;
    }

    @NotNull
    public static final CartLineItemViewData mapToCartLineItem(@NotNull CartLineItem cartLineItem) {
        Intrinsics.checkParameterIsNotNull(cartLineItem, "receiver$0");
        CartLineItemViewData cartLineItemViewData = new CartLineItemViewData(cartLineItem.getStore().getId(), cartLineItem.getStore().getStoreName(), cartLineItem.getLineItemTotalPrice(), cartLineItem.getLineItemShippingTotalPrice(), cartLineItem.getLineItemOrderPrice(), mapToCartVariantsList(cartLineItem.getLineItemVariants()));
        return cartLineItemViewData;
    }

    @NotNull
    public static final CartVariantsItem mapToCartVariantsItem(@NotNull CartLineItemVariants cartLineItemVariants) {
        Intrinsics.checkParameterIsNotNull(cartLineItemVariants, "receiver$0");
        long id = cartLineItemVariants.getId();
        String str = "active";
        boolean z = !Intrinsics.areEqual((Object) cartLineItemVariants.getVariant().getState(), (Object) str);
        String shopImageUrl = cartLineItemVariants.getVariant().getProduct().getShopImageUrl();
        String shopLinkUrl = cartLineItemVariants.getVariant().getProduct().getShopLinkUrl();
        String title = cartLineItemVariants.getVariant().getProduct().getTitle();
        int originPrice = cartLineItemVariants.getVariant().getOriginPrice();
        int price = cartLineItemVariants.getVariant().getPrice();
        Double discountRate = cartLineItemVariants.getVariant().getProduct().getDiscountRate();
        CartVariantsItem cartVariantsItem = new CartVariantsItem(id, z, shopImageUrl, shopLinkUrl, title, originPrice, price, Integer.valueOf((int) Math.ceil(discountRate != null ? discountRate.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), ProductEntityExtensionKt.mapToDomain(cartLineItemVariants.getVariant().getOption()), cartLineItemVariants.getSpecialDiscountInfo(), cartLineItemVariants.getQuantity(), Intrinsics.areEqual((Object) cartLineItemVariants.getVariant().getState(), (Object) str));
        return cartVariantsItem;
    }

    @NotNull
    public static final List<CartLineItemViewData> mapToOrderableLineItems(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartLineItemViewData cartLineItemViewData : list) {
            if (mapToOrderableCartVariants(cartLineItemViewData.getProductVariants()).size() > 0) {
                arrayList.add(cartLineItemViewData);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<CartVariantsItem> mapToOrderableCartVariants(@NotNull List<CartVariantsItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartVariantsItem cartVariantsItem : list) {
            if (cartVariantsItem.isCheckedOption()) {
                arrayList.add(cartVariantsItem);
            }
        }
        return arrayList;
    }

    public static final int getCheckedVariantsCount(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartLineItemViewData productVariants : list) {
            List<CartVariantsItem> productVariants2 = productVariants.getProductVariants();
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(productVariants2, 10));
            for (CartVariantsItem cartVariantsItem : productVariants2) {
                if (cartVariantsItem.isCheckedOption()) {
                    arrayList.add(cartVariantsItem);
                }
                arrayList3.add(Unit.INSTANCE);
            }
            arrayList2.add(arrayList3);
        }
        return arrayList.size();
    }

    @NotNull
    public static final String mapToLineItemsJson(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartLineItemViewData productVariants : list) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable<? extends T>) mapToVariantsJson(productVariants.getProductVariants()));
        }
        String json = new Gson().toJson((Object) arrayList);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(variantPrices)");
        return json;
    }

    @NotNull
    public static final List<VariantPrice> mapToVariantsJson(@NotNull List<CartVariantsItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartVariantsItem cartVariantsItem : list) {
            if (cartVariantsItem.isCheckedOption()) {
                arrayList.add(new VariantPrice(cartVariantsItem.getLineItemId(), cartVariantsItem.getProductCount()));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final String mapToVariantIdListAsJson(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartLineItemViewData productVariants : list) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable<? extends T>) mapToPreOrderVariantsAsJson(productVariants.getProductVariants()));
        }
        String json = new Gson().toJson((Object) arrayList);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(variantPrices)");
        return json;
    }

    @NotNull
    public static final List<PreOrderVariant> mapToPreOrderVariantsAsJson(@NotNull List<CartVariantsItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartVariantsItem cartVariantsItem : list) {
            if (cartVariantsItem.isCheckedOption()) {
                arrayList.add(new PreOrderVariant(cartVariantsItem.getLineItemId()));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final OrderInfoViewData mapToOrderableViewData(@NotNull CartOrderableItem cartOrderableItem) {
        Intrinsics.checkParameterIsNotNull(cartOrderableItem, "receiver$0");
        List mapToCartLineItems = mapToCartLineItems(cartOrderableItem.getLineItems());
        int totalProductCount = cartOrderableItem.getTotalProductCount();
        int totalProductPrice = cartOrderableItem.getTotalProductPrice();
        int totalShippingPrice = cartOrderableItem.getTotalShippingPrice();
        UserInfo userInfo = cartOrderableItem.getUserInfo();
        ShippingAddressResponse userAddress = cartOrderableItem.getUserAddress();
        List bankAccounts = cartOrderableItem.getBankAccounts();
        Date dueDate = cartOrderableItem.getDueDate();
        AdjustmentViewData adjustmentViewData = new AdjustmentViewData(cartOrderableItem.getPointAdjustmentPolicy().getMinHoldingValue(), cartOrderableItem.getPointAdjustmentPolicy().getMinOrderPrice(), cartOrderableItem.getPointAdjustmentPolicy().getAvailablePaymentPercentage(), cartOrderableItem.getPointAdjustmentPolicy().getUsageUnit(), cartOrderableItem.getUsablePoints(), cartOrderableItem.getFittsPoint());
        OrderInfoViewData orderInfoViewData = new OrderInfoViewData(mapToCartLineItems, null, totalProductCount, totalProductPrice, totalShippingPrice, userInfo, userAddress, bankAccounts, dueDate, adjustmentViewData);
        return orderInfoViewData;
    }

    @NotNull
    public static final String mapToProductOrderAsJson(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (CartLineItemViewData productVariants : list) {
            for (CartVariantsItem cartVariantsItem : productVariants.getProductVariants()) {
                arrayList.add(new VariantPrice(cartVariantsItem.getLineItemId(), cartVariantsItem.getProductCount()));
            }
        }
        String json = new Gson().toJson((Object) arrayList);
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(variantPrices)");
        return json;
    }

    @NotNull
    public static final CartLineItemsDomain mapToProductLineItemsDomain(@NotNull CartPriceItemEntity cartPriceItemEntity) {
        Intrinsics.checkParameterIsNotNull(cartPriceItemEntity, "receiver$0");
        CartLineItemsDomain cartLineItemsDomain = new CartLineItemsDomain(cartPriceItemEntity.getTotalProductCount(), cartPriceItemEntity.getTotalProductPrice(), cartPriceItemEntity.getTotalShippingPrice(), cartPriceItemEntity.getTotalOrderPrice(), mapToCartLineItemList(cartPriceItemEntity.getLineItems()));
        return cartLineItemsDomain;
    }

    @NotNull
    public static final CartLineItemViewData mapToProductLineItem(@NotNull CartPriceLineItem cartPriceLineItem) {
        Intrinsics.checkParameterIsNotNull(cartPriceLineItem, "receiver$0");
        CartLineItemViewData cartLineItemViewData = new CartLineItemViewData(cartPriceLineItem.getStoreInfo().getId(), cartPriceLineItem.getStoreInfo().getStoreName(), cartPriceLineItem.getLineItemTotalPrice(), cartPriceLineItem.getLineItemShippingTotalPrice(), cartPriceLineItem.getLineItemOrderPrice(), new ArrayList());
        return cartLineItemViewData;
    }

    @NotNull
    public static final CartLineItemViewData mapToProductLineItem(@NotNull CartLineItem cartLineItem) {
        Intrinsics.checkParameterIsNotNull(cartLineItem, "receiver$0");
        CartLineItemViewData cartLineItemViewData = new CartLineItemViewData(cartLineItem.getStore().getId(), cartLineItem.getStore().getStoreName(), cartLineItem.getLineItemTotalPrice(), cartLineItem.getLineItemShippingTotalPrice(), cartLineItem.getLineItemOrderPrice(), mapToProductVariantsList(cartLineItem.getLineItemVariants()));
        return cartLineItemViewData;
    }

    @NotNull
    public static final CartVariantsItem mapToProductVariantsItem(@NotNull CartLineItemVariants cartLineItemVariants) {
        Intrinsics.checkParameterIsNotNull(cartLineItemVariants, "receiver$0");
        String str = "active";
        CartVariantsItem cartVariantsItem = new CartVariantsItem(cartLineItemVariants.getVariant().getId(), !Intrinsics.areEqual((Object) cartLineItemVariants.getVariant().getState(), (Object) str), cartLineItemVariants.getVariant().getProduct().getShopImageUrl(), cartLineItemVariants.getVariant().getProduct().getShopLinkUrl(), cartLineItemVariants.getVariant().getProduct().getTitle(), cartLineItemVariants.getVariant().getOriginPrice(), cartLineItemVariants.getVariant().getPrice(), Integer.valueOf((int) Math.ceil(cartLineItemVariants.getVariant().getDiscountPercentage())), ProductEntityExtensionKt.mapToDomain(cartLineItemVariants.getVariant().getOption()), cartLineItemVariants.getSpecialDiscountInfo(), cartLineItemVariants.getQuantity(), Intrinsics.areEqual((Object) cartLineItemVariants.getVariant().getState(), (Object) str));
        return cartVariantsItem;
    }

    @NotNull
    public static final List<CartLineItemViewData> mapToCartLineItems(@NotNull List<CartLineItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartLineItem mapToCartLineItem : list) {
            arrayList.add(mapToCartLineItem(mapToCartLineItem));
        }
        return arrayList;
    }

    @NotNull
    public static final List<CartLineItemViewData> mapToCartLineItemList(@NotNull List<CartPriceLineItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartPriceLineItem mapToCartLineItem : list) {
            arrayList.add(mapToCartLineItem(mapToCartLineItem));
        }
        return arrayList;
    }

    @NotNull
    public static final List<CartVariantsItem> mapToCartVariantsList(@NotNull List<CartLineItemVariants> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartLineItemVariants mapToCartVariantsItem : list) {
            arrayList.add(mapToCartVariantsItem(mapToCartVariantsItem));
        }
        return arrayList;
    }

    public static final int getTotalVariantsCount(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        int i = 0;
        for (CartLineItemViewData productVariants : list) {
            for (CartVariantsItem isSoldOut : productVariants.getProductVariants()) {
                if (!isSoldOut.isSoldOut()) {
                    i++;
                }
            }
        }
        return i;
    }

    public static final int getCheckedVariantCount(@NotNull List<CartVariantsItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        int i = 0;
        for (CartVariantsItem isCheckedOption : list) {
            if (isCheckedOption.isCheckedOption()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final List<CartLineItemViewData> mapToProductLineItems(@NotNull List<CartLineItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartLineItem mapToProductLineItem : list) {
            arrayList.add(mapToProductLineItem(mapToProductLineItem));
        }
        return arrayList;
    }

    @NotNull
    public static final List<CartLineItemViewData> mapToProductLineItemList(@NotNull List<CartPriceLineItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartPriceLineItem mapToProductLineItem : list) {
            arrayList.add(mapToProductLineItem(mapToProductLineItem));
        }
        return arrayList;
    }

    @NotNull
    public static final List<CartVariantsItem> mapToProductVariantsList(@NotNull List<CartLineItemVariants> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CartLineItemVariants mapToProductVariantsItem : list) {
            arrayList.add(mapToProductVariantsItem(mapToProductVariantsItem));
        }
        return arrayList;
    }
}
