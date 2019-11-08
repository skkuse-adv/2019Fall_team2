package kr.co.popone.fitts.viewmodel.store.home;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class StoreFeedViewModel$leaveProductClickActionLog$1$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final StoreFeedViewModel$leaveProductClickActionLog$1$1 INSTANCE = new StoreFeedViewModel$leaveProductClickActionLog$1$1();

    StoreFeedViewModel$leaveProductClickActionLog$1$1() {
        super(1);
    }

    public final void invoke(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }
}
