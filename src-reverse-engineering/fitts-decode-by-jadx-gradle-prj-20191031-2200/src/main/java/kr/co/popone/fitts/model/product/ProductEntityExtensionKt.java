package kr.co.popone.fitts.model.product;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.FeedType;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.model.store.ProductOptionViewData;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserInfo;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductEntityExtensionKt {
    @NotNull
    public static final ProductFeedViewData mapToDomain(@NotNull Product product) {
        Intrinsics.checkParameterIsNotNull(product, "receiver$0");
        long id = product.getId();
        String title = product.getTitle();
        String shopImageUrl = product.getShopImageUrl();
        String shopLinkUrl = product.getShopLinkUrl();
        long originPrice = product.getOriginPrice();
        long salesPrice = product.getSalesPrice();
        Double discountRate = product.getDiscountRate();
        ProductFeedViewData productFeedViewData = new ProductFeedViewData(id, title, shopImageUrl, shopLinkUrl, originPrice, salesPrice, Integer.valueOf((int) Math.ceil(discountRate != null ? discountRate.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
        return productFeedViewData;
    }

    @NotNull
    public static final List<ProductVariantViewData> mapToDomain(@NotNull VariantOptionResult variantOptionResult) {
        Intrinsics.checkParameterIsNotNull(variantOptionResult, "receiver$0");
        ArrayList arrayList = new ArrayList();
        if (variantOptionResult.getTypes().size() == 0) {
            arrayList.add(new ProductVariantViewData("", mapToOptionsDomain(variantOptionResult.getOptions())));
            return arrayList;
        }
        int size = variantOptionResult.getTypes().size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                arrayList.add(new ProductVariantViewData((String) variantOptionResult.getTypes().get(i), mapToOptionsDomain(variantOptionResult.getOptions())));
            } else {
                arrayList.add(new ProductVariantViewData((String) variantOptionResult.getTypes().get(i), null));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final ProductOptionViewData mapToDomain(@NotNull Option option) {
        Intrinsics.checkParameterIsNotNull(option, "receiver$0");
        Long id = option.getId();
        String state = option.getState();
        String value = option.getValue();
        List subOption = option.getSubOption();
        return new ProductOptionViewData(id, state, value, subOption != null ? mapToOptionsDomain(subOption) : null);
    }

    @NotNull
    public static final OrderableOptionViewData mapToDomain(@NotNull VariantInfo variantInfo) {
        Intrinsics.checkParameterIsNotNull(variantInfo, "receiver$0");
        OrderableOptionViewData orderableOptionViewData = new OrderableOptionViewData(variantInfo.getId(), mapToDomain(variantInfo.getOption()), variantInfo.getPrice(), variantInfo.getAdditionalPrice(), variantInfo.getState(), 0, false, false, 224, null);
        return orderableOptionViewData;
    }

    @NotNull
    public static final String mapToDomain(@NotNull List<VariantInfoOption> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        int size = list.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(((VariantInfoOption) list.get(i)).getOptionValue());
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" / ");
                sb2.append(((VariantInfoOption) list.get(i)).getOptionValue());
                str = sb2.toString();
            }
        }
        return str;
    }

    @NotNull
    public static final OrderInfoViewData mapToOrderInfoViewData(@NotNull ProductOrderableItem productOrderableItem) {
        Intrinsics.checkParameterIsNotNull(productOrderableItem, "receiver$0");
        List mapToProductLineItems = CartEntityExtensionKt.mapToProductLineItems(CollectionsKt__CollectionsJVMKt.listOf(productOrderableItem.getLineItems()));
        Integer specialDiscountPrice = productOrderableItem.getSpecialDiscountPrice();
        int totalProductCount = productOrderableItem.getTotalProductCount();
        int totalProductPrice = productOrderableItem.getTotalProductPrice();
        int totalShippingPrice = productOrderableItem.getTotalShippingPrice();
        UserInfo userInfo = productOrderableItem.getUserInfo();
        ShippingAddressResponse userAddress = productOrderableItem.getUserAddress();
        List bankAccounts = productOrderableItem.getBankAccounts();
        Date dueDate = productOrderableItem.getDueDate();
        AdjustmentViewData adjustmentViewData = new AdjustmentViewData(productOrderableItem.getPointAdjustmentPolicy().getMinHoldingValue(), productOrderableItem.getPointAdjustmentPolicy().getMinOrderPrice(), productOrderableItem.getPointAdjustmentPolicy().getAvailablePaymentPercentage(), productOrderableItem.getPointAdjustmentPolicy().getUsageUnit(), productOrderableItem.getUsablePoints(), productOrderableItem.getFittsPoint());
        OrderInfoViewData orderInfoViewData = new OrderInfoViewData(mapToProductLineItems, specialDiscountPrice, totalProductCount, totalProductPrice, totalShippingPrice, userInfo, userAddress, bankAccounts, dueDate, adjustmentViewData);
        return orderInfoViewData;
    }

    @NotNull
    public static final FeedType mapToProductBridgeType(@NotNull Product product) {
        Intrinsics.checkParameterIsNotNull(product, "receiver$0");
        long id = product.getId();
        String title = product.getTitle();
        String shopImageUrl = product.getShopImageUrl();
        String shopImageUrl2 = product.getShopImageUrl();
        String mobileLinkUrl = product.getMobileLinkUrl();
        long originPrice = product.getOriginPrice();
        long salesPrice = product.getSalesPrice();
        Double discountRate = product.getDiscountRate();
        FeedType feedType = new FeedType(id, title, shopImageUrl, shopImageUrl2, mobileLinkUrl, originPrice, salesPrice, Integer.valueOf((int) Math.ceil(discountRate != null ? discountRate.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), product.getState());
        return feedType;
    }

    @NotNull
    /* renamed from: mapToDomain reason: collision with other method in class */
    public static final List<ProductFeedViewData> m153mapToDomain(@NotNull List<Product> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Product mapToDomain : list) {
            arrayList.add(mapToDomain(mapToDomain));
        }
        return arrayList;
    }

    @Nullable
    public static final List<ProductOptionViewData> mapToOptionsDomain(@NotNull List<Option> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Option mapToDomain : list) {
            arrayList.add(mapToDomain(mapToDomain));
        }
        return arrayList;
    }

    @NotNull
    public static final List<FeedType> mapToProductBridgeType(@NotNull ArrayList<Product> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "receiver$0");
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Product mapToProductBridgeType : arrayList) {
            arrayList2.add(mapToProductBridgeType(mapToProductBridgeType));
        }
        return arrayList2;
    }
}
