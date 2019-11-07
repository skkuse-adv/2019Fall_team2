package kr.co.popone.fitts.viewmodel.store.newest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class NewestProductViewModel$leaveProductClickActionLog$1$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final NewestProductViewModel$leaveProductClickActionLog$1$1 INSTANCE = new NewestProductViewModel$leaveProductClickActionLog$1$1();

    NewestProductViewModel$leaveProductClickActionLog$1$1() {
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
