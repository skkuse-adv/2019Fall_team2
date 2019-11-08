package kr.co.popone.fitts.feature.reward;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RewardPointUseActivity$onCreate$3<T, R> implements Function<T, R> {
    public static final RewardPointUseActivity$onCreate$3 INSTANCE = new RewardPointUseActivity$onCreate$3();

    RewardPointUseActivity$onCreate$3() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((CharSequence) obj));
    }

    public final boolean apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }
}
