package kr.co.popone.fitts.feature.intro.join;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$onCreate$34<T1, T2, R> implements BiFunction<Integer, Integer, Boolean> {
    public static final JoinActivity$onCreate$34 INSTANCE = new JoinActivity$onCreate$34();

    JoinActivity$onCreate$34() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        return Boolean.valueOf(apply((Integer) obj, (Integer) obj2));
    }

    public final boolean apply(@NotNull Integer num, @NotNull Integer num2) {
        Intrinsics.checkParameterIsNotNull(num, "weight");
        Intrinsics.checkParameterIsNotNull(num2, SettingsJsonConstants.ICON_HEIGHT_KEY);
        return Intrinsics.compare(num.intValue(), 0) > 0 && Intrinsics.compare(num2.intValue(), 0) > 0;
    }
}
