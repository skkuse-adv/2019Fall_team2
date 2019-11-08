package kr.co.popone.fitts.feature.event;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class AppliableEventApplyActivity$onCreate$6<T, R> implements Function<T, R> {
    public static final AppliableEventApplyActivity$onCreate$6 INSTANCE = new AppliableEventApplyActivity$onCreate$6();

    AppliableEventApplyActivity$onCreate$6() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((CharSequence) obj));
    }

    public final boolean apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return !StringsKt__StringsJVMKt.isBlank(charSequence);
    }
}
