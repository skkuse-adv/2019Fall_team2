package kr.co.popone.fitts.repository;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.ProductAPI;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductRepository {
    private final ProductAPI productAPI;

    public ProductRepository(@NotNull ProductAPI productAPI2) {
        Intrinsics.checkParameterIsNotNull(productAPI2, "productAPI");
        this.productAPI = productAPI2;
    }

    @NotNull
    public final Single<List<ProductFeedViewData>> getProductList(@NotNull String str, @Nullable Long l, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<List<ProductFeedViewData>> map = this.productAPI.getProductList(str, l, num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(ProductRepository$getProductList$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "productAPI.getProductLis…n()\n                    }");
        return map;
    }

    public final Observable<List<ProductVariantViewData>> getProductVariantOptions(long j) {
        return this.productAPI.getProductVariantOptions(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(ProductRepository$getProductVariantOptions$1.INSTANCE);
    }

    @NotNull
    public final Single<AffiliatesProduct> checkOrderableProductVariant(@NotNull String str, @Nullable Long l, @NotNull String str2, @Nullable Long l2) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Single<AffiliatesProduct> observeOn = this.productAPI.postCheckOrderableProduct(str, l, str2, l2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "productAPI.postCheckOrde…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<OrderInfoViewData> getProductVariantsPreOrderData(@NotNull String str, @NotNull String str2, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Single<OrderInfoViewData> map = this.productAPI.postProductPreOrderData(str, str2, l).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(ProductRepository$getProductVariantsPreOrderData$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "productAPI.postProductPr…a()\n                    }");
        return map;
    }

    @NotNull
    public final Single<OrderDetailListItem> orderProductVariants(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @Nullable String str10, @Nullable String str11, @Nullable Integer num, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable Long l4, long j) {
        Long l5;
        Intrinsics.checkParameterIsNotNull(str, "variantsJson");
        Intrinsics.checkParameterIsNotNull(str2, "buyerName");
        Intrinsics.checkParameterIsNotNull(str3, "buyerContact");
        Intrinsics.checkParameterIsNotNull(str5, "shippingName");
        Intrinsics.checkParameterIsNotNull(str6, "shippingContact");
        Intrinsics.checkParameterIsNotNull(str7, "shippingZipcode");
        Intrinsics.checkParameterIsNotNull(str8, "shippingAddress");
        Intrinsics.checkParameterIsNotNull(str9, "shippingAddress2");
        ProductAPI productAPI2 = this.productAPI;
        String str15 = j == -1 ? "normal" : "special_discount";
        if (j == -1) {
            l5 = null;
        } else {
            l5 = Long.valueOf(j);
        }
        Single<OrderDetailListItem> observeOn = productAPI2.postOrderProductVariants(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, num, l, l2, l3, str12, str13, str14, l4, str15, l5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "productAPI.postOrderProd…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<OrderableOptionViewData> getProductVariant(long j) {
        Single<OrderableOptionViewData> map = this.productAPI.getProductVariant(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(ProductRepository$getProductVariant$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "productAPI.getProductVar…n()\n                    }");
        return map;
    }

    @NotNull
    public final Single<Integer> getProductVariantsTotalPrice(@NotNull String str, @NotNull String str2, @Nullable Long l) {
        Intrinsics.checkParameterIsNotNull(str, "options");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Single<Integer> map = this.productAPI.postProductVariantsTotalPrice(str, str2, l).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(ProductRepository$getProductVariantsTotalPrice$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map, "productAPI.postProductVa…   .map { it.totalPrice }");
        return map;
    }

    public final Observable<List<Post>> getRelatedPosts(long j) {
        return this.productAPI.getPostsById(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
