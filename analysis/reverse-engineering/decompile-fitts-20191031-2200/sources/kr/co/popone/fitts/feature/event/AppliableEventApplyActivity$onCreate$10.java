package kr.co.popone.fitts.feature.event;

import io.reactivex.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class AppliableEventApplyActivity$onCreate$10<T1, T2, T3, T4, R> implements Function4<CharSequence, CharSequence, CharSequence, CharSequence, Boolean> {
    public static final AppliableEventApplyActivity$onCreate$10 INSTANCE = new AppliableEventApplyActivity$onCreate$10();

    AppliableEventApplyActivity$onCreate$10() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(apply((CharSequence) obj, (CharSequence) obj2, (CharSequence) obj3, (CharSequence) obj4));
    }

    public final boolean apply(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, @NotNull CharSequence charSequence4) {
        Intrinsics.checkParameterIsNotNull(charSequence, "itemName");
        Intrinsics.checkParameterIsNotNull(charSequence2, "linkUrl");
        Intrinsics.checkParameterIsNotNull(charSequence3, "color");
        Intrinsics.checkParameterIsNotNull(charSequence4, "size");
        return (StringsKt__StringsJVMKt.isBlank(charSequence) ^ true) && (StringsKt__StringsJVMKt.isBlank(charSequence2) ^ true) && (StringsKt__StringsJVMKt.isBlank(charSequence3) ^ true) && (StringsKt__StringsJVMKt.isBlank(charSequence4) ^ true);
    }
}
