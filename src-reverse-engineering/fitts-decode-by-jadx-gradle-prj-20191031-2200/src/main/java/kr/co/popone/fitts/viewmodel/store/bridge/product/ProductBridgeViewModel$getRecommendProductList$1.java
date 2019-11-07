package kr.co.popone.fitts.viewmodel.store.bridge.product;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;
import org.jetbrains.annotations.NotNull;

final class ProductBridgeViewModel$getRecommendProductList$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ long $postId;
    final /* synthetic */ ProductBridgeViewModel this$0;

    ProductBridgeViewModel$getRecommendProductList$1(ProductBridgeViewModel productBridgeViewModel, long j) {
        this.this$0 = productBridgeViewModel;
        this.$postId = j;
    }

    @NotNull
    public final Single<ArrayList<ProductBridgeViewData>> apply(@NotNull ArrayList<Product> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "it");
        return this.this$0.getProductBridgeHeaderInfo(this.$postId, arrayList);
    }
}
