package kr.co.popone.fitts.feature.event;

import io.reactivex.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class AppliableEventWinnerInputActivity$onCreate$5<T1, T2, T3, T4, T5, R> implements Function5<CharSequence, CharSequence, CharSequence, CharSequence, Boolean, Boolean> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onCreate$5(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return Boolean.valueOf(apply((CharSequence) obj, (CharSequence) obj2, (CharSequence) obj3, (CharSequence) obj4, (Boolean) obj5));
    }

    public final boolean apply(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, @NotNull CharSequence charSequence4, @NotNull Boolean bool) {
        Intrinsics.checkParameterIsNotNull(charSequence, "name");
        Intrinsics.checkParameterIsNotNull(charSequence2, "contact");
        Intrinsics.checkParameterIsNotNull(charSequence3, "zipcode");
        Intrinsics.checkParameterIsNotNull(charSequence4, "address1");
        Intrinsics.checkParameterIsNotNull(bool, "isAppliable");
        return this.this$0.checkAgreeable(charSequence, charSequence2, charSequence3, charSequence4, bool.booleanValue());
    }
}
