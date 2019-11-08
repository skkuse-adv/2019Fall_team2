package kr.co.popone.fitts.feature.push.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import org.jetbrains.annotations.NotNull;

final class OrderPaymentCompleteFragment$onViewCreated$7 extends FunctionReference implements Function1<ExpectedReceivablePoint, Unit> {
    OrderPaymentCompleteFragment$onViewCreated$7(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        super(1, orderPaymentCompleteFragment);
    }

    public final String getName() {
        return "updateExpectedReceivablePoint";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderPaymentCompleteFragment.class);
    }

    public final String getSignature() {
        return "updateExpectedReceivablePoint(Lkr/co/popone/fitts/model/datamodel/social/point/ExpectedReceivablePoint;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ExpectedReceivablePoint) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ExpectedReceivablePoint expectedReceivablePoint) {
        Intrinsics.checkParameterIsNotNull(expectedReceivablePoint, "p1");
        ((OrderPaymentCompleteFragment) this.receiver).updateExpectedReceivablePoint(expectedReceivablePoint);
    }
}
