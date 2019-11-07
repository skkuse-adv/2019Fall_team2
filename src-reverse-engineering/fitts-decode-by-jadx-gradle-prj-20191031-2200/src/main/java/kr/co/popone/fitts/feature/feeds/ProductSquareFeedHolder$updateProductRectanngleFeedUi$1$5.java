package kr.co.popone.fitts.feature.feeds;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$5<T> implements Consumer<Throwable> {
    public static final ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$5 INSTANCE = new ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$5();

    ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$5() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductSquareFeedHolder::");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
