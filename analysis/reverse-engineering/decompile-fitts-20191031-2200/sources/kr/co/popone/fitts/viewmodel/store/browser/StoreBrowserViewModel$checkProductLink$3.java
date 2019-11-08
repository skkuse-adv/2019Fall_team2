package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.AffiliatesProductRestrictState;
import kr.co.popone.fitts.model.product.OrderableType;
import org.jetbrains.annotations.NotNull;

final class StoreBrowserViewModel$checkProductLink$3<T, R> implements Function<Throwable, AffiliatesProduct> {
    public static final StoreBrowserViewModel$checkProductLink$3 INSTANCE = new StoreBrowserViewModel$checkProductLink$3();

    StoreBrowserViewModel$checkProductLink$3() {
    }

    @NotNull
    public final AffiliatesProduct apply(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        AffiliatesProduct affiliatesProduct = new AffiliatesProduct(false, null, OrderableType.NORMAL, AffiliatesProductRestrictState.NONE, 0);
        return affiliatesProduct;
    }
}
