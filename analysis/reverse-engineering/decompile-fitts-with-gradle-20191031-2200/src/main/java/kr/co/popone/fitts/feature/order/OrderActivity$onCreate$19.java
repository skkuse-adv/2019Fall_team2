package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$19 extends FunctionReference implements Function1<Result, Unit> {
    OrderActivity$onCreate$19(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "updateAddressInfoView";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderActivity.class);
    }

    public final String getSignature() {
        return "updateAddressInfoView(Lkr/co/popone/fitts/feature/reward/AddressWebViewActivity$Result;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Result result) {
        Intrinsics.checkParameterIsNotNull(result, "p1");
        ((OrderActivity) this.receiver).updateAddressInfoView(result);
    }
}
