package kr.co.popone.fitts.viewmodel.store;

import com.orhanobut.logger.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class StoreViewModel$storeTabSelectActionLog$1$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final StoreViewModel$storeTabSelectActionLog$1$1 INSTANCE = new StoreViewModel$storeTabSelectActionLog$1$1();

    StoreViewModel$storeTabSelectActionLog$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        Logger.d("StoreHomeFeed ActionLog Error", new Object[0]);
    }
}
