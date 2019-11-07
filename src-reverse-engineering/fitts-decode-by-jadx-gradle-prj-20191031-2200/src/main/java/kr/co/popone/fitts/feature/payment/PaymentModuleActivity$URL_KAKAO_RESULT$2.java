package kr.co.popone.fitts.feature.payment;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class PaymentModuleActivity$URL_KAKAO_RESULT$2 extends Lambda implements Function0<String> {
    public static final PaymentModuleActivity$URL_KAKAO_RESULT$2 INSTANCE = new PaymentModuleActivity$URL_KAKAO_RESULT$2();

    PaymentModuleActivity$URL_KAKAO_RESULT$2() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "https://fitts.co.kr/payments/kakao/complete";
    }
}
