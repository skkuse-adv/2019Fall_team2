package kr.co.popone.fitts.feature.payment;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import org.jetbrains.annotations.NotNull;

public final class PaymentDataUIExtensionsKt {
    @NotNull
    public static final String productOption(@NotNull PaymentUsage paymentUsage) {
        Intrinsics.checkParameterIsNotNull(paymentUsage, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append(paymentUsage.getColor());
        sb.append(' ');
        sb.append(paymentUsage.getSize());
        return sb.toString();
    }

    public static final int totalPrice(@NotNull PaymentUsage paymentUsage) {
        Intrinsics.checkParameterIsNotNull(paymentUsage, "receiver$0");
        return paymentUsage.getPrice() + paymentUsage.getShippingPrice();
    }

    @NotNull
    public static final String compositeShippingAddress(@NotNull PaymentUsage paymentUsage) {
        Intrinsics.checkParameterIsNotNull(paymentUsage, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append(paymentUsage.getShippingAddress());
        sb.append(' ');
        String shippingAddress2 = paymentUsage.getShippingAddress2();
        if (shippingAddress2 == null) {
            shippingAddress2 = "";
        }
        sb.append(shippingAddress2);
        return sb.toString();
    }
}
