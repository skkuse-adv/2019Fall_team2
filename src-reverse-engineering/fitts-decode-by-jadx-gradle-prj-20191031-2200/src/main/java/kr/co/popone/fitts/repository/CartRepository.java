package kr.co.popone.fitts.repository;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartAPI;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartRepository {
    private final CartAPI cartAPI;

    public CartRepository(@NotNull CartAPI cartAPI2) {
        Intrinsics.checkParameterIsNotNull(cartAPI2, "cartAPI");
        this.cartAPI = cartAPI2;
    }

    @NotNull
    public final Single<CartLineItemsDomain> getCartLineItems() {
        Single<CartLineItemsDomain> map = this.cartAPI.getCartLineItems().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(CartRepository$getCartLineItems$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "cartAPI.getCartLineItems…n()\n                    }");
        return map;
    }

    @NotNull
    public final Completable updateCartLineItemVariantCount(@NotNull String str, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        Completable observeOn = this.cartAPI.putCartLineItemVariants(str, l).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "cartAPI.putCartLineItemV…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<CartLineItemsDomain> putVariantsItem(long j, int i) {
        Single<CartLineItemsDomain> map = this.cartAPI.putCartLineItemsVariants(j, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(CartRepository$putVariantsItem$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "cartAPI.putCartLineItems…n()\n                    }");
        return map;
    }

    @NotNull
    public final Single<CartLineItemsDomain> removeVariantsItem(long j) {
        Single<CartLineItemsDomain> map = this.cartAPI.deleteCartLineItemVariants(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(CartRepository$removeVariantsItem$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "cartAPI.deleteCartLineIt…n()\n                    }");
        return map;
    }

    @NotNull
    public final Single<CartLineItemsDomain> getVariantsAndLineItemPrice(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        Single<CartLineItemsDomain> map = this.cartAPI.postCartLineItemVariantsTotalPrice(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(CartRepository$getVariantsAndLineItemPrice$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "cartAPI.postCartLineItem…n()\n                    }");
        return map;
    }

    @NotNull
    public final Single<OrderInfoViewData> putPreOrderableItems(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        Single<OrderInfoViewData> map = this.cartAPI.putPreOrderableItems(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(CartRepository$putPreOrderableItems$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "cartAPI.putPreOrderableI…a()\n                    }");
        return map;
    }

    @NotNull
    public final Single<OrderDetailListItem> orderCartLineItemVariants(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @Nullable String str10, @Nullable String str11, @Nullable Integer num, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable String str12, @Nullable String str13, @Nullable String str14) {
        String str15 = str;
        String str16 = str2;
        String str17 = str3;
        String str18 = str4;
        String str19 = str5;
        String str20 = str6;
        String str21 = str7;
        String str22 = str8;
        String str23 = str9;
        String str24 = str10;
        String str25 = str11;
        Integer num2 = num;
        Long l4 = l;
        Long l5 = l2;
        Long l6 = l3;
        String str26 = str12;
        String str27 = str13;
        String str28 = str14;
        String str29 = str15;
        Intrinsics.checkParameterIsNotNull(str15, "variantsJson");
        Intrinsics.checkParameterIsNotNull(str2, "buyerName");
        Intrinsics.checkParameterIsNotNull(str3, "buyerContact");
        Intrinsics.checkParameterIsNotNull(str5, "shippingName");
        Intrinsics.checkParameterIsNotNull(str6, "shippingContact");
        Intrinsics.checkParameterIsNotNull(str7, "shippingZipcode");
        Intrinsics.checkParameterIsNotNull(str8, "shippingAddress");
        Intrinsics.checkParameterIsNotNull(str9, "shippingAddress2");
        Single<OrderDetailListItem> observeOn = this.cartAPI.postOrderCartLineItemVariants(str29, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, num2, l4, l5, l6, str26, str27, str28).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "cartAPI.postOrderCartLin…dSchedulers.mainThread())");
        return observeOn;
    }
}
