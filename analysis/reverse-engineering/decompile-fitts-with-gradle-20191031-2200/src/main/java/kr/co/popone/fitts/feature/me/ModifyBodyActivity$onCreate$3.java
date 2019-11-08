package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ModifyBodyActivity$onCreate$3<T> implements Predicate<CharSequence> {
    public static final ModifyBodyActivity$onCreate$3 INSTANCE = new ModifyBodyActivity$onCreate$3();

    ModifyBodyActivity$onCreate$3() {
    }

    public final boolean test(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return charSequence.toString().length() > 0;
    }
}
