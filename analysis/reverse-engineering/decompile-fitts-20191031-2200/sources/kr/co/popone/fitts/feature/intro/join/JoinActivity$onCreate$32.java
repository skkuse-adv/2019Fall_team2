package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$onCreate$32<T1, T2, R> implements BiFunction<String, String, Boolean> {
    public static final JoinActivity$onCreate$32 INSTANCE = new JoinActivity$onCreate$32();

    JoinActivity$onCreate$32() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        return Boolean.valueOf(apply((String) obj, (String) obj2));
    }

    public final boolean apply(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "fittsID");
        if (str.length() > 0) {
            if (str2.length() > 0) {
                return true;
            }
        }
        return false;
    }
}
