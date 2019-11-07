package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.user.UserAPI.BadgeCount;
import org.jetbrains.annotations.NotNull;

final class MeFragment$getBadgeCount$1<T, R> implements Function<T, R> {
    public static final MeFragment$getBadgeCount$1 INSTANCE = new MeFragment$getBadgeCount$1();

    MeFragment$getBadgeCount$1() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((BadgeCount) obj));
    }

    public final int apply(@NotNull BadgeCount badgeCount) {
        Intrinsics.checkParameterIsNotNull(badgeCount, "it");
        return badgeCount.getCartVariantCount();
    }
}
