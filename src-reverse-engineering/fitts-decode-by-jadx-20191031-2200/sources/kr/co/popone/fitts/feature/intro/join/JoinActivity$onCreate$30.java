package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$onCreate$30<T1, T2, T3, R> implements Function3<String, String, String, Boolean> {
    public static final JoinActivity$onCreate$30 INSTANCE = new JoinActivity$onCreate$30();

    JoinActivity$onCreate$30() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2, Object obj3) {
        return Boolean.valueOf(apply((String) obj, (String) obj2, (String) obj3));
    }

    public final boolean apply(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "fittsID");
        Intrinsics.checkParameterIsNotNull(str3, "password");
        if (str.length() > 0) {
            if (str2.length() > 0) {
                if (str3.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
