package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ModifyBodyActivity$onCreate$4<T> implements Predicate<CharSequence> {
    public static final ModifyBodyActivity$onCreate$4 INSTANCE = new ModifyBodyActivity$onCreate$4();

    ModifyBodyActivity$onCreate$4() {
    }

    public final boolean test(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return Integer.parseInt(charSequence.toString()) >= 100;
    }
}
