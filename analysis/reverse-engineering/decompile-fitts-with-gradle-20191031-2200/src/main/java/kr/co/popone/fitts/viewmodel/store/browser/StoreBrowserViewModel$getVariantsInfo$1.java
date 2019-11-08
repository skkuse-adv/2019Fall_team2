package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.OrderableType;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import org.jetbrains.annotations.NotNull;

final class StoreBrowserViewModel$getVariantsInfo$1<T, R> implements Function<T, R> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$getVariantsInfo$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    @NotNull
    public final OrderableOptionViewData apply(@NotNull OrderableOptionViewData orderableOptionViewData) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "orderableOption");
        boolean z = false;
        orderableOptionViewData.setSingleOption(false);
        AffiliatesProduct affiliatesProduct = (AffiliatesProduct) this.this$0.isProductSubject.getValue();
        if ((affiliatesProduct != null ? affiliatesProduct.getOrderableType() : null) == OrderableType.SPECIAL_DISCOUNT) {
            z = true;
        }
        orderableOptionViewData.setSpecialDiscount(z);
        return orderableOptionViewData;
    }
}
