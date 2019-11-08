package kr.co.popone.fitts.model.order;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import org.jetbrains.annotations.NotNull;

public final class OrderExtensionKt {
    @NotNull
    public static final OrderListViewData mapToOrderListViewData(@NotNull OrderListItem orderListItem) {
        Intrinsics.checkParameterIsNotNull(orderListItem, "receiver$0");
        OrderListViewData orderListViewData = new OrderListViewData(orderListItem.getId(), orderListItem.getOrderCreatedDate(), orderListItem.getOrderNumber(), mapToOrderListLineItems(orderListItem.getLineItems()));
        return orderListViewData;
    }

    @NotNull
    public static final OrderListItemViewData mapToOrderListItemViewData(@NotNull OrderListLineItem orderListLineItem) {
        Intrinsics.checkParameterIsNotNull(orderListLineItem, "receiver$0");
        OrderListItemViewData orderListItemViewData = new OrderListItemViewData(orderListLineItem.getStore().getStoreName(), orderListLineItem.getProductPrice(), orderListLineItem.getShippingPrice(), orderListLineItem.getOrderPrice(), orderListLineItem.getStore().getStoreContactInfo(), mapToOrderListDetailViewDatas(orderListLineItem.getLineItemVariants()));
        return orderListItemViewData;
    }

    @NotNull
    public static final OrderListDetailViewData mapToOrderListDetailViewData(@NotNull OrderListLineItemVariant orderListLineItemVariant) {
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "receiver$0");
        long id = orderListLineItemVariant.getId();
        String shopImageUrl = orderListLineItemVariant.getVariant().getProduct().getShopImageUrl();
        String shopLinkUrl = orderListLineItemVariant.getVariant().getProduct().getShopLinkUrl();
        String title = orderListLineItemVariant.getVariant().getProduct().getTitle();
        String state = orderListLineItemVariant.getState();
        if (state != null) {
            String upperCase = state.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            OrderListDetailViewData orderListDetailViewData = new OrderListDetailViewData(id, shopImageUrl, shopLinkUrl, title, OrderState.valueOf(upperCase), orderListLineItemVariant.getOriginPrice(), orderListLineItemVariant.getSalesPrice(), (int) Math.ceil(orderListLineItemVariant.getDiscountPercentage()), mapToOptionString(orderListLineItemVariant.getVariant().getOption()), orderListLineItemVariant.getQuantity(), orderListLineItemVariant.getExchangeId(), orderListLineItemVariant.getRefundId(), orderListLineItemVariant.getPostId(), orderListLineItemVariant.getCategories(), orderListLineItemVariant.getVariant().getProduct().getState(), orderListLineItemVariant.getSpecialDiscountInfo());
            return orderListDetailViewData;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public static final String mapToOptionString(@NotNull List<VariantInfoOption> list) {
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
    public static final OrderDetailViewData mapToOrderDetailViewData(@NotNull OrderDetailListItem orderDetailListItem) {
        Intrinsics.checkParameterIsNotNull(orderDetailListItem, "receiver$0");
        long id = orderDetailListItem.getId();
        String state = ((OrderListLineItemVariant) CollectionsKt___CollectionsKt.first(((OrderListLineItem) CollectionsKt___CollectionsKt.first(orderDetailListItem.getLineItems())).getLineItemVariants())).getState();
        if (state != null) {
            String upperCase = state.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            OrderDetailViewData orderDetailViewData = new OrderDetailViewData(id, OrderState.valueOf(upperCase), orderDetailListItem.getOrderCreatedDate(), orderDetailListItem.getOrderNumber(), mapToOrderListLineItems(orderDetailListItem.getLineItems()), orderDetailListItem.getTotalCount(), orderDetailListItem.getSpecialDiscountPrice(), orderDetailListItem.getTotalProductPrice(), orderDetailListItem.getTotalShippingPrice(), orderDetailListItem.getTotalPaymentPrice(), orderDetailListItem.getAdjustType(), orderDetailListItem.getAdjustValue(), orderDetailListItem.getPaymentMethod(), orderDetailListItem.getPaymentInfo(), orderDetailListItem.getUserInfo(), orderDetailListItem.getShippingAddress(), orderDetailListItem.getPredictPoint(), orderDetailListItem.getOrderDiscountType());
            return orderDetailViewData;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public static final OrderCompleteViewData mapToOrderCompleteViewData(@NotNull OrderDetailListItem orderDetailListItem) {
        Intrinsics.checkParameterIsNotNull(orderDetailListItem, "receiver$0");
        return new OrderCompleteViewData(orderDetailListItem.getId(), orderDetailListItem.getTotalPaymentPrice(), orderDetailListItem.getPaymentInfo());
    }

    @NotNull
    public static final List<OrderListViewData> mapToOrderListItems(@NotNull List<OrderListItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (OrderListItem mapToOrderListViewData : list) {
            arrayList.add(mapToOrderListViewData(mapToOrderListViewData));
        }
        return arrayList;
    }

    @NotNull
    public static final List<OrderListItemViewData> mapToOrderListLineItems(@NotNull List<OrderListLineItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (OrderListLineItem mapToOrderListItemViewData : list) {
            arrayList.add(mapToOrderListItemViewData(mapToOrderListItemViewData));
        }
        return arrayList;
    }

    @NotNull
    public static final List<OrderListDetailViewData> mapToOrderListDetailViewDatas(@NotNull List<OrderListLineItemVariant> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (OrderListLineItemVariant mapToOrderListDetailViewData : list) {
            arrayList.add(mapToOrderListDetailViewData(mapToOrderListDetailViewData));
        }
        return arrayList;
    }
}
