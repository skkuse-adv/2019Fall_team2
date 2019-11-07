package kr.co.popone.fitts.feature.order;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$10 extends FunctionReference implements Function1<List<? extends Membership>, Unit> {
    OrderActivity$onCreate$10(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "updateFittsMemberships";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderActivity.class);
    }

    public final String getSignature() {
        return "updateFittsMemberships(Ljava/util/List;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<Membership> list) {
        Intrinsics.checkParameterIsNotNull(list, "p1");
        ((OrderActivity) this.receiver).updateFittsMemberships(list);
    }
}
