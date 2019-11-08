package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ModifyBodyActivity$onCreate$5<T, R> implements Function<T, R> {
    public static final ModifyBodyActivity$onCreate$5 INSTANCE = new ModifyBodyActivity$onCreate$5();

    ModifyBodyActivity$onCreate$5() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((CharSequence) obj));
    }

    public final int apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return Integer.parseInt(charSequence.toString());
    }
}
