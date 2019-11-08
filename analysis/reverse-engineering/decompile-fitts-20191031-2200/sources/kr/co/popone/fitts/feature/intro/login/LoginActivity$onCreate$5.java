package kr.co.popone.fitts.feature.intro.login;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class LoginActivity$onCreate$5<T1, T2, R> implements BiFunction<CharSequence, CharSequence, Boolean> {
    public static final LoginActivity$onCreate$5 INSTANCE = new LoginActivity$onCreate$5();

    LoginActivity$onCreate$5() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        return Boolean.valueOf(apply((CharSequence) obj, (CharSequence) obj2));
    }

    public final boolean apply(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "emailText");
        Intrinsics.checkParameterIsNotNull(charSequence2, "passwordText");
        return (StringsKt__StringsJVMKt.isBlank(charSequence) ^ true) && (StringsKt__StringsJVMKt.isBlank(charSequence2) ^ true);
    }
}
