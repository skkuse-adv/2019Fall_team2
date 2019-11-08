package kr.co.popone.fitts.viewmodel.store.bridge.product;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.post.PostAPI.PostProductInfoResponse;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType;
import org.jetbrains.annotations.NotNull;

final class ProductBridgeViewModel$getProductBridgeHeaderInfo$1<T, R> implements Function<T, R> {
    final /* synthetic */ ArrayList $products;

    ProductBridgeViewModel$getProductBridgeHeaderInfo$1(ArrayList arrayList) {
        this.$products = arrayList;
    }

    @NotNull
    public final ArrayList<ProductBridgeViewData> apply(@NotNull PostProductInfoResponse postProductInfoResponse) {
        Intrinsics.checkParameterIsNotNull(postProductInfoResponse, "result");
        ProductBridgeViewData[] productBridgeViewDataArr = new ProductBridgeViewData[2];
        Product product = postProductInfoResponse.getLinkInfo().getProduct();
        String imageUrl = product != null ? product.getImageUrl() : null;
        String linkUrl = postProductInfoResponse.getLinkInfo().getLinkUrl();
        Shop shop = postProductInfoResponse.getLinkInfo().getShop();
        String name = shop != null ? shop.getName() : null;
        Product product2 = postProductInfoResponse.getLinkInfo().getProduct();
        String name2 = product2 != null ? product2.getName() : null;
        Product product3 = postProductInfoResponse.getLinkInfo().getProduct();
        HeaderType headerType = new HeaderType(imageUrl, linkUrl, name, name2, product3 != null ? product3.getPrice() : null);
        productBridgeViewDataArr[0] = headerType;
        productBridgeViewDataArr[1] = new ImageType(postProductInfoResponse.getImage().getImageUrl(), postProductInfoResponse.getImage().getImageRatio(), postProductInfoResponse.getImageScheme());
        ArrayList<ProductBridgeViewData> arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(productBridgeViewDataArr);
        arrayListOf.addAll(ProductEntityExtensionKt.mapToProductBridgeType(this.$products));
        return arrayListOf;
    }
}
