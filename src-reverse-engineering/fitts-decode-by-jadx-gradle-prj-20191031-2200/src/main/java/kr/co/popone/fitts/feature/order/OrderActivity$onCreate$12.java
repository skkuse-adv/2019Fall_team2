package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import org.jetbrains.annotations.Nullable;

final class OrderActivity$onCreate$12 extends FunctionReference implements Function1<Membership, Unit> {
    OrderActivity$onCreate$12(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "showMembershipDialog";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderActivity.class);
    }

    public final String getSignature() {
        return "showMembershipDialog(Lkr/co/popone/fitts/model/datamodel/social/membership/Membership;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Membership) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Membership membership) {
        ((OrderActivity) this.receiver).showMembershipDialog(membership);
    }
}
