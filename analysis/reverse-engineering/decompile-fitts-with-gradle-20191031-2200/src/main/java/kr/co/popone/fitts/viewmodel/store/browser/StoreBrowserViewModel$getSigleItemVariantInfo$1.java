package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.OrderableType;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import org.jetbrains.annotations.NotNull;

final class StoreBrowserViewModel$getSigleItemVariantInfo$1<T, R> implements Function<T, R> {
    final /* synthetic */ String $option;
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$getSigleItemVariantInfo$1(StoreBrowserViewModel storeBrowserViewModel, String str) {
        this.this$0 = storeBrowserViewModel;
        this.$option = str;
    }

    @NotNull
    public final OrderableOptionViewData apply(@NotNull OrderableOptionViewData orderableOptionViewData) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "orderableOption");
        orderableOptionViewData.setProductName(this.$option);
        boolean z = true;
        orderableOptionViewData.setSingleOption(true);
        AffiliatesProduct affiliatesProduct = (AffiliatesProduct) this.this$0.isProductSubject.getValue();
        if ((affiliatesProduct != null ? affiliatesProduct.getOrderableType() : null) != OrderableType.SPECIAL_DISCOUNT) {
            z = false;
        }
        orderableOptionViewData.setSpecialDiscount(z);
        return orderableOptionViewData;
    }
}
