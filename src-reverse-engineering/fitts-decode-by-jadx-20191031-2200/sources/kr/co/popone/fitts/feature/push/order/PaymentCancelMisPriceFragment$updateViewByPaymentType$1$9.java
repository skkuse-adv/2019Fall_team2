package kr.co.popone.fitts.feature.push.order;

import io.reactivex.functions.Function;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class PaymentCancelMisPriceFragment$updateViewByPaymentType$1$9<T, R> implements Function<T, R> {
    public static final PaymentCancelMisPriceFragment$updateViewByPaymentType$1$9 INSTANCE = new PaymentCancelMisPriceFragment$updateViewByPaymentType$1$9();

    PaymentCancelMisPriceFragment$updateViewByPaymentType$1$9() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Triple) obj));
    }

    public final boolean apply(@NotNull Triple<? extends CharSequence, ? extends CharSequence, ? extends CharSequence> triple) {
        Intrinsics.checkParameterIsNotNull(triple, "it");
        Object first = triple.getFirst();
        Intrinsics.checkExpressionValueIsNotNull(first, "it.first");
        if (((CharSequence) first).length() > 0) {
            Object second = triple.getSecond();
            Intrinsics.checkExpressionValueIsNotNull(second, "it.second");
            if (((CharSequence) second).length() > 0) {
                Object third = triple.getThird();
                Intrinsics.checkExpressionValueIsNotNull(third, "it.third");
                if (((CharSequence) third).length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
