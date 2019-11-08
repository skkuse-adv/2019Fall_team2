package kr.co.popone.fitts.model.store;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.VariantPrice;
import org.jetbrains.annotations.NotNull;

public final class ProductOptionViewDataKt {
    @NotNull
    public static final VariantPrice mapToEntiry(@NotNull OrderableOptionViewData orderableOptionViewData) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "receiver$0");
        return new VariantPrice(orderableOptionViewData.getProductId(), orderableOptionViewData.getProductCount());
    }

    @NotNull
    public static final List<VariantPrice> mapToEntiry(@NotNull List<OrderableOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (OrderableOptionViewData mapToEntiry : list) {
            arrayList.add(mapToEntiry(mapToEntiry));
        }
        return arrayList;
    }
}
