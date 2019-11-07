package kr.co.popone.fitts.feature.reward;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class RewardPointUseActivity$onCreate$11<T1, T2, R> implements BiFunction<Integer, Integer, Pair<? extends Integer, ? extends Integer>> {
    public static final RewardPointUseActivity$onCreate$11 INSTANCE = new RewardPointUseActivity$onCreate$11();

    RewardPointUseActivity$onCreate$11() {
    }

    @NotNull
    public final Pair<Integer, Integer> apply(@NotNull Integer num, @NotNull Integer num2) {
        Intrinsics.checkParameterIsNotNull(num, "t1");
        Intrinsics.checkParameterIsNotNull(num2, "t2");
        return new Pair<>(num, num2);
    }
}
