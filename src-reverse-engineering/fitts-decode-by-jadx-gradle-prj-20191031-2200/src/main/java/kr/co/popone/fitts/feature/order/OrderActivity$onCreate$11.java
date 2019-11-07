package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.ui.custom.DiscountChoiceSelector;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$11 extends FunctionReference implements Function1<String, Unit> {
    OrderActivity$onCreate$11(DiscountChoiceSelector discountChoiceSelector) {
        super(1, discountChoiceSelector);
    }

    public final String getName() {
        return "updateMembershipNotUsableReason";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DiscountChoiceSelector.class);
    }

    public final String getSignature() {
        return "updateMembershipNotUsableReason(Ljava/lang/String;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "p1");
        ((DiscountChoiceSelector) this.receiver).updateMembershipNotUsableReason(str);
    }
}
