package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ModifyBodyActivity$onCreate$8<T> implements Predicate<CharSequence> {
    public static final ModifyBodyActivity$onCreate$8 INSTANCE = new ModifyBodyActivity$onCreate$8();

    ModifyBodyActivity$onCreate$8() {
    }

    public final boolean test(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return charSequence.toString().length() > 0;
    }
}
